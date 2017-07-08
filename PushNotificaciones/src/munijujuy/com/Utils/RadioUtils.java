package munijujuy.com.Utils;

import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class RadioUtils  extends Activity{
public  final String msgError = "Error Verifique su conexion a internet";

public final static String NUMERO="3885088297";
public final static String ERROR_MENSAJE="No se puede enviar, Porvafor escriba un mensaje";
public boolean stateBtnPlay;
public  boolean stateBtnStop;

public boolean isOnline() {
	ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

	NetworkInfo netInfo = cm.getActiveNetworkInfo();

	if (netInfo != null &&  netInfo.isConnectedOrConnecting()) {
	return true;
	}

	return false;
	}
}
