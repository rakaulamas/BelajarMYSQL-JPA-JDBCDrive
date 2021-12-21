package com.mysql.model;

public class KPRDataPelanggan {

	private String df;
	private int lamapinjaman;
	private double platfond;
	private double bunga;
	
	
	
	
	public KPRDataPelanggan(String df, int lamapinjaman, double platfond, double bunga) {		//Menggunakan field contructor
		super();
		this.df = df;
		this.lamapinjaman = lamapinjaman;
		this.platfond = platfond;
		this.bunga = bunga;
	}


	public String getDf() {
		return df;
	}
	public void setDf(String df) {
		this.df = df;
	}
	public int getLamapinjaman() {
		return lamapinjaman;
	}
	public void setLamapinjaman(int lamapinjaman) {
		this.lamapinjaman = lamapinjaman;
	}
	public double getPlatfond() {
		return platfond;
	}
	public void setPlatfond(double platfond) {
		this.platfond = platfond;
	}
	public double getBunga() {
		return bunga;
	}
	public void setBunga(double bunga) {
		this.bunga = bunga;
	}
	
	
	
	
	
	
	
}
