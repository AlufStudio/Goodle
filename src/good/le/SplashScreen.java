package good.le;

import good.le.lib.DatabaseHandler;
import good.le.lib.JSONParser;
import good.le.lib.KandidatClass;
import good.le.lib.RiwayatPHClass;
import good.le.lib.RiwayatPKClass;
import good.le.lib.RiwayatPNClass;
import good.le.lib.RiwayatROClass;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.app.Activity;
import android.content.Intent;

public class SplashScreen extends Activity {
	JSONParser jsonParser = new JSONParser();
	ProgressBar pBar;
	DatabaseHandler db;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		db = new DatabaseHandler(this);
		
		pBar = (ProgressBar)findViewById(R.id.loadingProgress);
		
		new AmbilSemuaKandidat().execute();
	}
	
	class AmbilSemuaKandidat extends AsyncTask<String, Integer, String>{
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			
		}

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			try {
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("apiKey","bd9f0756d73496e3d38400012f03df1b"));
				params.add(new BasicNameValuePair("limit","4"));
				
				JSONObject json = jsonParser.makeHttpRequest("http://api.pemiluapi.org/calonpresiden/api/caleg","GET",params);
				JSONObject data = json.getJSONObject("data");
				JSONObject results = data.getJSONObject("results");
				JSONArray caleg = results.getJSONArray("caleg");
				for(int i = 0;i < caleg.length();i++){
					JSONObject detail_caleg = caleg.getJSONObject(i);
					
					String nama = detail_caleg.getString("nama");
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
					if(db.getTableCounts("kandidat_rpk",inisial_caleg) != riwayat_pendidikan.length()){
						for(int j = 0;j < riwayat_pendidikan.length();j++){
							JSONObject detail_riwayat_pendidikan = riwayat_pendidikan.getJSONObject(j);
							String ringkasan_rpn_caleg = detail_riwayat_pendidikan.getString("ringkasan");
							String tanggal_mulai_rpn_caleg = detail_riwayat_pendidikan.getString("tanggal_mulai");
							String tanggal_selesai_rpn_caleg = detail_riwayat_pendidikan.getString("tanggal_selesai");
							
							//Insert ke table riwayat pendidikan
							db.addRiwayatRPN(new RiwayatPNClass(inisial_caleg,ringkasan_rpn_caleg, tanggal_mulai_rpn_caleg, tanggal_selesai_rpn_caleg));
						}
					} else if(db.getTableCounts("kandidat_rpn",inisial_caleg) < riwayat_pendidikan.length()){
						for(int j = db.getTableCounts("kandidat_rpk",inisial_caleg);j < riwayat_pendidikan.length();j++){
							JSONObject detail_riwayat_pendidikan = riwayat_pendidikan.getJSONObject(j);
							String ringkasan_rpn_caleg = detail_riwayat_pendidikan.getString("ringkasan");
							String tanggal_mulai_rpn_caleg = detail_riwayat_pendidikan.getString("tanggal_mulai");
							String tanggal_selesai_rpn_caleg = detail_riwayat_pendidikan.getString("tanggal_selesai");
							
							//Insert ke table riwayat pendidikan
							db.addRiwayatRPN(new RiwayatPNClass(inisial_caleg,ringkasan_rpn_caleg, tanggal_mulai_rpn_caleg, tanggal_selesai_rpn_caleg));
						}
					} else {
						//pass
					}
					
					//Get riwayat pekerjaan
					JSONArray riwayat_pekerjaan = detail_caleg.getJSONArray("riwayat_pekerjaan");
					if(db.getTableCounts("kandidat_rpk",inisial_caleg) != riwayat_pekerjaan.length()){
						for(int k = 0;k < riwayat_pekerjaan.length();k++){
							JSONObject detail_riwayat_pekerjaan = riwayat_pekerjaan.getJSONObject(k);
							String ringkasan_rpk_caleg = detail_riwayat_pekerjaan.getString("ringkasan");
							String tanggal_mulai_rpk_caleg = detail_riwayat_pekerjaan.getString("tanggal_mulai");
							String tanggal_selesai_rpk_caleg = detail_riwayat_pekerjaan.getString("tanggal_selesai");
							
							//Input ke table riwayat pekerjaan
							db.addRiwayatRPK(new RiwayatPKClass(inisial_caleg, ringkasan_rpk_caleg, tanggal_mulai_rpk_caleg, tanggal_selesai_rpk_caleg));
						}
					} else if(db.getTableCounts("kandidat_rpk",inisial_caleg) < riwayat_pekerjaan.length()){
						for(int k = db.getTableCounts("kandidat_rpk",inisial_caleg);k < riwayat_pekerjaan.length();k++){
							JSONObject detail_riwayat_pekerjaan = riwayat_pekerjaan.getJSONObject(k);
							String ringkasan_rpk_caleg = detail_riwayat_pekerjaan.getString("ringkasan");
							String tanggal_mulai_rpk_caleg = detail_riwayat_pekerjaan.getString("tanggal_mulai");
							String tanggal_selesai_rpk_caleg = detail_riwayat_pekerjaan.getString("tanggal_selesai");
							
							//Input ke table riwayat pekerjaan
							db.addRiwayatRPK(new RiwayatPKClass(inisial_caleg, ringkasan_rpk_caleg, tanggal_mulai_rpk_caleg, tanggal_selesai_rpk_caleg));
						}
					} else {
						//pass
					}
					
					//Get riwayat organisasi
					JSONArray riwayat_organisasi = detail_caleg.getJSONArray("riwayat_organisasi");
					if(db.getTableCounts("kandidat_ro",inisial_caleg) != riwayat_organisasi.length()){
						for(int l = 0;l < riwayat_organisasi.length();l++){
							JSONObject detail_riwayat_organisasi = riwayat_organisasi.getJSONObject(l);
							String ringkasan_ro_caleg = detail_riwayat_organisasi.getString("ringkasan");
							String jabatan_ro_caleg = detail_riwayat_organisasi.getString("jabatan");
							String tanggal_mulai_ro_caleg = detail_riwayat_organisasi.getString("tanggal_mulai");
							String tanggal_selesai_ro_caleg = detail_riwayat_organisasi.getString("tanggal_selesai");
							
							//Input ke table riwayat organisasi
							db.addRiwayatRO(new RiwayatROClass(inisial_caleg, ringkasan_ro_caleg, jabatan_ro_caleg, tanggal_mulai_ro_caleg, tanggal_selesai_ro_caleg));
						}
					} else if(db.getTableCounts("kandidat_ro",inisial_caleg) < riwayat_organisasi.length()){
						for(int l = db.getTableCounts("kandidat_ro",inisial_caleg);l < riwayat_organisasi.length();l++){
							JSONObject detail_riwayat_organisasi = riwayat_organisasi.getJSONObject(l);
							String ringkasan_ro_caleg = detail_riwayat_organisasi.getString("ringkasan");
							String jabatan_ro_caleg = detail_riwayat_organisasi.getString("jabatan");
							String tanggal_mulai_ro_caleg = detail_riwayat_organisasi.getString("tanggal_mulai");
							String tanggal_selesai_ro_caleg = detail_riwayat_organisasi.getString("tanggal_selesai");
							
							//Input ke table riwayat organisasi
							db.addRiwayatRO(new RiwayatROClass(inisial_caleg, ringkasan_ro_caleg, jabatan_ro_caleg, tanggal_mulai_ro_caleg, tanggal_selesai_ro_caleg));
						}
					} else {
						//pass
					}
					
					//Get riwayat penghargaan
					JSONArray riwayat_penghargaan = detail_caleg.getJSONArray("riwayat_penghargaan");
					if(db.getTableCounts("kandidat_rph",inisial_caleg) != riwayat_penghargaan.length()){
						for(int m = 0;m < riwayat_penghargaan.length();m++){
							JSONObject detail_riwayat_penghargaan = riwayat_penghargaan.getJSONObject(m);
							String ringkasan_rph_caleg = detail_riwayat_penghargaan.getString("ringkasan");
							String institusi_rph_caleg = detail_riwayat_penghargaan.getString("institusi");
							String tanggal_rph_caleg = detail_riwayat_penghargaan.getString("tanggal");
							
							//Input ke table riwayat organisasi
							db.addRiwayatPH(new RiwayatPHClass(inisial_caleg, ringkasan_rph_caleg, institusi_rph_caleg, tanggal_rph_caleg));
						}
					} else if(db.getTableCounts("kandidat_rph",inisial_caleg) < riwayat_penghargaan.length()){
						for(int m = db.getTableCounts("kandidat_rph",inisial_caleg);m < riwayat_penghargaan.length();m++){
							JSONObject detail_riwayat_penghargaan = riwayat_penghargaan.getJSONObject(m);
							String ringkasan_rph_caleg = detail_riwayat_penghargaan.getString("ringkasan");
							String institusi_rph_caleg = detail_riwayat_penghargaan.getString("institusi");
							String tanggal_rph_caleg = detail_riwayat_penghargaan.getString("tanggal");
							
							//Input ke table riwayat organisasi
							db.addRiwayatPH(new RiwayatPHClass(inisial_caleg, ringkasan_rph_caleg, institusi_rph_caleg, tanggal_rph_caleg));
						}
					} else {
						//pass
					}
					
					//Insert ke table kandidat
					if(db.kandidatExists(inisial_caleg)){
						db.updateKandidat(new KandidatClass(tahun_caleg, jumlah_anak_caleg, nama,inisial_caleg, role_caleg, id_running_mate_caleg, jenis_kelamin_caleg, agama_caleg, tempat_lahir_caleg, tanggal_lahir_caleg, status_perkawinan_caleg, nama_pasangan_caleg, kelurahan_tinggal_caleg, kecamatan_tinggal_caleg, kab_kota_tinggal_caleg, provinsi_tinggal, nama_partai_caleg, biografi_caleg));
					} else
						db.addKandidat(new KandidatClass(tahun_caleg, jumlah_anak_caleg, nama,inisial_caleg, role_caleg, id_running_mate_caleg, jenis_kelamin_caleg, agama_caleg, tempat_lahir_caleg, tanggal_lahir_caleg, status_perkawinan_caleg, nama_pasangan_caleg, kelurahan_tinggal_caleg, kecamatan_tinggal_caleg, kab_kota_tinggal_caleg, provinsi_tinggal, nama_partai_caleg, biografi_caleg));
				}
			} catch (JSONException e){
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			Intent i = new Intent(SplashScreen.this,HomeScreen.class);
			startActivity(i);
			finish();
			pBar.setVisibility(View.GONE);
		}
    }

}
