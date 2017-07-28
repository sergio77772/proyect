package munijujuy.com.Vistas;

import munijujuy.com.R;
import munijujuy.com.R.layout;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NoticiaActivity extends Activity {
	
	private WebView noticia;

	@Override
	@SuppressLint("SetJavaScriptEnabled")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_noticia);
		
		noticia = (WebView)findViewById(R.id.webViewNoticia);
		
		noticia.setWebChromeClient(new WebChromeClient());
		noticia.getSettings().setJavaScriptEnabled(true);
		noticia.getSettings().setBuiltInZoomControls(true);
		noticia.getSettings().setLoadWithOverviewMode(true); // Ajustamos la vista al tamaño de pantalla

		noticia.loadUrl("http://www.frentejujeñocambiemos.com.ar");//cambiar por la de noticia
		
		noticia.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				return false;
			}
		});
		
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
