package munijujuy.com.Vistas;



import munijujuy.com.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class EventListActivity extends Activity  {
	private WebView browser;
	   @SuppressLint("SetJavaScriptEnabled") protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	 
	       this.setContentView(R.layout.listevento);
	       browser = (WebView)findViewById(R.id.Listvento);
	        //habilitamos javascript y el zoom
	        browser.getSettings().setJavaScriptEnabled(true);
	        browser.getSettings().setBuiltInZoomControls(true);
	        
	       
	               //habilitamos los plugins (flash)
	           
	        browser.getSettings().setLoadWithOverviewMode(true); // Ajustamos la vista para que no se vea demasiado grande

	        browser.loadUrl("http://vt000269.ferozo.com/APPUCR/droidlogin/ListaDeEventos.php");
	        browser.addJavascriptInterface(new  JavascriptManager(), "Android");

	        browser.setWebViewClient(new WebViewClient()
	        {
	            // evita que los enlaces se abran fuera nuestra app en el navegador de android
	        @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url)
	        {
	        return false;
	        }   

	        });
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
	    class JavascriptManager 
		{
		    @JavascriptInterface
		    public void VolverLogin()
		    {
		    	
		    	finish();
		    }
		}
}
