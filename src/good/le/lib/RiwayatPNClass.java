package good.le.lib;

public class RiwayatPNClass {
	int id;
	String id_kandidat,ringkasan,tahun_mulai,tahun_selesai;
	
	public RiwayatPNClass(){
		
	}
	
	public RiwayatPNClass(int id,String id_kandidat,String ringkasan,String tahun_mulai,String tahun_selesai){
		this.id = id;
		this.id_kandidat = id_kandidat;
		this.ringkasan = ringkasan;
		this.tahun_mulai = tahun_mulai;
		this.tahun_selesai = tahun_selesai;
	}
	
	public RiwayatPNClass(String id_kandidat,String ringkasan,String tahun_mulai,String tahun_selesai){
		this.id_kandidat = id_kandidat;
		this.ringkasan = ringkasan;
		this.tahun_mulai = tahun_mulai;
		this.tahun_selesai = tahun_selesai;
	}
	
	public int getID(){
		return this.id;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public String getIDKandidat(){
		return this.id_kandidat;
	}
	
	public void setIDKandidat(String id_kandidat){
		this.id_kandidat = id_kandidat;
	}
	
	public String getRingkasan(){
		return this.ringkasan;
	}
	
	public void setRingkasan(String ringkasan){
		this.ringkasan = ringkasan;
	}
	
	public String getTahunMulai(){
		return this.tahun_mulai;
	}
	
	public void setTahunMulai(String tahun_mulai){
		this.tahun_mulai = tahun_mulai;
	}
	
	public String getTahunSelesai(){
		return this.tahun_selesai;
	}
	
	public void setTahunSelesai(String tahun_selesai){
		this.tahun_selesai = tahun_selesai;
	}
}
