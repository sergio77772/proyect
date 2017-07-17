package munijujuy.com.Utils;

import android.content.SharedPreferences;

public class Preferences {
	
	public static String getUserMailPrefs(SharedPreferences preferences){
		return preferences.getString("email", "");
	}
	
	private static String getUserPassPrefs(SharedPreferences preferences){
		return preferences.getString("pass", "");
	}

}
