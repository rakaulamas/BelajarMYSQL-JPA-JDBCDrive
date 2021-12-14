package com.mysql.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;



public class DaoBiodata {

		@Autowired
		JdbcTemplate jdbc;
	
//		public int insertBiodata(Biodata biodata) {
//			return jdbc.update("insert into Biodata(nik,nama,alamat,id_salary) values ('"+biodata.getNik()+"','"+biodata.getNama()+"','"+biodata.getAlamat()+"',"+biodata.getId_Salary()+")");
//		}
		
		
//		public List<Biodata> getBiodata() {
//			String sql= "Select * from Biodata";
//			List<Biodata> biodata = jdbc.query(sql, new BiodataRowMapper());
//			return biodata;	
//		}
		
		public int updateBiodata() {
			return 0;
		}
	
		public int deleteBiodata() {
			return 0;
		}
}
