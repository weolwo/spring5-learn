package com.poplar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create BY poplar ON 2020/4/18
 */
@Repository
public class StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void add() {
        jdbcTemplate.update("INSERT INTO `student`(`name`, `note`) VALUES (?, ?)", "MMM", "名字");
        System.out.println("操作完成");
        int x = 1/0;
    }
}
