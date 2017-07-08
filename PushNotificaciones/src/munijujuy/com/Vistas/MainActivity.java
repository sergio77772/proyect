package munijujuy.com.Vistas;

import munijujuy.com.R;

import com.parse.ParseAnalytics;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Toast;


public class MainActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ParseAnalytics.trackAppOpened(getIntent());
		
		//myWebView = (WebView) findViewById(R.id.webview);
		//WebSettings webSettings = myWebView.getSettings();
		
		//webSettings.setJavaScriptEnabled(true);
      //  webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
       // myWebView.loadUrl("http://www.sansalvadordejujuy.gob.ar/");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	
	public void btnPlay (View view)
	{
		
		
		//Toast toast1 = Toast.makeText(getApplicationContext(),"Disculpe no esta disponible hasta su lanzamiento", Toast.LENGTH_SHORT);
 	    //toast1.show();  
		Intent intent = new Intent(this, ContactActivity.class);
		
		startActivityForResult(intent,2);
		
	}
	
	public void btnContacto (View view)
	{
		
		
		  
		Intent intent = new Intent(this, ContactActivity.class);
		
		startActivityForResult(intent,2);
		
	}
	
	
	
	public void btnMap (View view)
	{
		
		Intent intent = new Intent(this, MapaActivity.class);
		
		startActivityForResult(intent,2);
		
	}
	
	
	public void btnweb (View view)
	{
		
		Intent intent = new Intent(this, WebActivity.class);
		
		startActivity(intent);
		
	}
	
	public void btnAddEvent (View view)
	{
		
		Intent intent = new Intent(this, AddEventActivity.class);
		
		startActivity(intent);
		
	}
	
	public void btnListaActividades (View view)
	{
		
		Intent intent = new Intent(this, EventListActivity.class);
		
		startActivity(intent);
		
	}
	
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode==2)
		{
			switch (resultCode){
		case 2:{
			
			Toast.makeText(getApplicationContext(), "Se Detuvo la trasnmision", Toast.LENGTH_LONG).show();
			
			break;}
			}
	}
}
	

	
        
	
	
	
}
