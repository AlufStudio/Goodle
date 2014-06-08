package good.le.lib;

public class JanjiClass {
	int id;
	String inisial_kandidat,context_janji,janji,tanggal,judul_sumber,url_sumber,tags_janji;
	
	public JanjiClass(){
		
	}
	
	public JanjiClass(int id,String inisial_kandidat, String context_janji, String janji, String tanggal, String judul_sumber, String url_sumber, String tags_janji){
		this.id = id;
		this.inisial_kandidat = inisial_kandidat;
		this.context_janji = context_janji;
		this.janji = janji;
		this.tanggal = tanggal;
		this.judul_sumber = judul_sumber;
		this.url_sumber = url_sumber;
		this.tags_janji = tags_janji;
	}
	
	public JanjiClass(String inisial_kandidat, String context_janji, String janji, String tanggal, String judul_sumber, String url_sumber, String tags_janji){
		this.inisial_kandidat = inisial_kandidat;
		this.context_janji = context_janji;
		this.janji = janji;
		this.tanggal = tanggal;
		this.judul_sumber = judul_sumber;
		this.url_sumber = url_sumber;
		this.tags_janji = tags_janji;
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
	
	public String getContextJanji(){
		return this.context_janji;
	}
	
	public void setContextJanji(String context_janji){
		this.context_janji = context_janji;
	}
	
	public String getJanji(){
		return this.janji;
	}
	
	public void setJanji(String janji){
		this.janji = janji;
	}
	
	public String getTanggal(){
		return this.tanggal;
	}
	
	public void setTanggal(String tanggal){
		this.tanggal = tanggal;
	}
	
	public String getJudulSumber(){
		return this.judul_sumber;
	}
	
	public void setJudulSumber(String judul_sumber){
		this.judul_sumber = judul_sumber;
	}
	
	public String getUrlSumber(){
		return this.url_sumber;
	}
	
	public void setUrlSumber(String url_sumber){
		this.url_sumber = url_sumber;
	}
	
	public String getTagsJanji(){
		return this.janji;
	}
	
	public void setTagsJanji(String tags_janji){
		this.tags_janji = tags_janji;
	}
}
