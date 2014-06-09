package good.le.lib;

public class RiwayatPHClass {
	int id;
	String id_kandidat,ringkasan,institusi,tanggal;
	
	public RiwayatPHClass(){
		
	}
	
	public RiwayatPHClass(int id,String id_kandidat,String ringkasan,String institusi,String tanggal){
		this.id = id;
		this.id_kandidat = id_kandidat;
		this.ringkasan = ringkasan;
		this.institusi = institusi;
		this.tanggal = tanggal;
	}
	
	public RiwayatPHClass(String id_kandidat,String ringkasan,String institusi,String tanggal){
		this.id_kandidat = id_kandidat;
		this.ringkasan = ringkasan;
		this.institusi = institusi;
		this.tanggal = tanggal;
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
	
	public String getInstitusi(){
		return this.institusi;
	}
	
	public void setInstitusi(String institusi){
		this.institusi = institusi;
	}
	
	public String getTanggal(){
		return this.tanggal;
	}
	
	public void setTanggal(String tanggal){
		this.tanggal = tanggal;
	}
}
