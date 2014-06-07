package good.le;

import good.le.lib.DatabaseHandler;
import good.le.lib.JSONParser;
import good.le.lib.KandidatClass;
import good.le.lib.RiwayatPHClass;
import good.le.lib.RiwayatPPClass;
import good.le.lib.RiwayatROClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
	JSONParser jsonParser;
	DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHandler(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    class AmbilSemuaKandidat extends AsyncTask<String, Integer, String>{

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			try {
				JSONObject json = jsonParser.getJSONFromUrl("http://api.pemiluapi.org/calonpresiden/api/caleg?apiKey=fea6f7d9ec0b31e256a673114792cb17");
				JSONObject data = json.getJSONObject("data");
				JSONObject results = data.getJSONObject("results");
				JSONArray caleg = results.getJSONArray("caleg");
				for(int i = 0;i < caleg.length();i++){
					JSONObject detail_caleg = caleg.getJSONObject(i);
					
					String inisial_caleg = detail_caleg.getString("id");
					int tahun_caleg = detail_caleg.getInt("tahun");
					String role_caleg = detail_caleg.getString("role");
					String id_running_mate_caleg = detail_caleg.getString("id_running_mate");
					String jenis_kelamin_caleg = detail_caleg.getString("jenis_kelamin");
					String agama_caleg = detail_caleg.getString("agama");
					String tempat_lahir_caleg = detail_caleg.getString("tempat_lahir");
					String tanggal_lahir_caleg = detail_caleg.getString("tanggal_lahir");
					String status_perkawinan_caleg = detail_caleg.getString("status_perkawinan");
					String nama_pasangan_caleg = detail_caleg.getString("nama_pasangan");
					int jumlah_anak_caleg = detail_caleg.getInt("jumlah_anak");
					String kelurahan_tinggal_caleg = detail_caleg.getString("kelurahan_tinggal");
					String kecamatan_tinggal_caleg = detail_caleg.getString("kecamatan_tinggal");
					String kab_kota_tinggal_caleg = detail_caleg.getString("kab_kota_tinggal");
					String provinsi_tinggal = detail_caleg.getString("provinsi_tinggal");
					JSONObject partai = detail_caleg.getJSONObject("partai");
					String nama_partai_caleg = partai.getString("nama");
					String biografi_caleg = detail_caleg.getString("biografi");
					
					//Insert ke table kandidat
					db.addKandidat(new KandidatClass(i, tahun_caleg, jumlah_anak_caleg, inisial_caleg, role_caleg, id_running_mate_caleg, jenis_kelamin_caleg, agama_caleg, tempat_lahir_caleg, tanggal_lahir_caleg, status_perkawinan_caleg, nama_pasangan_caleg, kelurahan_tinggal_caleg, kecamatan_tinggal_caleg, kab_kota_tinggal_caleg, provinsi_tinggal, nama_partai_caleg, biografi_caleg));
					
					//Get riwayat pendidikan
					JSONArray riwayat_pendidikan = detail_caleg.getJSONArray("riwayat_pendidikan");
					for(int j = 0;j < riwayat_pendidikan.length();j++){
						JSONObject detail_riwayat_pendidikan = riwayat_pendidikan.getJSONObject(j);
						String ringkasan_rpn_caleg = detail_riwayat_pendidikan.getString("ringkasan");
						String tanggal_mulai_rpn_caleg = detail_riwayat_pendidikan.getString("tanggal_mulai");
						String tanggal_selesai_rpn_caleg = detail_riwayat_pendidikan.getString("tanggal_selesai");
						
						//Insert ke table riwayat pendidikan
						db.addRiwayatRPK(new RiwayatPPClass(j, i, ringkasan_rpn_caleg, tanggal_mulai_rpn_caleg, tanggal_selesai_rpn_caleg));
					}
					
					//Get riwayat pekerjaan
					JSONArray riwayat_pekerjaan = detail_caleg.getJSONArray("riwayat_pendidikan");
					for(int k = 0;k < riwayat_pekerjaan.length();k++){
						JSONObject detail_riwayat_pekerjaan = riwayat_pekerjaan.getJSONObject(k);
						String ringkasan_rpk_caleg = detail_riwayat_pekerjaan.getString("ringkasan");
						String tanggal_mulai_rpk_caleg = detail_riwayat_pekerjaan.getString("tanggal_mulai");
						String tanggal_selesai_rpk_caleg = detail_riwayat_pekerjaan.getString("tanggal_selesai");
						
						//Input ke table riwayat pekerjaan
						db.addRiwayatRPN(new RiwayatPPClass(k, i, ringkasan_rpk_caleg, tanggal_mulai_rpk_caleg, tanggal_selesai_rpk_caleg));
					}
					
					//Get riwayat organisasi
					JSONArray riwayat_organisasi = detail_caleg.getJSONArray("riwayat_organisasi");
					for(int l = 0;l < riwayat_organisasi.length();l++){
						JSONObject detail_riwayat_organisasi = riwayat_organisasi.getJSONObject(l);
						String ringkasan_ro_caleg = detail_riwayat_organisasi.getString("ringkasan");
						String jabatan_ro_caleg = detail_riwayat_organisasi.getString("jabatan");
						String tanggal_mulai_ro_caleg = detail_riwayat_organisasi.getString("tanggal_mulai");
						String tanggal_selesai_ro_caleg = detail_riwayat_organisasi.getString("tanggal_selesai");
						
						//Input ke table riwayat organisasi
						db.addRiwayatRO(new RiwayatROClass(l, i, ringkasan_ro_caleg, jabatan_ro_caleg, tanggal_mulai_ro_caleg, tanggal_selesai_ro_caleg));
					}
					
					//Get riwayat penghargaan
					JSONArray riwayat_penghargaan = detail_caleg.getJSONArray("riwayat_penghargaan");
					for(int m = 0;m < riwayat_penghargaan.length();m++){
						JSONObject detail_riwayat_penghargaan = riwayat_penghargaan.getJSONObject(m);
						String ringkasan_rph_caleg = detail_riwayat_penghargaan.getString("ringkasan");
						String institusi_rph_caleg = detail_riwayat_penghargaan.getString("institusi");
						String tanggal_rph_caleg = detail_riwayat_penghargaan.getString("tanggal");
						
						//Input ke table riwayat organisasi
						db.addRiwayatPH(new RiwayatPHClass(m, i, ringkasan_rph_caleg, institusi_rph_caleg, tanggal_rph_caleg));
					}
					
					//Input ke table candidate
				}
			} catch (JSONException e){
				e.printStackTrace();
			}
			return null;
		}
    	
    }
    
    class AmbilSemuaEvent extends AsyncTask<String, Integer, String>{

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			try {
				JSONObject json = jsonParser.getJSONFromUrl("http://api.pemiluapi.org/calonpresiden/api/events?apiKey=fea6f7d9ec0b31e256a673114792cb17");
				JSONObject data = json.getJSONObject("data");
				JSONObject results = data.getJSONObject("results");
				JSONArray events = results.getJSONArray("events");
				
				for(int i = 0;i < events.length();i++){
					JSONObject detail_events = events.getJSONObject(i);
					String inisial_calon_event = detail_events.getJSONArray("id_calon").toString();
					String judul_event = detail_events.getString("judul");
					String deskripsi_event = detail_events.getString("deskripsi");
					String tanggal_mulai_event = detail_events.getString("tanggal_mulai");
					String waktu_mulai_event = detail_events.getString("waktu_mulai");
					String tanggal_selesai_event = detail_events.getString("tanggal_selesai");
					String tags_event = detail_events.getJSONArray("tags").toString();
					
					//Input ke table event
				}
			} catch (JSONException e){
				e.printStackTrace();
			}
			return null;
		}
    	
    }
    
    class AmbilSemuaJanji extends AsyncTask<String, Integer, String>{

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			try {
				JSONObject json = jsonParser.getJSONFromUrl("http://api.pemiluapi.org/calonpresiden/api/promises?apiKey=fea6f7d9ec0b31e256a673114792cb17");
				JSONObject data = json.getJSONObject("data");
				JSONObject results = data.getJSONObject("results");
				JSONArray promises = results.getJSONArray("promises");
				
				for(int i = 0;i < promises.length();i++){
					JSONObject detail_promises = promises.getJSONObject(i);
					String inisial_calon = detail_promises.getString("id_calon");
					String context_janji = detail_promises.getString("context_janji");
					String janji = detail_promises.getString("janji");
					String tanggal = detail_promises.getString("tanggal");
					String judul_sumber = detail_promises.getString("judul_sumber");
					String url_sumber = detail_promises.getString("url_sumber");
					String tags_janji = detail_promises.getJSONArray("tags").toString();
					
					//Input ke table promise
				}
				
			} catch (JSONException e){
				e.printStackTrace();
			}
			return null;
		}

    }
    
    class AmbilDataKeuangan extends AsyncTask<String, Integer, String>{

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			try{
				JSONObject json = jsonParser.getJSONFromUrl("http://api.pemiluapi.org/campaignfinance/api/contributions?apiKey=fea6f7d9ec0b31e256a673114792cb17");
				JSONObject data = json.getJSONObject("data");
				JSONObject results = data.getJSONObject("results");
				JSONArray contributions = results.getJSONArray("contributions");
				for(int i = 0;i < contributions.length();i++){
					JSONObject detail_contributions = contributions.getJSONObject(i);
					String periode_contributions = detail_contributions.getJSONArray("periode").toString();
					String role_contributions = detail_contributions.getString("role");
					String partai_contributions = detail_contributions.getString("partai");
					String id_calon_contributions = detail_contributions.getString("id_calon");
					String lembaga_contributions = detail_contributions.getString("lembaga");
					int tahun_contributions = detail_contributions.getInt("tahun");
					String mata_uang_contributions = detail_contributions.getString("mata_uang");
					int uang_contributions = detail_contributions.getInt("uang");
					int nilai_barang_contributions = detail_contributions.getInt("nilai_barang");
					int unit_barang_contributions = detail_contributions.getInt("unit_barang");
					int nilai_jasa_contributions = detail_contributions.getInt("nilai_jasa");
					String bentuk_jasa_contributions = detail_contributions.getString("bentuk_jasa");
					int jumlah_contributions = detail_contributions.getInt("jumlah");
					String keterangan_contributions = detail_contributions.getString("keterangan");
					
					//Insert database
				}
			} catch (JSONException e){
				e.printStackTrace();
			}
			return null;
		}
    	
    }
    
    class AmbilDataPelanggaran extends AsyncTask<String, Integer, String>{

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			try {
				JSONObject json = jsonParser.getJSONFromUrl("http://api.pemiluapi.org/laporan_pelanggaran/api/reports?apiKey=fea6f7d9ec0b31e256a673114792cb17");
				JSONObject data = json.getJSONObject("data");
				JSONObject results = data.getJSONObject("results");
				JSONArray reports = results.getJSONArray("reports");
				for(int i = 0; i < reports.length();i++){
					JSONObject detail_reports = reports.getJSONObject(i);
					String judul_laporan_reports = detail_reports.getString("judul_laporan");
					String tanggal_kejadian_reports = detail_reports.getString("tanggal_kejadian");
					String alamat_reports = detail_reports.getString("alamat");
					String kelurahan_desa_reports = detail_reports.getString("kelurahan_desa");
					String kecamatan_reports = detail_reports.getString("kecamatan");
					String kab_kota_reports = detail_reports.getString("kab_kota");
					String provinsi_reports = detail_reports.getString("provinsi");
					String keterangan_reports = detail_reports.getString("keterangan");
					String kategori_reports = detail_reports.getString("kategori");
					String status_reports = detail_reports.getString("status");
					String tags_reports = detail_reports.getString("tags");
					
					//Insert ke data pelanggaran
				}
			} catch (JSONException e){
				e.printStackTrace();
			}
			return null;
		}
    	
    }
}
