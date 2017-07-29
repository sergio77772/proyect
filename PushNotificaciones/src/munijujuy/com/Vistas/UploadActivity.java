package munijujuy.com.Vistas;

import munijujuy.com.R;
import munijujuy.com.R.layout;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import munijujuy.com.Vistas.AndroidMultiPartEntity.ProgressListener;

import java.io.File;
import java.io.IOException;
 




import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
 




import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;


public class UploadActivity extends Activity {
	
	 // LogCat tag
    private static final String TAG = MainActivity.class.getSimpleName();
    
    /*> La trayectoria de la imagen / video capturada de la c�mara se recibe de MainActivity y 
     * la imagen / el v�deo se exhibe en la pantalla para el prop�sito de la previsualizaci�n. 
     * > UploadFileToServer m�todo as�ncrono se encarga de subir el archivo al servidor y actualizar la barra de progreso.
     */

    private ProgressBar progressBar;
    private String filePath = null;
    private TextView txtPercentage;
    private ImageView imgPreview, imgGaleria;
    private EditText txtTelefono, txtNombre, txtEsquina;
    //private VideoView vidPreview;
    public static String telefono,nombre,esquina;
    private Button btnUpload, btnRegresar;
    long totalSize = 0;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_upload);
		
		txtPercentage = (TextView) findViewById(R.id.txtPercentage);
        btnUpload = (Button) findViewById(R.id.btnUpload);
        btnRegresar = (Button)findViewById(R.id.btnRegresar);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        imgPreview = (ImageView) findViewById(R.id.imgPreview);
        imgGaleria = (ImageView) findViewById(R.id.imgPreviewGaleria);
        txtTelefono = (EditText)findViewById(R.id.editTextTelefono);
        txtNombre = (EditText)findViewById(R.id.editTextNombre);
        txtEsquina = (EditText)findViewById(R.id.editTextEsquina);
        
        //vidPreview = (VideoView) findViewById(R.id.videoPreview);
        
        /*
        // Changing action bar background color
        getActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor(getResources().getString(
                        R.color.action_bar))));
 		*/
        // Receiving the data from previous activity
        Intent i = getIntent();
 
        // image or video path that is captured in previous activity
        filePath = i.getStringExtra("filePath");
 
        // boolean flag to identify the media type, image or video
        boolean isImage = i.getBooleanExtra("isImage", true);
 
        if (filePath != null) {
            // Displaying the image or video on the screen
            previewMedia(isImage);
        } else {
            Toast.makeText(getApplicationContext(),
                    "Lo Sentimos!, falta la ruta del archivo", Toast.LENGTH_LONG).show();
        }
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // uploading the file to server
            	//tomamos los datos ingresados por el usuario
            	telefono = txtTelefono.getText().toString();
            	nombre = txtNombre.getText().toString();
            	esquina = txtEsquina.getText().toString();
            	if(!telefono.isEmpty() && !nombre.isEmpty() && !esquina.isEmpty()){
            		new UploadFileToServer().execute();
            	}else{
            		Toast.makeText(UploadActivity.this, "Debe completar todos los Campos Correctamente", Toast.LENGTH_SHORT).show();
            	}
                //new UploadFileToServer().execute();
                //Toast.makeText(UploadActivity.this, "el boton si anda", Toast.LENGTH_SHORT).show();
            }
        });
        
        btnRegresar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(UploadActivity.this, MainActivity.class);
				//i.putExtra("user", "nada");
				//evitar que al retroceder vuelva a la vista anterior
				i.setFlags(i.FLAG_ACTIVITY_NEW_TASK | i.FLAG_ACTIVITY_CLEAR_TASK);
				startActivity(i);
			}
		});
	}
	//validacon email
	private boolean isValidEmail(String mail) {
		return !TextUtils.isEmpty(mail)&& Patterns.EMAIL_ADDRESS.matcher(mail).matches();
	}
	private void previewMedia(boolean isImage) {
        // Checking whether captured media is image or video
        if (isImage) {
            imgPreview.setVisibility(View.VISIBLE);
            //vidPreview.setVisibility(View.GONE);
            // bimatp factory
            BitmapFactory.Options options = new BitmapFactory.Options();
 
            // down sizing image as it throws OutOfMemory Exception for larger
            // images
            options.inSampleSize = 8;
 
            final Bitmap bitmap = BitmapFactory.decodeFile(filePath, options);
 
            imgPreview.setImageBitmap(bitmap);
        }else {
        	imgGaleria.setVisibility(View.VISIBLE);
            //vidPreview.setVisibility(View.GONE);
            // bimatp factory
            BitmapFactory.Options options = new BitmapFactory.Options();
 
            // down sizing image as it throws OutOfMemory Exception for larger
            // images
            options.inSampleSize = 8;
 
            final Bitmap bitmap = BitmapFactory.decodeFile(filePath, options);
 
            imgPreview.setImageBitmap(bitmap);
        	
            /*imgPreview.setVisibility(View.GONE);
            vidPreview.setVisibility(View.VISIBLE);
            vidPreview.setVideoPath(filePath);
            // start playing
            vidPreview.start();*/
        }
    }
	/**
     * Uploading the file to server
     * */
    private class UploadFileToServer extends AsyncTask<Void, Integer, String> {
    	
        @Override
        protected void onPreExecute() {
            // setting progress bar to zero
            progressBar.setProgress(0);
            super.onPreExecute();
        }
        @Override
        protected void onProgressUpdate(Integer... progress) {
            //Hacer visible la barra de progreso
            progressBar.setVisibility(View.VISIBLE);
 
            //Actualizaci�n del valor de la barra de progreso
            progressBar.setProgress(progress[0]);
 
            // updating percentage value
            txtPercentage.setText(String.valueOf(progress[0]) + "%");
        }
 
        @Override
        protected String doInBackground(Void... params) {
            return uploadFile();
        }
        @SuppressWarnings("deprecation")
        private String uploadFile() {
        	telefono = txtTelefono.getText().toString();
        	nombre = txtNombre.getText().toString();
        	esquina = txtEsquina.getText().toString();
            String responseString = null;
 
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(Config.FILE_UPLOAD_URL);
 
            try {
                AndroidMultiPartEntity entity = new AndroidMultiPartEntity(
                        new ProgressListener() {
 
                            @Override
                            public void transferred(long num) {
                                publishProgress((int) ((num / (float) totalSize) * 100));
                            }
                        });
 
                File sourceFile = new File(filePath);
 
                // Adding file data to http body
                entity.addPart("image", new FileBody(sourceFile));
 
                //Par�metros adicionales si desea pasar al servidor
                
                //AGREGAR ACA LOS DATOS!!!!!!!!!!!1
                telefono = txtTelefono.getText().toString();
            	nombre = txtNombre.getText().toString();
            	esquina = txtEsquina.getText().toString();
                
                //entity.addPart("website",new StringBody("www.androidhive.info"));
                //entity.addPart("email", new StringBody("abc@gmail.com"));
                //entity.addPart(nombre);
                entity.addPart("nombre", new StringBody(nombre));
                entity.addPart("esquina", new StringBody(esquina));
                entity.addPart("telefono", new StringBody(telefono));
            	/*entity.addPart("nombre", new StringBody("Raul"));
            	entity.addPart("esquina", new StringBody("plazoleta"));
            	entity.addPart("telefono", new StringBody("1234567"));*/
 
                totalSize = entity.getContentLength();
                httppost.setEntity(entity);
 
                //Hacer llamada al servidor
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity r_entity = response.getEntity();
 
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == 200) {
                    //Respuesta del servidor
                    responseString = EntityUtils.toString(r_entity);
                } else {
                    responseString = "Se produjo un error! Http Status Code: "
                            + statusCode;
                }
 
            } catch (ClientProtocolException e) {
                responseString = e.toString();
            } catch (IOException e) {
                responseString = e.toString();
            }
 
            return responseString;
 
        }
        
        @Override
        protected void onPostExecute(String result) {
            Log.e(TAG, "Response from server: " + result);
 
            // showing the server response in an alert dialog
            showAlert(result);
 
            super.onPostExecute(result);
        }
 
    }
    
    /**
     * Method to show alert dialog
     * */
    private void showAlert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message).setTitle("Response from Servers")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // do nothing
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
        
}
