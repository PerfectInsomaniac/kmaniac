package com.example.kmaniac;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class boardDisplay extends Activity {

	CountDownTimer myCountDownTimerObject;
	TextView tv1;
	Button b1;
	GridView gridView;
	int no_of_levels = 0;
	int no_of_selected = 0;
	int shape;
	public Integer[][] board = new Integer[5][5];
	int[][] temp_board = new int[4][4];
   
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.game_board);
		gridView = (GridView) findViewById(R.id.gridView1);
		tv1 = (TextView) findViewById(R.id.textView1);
		b1 = (Button) findViewById(R.id.button1);

		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				board[i][j] = R.drawable.s;

		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				ImageView imageView = (ImageView) v;
				Log.v(null, ""+imageView.getTag());
				if (imageView.getTag().equals("SELECTED"))
 {
					Log.v(null, "b");
					imageView.setImageResource(R.drawable.ns);
					imageView.setTag("NOT_SELECTED");
					
					no_of_selected--;
				}
				else if(imageView.getTag().equals("NOT_SELECTED"))
				{
					
					if (no_of_selected < 2) {
						
						imageView.setImageResource(R.drawable.s);
						imageView.setTag("SELECTED");
						no_of_selected++;
						
					}

				}

			}
		});

		displayPage();
	}

	void prepareArray(int a) {
		Random r = new Random();
		int rand_number;

		int coord_random;
		coord_random = r.nextInt(4);
		int x;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				rand_number = r.nextInt(3);
				if(rand_number>1)
				temp_board[i][j] =1;
				else
					temp_board[i][j]=0;
			}
		}

		switch (a) {
		case 0:
			if (r.nextInt(4) % 2 == 0) {
				x = 1;
				temp_board[x][coord_random] = temp_board[x + 1][coord_random] = 1;

			} else {
				x = 3;
				temp_board[x][coord_random] = temp_board[0][coord_random] = 1;
			}
			break;
		case 1:
			if (r.nextInt(4) % 2 == 0) {
				x = 0;
				temp_board[x][coord_random] = temp_board[x + 1][coord_random] = 1;

			} else {
				x = 2;
				temp_board[x][coord_random] = temp_board[x + 1][coord_random] = 1;
			}
			break;
		case 3:
			if (r.nextInt(4) % 2 == 0) {
				x = 1;
				temp_board[coord_random][x] = temp_board[coord_random][x + 1] = 1;

			} else {
				x = 3;
				temp_board[coord_random][x] = temp_board[coord_random][0] = 1;
			}
			break;
		case 4:
			if (r.nextInt(4) % 2 == 0) {
				x = 0;
				temp_board[coord_random][x] = temp_board[coord_random][x + 1] = 1;

			} else {
				x = 2;
				temp_board[coord_random][x] = temp_board[coord_random][x + 1] = 1;
			}
			break;
		}

	}

	public void prepareBoard(int a) {
		gridView = (GridView) findViewById(R.id.gridView1);
		prepareArray(a);

		board[0][0] = R.drawable.zero;
		board[0][1] = R.drawable.one;
		board[0][2] = R.drawable.two;
		board[0][3] = R.drawable.three;
		board[0][4] = R.drawable.four;
		board[1][0] = R.drawable.five;
		board[2][0] = R.drawable.six;
		board[3][0] = R.drawable.seven;
		board[4][0] = R.drawable.eight;

		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {

				if (temp_board[i - 1][j - 1] == 1) {
					board[i][j] = R.drawable.ns;

				} else {
					board[i][j] = 0;
				}

			}

		}

		gridView.setAdapter(new ImageAdapter(this, boardDisplay.this));
	}

	public void displayPage() {

		Random r = new Random();
		int rand_number;
		rand_number = r.nextInt(4);
		tv1 = (TextView) findViewById(R.id.textView1);
		b1 = (Button) findViewById(R.id.button1);

		shape = rand_number;
		switch (rand_number) {
		case 0:
			b1.setText("Eliminate Triangle");
			break;
		case 1:
			b1.setText("Eliminate Circle");
			break;
		case 2:
			b1.setText("Eliminate Star");
			break;
		case 3:
			b1.setText("Eliminate Square");
			break;

		}

		prepareBoard(rand_number);
		myCountDownTimerObject = new CountDownTimer(
				20000 - 2000 * no_of_levels, 1000) {

			public void onTick(long millisUntilFinished) {
				tv1.setText("" + (int) (millisUntilFinished / 1000));
			}

			public void onFinish() {
				tv1.setText("done!");

				b1.setClickable(false);
				gridView.setClickable(false);
				Toast.makeText(getApplicationContext(),
						"Hehe !! Just " + no_of_levels + " levels",
						Toast.LENGTH_LONG).show();
				finish();

			}
		}.start();

	}

	public void checkAns(View v) {
		boolean result = false;
		final int numVisibleChildren = gridView.getChildCount();
		final int firstVisiblePosition = gridView.getFirstVisiblePosition();
		ImageView imageView;

		int[] resultTempArray = new int[16];
		int[][] resultArray = new int[4][4];
		int j = 0;

		myCountDownTimerObject.cancel();

		for (int i = firstVisiblePosition; i < numVisibleChildren; i++) {

			imageView = (ImageView) gridView.getChildAt(i);
			if (imageView.getTag().equals("SELECTED"))
				resultTempArray[j++] = 1;
			else if (imageView.getTag().equals("NOT_SELECTED"))
				resultTempArray[j++] = 0;
			else if(imageView.getTag().equals("NO_IMAGE"))
			{resultTempArray[j++] = 0;}
		}

		j = 0;
		for (int k = 0; k < 4; k++)
			for (int m = 0; m < 4; m++) {
				resultArray[k][m] = resultTempArray[j++];

			}
		
		Log.v(null, ""+resultArray[0][0]);
		Log.v(null, ""+resultArray[0][1]);
		Log.v(null, ""+resultArray[0][2]);
		Log.v(null, ""+resultArray[0][3]);
		Log.v(null, ""+resultArray[1][0]);
		Log.v(null, ""+resultArray[1][1]);
		Log.v(null, ""+resultArray[1][2]);
		Log.v(null, ""+resultArray[1][3]);
		Log.v(null, ""+resultArray[2][0]);
		Log.v(null, ""+resultArray[2][1]);
		Log.v(null, ""+resultArray[2][2]);
		Log.v(null, ""+resultArray[2][3]);
		Log.v(null, ""+resultArray[3][0]);
		Log.v(null, ""+resultArray[3][1]);
		Log.v(null, ""+resultArray[3][2]);
		Log.v(null, ""+resultArray[3][3]);
		
		
		
		switch (shape)
		{
		case 0:
			for (int b = 0; b < 4; b++) {
				if ((resultArray[1][b] == 1 && resultArray[2][b] == 1)
						|| (resultArray[0][b] == 1 && resultArray[3][b] == 1)) {
					result = true;
					Log.v(null,"A");
					break;
					
				}
				Log.v(null,"A");
			}
			break;
		case 1:
			for (int b = 0; b < 4; b++) {
				if ((resultArray[2][b] == 1 && resultArray[3][b] == 1)
						|| (resultArray[0][b] == 1 && resultArray[1][b] == 1)) {
					result = true;
					Log.v(null,"B");
					break;
				}
				Log.v(null,"B");
			}
			break;
		case 2:
			for (int b = 0; b < 4; b++) {
				if ((resultArray[b][1] == 1 && resultArray[b][2] == 1)
						|| (resultArray[b][0] == 1 && resultArray[b][3] == 1)) {
					result = true;
					
					break;
				}
				Log.v(null,"C");
			}
			break;
		case 3:
			for (int b = 0; b < 4; b++) {
				if ((resultArray[b][1] == 1 && resultArray[b][0] == 1)
						|| (resultArray[b][2] == 1 && resultArray[b][3] == 1)) {
					result = true;
					Log.v(null,"D");
					break;
				}
				Log.v(null,"D");
			}
			break;

		}

		if (result) {
			no_of_levels++;
			no_of_selected=0;
			displayPage();

		} 
		else {
			Toast.makeText(getApplicationContext(),
					" Just " + no_of_levels + " levels",
					Toast.LENGTH_LONG).show();
			finish();
		}

	}

}
