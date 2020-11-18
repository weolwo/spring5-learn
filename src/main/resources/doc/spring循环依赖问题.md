# spring 循环依赖问题
问题如图：
![](../images/springfor.jpg)
### 核心代码流程跟踪

环境：
```java
  <bean id="orange" class="com.poplar.bean.Orange">
        <property name="apple" ref="apple"/>
    </bean>

    <bean id="apple" class="com.poplar.bean.Apple">
        <property name="orange" ref="orange"/>
    </bean>
```

- 测试代码

```java
public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        context.close();
    }
```

- 核心方法

```java
//入口方法
    public void refresh() {
        // Instantiate all remaining (non-lazy-init) singletons.
        finishBeanFactoryInitialization(beanFactory);
    }
    
    protected void finishBeanFactoryInitialization(ConfigurableListableBeanFactory beanFactory) {
        beanFactory.preInstantiateSingletons();
    }
```
- 核心方法

```java
    //AbstractBeanFactory.doGetBean()中的
	// Create bean instance.
    if (mbd.isSingleton()) {
        sharedInstance = getSingleton(beanName, () -> {
            try {
                return createBean(beanName, mbd, args);
            }
            catch (BeansException ex) {
                // Explicitly remove instance from singleton cache: It might have been put there
                // eagerly by the creation process, to allow for circular reference resolution.
                // Also remove any beans that received a temporary reference to the bean.
                destroySingleton(beanName);
                throw ex;
            }
        });
        bean = getObjectForBeanInstance(sharedInstance, name, beanName, mbd);
    }
```

```java
protected Object doCreateBean(final String beanName, final RootBeanDefinition mbd, final @Nullable Object[] args) {

		// Instantiate the bean.
		BeanWrapper instanceWrapper = null;
		if (mbd.isSingleton()) {
			instanceWrapper = this.factoryBeanInstanceCache.remove(beanName);
		}
		if (instanceWrapper == null) {
			instanceWrapper = createBeanInstance(beanName, mbd, args);
		}
}
```

```java
//SimpleInstantiationStrategy
public Object instantiate(RootBeanDefinition bd, @Nullable String beanName, BeanFactory owner) {
	//完成实例化
    return BeanUtils.instantiateClass(constructorToUse);
	}
```
- 第二个重要的lambda表达式
```java
addSingletonFactory(beanName, () -> getEarlyBeanReference(beanName, mbd, bean));

	protected void addSingletonFactory(String beanName, ObjectFactory<?> singletonFactory) {
		Assert.notNull(singletonFactory, "Singleton factory must not be null");
		synchronized (this.singletonObjects) {
            //判断一级缓存中是否包含 beanName
			if (!this.singletonObjects.containsKey(beanName)) {
                //放入三级缓存，value为上面那个lamda表达式
				this.singletonFactories.put(beanName, singletonFactory);
				this.earlySingletonObjects.remove(beanName);
				this.registeredSingletons.add(beanName);
			}
		}
	}
```
- 填充属性

```java
protected void populateBean(String beanName, RootBeanDefinition mbd, @Nullable BeanWrapper bw) {

		if (pvs != null) {
			applyPropertyValues(beanName, mbd, bw, pvs);
		}
	}
```
- 核心方法

```java
    //DefaultSingletonBeanRegistry
	protected Object getSingleton(String beanName, boolean allowEarlyReference) {
        //先从一级缓存中找，由于目前2个对象均为填充完属性，所以找不到
		Object singletonObject = this.singletonObjects.get(beanName);
		if (singletonObject == null && isSingletonCurrentlyInCreation(beanName)) {
			synchronized (this.singletonObjects) {
                //再去二级缓存中找，二级缓存中放的是半成品
				singletonObject = this.earlySingletonObjects.get(beanName);
				if (singletonObject == null && allowEarlyReference) {
                    //三级缓存中放的是  () -> getEarlyBeanReference(beanName, mbd, bean)
					ObjectFactory<?> singletonFactory = this.singletonFactories.get(beanName);
					if (singletonFactory != null) {
						singletonObject = singletonFactory.getObject();
						this.earlySingletonObjects.put(beanName, singletonObject);
						this.singletonFactories.remove(beanName);
					}
				}
			}
		}
		return singletonObject;
	}
```
- 获取三级缓存中的lambda时执行的方法

```java
	/**
	 * Obtain a reference for early access to the specified bean,
	 * typically for the purpose of resolving a circular reference.
	 * @param beanName the name of the bean (for error handling purposes)
	 * @param mbd the merged bean definition for the bean
	 * @param bean the raw bean instance
	 * @return the object to expose as bean reference
       并不是初始化每个bean都会调用这个方法
	 */
	protected Object getEarlyBeanReference(String beanName, RootBeanDefinition mbd, Object bean) {
		Object exposedObject = bean;
		if (!mbd.isSynthetic() && hasInstantiationAwareBeanPostProcessors()) {
			for (BeanPostProcessor bp : getBeanPostProcessors()) {
				if (bp instanceof SmartInstantiationAwareBeanPostProcessor) {
					SmartInstantiationAwareBeanPostProcessor ibp = (SmartInstantiationAwareBeanPostProcessor) bp;
                    //为需要创建代理的bean，如果执行这个方法，原来的bean会被覆盖
					exposedObject = ibp.getEarlyBeanReference(exposedObject, beanName);
				}
			}
		}
		return exposedObject;
	}
```

### 思考与总结
- 三级缓存解决循环依赖问题的关键是什么?为什么通过提前暴露对象能解决?

  实例化和初始化分开操作，在中间过程中给其他对象赋值的时候，并不是一个完整对象，而是把
  半成品对象赋值给了其他对象
  
- 如果只使用- -级缓存能不能解决问题?

   不能。在整个处理过程中，缓存中放的是半成品和成品对象，如果只有一级缓存，那么成品和半
   成品都会放到一-级缓存中，有可能在获取过程中获取到半成品对象，此时半成品对象是无法使用
   的，不能直接进行相关的处理，因此要把半成品和成品的存放空间分割开来。
   
- 只使用级缓存行不行?为什么需要三级缓存?

   如果我能保证所有的bean对象都不去调用getEarlyBeanReference此方法，使用级缓存可以吗?
   是的，如果保证所有的bean对象都不调用此方法，就可以只使用二级缓存! ! !
   使用三级缓存的本质在于解决代理问题

- 如果某个bean对象代理对象，那么会不会创建普通的bean对象?
   会，必须会

- 为什么使用了三级缓存就可以解决这个问题?

    当一个对象需要被代理的时候，在整个创建过程中是包含两个对象吧。-一个是普通对象，-一个代理生成
    的对象，bean默认都是单例，那么我在整个生命周期的处理环节中，-个beanName能对应两个对象
    吗?不能，既然不能的话，保证我在使用的时候加-层判断，判断-下是否需要进行代理的处理。

- 我怎么知道你什么时候使用呢?

    因为不知道什么时候会调用，所以通过一个匿名内部类的方式，在使用的时候直接对普通对象进行覆盖
    操作，保证全局唯一! ! !




  
