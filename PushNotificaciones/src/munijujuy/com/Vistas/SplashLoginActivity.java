package munijujuy.com.Vistas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SplashLoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_splash_login);
		Intent intent = new Intent(this,LoginActivity.class);
		startActivity(intent);
		
	}
}
