package munijujuy.com.JavaClass;

import android.app.Application;
import android.os.SystemClock;
import android.provider.Settings.System;

public class Inicio extends Application{
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		SystemClock.sleep(3000);
	}

}
