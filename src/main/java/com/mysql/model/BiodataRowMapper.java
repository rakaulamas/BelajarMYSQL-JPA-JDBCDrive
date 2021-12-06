package com.mysql.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BiodataRowMapper implements RowMapper<Biodata> {

	@Override
	public Biodata mapRow(ResultSet rs, int rowNum) throws SQLException {
		Biodata biodata = new Biodata();
		biodata.setNik(rs.getString("Nik"));
		biodata.setNama(rs.getString("nama"));
		biodata.setAlamat(rs.getString("alamat"));
		biodata.setId_Salary(rs.getInt("id_salary"));
		
		return biodata;
	}

	
}
