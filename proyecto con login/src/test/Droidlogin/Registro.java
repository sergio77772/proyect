package test.Droidlogin;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.apache.http.message.BasicNameValuePair;
import android.os.AsyncTask;
import test.Droidlogin.Login.asynclogin;
import test.Droidlogin.library.Httppostaux;
import android.app.ProgressDialog;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class Registro extends Activity {
    private WebView browser;

	@SuppressWarnings("SetJavaScriptEnabled") @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registro);
		browser = (WebView)findViewById(R.id.webkit);
        
        //habilitamos javascript y el zoom
browser.getSettings().setJavaScriptEnabled(true);
//browser.getSettings().setBuiltInZoomControls(true);
browser.getSettings().setJavaScriptEnabled(true);
browser.setInitialScale(130);
       //habilitamos los plugins (flash)
//browser.getSettings().setPluginState();      
//browser.getSettings().setLoadWithOverviewMode(true); // Ajustamos la vista para que no se vea demasiado grande

browser.loadUrl("http://vt000269.ferozo.com/APPUCR/droidlogin/adduser.html");
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
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
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
