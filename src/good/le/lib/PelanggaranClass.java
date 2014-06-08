package good.le.lib;

public class PelanggaranClass {
	int id;
	String judul,tanggal,alamat,kelurahan,kecamatan,kota,provinsi,keterangan,kategori,status,tags;
	
	public PelanggaranClass(){
		
	}
	
	public PelanggaranClass(int id,String judul,String tanggal,String alamat,String kelurahan,String kecamatan,String kota,String provinsi,String keterangan,String kategori,String status,String tags){
		this.id = id;
		this.judul = judul;
		this.tanggal = tanggal;
		this.alamat = alamat;
		this.kelurahan = kelurahan;
		this.kecamatan = kecamatan;
		this.kota = kota;
		this.provinsi = provinsi;
		this.keterangan = keterangan;
		this.kategori = kategori;
		this.status = status;
		this.tags = tags;
	}
	
	public PelanggaranClass(String judul,String tanggal,String alamat,String kelurahan,String kecamatan,String kota,String provinsi,String keterangan,String kategori,String status,String tags){
		this.judul = judul;
		this.tanggal = tanggal;
		this.alamat = alamat;
		this.kelurahan = kelurahan;
		this.kecamatan = kecamatan;
		this.kota = kota;
		this.provinsi = provinsi;
		this.keterangan = keterangan;
		this.kategori = kategori;
		this.status = status;
		this.tags = tags;
	}
	
	public int getID(){
		return this.id;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public String getJudul(){
		return this.judul;
	}
	
	public void setJudul(String judul){
		this.judul = judul;
	}
	
	public String getTanggal(){
		return this.tanggal;
	}
	
	public void setTanggal(String tanggal){
		this.tanggal = tanggal;
	}
	
	public String getAlamat(){
		return this.alamat;
	}
	
	public void setAlamat(String alamat){
		this.alamat = alamat;
	}
	
	public String getKelurahan(){
		return this.kelurahan;
	}
	
	public void setKelurahan(String kelurahan){
		this.kelurahan = kelurahan;
	}
	
	public String getKecamatan(){
		return this.kecamatan;
	}
	
	public void setKecamatan(String kecamatan){
		this.kecamatan = kecamatan;
	}
	
	public String getKota(){
		return this.kota;
	}
	
	public void setKota(String kota){
		this.kota = kota;
	}
	
	public String getProvinsi(){
		return this.provinsi;
	}
	
	public void setProvinsi(String provinsi){
		this.provinsi = provinsi;
	}
	
	public String getKeterangan(){
		return this.keterangan;
	}
	
	public void setKeterangan(String keterangan){
		this.keterangan = keterangan;
	}
	
	public String getKategori(){
		return this.kategori;
	}
	
	public void setKategori(String kategori){
		this.kategori = kategori;
	}
	
	public String getStatus(){
		return this.status;
	}
	
	public void setStatus(String status){
		this.status = status;
	}
	
	public String getTags(){
		return this.tags;
	}
	
	public void setTags(String tags){
		this.tags = tags;
	}
}
