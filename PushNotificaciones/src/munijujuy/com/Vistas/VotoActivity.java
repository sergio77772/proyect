package munijujuy.com.Vistas;

import munijujuy.com.R;
import munijujuy.com.R.layout;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.InputFilter.LengthFilter;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class VotoActivity extends Activity {
	
	private WebView votoFoto;

	@Override
	@SuppressLint("SetJavaScriptEnabled")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_voto);
		
		votoFoto = (WebView)findViewById(R.id.webViewVotoFoto);
		
		votoFoto.setWebChromeClient(new WebChromeClient());
		votoFoto.getSettings().setJavaScriptEnabled(true);
		votoFoto.getSettings().setBuiltInZoomControls(true);
		votoFoto.getSettings().setLoadWithOverviewMode(true); // Ajustamos la vista al tamaño de pantalla

		votoFoto.loadUrl("http://www.comitecapitaljujuy.com/MOVIL/");//cambiar por la de voto foto
		
		votoFoto.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				return false;
			}
		});
		Toast.makeText(this, "Por Favor Espera a que se carguen las Imagenes", Toast.LENGTH_LONG).show();
	}
	
	/*@Override
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

	class JavascriptManager {
		@JavascriptInterface
		public void VolverLogin() {

			finish();
		}
	}*/
		
}
