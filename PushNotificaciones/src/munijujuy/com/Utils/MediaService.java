package munijujuy.com.Utils;

import java.io.IOException;

import munijujuy.com.R;

import munijujuy.com.Vistas.MainActivity;
import munijujuy.com.Vistas.Radio;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;


public class MediaService extends Service {
	public static MediaPlayer mp;
	  public static boolean state=false ;
	@SuppressWarnings("deprecation")
	@Override
	  public int onStartCommand(Intent intent, int flags, int startId) {
	    //TODO do something useful
				String songName="FM 88.5 RADIO MUNI";
				// assign the song name to songName
				PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0,
				               new Intent(getApplicationContext(), Radio.class),
				               PendingIntent.FLAG_UPDATE_CURRENT);
				Notification notification = new Notification();
				notification.tickerText = "Radio Muni";
				notification.icon = R.drawable.ic_launcher;
				notification.flags |= Notification.FLAG_ONGOING_EVENT;
				notification.setLatestEventInfo(getApplicationContext(), "Fm Muni la Radio te hace bien",
				                "Playing: " + songName, pi);
				startForeground(1, notification);
	    return Service.START_NOT_STICKY;}
	  

	  @Override
	  public IBinder onBind(Intent intent) {
	  //TODO for communication return IBinder implementation
	    return null;
	  }
	  
			 
	} 
