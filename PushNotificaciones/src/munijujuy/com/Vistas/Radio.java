package munijujuy.com.Vistas;

import java.io.IOException;

import munijujuy.com.Utils.MediaService;
import munijujuy.com.Utils.RadioUtils;
import munijujuy.com.R;
import android.R.string;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

public class Radio extends Activity {
	Button btnPlay, btnStop, btnSalir, btnMsg, btnNvoMsg;
	MediaPlayer mediaPlayer = new MediaPlayer();
	RadioUtils radioUtils = new RadioUtils();
	EditText txtMsg;
	Intent oIntent2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_radio);
		btnPlay = (Button) findViewById(R.id.btplay);
		btnSalir = (Button) findViewById(R.id.btnSalir);
		btnStop = (Button) findViewById(R.id.btnStop);
		btnNvoMsg = (Button) findViewById(R.id.btnNvoMsg);
		btnNvoMsg.setEnabled(false);
		btnStop.setEnabled(false);
		Resources res = getResources();
		cargaTabs();
		oIntent2 = new Intent(getApplication(), MediaService.class);
		if (MediaService.state == true) {
			int duration = Toast.LENGTH_SHORT;
			Toast toast = Toast.makeText(getApplicationContext(),
					"La radio ya esta en funcionamiento", duration);
			toast.show();
			btnPlay.setEnabled(false);
			btnStop.setEnabled(true);

		}
		btnPlay.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (isOnline() && MediaService.state == false) {
					Comenzar();

					startService(oIntent2);
					btnPlay.setEnabled(false);
					btnStop.setEnabled(true);
					radioUtils.stateBtnPlay = false;
					radioUtils.stateBtnStop = true;
					MediaService.state = true;
					MediaService.mp = mediaPlayer;

				}

				else {
					Context context = getApplicationContext();

					int duration = Toast.LENGTH_SHORT;
					Toast toast = Toast.makeText(context, radioUtils.msgError,
							duration);
					toast.show();
				}

			}

		});

		btnStop.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (mediaPlayer.isPlaying()) {
					Pause();
					// Intent oIntent = new Intent();
					// setResult(2, oIntent);
					// stopService(oIntent2);
					MediaService.state = false;
					// finish();
				} else {
					mediaPlayer = MediaService.mp;
					mediaPlayer.reset();
					btnPlay.setEnabled(true);
					btnStop.setEnabled(false);
					MediaService.state = false;

				}
			}

		});

		btnSalir.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (mediaPlayer.isPlaying()) {
					Pause();
					Intent oIntent = new Intent();
					MediaService.state = false;
					setResult(2, oIntent);
					finish();
				} else {
					mediaPlayer = MediaService.mp;
					mediaPlayer.reset();
					btnPlay.setEnabled(true);
					btnStop.setEnabled(false);
					MediaService.state = false;
					Intent oIntent = new Intent();
					setResult(2, oIntent);
					stopService(oIntent2);
					finish();
				}
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

	public boolean isOnline() {
		ConnectivityManager cm = (ConnectivityManager) this
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo netInfo = cm.getActiveNetworkInfo();

		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			return true;
		}

		return false;
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		boolean play = radioUtils.stateBtnPlay;
		boolean stop = radioUtils.stateBtnStop;
		outState.putBoolean("BOLEAN1", play);
		outState.putBoolean("BOLEAN2", stop);
		outState.putBoolean("BOLEAN3", MediaService.state);

	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		boolean play = savedInstanceState.getBoolean("BOLEAN1");
		boolean stop = savedInstanceState.getBoolean("BOLEAN2");
		boolean estado = savedInstanceState.getBoolean("BOLEAN3");
		MediaService.state = estado;
		btnPlay.setEnabled(play);
		btnStop.setEnabled(stop);
		mediaPlayer = MediaService.mp;
	}

	public void Comenzar() {
		try {

			mediaPlayer
					.setDataSource("http://icecasthd.net:25741/stream?type=.mp3");
			mediaPlayer.prepare();
			mediaPlayer.start();

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Pause() {
		mediaPlayer.stop();
		mediaPlayer.reset();
		btnPlay.setEnabled(true);
		btnStop.setEnabled(false);
		MediaService.state = false;
		stopService(oIntent2);
	}

	public void cargaTabs() {
		Resources res = getResources();
		TabHost tabs = (TabHost) findViewById(android.R.id.tabhost);
		tabs.setup();

		TabHost.TabSpec spec = tabs.newTabSpec("mitab1");
		spec.setContent(R.id.tab1);
		spec.setIndicator("", res.getDrawable(android.R.drawable.ic_media_play));
		tabs.addTab(spec);

		spec = tabs.newTabSpec("mitab2");
		spec.setContent(R.id.tab2);
		spec.setIndicator("", res.getDrawable(android.R.drawable.ic_menu_help));
		tabs.addTab(spec);

		spec = tabs.newTabSpec("mitab3");
		spec.setContent(R.id.tab3);
		spec.setIndicator("", res.getDrawable(android.R.drawable.ic_dialog_map));
		tabs.addTab(spec);
		tabs.setCurrentTab(0);

	}

	public void btnSms(View view) {
		btnMsg = (Button) findViewById(R.id.btnSend);
		txtMsg = ((EditText) findViewById(R.id.txtMsg));
		PendingIntent sentIntent = PendingIntent.getBroadcast(
				getApplicationContext(), 0, new Intent("SMS_SENT"), 0);

		registerReceiver(new BroadcastReceiver() {

			@Override
			public void onReceive(Context context, Intent intent) {
				switch (getResultCode()) {
				case Activity.RESULT_OK:
					Toast.makeText(getApplicationContext(), "SMS enviado",
							Toast.LENGTH_SHORT).show();
					break;
				case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
					Toast.makeText(getApplicationContext(),
							"No se pudo enviar SMS", Toast.LENGTH_SHORT).show();
					break;
				case SmsManager.RESULT_ERROR_NO_SERVICE:
					Toast.makeText(getApplicationContext(),
							"Servicio no diponible", Toast.LENGTH_SHORT).show();
					break;
				case SmsManager.RESULT_ERROR_NULL_PDU:
					Toast.makeText(getApplicationContext(),
							"PDU (Protocol Data Unit) es NULL",
							Toast.LENGTH_SHORT).show();
					break;
				case SmsManager.RESULT_ERROR_RADIO_OFF:
					Toast.makeText(getApplicationContext(),
							"Failed because radio was explicitly turned off",
							Toast.LENGTH_SHORT).show();
					break;
				}
			}
		}, new IntentFilter("SMS_SENT"));

		SmsManager sms = SmsManager.getDefault();
		if (txtMsg.getText().toString().length() > 0
				&& txtMsg.getText().toString().length() > 0) {
			sms.sendTextMessage("+5493885088297", null, txtMsg.getText()
					.toString(), sentIntent, null);
			btnMsg.setEnabled(false);
			btnNvoMsg.setEnabled(true);
		} else {
			Toast.makeText(getApplicationContext(), RadioUtils.ERROR_MENSAJE,
					Toast.LENGTH_SHORT).show();
		}

	}

	public void btnNvoMsg(View view) {
		btnMsg = (Button) findViewById(R.id.btnSend);
		btnMsg.setEnabled(true);
		btnNvoMsg.setEnabled(false);

	}

}
