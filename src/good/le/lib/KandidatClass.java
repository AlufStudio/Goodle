package good.le.lib;

public class KandidatClass {
	int id,tahun,jumlah_anak;
	String inisial,role,running_mate,jenis_kelamin,agama,tempat_lahir,tanggal_lahir,status_kawin,nama_pasangan,kelurahan,kecamatan,kota,provinsi,nama_partai,biografi;
	
	public KandidatClass(){
		
	}
	
	public KandidatClass(int id,int tahun,int jumlah_anak,String inisial,String role,String running_mate,String jenis_kelamin,String agama,String tempat_lahir,String tanggal_lahir,String status_kawin,String nama_pasangan,String kelurahan,String kecamatan,String kota,String provinsi,String nama_partai,String biografi){
		this.id = id;
		this.tahun = tahun;
		this.jumlah_anak = jumlah_anak;
		this.inisial = inisial;
		this.role = role;
		this.running_mate = running_mate;
		this.jenis_kelamin = jenis_kelamin;
		this.agama = agama;
		this.tempat_lahir = tempat_lahir;
		this.tanggal_lahir = tanggal_lahir;
		this.status_kawin = status_kawin;
		this.nama_pasangan = nama_pasangan;
		this.kelurahan = kelurahan;
		this.kecamatan = kecamatan;
		this.kota = kota;
		this.provinsi = provinsi;
		this.nama_partai = nama_partai;
		this.biografi = biografi;
	}
	
	public KandidatClass(int tahun,int jumlah_anak,String inisial,String role,String running_mate,String jenis_kelamin,String agama,String tempat_lahir,String tanggal_lahir,String status_kawin,String nama_pasangan,String kelurahan,String kecamatan,String kota,String provinsi,String nama_partai,String biografi){
		this.tahun = tahun;
		this.jumlah_anak = jumlah_anak;
		this.inisial = inisial;
		this.role = role;
		this.running_mate = running_mate;
		this.jenis_kelamin = jenis_kelamin;
		this.agama = agama;
		this.tempat_lahir = tempat_lahir;
		this.tanggal_lahir = tanggal_lahir;
		this.status_kawin = status_kawin;
		this.nama_pasangan = nama_pasangan;
		this.kelurahan = kelurahan;
		this.kecamatan = kecamatan;
		this.kota = kota;
		this.provinsi = provinsi;
		this.nama_partai = nama_partai;
		this.biografi = biografi;
	}
	
	public int getID(){
		return this.id;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public int getTahun(){
		return this.tahun;
	}
	
	public void setTahun(int tahun){
		this.tahun = tahun;
	}
	
	public int getJumlahAnak(){
		return this.jumlah_anak;
	}
	
	public void setJumlahAnak(int jumlah_anak){
		this.jumlah_anak = jumlah_anak;
	}
	
	public String getInisial(){
		return this.inisial;
	}
	
	public void setInisial(String inisial){
		this.inisial = inisial;
	}
	
	public String getRole(){
		return this.role;
	}
	
	public void setRole(String role){
		this.role = role;
	}
	
	public String getRunningMate(){
		return this.running_mate;
	}
	
	public void setRunningMate(String running_mate){
		this.running_mate = running_mate;
	}
	
	public String getJenisKelamin(){
		return this.jenis_kelamin;
	}
	
	public void setJenisKelamin(String jenis_kelamin){
		this.jenis_kelamin = jenis_kelamin;
	}
	
	public String getAgama(){
		return this.agama;
	}
	
	public void setAgama(String agama){
		this.agama = agama;
	}
	
	public String getTempatLahir(){
		return this.tempat_lahir;
	}
	
	public void setTempatLahir(String tempat_lahir){
		this.tempat_lahir = tempat_lahir;
	}
	
	public String getTanggalLahir(){
		return this.tanggal_lahir;
	}
	
	public void setTanggalLahir(String tanggal_lahir){
		this.tanggal_lahir = tanggal_lahir;
	}
	
	public String getStatusKawin(){
		return this.status_kawin;
	}
	
	public void setStatusKawin(String status_kawin){
		this.status_kawin = status_kawin;
	}
	
	public String getNamaPasangan(){
		return this.nama_pasangan;
	}
	
	public void setNamaPasangan(String nama_pasangan){
		this.nama_pasangan = nama_pasangan;
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
	
	public String getNamaPartai(){
		return this.nama_partai;
	}
	
	public void setNamaPartai(String nama_partai){
		this.nama_partai = nama_partai;
	}
	
	public String getBiografi(){
		return this.biografi;
	}
	
	public void setBiografi(String biografi){
		this.biografi = biografi;
	}
}