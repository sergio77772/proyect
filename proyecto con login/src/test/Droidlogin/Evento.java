package test.Droidlogin;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class Evento extends Activity {

	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	 
	        this.setContentView(R.layout.web);
	 
	        WebView myWebView = (WebView) this.findViewById(R.id.webView);
	        myWebView.loadUrl("http://vt000269.ferozo.com/APPUCR/droidlogin/addEvento.php");
	 
	    }
	   
	   

}
