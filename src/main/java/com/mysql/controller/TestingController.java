package com.mysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.dao.DaoBiodata;
import com.mysql.model.Biodata;
import com.mysql.model.BiodataRowMapper;

@RestController
public class TestingController {
	
	
//	@RequestMapping("/testing")
//	public String testPage(){ 
//		return "Good Morning";
//	}
	
//	@RequestMapping(method = RequestMethod.GET, value= "/")
//	public String homeIndex(){ 
//		return "<html><body><h1><b>Hello World</b></h1></body></html>";	
//	}
	
		@Autowired
		JdbcTemplate jdbc;
	
		public List<Biodata> getBiodata() {
			String sql= "Select * from Biodata";
			List <Biodata> biodata = jdbc.query(sql, new BiodataRowMapper());
			return biodata;	
		}
		
			public int insertBiodata(Biodata biodata) {
				return jdbc.update("insert into Biodata(nik,nama,alamat,id_salary) values ('"+biodata.getNik()+"','"+biodata.getNama()+"','"+biodata.getAlamat()+"',"+biodata.getId_Salary()+")");
		}
	
	
		@RequestMapping("/testing")
		public String testPage(){ 
		
//			DaoBiodata tblBiodata = new DaoBiodata();
		
			List<Biodata> lstBiodata = getBiodata();
			
			String dummy = "";
			for (int x=0; x < lstBiodata.size(); x++) {
				dummy+= lstBiodata.get(x).getNama() + ",";
			}
			return dummy;
	}
	
	
		@RequestMapping("/insert")
		public String insertBiodata() {
		
			Biodata biodata = new Biodata();
			biodata.setNik("N05");
			biodata.setNama("Ari Setiawan");
			biodata.setAlamat("Cibubur");
			biodata.setId_Salary(5);
			
			if(this.insertBiodata(biodata)==1) {
				return "Insert Data Berhasil";
			}else {
				return "Insert Data Gagal";
		}
		
	}
	
	
	
}
