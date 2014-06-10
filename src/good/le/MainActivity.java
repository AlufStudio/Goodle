package good.le;

import good.le.lib.DatabaseHandler;
import good.le.lib.EventsClass;
import good.le.lib.JSONParser;
import good.le.lib.JanjiClass;
import good.le.lib.KandidatClass;
import good.le.lib.KeuanganClass;
import good.le.lib.PelanggaranClass;
import good.le.lib.RiwayatPHClass;
import good.le.lib.RiwayatPKClass;
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
    
    //Ambil , simpan , dan Awasi janjinya
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
					db.addJanji(new JanjiClass(i, inisial_calon, context_janji, janji, tanggal, judul_sumber, url_sumber, tags_janji));
				}
				
			} catch (JSONException e){
				e.printStackTrace();
			}
			return null;
		}

    }
    
    //Lihat data keuangan dengan baik dan benar
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
					db.addKeuangan(new KeuanganClass(i, tahun_contributions, uang_contributions, nilai_barang_contributions, unit_barang_contributions, nilai_jasa_contributions, jumlah_contributions, periode_contributions, role_contributions, partai_contributions, id_calon_contributions, lembaga_contributions, mata_uang_contributions, bentuk_jasa_contributions, keterangan_contributions));
				}
			} catch (JSONException e){
				e.printStackTrace();
			}
			return null;
		}
    	
    }
    
    //Jika terjadi pelanggaran , gantung dengan kabel LAN :D
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
					db.addPelanggaran(new PelanggaranClass(i, judul_laporan_reports, tanggal_kejadian_reports, alamat_reports, kelurahan_desa_reports, kecamatan_reports, kab_kota_reports, provinsi_reports, keterangan_reports, kategori_reports, status_reports, tags_reports));
				}
			} catch (JSONException e){
				e.printStackTrace();
			}
			return null;
		}
    	
    }
}
