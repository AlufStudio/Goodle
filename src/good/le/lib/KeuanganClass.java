package good.le.lib;

public class KeuanganClass {
	int id,tahun,uang,nilai_barang,unit_barang,nilai_jasa,jumlah;
	String periode,role,partai,id_calon,lembaga,mata_uang,bentuk_jasa,keterangan;
	
	public KeuanganClass(){
		
	}
	
	public KeuanganClass(int id, int tahun, int uang, int nilai_barang, int unit_barang, int nilai_jasa,int jumlah, String periode, String role, String partai, String id_calon,String lembaga, String mata_uang, String bentuk_jasa,String keterangan){
		this.id = id;
		this.tahun = tahun;
		this.uang = uang;
		this.nilai_barang = nilai_barang;
		this.unit_barang = unit_barang;
		this.nilai_jasa = nilai_jasa;
		this.jumlah = jumlah;
		this.periode = periode;
		this.role = role;
		this.partai = partai;
		this.id_calon = id_calon;
		this.lembaga = mata_uang;
		this.bentuk_jasa = bentuk_jasa;
		this.keterangan = keterangan;
	}
	
	public KeuanganClass(int tahun, int uang, int nilai_barang, int unit_barang, int nilai_jasa,int jumlah, String periode, String role, String partai, String id_calon,String lembaga, String mata_uang, String bentuk_jasa,String keterangan){
		this.tahun = tahun;
		this.uang = uang;
		this.nilai_barang = nilai_barang;
		this.unit_barang = unit_barang;
		this.nilai_jasa = nilai_jasa;
		this.jumlah = jumlah;
		this.periode = periode;
		this.role = role;
		this.partai = partai;
		this.id_calon = id_calon;
		this.lembaga = mata_uang;
		this.bentuk_jasa = bentuk_jasa;
		this.keterangan = keterangan;
	}
	
	public int getID(){
		return this.id;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public int getUang(){
		return this.uang;
	}
	
	public void setUang(int uang){
		this.uang = uang;
	}
	
	public int getTahun(){
		return this.tahun;
	}
	
	public void setTahun(int tahun){
		this.tahun = tahun;
	}
	
	public int getNilaiBarang(){
		return this.nilai_barang;
	}
	
	public void setNilaiBarang(int nilai_barang){
		this.nilai_barang = nilai_barang;
	}
	
	public int getUnitBarang(){
		return this.unit_barang;
	}
	
	public void setUnitBarang(int unit_barang){
		this.unit_barang = unit_barang;
	}
	
	public int getNilaiJasa(){
		return this.nilai_jasa;
	}
	
	public void setNilaiJasa(int nilai_jasa){
		this.nilai_jasa = nilai_jasa;
	}
	
	public int getJumlah(){
		return this.jumlah;
	}
	
	public void setJumlah(int jumlah){
		this.jumlah = jumlah;
	}
	
	public String getPeriode(){
		return this.periode;
	}
	
	public void setPeriode(String periode){
		this.periode = periode;
	}
	
	public String getRole(){
		return this.role;
	}
	
	public void setRole(String role){
		this.role = role;
	}
	
	public String getPartai(){
		return this.partai;
	}
	
	public void setPartai(String partai){
		this.partai = partai;
	}
	
	public String getIDCalon(){
		return this.id_calon;
	}
	
	public void setIDCalon(String id_calon){
		this.id_calon = id_calon;
	}
	
	public String getLembaga(){
		return this.lembaga;
	}
	
	public void setLembaga(String lembaga){
		this.lembaga = lembaga;
	}
	
	public String getMataUang(){
		return this.mata_uang;
	}
	
	public void setMataUang(String mata_uang){
		this.mata_uang = mata_uang;
	}
	
	public String getBentukJasa(){
		return this.bentuk_jasa;
	}
	
	public void setBentukJasa(String bentuk_jasa){
		this.bentuk_jasa = bentuk_jasa;
	}
	
	public String getKeterangan(){
		return this.keterangan;
	}
	
	public void setKeterangan(String keterangan){
		this.keterangan = keterangan;
	}
}
