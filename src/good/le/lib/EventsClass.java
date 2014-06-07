package good.le.lib;

public class EventsClass {
	int id;
	String inisial_kandidat,judul,deskripsi,tanggal_mulai,waktu_mulai,tanggal_selesai,tags;
	
	public EventsClass(){
		
	}
	
	public EventsClass(int id,String inisial_kandidat, String judul, String deskripsi, String tanggal_mulai, String waktu_mulai, String tanggal_selesai, String tags){
		this.id = id;
		this.inisial_kandidat = inisial_kandidat;
		this.judul = judul;
		this.deskripsi = deskripsi;
		this.tanggal_mulai = tanggal_mulai;
		this.waktu_mulai = waktu_mulai;
		this.tanggal_selesai = tanggal_selesai;
		this.tags = tags;
	}
	
	public EventsClass(String inisial_kandidat, String judul, String deskripsi, String tanggal_mulai, String waktu_mulai, String tanggal_selesai, String tags){
		this.inisial_kandidat = inisial_kandidat;
		this.judul = judul;
		this.deskripsi = deskripsi;
		this.tanggal_mulai = tanggal_mulai;
		this.waktu_mulai = waktu_mulai;
		this.tanggal_selesai = tanggal_selesai;
		this.tags = tags;
	}
	
	public int getID(){
		return this.id;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public String getInisialKandidat(){
		return this.inisial_kandidat;
	}
	
	public void setInisialKandidat(String inisial_kandidat){
		this.inisial_kandidat = inisial_kandidat;
	}
	
	public String getJudul(){
		return this.judul;
	}
	
	public void setJudul(String judul){
		this.judul = judul;
	}
	
	public String getDeskripsi(){
		return this.deskripsi;
	}
	
	public void setDeskripsi(String deskripsi){
		this.deskripsi = deskripsi;
	}
	
	public String getTanggalMulai(){
		return this.tanggal_mulai;
	}
	
	public void setTanggalMulai(String tanggal_mulai){
		this.tanggal_mulai = tanggal_mulai;
	}
	
	public String getWaktuMulai(){
		return this.waktu_mulai;
	}
	
	public void setWaktuMulai(String waktu_mulai){
		this.waktu_mulai = waktu_mulai;
	}
	
	public String getTanggalSelesai(){
		return this.getTanggalSelesai();
	}
	
	public void setTanggalSelesai(String tanggal_selesai){
		this.tanggal_selesai = tanggal_selesai;
	}
	
	public String getTags(){
		return this.tags;
	}
	
	public void setTags(String tags){
		this.tags = tags;
	}
}
