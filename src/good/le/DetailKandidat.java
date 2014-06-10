package good.le;

import java.util.List;

import good.le.lib.DatabaseHandler;
import good.le.lib.KandidatClass;
import good.le.lib.RiwayatPHClass;
import good.le.lib.RiwayatPKClass;
import good.le.lib.RiwayatPNClass;
import good.le.lib.RiwayatROClass;
import android.os.Bundle;
import android.app.Activity;	
import android.view.Menu;
import android.widget.TextView;

public class DetailKandidat extends Activity {
	private DatabaseHandler db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_kandidat);
		db = new DatabaseHandler(this);
		Bundle extra = getIntent().getExtras();
		KandidatClass kc = db.getKandidat(extra.getString("inisial"));
		TextView tx1 = (TextView)findViewById(R.id.namaKandidat);
		TextView tx2 = (TextView)findViewById(R.id.lahirKandidat);
		TextView tx3 = (TextView)findViewById(R.id.textBiografi);
		TextView tx4 = (TextView)findViewById(R.id.textPendidikan);
		TextView tx5 = (TextView)findViewById(R.id.textPekerjaan);
		TextView tx6 = (TextView)findViewById(R.id.textOrganisasi);
		TextView tx7 = (TextView)findViewById(R.id.textPenghargaan);
		
		
		tx1.setText(kc.getNama() + "");
		tx2.setText("Lahir : " + kc.getTempatLahir() + "\n" + "Tanggal : " + kc.getTanggalLahir() +"\n"
					+ "Agama : " + kc.getAgama() +"\nStatus : " + kc.getStatusKawin() + "\nNama Pasangan : " + kc.getNamaPasangan() + "\nPartai : " + kc.getNamaPartai());
		tx3.setText(kc.getBiografi());
		
		List<RiwayatPNClass> pendidikan = db.getAllRiwayatPendidikan(5, extra.getString("inisial"));
		String list_pendidikan = "";
		int nomor = 0;
		for (RiwayatPNClass rpp : pendidikan) {
			nomor++;
            list_pendidikan += String.valueOf(nomor) + "." + rpp.getRingkasan() + "\n";
		}
		
		tx4.setText(list_pendidikan);
		
		List<RiwayatPKClass> pekerjaan = db.getAllRiwayatPekerjaan(5, extra.getString("inisial"));
		String list_pekerjaan = "";
		nomor = 0;
		for (RiwayatPKClass rpk : pekerjaan) {
			nomor++;
			list_pekerjaan += String.valueOf(nomor) + "." + rpk.getRingkasan() + "\n";
		}
			
		tx5.setText(list_pekerjaan);
		
		List<RiwayatROClass> organisasi = db.getAllRiwayatOrganisasi(5, extra.getString("inisial"));
		String list_organisasi = "";
		nomor = 0;
		for (RiwayatROClass ro : organisasi) {
			nomor++;
			list_organisasi += String.valueOf(nomor) + "." + ro.getRingkasan() + "\n";
		}
			
		tx6.setText(list_organisasi);
		
		List<RiwayatPHClass> penghargaan = db.getAllRiwayatPenghargaan(5, extra.getString("inisial"));
		String list_penghargaan = "";
		nomor = 0;
		for (RiwayatPHClass rph : penghargaan) {
			nomor++;
			list_penghargaan += String.valueOf(nomor) + "." + rph.getRingkasan() + "\n";
		}
			
		tx7.setText(list_penghargaan);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail_kandidat, menu);
		return true;
	}

}
