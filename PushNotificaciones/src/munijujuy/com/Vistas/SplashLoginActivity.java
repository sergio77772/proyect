package munijujuy.com.Vistas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;

public class SplashLoginActivity extends Activity {
	
	private SharedPreferences prefs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_splash_login);
		prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
		Intent intentLogin = new Intent(this,LoginActivity.class);
		intentLogin.setFlags(intentLogin.FLAG_ACTIVITY_NEW_TASK | intentLogin.FLAG_ACTIVITY_CLEAR_TASK);
		Intent intentMain = new Intent(this,MainActivity.class);
		intentMain.setFlags(intentMain.FLAG_ACTIVITY_NEW_TASK | intentMain.FLAG_ACTIVITY_CLEAR_TASK);
		
		if(!TextUtils.isEmpty(getUserMailPrefs()) && !TextUtils.isEmpty(getUserPassPrefs())){
			startActivity(intentMain);
		}else{
			startActivity(intentLogin);
		}
		
		
	}
	private String getUserMailPrefs(){
		return prefs.getString("email", "");
	}
	
	private String getUserPassPrefs(){
		return prefs.getString("pass", "");
	}
}

