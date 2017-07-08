package test.Droidlogin;

import java.util.Timer;
import java.util.Timer;
import java.util.TimerTask;
 
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;


import java.util.TimerTask;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;
/*PANTALLA DE BIENVENIDA*/
public class HiScreen extends Activity {
	String user;
	TextView txt_usr, logoff;
//	private ImageSwitcher imageSwitcher;
//	private static final Integer DURATION = 2500;
//	private int[] gallery = {R.drawable.ic_bandera, R.drawable.b, R.drawable.c, R.drawable.d};
//	private int position = 0;
//	private Timer timer = null;
	 @Override
	public void onCreate(Bundle savedInstanceState) {
		 
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.lay_screen);
//	       imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
//	        imageSwitcher.setFactory(new ViewFactory() {
//	 
//	            public View makeView() {
//	                return new ImageView(HiScreen.this);
//	            }
//	        });
//	        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
//	        Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
//	        imageSwitcher.setInAnimation(fadeIn);
//	        imageSwitcher.setOutAnimation(fadeOut);
//	        if (timer != null) {
//	            timer.cancel();
//	        }
//	        position = 0;
//	        startSlider();
            
	        txt_usr= (TextView) findViewById(R.id.usr_name);
            logoff= (TextView) findViewById(R.id.logoff);  
            
            Bundle extras = getIntent().getExtras();
            //Obtenemos datos enviados en el intent.
            if (extras != null) {
         	   user  = extras.getString("user");//usuario
            }else{
         	   user="error";
         	   }
            
            txt_usr.setText(user);//cambiamos texto al nombre del usuario logueado
   		   	             
	        logoff.setOnClickListener(new View.OnClickListener(){
	         	
	         	@Override
				public void onClick(View view){
    	        //'cerrar  sesion' nos regresa a la ventana anterior.      
	         		finish(); 
	         									}
	         	});	               
	 }
	 
//Definimos que para cuando se presione la tecla BACK no volvamos para atras  	 
	 @Override
	 public boolean onKeyDown(int keyCode, KeyEvent event)  {
	     if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
	         // no hacemos nada.
	         return true;
	     }

	     return super.onKeyDown(keyCode, event);
	 }
	
//	 public void startSlider() {
//	        timer = new Timer();
//	        timer.scheduleAtFixedRate(new TimerTask() {
//	 
//	            public void run() {
//	                // avoid exception:
//	                // "Only the original thread that created a view hierarchy can touch its views"
//	                runOnUiThread(new Runnable() {
//	                    public void run() {
//	                        imageSwitcher.setImageResource(gallery[position]);
//	                        position++;
//	                        if (position == gallery.length) {
//	                            position = 0;
//	                        }
//	                    }
//	                });
//	            }
//	 
//	        }, 0, DURATION);
//	    }
	 
	 public void btn1 (View view)
		{
			
			Intent intent = new Intent(this, Evento.class);
			
			startActivityForResult(intent,2);
			
		}
	 
	 
	 
	 
	 public void btnCaminatas (View view)
		{
		 Toast toast1 = Toast.makeText(getApplicationContext(),"Error:tenemos incovenientes perdon", Toast.LENGTH_SHORT);
	 	    toast1.show();  
			
			
		}
	 
	 
}
