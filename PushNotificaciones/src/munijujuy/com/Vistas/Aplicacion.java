package munijujuy.com.Vistas;

//importamos la libreria de parse
import java.io.PushbackReader;

import com.parse.Parse;
import com.parse.ParseFacebookUtils;
import com.parse.ParseInstallation;
import com.parse.ParseQueryAdapter;
import com.parse.ParseTwitterUtils;
import com.parse.PushService;

public class Aplicacion extends android.app.Application {

  public Aplicacion() {
  }

@Override
  public void onCreate() {
    super.onCreate();
    //Inicializamos Parse con la APP_ID y la CLIENT_KEY
    Parse.initialize(this, "jruKV7cnjIia2at6O3BDAg7Emv5ZsjfKIdtBolk3", "WgkHuUFwuaIWsRoWi79vgldXJ3ZNPIGxbkyGQLfG"); 
	PushService.setDefaultPushCallback(this, MainActivity.class);
	ParseInstallation.getCurrentInstallation().saveInBackground();
	
	//Debemos suscribir el dispositivo a un canal de comunicacion, en este caso se llama Notificacion
	//Parse maneja canales para enviar la notificacion
	PushService.subscribe(getBaseContext(), "Notificacion", MainActivity.class);
	
  }
  
}