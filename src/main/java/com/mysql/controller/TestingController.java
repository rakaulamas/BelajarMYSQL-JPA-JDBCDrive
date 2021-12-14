package com.mysql.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.mysql.model.Biodata;
import com.mysql.model.BiodataRowMapper;

@RestController
@RequestMapping("/biodata")
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
	
	
		public int updateBiodata(String nik, Biodata biodata) {
			return jdbc.update("UPDATE biodata set `nama`='"+biodata.getNama()+"',`alamat`='"+biodata.getAlamat()+"',`id_salary`="+biodata.getId_Salary()+" WHERE nik = '"	+biodata.getNik()+"'");
		}

		public int deleteBiodata(String nik) {
			return jdbc.update("DELETE from `biodata` WHERE `nik`= '"+nik+"';");
		}
		
		
		
		
		
		@GetMapping("/view")
	 	public List<Biodata> list(){
			return getBiodata();
		}
		
		
		@PostMapping("/")
		public String add(@RequestBody Biodata biodata) {
			
			if(this.insertBiodata(biodata)==1) {
				return "Insert Data Berhasil";
			}else {
				return "Gagal Insert Data";
			}
		}
		
		
		@PutMapping("/{nik}")
		public ResponseEntity<?> update(@RequestBody Biodata biodata, @PathVariable String nik){
			try {
				updateBiodata(nik,biodata);
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (NoSuchElementException e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		}
		
		
		@DeleteMapping("/{nik}")
		public String delete(@PathVariable String nik) {
			if(deleteBiodata(nik)==1) {
				return "Berhasil Hapus Biodata";
			}else {
			return "Gagal Hapus Biodata";
			}
		}
		
		
		
		
//		@RequestMapping("/testing")
//		public String testPage(){ 
//		
////			DaoBiodata tblBiodata = new DaoBiodata();
//		
//			List<Biodata> lstBiodata = getBiodata();
//			
//			String dummy = "";
//			for (int x=0; x < lstBiodata.size(); x++) {
//				dummy+= lstBiodata.get(x).getNama() + ",";
//			}
//			return dummy;
//	}
	
	
//		@RequestMapping("/insert")
//		public String insertBiodata() {
//		
//			Biodata biodata = new Biodata();
//			biodata.setNik("N05");
//			biodata.setNama("Ari Setiawan");
//			biodata.setAlamat("Cibubur");
//			biodata.setId_Salary(5);
//			
//			if(this.insertBiodata(biodata)==1) {
//				return "Insert Data Berhasil";
//			}else {
//				return "Insert Data Gagal";
//		}
//		
//	}
	
	
	
}
