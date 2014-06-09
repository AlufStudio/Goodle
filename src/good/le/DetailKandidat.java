package good.le;

import good.le.lib.DatabaseHandler;
import good.le.lib.KandidatClass;
import good.le.lib.RiwayatROClass;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class DetailKandidat extends Activity {
	private DatabaseHandler db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_kandidat);
		db = new DatabaseHandler(this);
		
		RiwayatROClass rro = db.getRiwayatRO(1);
		Log.d("RRO", rro.getJabatan());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail_kandidat, menu);
		return true;
	}

}
