package com.codekul.java6AprilSpring.jdbctemplete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JdbcTempleteController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("getBankDetails")
    public List<BankDto> getBankDetails() {
        return jdbcTemplate.query("select * from bank", BeanPropertyRowMapper.newInstance(BankDto.class));
    }

    @GetMapping("getBankDetails/{id}")
    public BankDto getBankDetails(@PathVariable("id")Long id) {
        return jdbcTemplate.queryForObject("select * from bank where id = ?",
                new Object[]{id},BeanPropertyRowMapper.newInstance(BankDto.class));
    }

}
