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

import com.mysql.model.Absensi;
import com.mysql.model.AbsensiRowMapper;

@RestController
@RequestMapping("/absensi")
public class AbsensiController {

	@Autowired
	JdbcTemplate jdbc;
	
	public List<Absensi> getAbsensi(){
		String sql = "Select * from absensi";
		List<Absensi> absensi = jdbc.query(sql, new AbsensiRowMapper());
		return absensi;
		
	}
	
	public String insertAbsensi(Absensi absensi) {
		
		int sukses =jdbc.update("INSERT INTO `absensi`(`id`, `nik`, `start_date`, `end_date`) VALUES ('"+absensi.getId()+"','"+absensi.getNik()+"','"+absensi.getStart_date()+"','"+absensi.getEnd_date()+"')");
		
		String hasil;
		if(sukses == 1) {
			hasil="Berhasil input Data Absensi";
		}else {
			hasil="Gagal Input Data Absensi";
		}
		
		return hasil;
	}
	
	
	public String deleteAbsensi(int id) {
		
		int delete = jdbc.update("DELETE FROM `absensi` WHERE id="+id);
		String hasil;
		if(delete == 1) {
			hasil="Berhasil Hapus Data Absensi";
		}else {
			hasil="Gagal Hapus Data Absensi";
		}
		
		return hasil;
		
		
	}
	
	public String updateBiodata(int id, Absensi absensi) {
		
		int update = jdbc.update("UPDATE `absensi` SET `nik`='"+absensi.getNik()+"',`start_date`='"+absensi.getStart_date()+"',`end_date`='"+absensi.getEnd_date()+"' WHERE id= "+absensi.getId()+"");
		String hasil;
		if(update==1) {
			hasil="Berhasil Update Absensi";
		}else {
			hasil="Gagal Update Absensi";
		}
		return hasil;
	}
	
	
	
	
//	Mapping
	@GetMapping("/")
		public List<Absensi> getAll(){
			return getAbsensi();
		}
	
	@PostMapping("/")
		public String addData(@RequestBody Absensi absensi) {
		return insertAbsensi(absensi);
	}
	
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		return deleteAbsensi(id);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Absensi> update(@RequestBody Absensi absensi, @PathVariable int id) {
		try {
			updateBiodata(id, absensi);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
}
