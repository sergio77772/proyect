package munijujuy.com.Vistas;

import munijujuy.com.R;
import munijujuy.com.R.id;
import munijujuy.com.R.layout;
import munijujuy.com.R.menu;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import munijujuy.com.Utils.Httppostaux;
import android.animation.AnimatorSet.Builder;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
	/** Called when the activity is first created. */

	EditText user;
	EditText pass;
	Button blogin;
	TextView registrar;
	Httppostaux post;
	Switch switchRemember;
	private SharedPreferences prefs;
	//RadioButton RBsesion;
	// String
	// URL_connect="http://vt000269.ferozo.com/APPUCR/droidlogin/acces.php";
	String IP_Server = "vt000269.ferozo.com/APPUCR";// IP DE NUESTRO PC
	String URL_connect = "http://" + IP_Server + "/droidlogin/acces.php";

	boolean result_back;
	private ProgressDialog pDialog;
    
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		/*if(Preferences.obtenerPreferenceBoolean(this,Preferences.PREFERENCE_ESTADO_BUTTON_SESION)){
            iniciarActividadSiguiente();
        }*/
		
		post = new Httppostaux();

		user = (EditText) findViewById(R.id.edusuario);
		pass = (EditText) findViewById(R.id.edpassword);
		blogin = (Button) findViewById(R.id.Blogin);
		registrar = (TextView) findViewById(R.id.link_to_register);
		switchRemember = (Switch)findViewById(R.id.switchRemember);
		
		prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
		
		setCredentialsIfExist();

		// Login button action
		blogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// Extreamos datos de los EditText
				String usuario = user.getText().toString();
				String passw = pass.getText().toString();

				// verificamos si estan en blanco
				if (checklogindata(usuario, passw) == true) {

					// si pasamos esa validacion ejecutamos el asynctask pasando
					// el usuario y clave como parametros

					new asynclogin().execute(usuario, passw);
					saveOnPreferences(usuario, passw);
				} else {
					// si detecto un error en la primera validacion vibrar y
					// mostrar un Toast con un mensaje de error.
					err_login();
				}

			}
		});

	}
	
	//obtener credenciales para el login
	private void setCredentialsIfExist(){
		String email = getUserMailPrefs();
		String password = getUserPassPrefs();
		if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
			user.setText(email);
			pass.setText(password);
		}
	}
	
	
	//sharedpreference mantener session

	public void saveOnPreferences(String email, String pass){
		if(switchRemember.isChecked()){
			SharedPreferences.Editor editor = prefs.edit();
			editor.putString("email", email);
			editor.putString("pass", pass);
			//editor.commit();
			editor.apply();
		}
	}
	
	//obtener datos del sharedpref
	private String getUserMailPrefs(){
		return prefs.getString("email", "");
	}
	
	private String getUserPassPrefs(){
		return prefs.getString("pass", "");
	}

	// vibra y muestra un Toast
	public void err_login() {
		Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		vibrator.vibrate(200);
		Toast toast1 = Toast.makeText(getApplicationContext(),
				"Error:Nombre de usuario o password incorrectos",
				Toast.LENGTH_SHORT);
		toast1.show();
	}

	public void btnReg(View view) {

		if (checkConnectivity()) {
			Intent i = new Intent(LoginActivity.this, RegistroActivity.class);
			startActivity(i);
		} else {
			Toast toast1 = Toast.makeText(getApplicationContext(),
					"Necesitas tener internet para registrate",
					Toast.LENGTH_SHORT);
			toast1.show();
		}
	}

	private boolean checkConnectivity() {
		boolean enabled = true;

		ConnectivityManager connectivityManager = (ConnectivityManager) this
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = connectivityManager.getActiveNetworkInfo();

		if ((info == null || !info.isConnected() || !info.isAvailable())) {
			enabled = false;

		}
		return enabled;
	}

	/*
	 * Valida el estado del logueo solamente necesita como parametros el usuario
	 * y passw
	 */
	public boolean loginstatus(String username, String password) {
		int logstatus = -1;

		/*
		 * Creamos un ArrayList del tipo nombre valor para agregar los datos
		 * recibidos por los parametros anteriores y enviarlo mediante POST a
		 * nuestro sistema para relizar la validacion
		 */
		ArrayList<NameValuePair> postparameters2send = new ArrayList<NameValuePair>();

		postparameters2send.add(new BasicNameValuePair("usuario", username));
		postparameters2send.add(new BasicNameValuePair("password", password));

		// realizamos una peticion y como respuesta obtenes un array JSON
		JSONArray jdata = post.getserverdata(postparameters2send, URL_connect);

		/*
		 * como estamos trabajando de manera local el ida y vuelta sera casi
		 * inmediato para darle un poco realismo decimos que el proceso se pare
		 * por unos segundos para poder observar el progressdialog la podemos
		 * eliminar si queremos
		 */
		SystemClock.sleep(950);

		// si lo que obtuvimos no es null
		if (jdata != null && jdata.length() > 0) {

			JSONObject json_data; // creamos un objeto JSON
			try {
				json_data = jdata.getJSONObject(0); // leemos el primer segmento
													// en nuestro caso el unico
				logstatus = json_data.getInt("logstatus");// accedemos al valor
				Log.e("loginstatus", "logstatus= " + logstatus);// muestro por
																// log que
																// obtuvimos
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// validamos el valor obtenido
			if (logstatus == 0) {// [{"logstatus":"0"}]
				Log.e("loginstatus ", "invalido");
				return false;
			} else {// [{"logstatus":"1"}]
				Log.e("loginstatus ", "valido");
				return true;
			}

		} else { // json obtenido invalido verificar parte WEB.
			Log.e("JSON  ", "ERROR");
			return false;
		}

	}

	// validamos si no hay ningun campo en blanco
	public boolean checklogindata(String username, String password) {

		if (username.equals("") || password.equals("")) {
			Log.e("Login ui", "checklogindata user or pass error");
			return false;

		} else {

			return true;
		}

	}

	/*
	 * CLASE ASYNCTASK
	 * 
	 * usaremos esta para poder mostrar el dialogo de progreso mientras enviamos
	 * y obtenemos los datos podria hacerse lo mismo sin usar esto pero si el
	 * tiempo de respuesta es demasiado lo que podria ocurrir si la conexion es
	 * lenta o el servidor tarda en responder la aplicacion sera inestable.
	 * ademas observariamos el mensaje de que la app no responde.
	 */

	class asynclogin extends AsyncTask<String, String, String> {

		String user, pass;

		@Override
		protected void onPreExecute() {
			// para el progress dialog
			pDialog = new ProgressDialog(LoginActivity.this);
			pDialog.setMessage("Autenticando....");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... params) {
			// obtnemos usr y pass
			user = params[0];
			pass = params[1];

			// enviamos y recibimos y analizamos los datos en segundo plano.
			if (loginstatus(user, pass) == true) {
				//aqui meter el radiobuton para guardar si esta cliqueado o no
				//saveOnPreferences(user, pass);
				return "ok"; // login valido
			} else {
				return "err"; // login invalido
			}

		}

		/*
		 * Una vez terminado doInBackground segun lo que halla ocurrido pasamos
		 * a la sig. activity o mostramos error
		 */
		@Override
		protected void onPostExecute(String result) {

			pDialog.dismiss();// ocultamos progess dialog.
			Log.e("onPostExecute=", "" + result);

			if (result.equals("ok")) {

				Intent i = new Intent(LoginActivity.this, MainActivity.class);
				i.putExtra("user", user);
				//evitar que al retroceder vuelva al login
				i.setFlags(i.FLAG_ACTIVITY_NEW_TASK | i.FLAG_ACTIVITY_CLEAR_TASK);
				startActivity(i);
				//saveOnPreferences(email, pass);
			} else {
				err_login();
			}

		}

	}
	
	/* public void iniciarActividadSiguiente(){
	        Intent i = new Intent(LoginActivity.this,MainActivity.class);
	        startActivity(i);
	        finish();
	    }*/

}