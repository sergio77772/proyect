package munijujuy.com.Vistas;
/*CREADO POR SEBASTIAN CIPOLAT*/
import java.util.ArrayList;



import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import munijujuy.com.R;
import munijujuy.com.Utils.*;
import android.animation.AnimatorSet.Builder;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {
    /** Called when the activity is first created. */
    
    EditText user;
    EditText pass;
    Button blogin;
    TextView registrar;
    Httppostaux post;
    // String URL_connect="http://vt000269.ferozo.com/APPUCR/droidlogin/acces.php";
    String IP_Server="vt000269.ferozo.com/APPUCR";//IP DE NUESTRO PC
    String URL_connect="http://"+IP_Server+"/droidlogin/acces.php";//ruta en donde estan nuestros archivos
  
    boolean result_back;
    private ProgressDialog pDialog;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        post=new Httppostaux();
        
        user= (EditText) findViewById(R.id.edusuario);
        pass= (EditText) findViewById(R.id.edpassword);
        blogin= (Button) findViewById(R.id.Blogin);
        registrar=(TextView) findViewById(R.id.link_to_register);
                    
        //Login button action
        blogin.setOnClickListener(new View.OnClickListener(){
       
        	@Override
			public void onClick(View view){
        		 
        		//Extreamos datos de los EditText
        		String usuario=user.getText().toString();
        		String passw=pass.getText().toString();
        		
        		//verificamos si estan en blanco
        		if( checklogindata( usuario , passw )==true){

        			//si pasamos esa validacion ejecutamos el asynctask pasando el usuario y clave como parametros
        			
        		new asynclogin().execute(usuario,passw);        		               
        			      		
        		
        		}else{
        			//si detecto un error en la primera validacion vibrar y mostrar un Toast con un mensaje de error.
        			err_login();
        		}
        		
        	}
        													});
        
      
                
    }
    
    //vibra y muestra un Toast
    public void err_login(){
    	Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
	    vibrator.vibrate(200);
	    Toast toast1 = Toast.makeText(getApplicationContext(),"Error:Nombre de usuario o password incorrectos", Toast.LENGTH_SHORT);
 	    toast1.show();    	
    }
    
    public void  btnReg(View view) {
    	
    	  if (checkConnectivity()){
    	//Intent i = new Intent(this, Registro.class );
        //startActivity(i);
    		  Toast toast1 = Toast.makeText(getApplicationContext(),"NO ESTA AUTORIZADO", Toast.LENGTH_SHORT);
  	 	    toast1.show(); 
    		  }
    	  else {
    		  Toast toast1 = Toast.makeText(getApplicationContext(),"Necesitas tener internet para registrate", Toast.LENGTH_SHORT);
    	 	    toast1.show();  
		}
	}
    
    private boolean checkConnectivity()
	{
		boolean enabled = true;

		ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = connectivityManager.getActiveNetworkInfo();
		
		if ((info == null || !info.isConnected() || !info.isAvailable()))
		{
			enabled = false;
				
		}
		return enabled;			
	}
    
    
    
    /*Valida el estado del logueo solamente necesita como parametros el usuario y passw*/
    public boolean loginstatus(String username ,String password ) {
    	int logstatus=-1;
    	
    	/*Creamos un ArrayList del tipo nombre valor para agregar los datos recibidos por los parametros anteriores
    	 * y enviarlo mediante POST a nuestro sistema para relizar la validacion*/ 
    	ArrayList<NameValuePair> postparameters2send= new ArrayList<NameValuePair>();
     		
		    		postparameters2send.add(new BasicNameValuePair("usuario",username));
		    		postparameters2send.add(new BasicNameValuePair("password",password));

		   //realizamos una peticion y como respuesta obtenes un array JSON
      		JSONArray jdata=post.getserverdata(postparameters2send, URL_connect);

      		/*como estamos trabajando de manera local el ida y vuelta sera casi inmediato
      		 * para darle un poco realismo decimos que el proceso se pare por unos segundos para poder
      		 * observar el progressdialog
      		 * la podemos eliminar si queremos
      		 */
		    SystemClock.sleep(950);
		    		
		    //si lo que obtuvimos no es null
		    	if (jdata!=null && jdata.length() > 0){

		    		JSONObject json_data; //creamos un objeto JSON
					try {
						json_data = jdata.getJSONObject(0); //leemos el primer segmento en nuestro caso el unico
						 logstatus=json_data.getInt("logstatus");//accedemos al valor 
						 Log.e("loginstatus","logstatus= "+logstatus);//muestro por log que obtuvimos
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		            
		             
					//validamos el valor obtenido
		    		 if (logstatus==0){// [{"logstatus":"0"}] 
		    			 Log.e("loginstatus ", "invalido");
		    			 return false;
		    		 }
		    		 else{// [{"logstatus":"1"}]
		    			 Log.e("loginstatus ", "valido");
		    			 return true;
		    		 }
		    		 
			  }else{	//json obtenido invalido verificar parte WEB.
		    			 Log.e("JSON  ", "ERROR");
			    		return false;
			  }
    	
    }
    
          
    //validamos si no hay ningun campo en blanco
    public boolean checklogindata(String username ,String password ){
    	
    if 	(username.equals("") || password.equals("")){
    	Log.e("Login ui", "checklogindata user or pass error");
    return false;
    
    }else{
    	
    	return true;
    }
    
}           
    
/*		CLASE ASYNCTASK
 * 
 * usaremos esta para poder mostrar el dialogo de progreso mientras enviamos y obtenemos los datos
 * podria hacerse lo mismo sin usar esto pero si el tiempo de respuesta es demasiado lo que podria ocurrir    
 * si la conexion es lenta o el servidor tarda en responder la aplicacion sera inestable.
 * ademas observariamos el mensaje de que la app no responde.     
 */
    
    class asynclogin extends AsyncTask< String, String, String > {
    	 
    	String user,pass;
        @Override
		protected void onPreExecute() {
        	//para el progress dialog
            pDialog = new ProgressDialog(Login.this);
            pDialog.setMessage("Autenticando....");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }
 
		@Override
		protected String doInBackground(String... params) {
			//obtnemos usr y pass
			user=params[0];
			pass=params[1];
            
			//enviamos y recibimos y analizamos los datos en segundo plano.
    		if (loginstatus(user,pass)==true){    		    		
    			return "ok"; //login valido
    		}else{    		
    			return "err"; //login invalido     	          	  
    		}
        	
		}
       
		/*Una vez terminado doInBackground segun lo que halla ocurrido 
		pasamos a la sig. activity
		o mostramos error*/
        @Override
		protected void onPostExecute(String result) {

           pDialog.dismiss();//ocultamos progess dialog.
           Log.e("onPostExecute=",""+result);
           
           if (result.equals("ok")){

				Intent i=new Intent(Login.this, MainActivity.class);
				i.putExtra("user",user);
				startActivity(i); 
				
            }else{
            	err_login();
            }
            
                									}
		
        }
 
    }
    

   
     
    //-----------------------------------------------------------------------
    
    
 

