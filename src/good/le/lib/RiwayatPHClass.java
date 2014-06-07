package good.le.lib;

public class RiwayatPHClass {
	int id,id_kandidat;
	String ringkasan,institusi,tanggal;
	
	public RiwayatPHClass(){
		
	}
	
	public RiwayatPHClass(int id,int id_kandidat,String ringkasan,String institusi,String tanggal){
		this.id = id;
		this.id = id_kandidat;
		this.ringkasan = ringkasan;
		this.institusi = institusi;
		this.tanggal = tanggal;
	}
	
	public RiwayatPHClass(int id_kandidat,String ringkasan,String institusi,String tanggal){
		this.id = id_kandidat;
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
	
	public int getIDKandidat(){
		return this.id_kandidat;
	}
	
	public void setIDKandidat(int id_kandidat){
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
