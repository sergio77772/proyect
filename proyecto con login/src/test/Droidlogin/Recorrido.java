package test.Droidlogin;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class Recorrido extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        this.setContentView(R.layout.recorridos);
 
        WebView myWebView = (WebView) this.findViewById(R.id.webRecorridos);
        myWebView.loadUrl("http://pruebasyproyectos.890m.com/recorrido3/recorrido2.html");
 
    }

}
