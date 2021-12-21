package com.mysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mysql.model.KPR;
import com.mysql.model.KPRDataPelanggan;
import com.mysql.model.KPRRowMapper;

@RestController
@RequestMapping("/kpr")
public class KPRController {

	@Autowired
	JdbcTemplate jdbc;
	
	
	public List<KPR> viewDataKPR(){
		String sql= "CALL `ulangBulan`('2021-12-21 00:00:00.000000', '15000000', '1.2', '12')";
		List<KPR> kpr = jdbc.query(sql, new KPRRowMapper());
		return kpr;
	}
	
	
	@GetMapping("/")
	public List<KPR> getAll(){
		return viewDataKPR();
	} 
	
	
	@PostMapping("/showKpr")
		public List<KPR> lstKpr(@RequestBody KPRDataPelanggan kprDataPelanggan) {
		String sql= "CALL `ulangBulan`('"+kprDataPelanggan.getDf()+"', '"+kprDataPelanggan.getPlatfond()+"', '"+kprDataPelanggan.getBunga()+"', '"+kprDataPelanggan.getLamapinjaman()+"')";
		List<KPR> kpr = jdbc.query(sql, new KPRRowMapper());
		return kpr;
	}
	
	
	
	
	
}
