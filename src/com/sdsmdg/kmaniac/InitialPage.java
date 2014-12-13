package com.sdsmdg.kmaniac;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.sdsmdg.kmaniac.R;

public class InitialPage extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_initial_page);

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// Handle the back button
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			// Ask the user if they want to quit
			new AlertDialog.Builder(this)

					.setTitle(R.string.quit_title)
					.setMessage(R.string.quit)
					.setPositiveButton(R.string.quit_yes,
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {

									// Stop the activity
									android.os.Process
											.killProcess(android.os.Process
													.myPid());
									System.exit(1);
								}

							}).setNegativeButton(R.string.quit_no, null).show();

			return true;
		} else {
			return super.onKeyDown(keyCode, event);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.initial_page, menu);
		return true;
	}

	public void showBoard(View v) {
		Thread display = new Thread() {
			public void run() {
				try {
					sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				finally {
					Intent openBoardPage = new Intent(
							"com.sdsmdg.kmaniac.boardDisplay");
					startActivity(openBoardPage);

				}

			}

		};
		display.start();

	}

	public void showFour(View v) {
		Thread display = new Thread() {
			public void run() {
				try {
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				finally {
					Intent openBoardPage = new Intent(
							"com.sdsmdg.kmaniac.fourBoard");
					startActivity(openBoardPage);

				}

			}

		};
		display.start();

	}
	
	
	public void showcredits(View v) {
		Thread display = new Thread() {
			public void run() {
				try {
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				finally {
					Intent openBoardPage = new Intent(
							"com.sdsmdg.kmaniac.credit");
					startActivity(openBoardPage);

				}

			}

		};
		display.start();

	}

	public void showhow(View v) {
		Thread display = new Thread() {
			public void run() {
				try {
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				finally {
					Intent openBoardPage = new Intent(
							"com.sdsmdg.kmaniac.howtoplay");
					startActivity(openBoardPage);

				}

			}

		};
		display.start();

	}

}
