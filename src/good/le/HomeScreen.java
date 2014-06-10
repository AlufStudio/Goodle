package good.le;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen);
		
		
		
		Button btn1 = (Button)findViewById(R.id.button1);
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(HomeScreen.this, DetailKandidat.class);
				i.putExtra("inisial", "ps");
				startActivity(i);
			}
		});
		
		Button btn2 = (Button)findViewById(R.id.button2);
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(HomeScreen.this, DetailKandidat.class);
				i.putExtra("inisial", "hr");
				startActivity(i);
			}
		});
		
		Button btn3 = (Button)findViewById(R.id.button3);
		btn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(HomeScreen.this, DetailKandidat.class);
				i.putExtra("inisial", "jk");
				startActivity(i);
			}
		});
		
		Button btn4 = (Button)findViewById(R.id.button4);
		btn4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(HomeScreen.this, DetailKandidat.class);
				i.putExtra("inisial", "jw");
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_screen, menu);
		return true;
	}

}
