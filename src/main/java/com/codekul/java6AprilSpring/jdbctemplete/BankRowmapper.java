package com.codekul.java6AprilSpring.jdbctemplete;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BankRowmapper implements RowMapper<BankDto> {
    @Override
    public BankDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        BankDto bankDto = new BankDto();
        bankDto.setId(rs.getLong("id"));
        bankDto.setAccountNumber(rs.getLong("account_number"));
        bankDto.setIfscCode(rs.getString("ifsc_code"));
        return bankDto;
    }
}
