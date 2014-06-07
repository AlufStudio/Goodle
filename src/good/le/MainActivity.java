package good.le;

import good.le.lib.JSONParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
	JSONParser jsonParser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
					
					//Get riwayat pendidikan
					JSONArray riwayat_pendidikan = detail_caleg.getJSONArray("riwayat_pendidikan");
					for(int j = 0;j < riwayat_pendidikan.length();j++){
						JSONObject detail_riwayat_pendidikan = riwayat_pendidikan.getJSONObject(j);
						String ringkasan_rpn_caleg = detail_riwayat_pendidikan.getString("ringkasan");
						String tanggal_mulai_rpn_caleg = detail_riwayat_pendidikan.getString("tanggal_mulai");
						String tanggal_selesai_rpn_caleg = detail_riwayat_pendidikan.getString("tanggal_selesai");
						//Insert ke table riwayat pendidikan
					}
					
					//Get riwayat pekerjaan
					JSONArray riwayat_pekerjaan = detail_caleg.getJSONArray("riwayat_pendidikan");
					for(int k = 0;k < riwayat_pekerjaan.length();k++){
						JSONObject detail_riwayat_pekerjaan = riwayat_pekerjaan.getJSONObject(k);
						String ringkasan_rpk_caleg = detail_riwayat_pekerjaan.getString("ringkasan");
						String tanggal_mulai_rpk_caleg = detail_riwayat_pekerjaan.getString("tanggal_mulai");
						String tanggal_selesai_rpk_caleg = detail_riwayat_pekerjaan.getString("tanggal_selesai");
						//Input ke table riwayat pekerjaan
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
					}
					
					//Get riwayat penghargaan
					JSONArray riwayat_penghargaan = detail_caleg.getJSONArray("riwayat_penghargaan");
					for(int m = 0;m < riwayat_penghargaan.length();m++){
						JSONObject detail_riwayat_penghargaan = riwayat_penghargaan.getJSONObject(m);
						String ringkasan_rph_caleg = detail_riwayat_penghargaan.getString("ringkasan");
						String institusi_rph_caleg = detail_riwayat_penghargaan.getString("institusi");
						String tanggal_rph_caleg = detail_riwayat_penghargaan.getString("tanggal");
						//Input ke table riwayat organisasi
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
    
}
