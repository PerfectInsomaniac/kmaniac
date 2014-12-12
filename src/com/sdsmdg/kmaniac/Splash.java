package com.sdsmdg.kmaniac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.sdsmdg.kmaniac.R;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle SplashPageVariable) {
		// TODO Auto-generated method stub
		super.onCreate(SplashPageVariable);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.splash);

		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				finally {
					Intent openInitialPage = new Intent(
							"com.example.kmaniac.InitialPage");
					startActivity(openInitialPage);
					finish();
				}

			}

		};
		timer.start();
	}

}
