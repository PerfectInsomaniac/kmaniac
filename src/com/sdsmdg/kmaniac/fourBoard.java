package com.sdsmdg.kmaniac;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.sdsmdg.kmaniac.R;

public class fourBoard extends Activity{

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

		

		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				ImageView imageView = (ImageView) v;

				if (imageView.getTag().equals("SELECTED")) {

					imageView.setImageResource(R.drawable.ns);
					imageView.setTag("NOT_SELECTED");

					no_of_selected--;
				} else if (imageView.getTag().equals("NOT_SELECTED")) {

					if (no_of_selected < 4) {

						imageView.setImageResource(R.drawable.s);
						imageView.setTag("SELECTED");
						no_of_selected++;

					}

				}

			}
		});

		displayPage();
	}
	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		myCountDownTimerObject.cancel();
		return super.onKeyDown(keyCode, event);
	}
	

	void prepareArray(int a) {
		Random r = new Random();
		int coord_random;
		coord_random = r.nextInt(4);
		int rand_number;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				rand_number = r.nextInt(5);
				if (rand_number < 2)
					temp_board[i][j] = 1;
				else
					temp_board[i][j] = 0;
			}
		}
		
		switch(a)
		{
		case 0 :
			   switch(coord_random)
			         {
			   case 0 : temp_board[0][0]=temp_board[1][0]=temp_board[2][0]=temp_board[3][0]=1;
			           break;
			   case 1 : temp_board[0][1]=temp_board[1][1]=temp_board[2][1]=temp_board[3][1]=1;
	           break;
			   case 2 : temp_board[0][2]=temp_board[1][2]=temp_board[2][2]=temp_board[3][2]=1;
	           break;
			   case 3 : temp_board[0][3]=temp_board[1][3]=temp_board[2][3]=temp_board[3][3]=1;
	           break;
	                 }
			   break;
		case 1 :
			 switch(coord_random)
	         {
	   case 0 : temp_board[0][0]=temp_board[0][3]=temp_board[3][0]=temp_board[3][3]=1;
	           break;
	   case 1 : temp_board[0][1]=temp_board[0][2]=temp_board[3][1]=temp_board[3][2]=1;
       break;
	   case 2 : temp_board[1][0]=temp_board[2][0]=temp_board[1][3]=temp_board[2][3]=1;
       break;
	   case 3 : temp_board[1][1]=temp_board[2][1]=temp_board[1][2]=temp_board[2][2]=1;
       break;
             }
			   break;
		case 2 :
			 switch(coord_random)
	         {
	   case 0 : temp_board[0][0]=temp_board[0][1]=temp_board[3][0]=temp_board[3][1]=1;
	           break;
	   case 1 : temp_board[0][2]=temp_board[0][3]=temp_board[3][2]=temp_board[3][3]=1;
       break;
	   case 2 : temp_board[1][0]=temp_board[1][1]=temp_board[2][0]=temp_board[2][1]=1;
       break;
	   case 3 : temp_board[1][2]=temp_board[1][3]=temp_board[2][2]=temp_board[2][3]=1;
       break;
             }
			   break;
		case 3 :
			 switch(coord_random)
	         {
	   case 0 : temp_board[0][0]=temp_board[1][0]=temp_board[0][3]=temp_board[1][3]=1;
	           break;
	   case 1 : temp_board[0][1]=temp_board[0][2]=temp_board[1][1]=temp_board[1][2]=1;
       break;
	   case 2 : temp_board[2][0]=temp_board[2][3]=temp_board[3][0]=temp_board[3][3]=1;
       break;
	   case 3 : temp_board[2][1]=temp_board[2][2]=temp_board[3][1]=temp_board[3][2]=1;
       break;
             }
			   break;
		case 4 :
			 switch(coord_random)
	         {
	   case 0 : temp_board[0][0]=temp_board[0][1]=temp_board[1][0]=temp_board[1][1]=1;
	           break;
	   case 1 : temp_board[0][2]=temp_board[0][3]=temp_board[1][2]=temp_board[1][3]=1;
       break;
	   case 2 : temp_board[2][0]=temp_board[2][1]=temp_board[3][0]=temp_board[3][1]=1;
       break;
	   case 3 : temp_board[2][2]=temp_board[2][3]=temp_board[3][2]=temp_board[3][3]=1;
       break;
             }
			   break;
		case 5 :
			 switch(coord_random)
	         {
	   case 0 : temp_board[0][0]=temp_board[0][1]=temp_board[0][2]=temp_board[0][3]=1;
	           break;
	   case 1 : temp_board[1][0]=temp_board[1][1]=temp_board[1][2]=temp_board[1][3]=1;
       break;
	   case 2 : temp_board[2][0]=temp_board[2][1]=temp_board[2][2]=temp_board[2][3]=1;
       break;
	   case 3 : temp_board[3][0]=temp_board[3][1]=temp_board[3][2]=temp_board[3][3]=1;
       break;
             }
			   break;
		
			   
		}
		
		
		
		
	}

	public void prepareBoard(int a) {

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

		gridView.setAdapter(new ImageAdapter(this, fourBoard.this));
	}

	public void displayPage() {

		Random r = new Random();
		int rand_number;
		rand_number = r.nextInt(6);
		tv1 = (TextView) findViewById(R.id.textView1);
		b1 = (Button) findViewById(R.id.button1);

		shape = rand_number;
		switch (rand_number) {
		case 0:
			b1.setText("Eliminate Triangle And Circle");
			break;
		case 1:
			b1.setText("Eliminate Triangle And Star");
			break;
		case 2:
			b1.setText("Eliminate Triangle And Square");
			break;
		case 3:
			b1.setText("Eliminate Circle And Star");
			break;
		case 4:
			b1.setText("Eliminate Circle And Square");
			break;

		case 5:
			b1.setText("Eliminate Star And Square");
			break;


		}

		prepareBoard(rand_number);
		myCountDownTimerObject = new CountDownTimer(
				20000 - 1000 * no_of_levels, 1000) {

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
			else if (imageView.getTag().equals("NO_IMAGE")) {
				resultTempArray[j++] = 0;
			}
		}

		j = 0;
		for (int k = 0; k < 4; k++)
			for (int m = 0; m < 4; m++) {
				resultArray[k][m] = resultTempArray[j++];

			}

		switch (shape) {
		case 0 :if(
				(resultArray[0][0]==1 && resultArray[1][0]==1 && resultArray[2][0]==1 && resultArray[3][0]==1)||
				(resultArray[0][1]==1 && resultArray[1][1]==1 && resultArray[2][1]==1 && resultArray[3][1]==1)||
				(resultArray[0][2]==1 && resultArray[1][2]==1 && resultArray[2][2]==1 && resultArray[3][2]==1)||
				(resultArray[0][3]==1 && resultArray[1][3]==1 && resultArray[2][3]==1 && resultArray[3][3]==1)
				)
		       {
			    result=true;
		       }
		         break;
		       
		case 1 :if(
				(resultArray[0][0]==1 && resultArray[0][3]==1 && resultArray[3][0]==1 && resultArray[3][3]==1)||
				(resultArray[0][1]==1 && resultArray[0][2]==1 && resultArray[3][1]==1 && resultArray[3][2]==1)||
				(resultArray[1][0]==1 && resultArray[2][0]==1 && resultArray[1][3]==1 && resultArray[2][3]==1)||
				(resultArray[1][1]==1 && resultArray[2][1]==1 && resultArray[1][2]==1 && resultArray[2][2]==1)
				)   
		        {
			    result=true;
		        }
		       break;
		       
		case 2:if(
				(resultArray[0][0]==1 && resultArray[0][1]==1 && resultArray[3][0]==1 && resultArray[3][1]==1)||
				(resultArray[0][2]==1 && resultArray[0][3]==1 && resultArray[3][2]==1 && resultArray[3][3]==1)||
				(resultArray[1][0]==1 && resultArray[1][1]==1 && resultArray[2][0]==1 && resultArray[2][1]==1)||
				(resultArray[1][2]==1 && resultArray[1][3]==1 && resultArray[2][2]==1 && resultArray[2][3]==1)
				)	
		          {
			result =true;
		          }
		       break;
		       
		case 3: if(
				(resultArray[0][0]==1 && resultArray[1][0]==1 && resultArray[0][3]==1 && resultArray[1][3]==1)||
				(resultArray[0][1]==1 && resultArray[0][2]==1 && resultArray[1][1]==1 && resultArray[1][2]==1)||
				(resultArray[2][0]==1 && resultArray[2][3]==1 && resultArray[3][0]==1 && resultArray[3][3]==1)||
				(resultArray[2][1]==1 && resultArray[2][2]==1 && resultArray[3][1]==1 && resultArray[3][2]==1)
				)  
		        {
			   result = true;
		        }
		       break;
		case 4:if(
				(resultArray[0][0]==1 && resultArray[0][1]==1 && resultArray[1][0]==1 && resultArray[1][1]==1)||
				(resultArray[0][2]==1 && resultArray[0][3]==1 && resultArray[1][2]==1 && resultArray[1][3]==1)||
				(resultArray[2][0]==1 && resultArray[2][1]==1 && resultArray[3][0]==1 && resultArray[3][1]==1)||
				(resultArray[2][2]==1 && resultArray[2][3]==1 && resultArray[3][2]==1 && resultArray[3][3]==1)
				)   
		        {
			     result = true;
		        }
		        break;
		case 5 : if(
				(resultArray[0][0]==1 && resultArray[0][1]==1 && resultArray[0][2]==1 && resultArray[0][3]==1)||
				(resultArray[1][0]==1 && resultArray[1][1]==1 && resultArray[1][2]==1 && resultArray[1][3]==1)||
				(resultArray[2][0]==1 && resultArray[2][1]==1 && resultArray[2][2]==1 && resultArray[2][3]==1)||
				(resultArray[3][0]==1 && resultArray[3][1]==1 && resultArray[3][2]==1 && resultArray[3][3]==1)
				)	
		        {
			     result = true;			
		        }
		       break;
		}

		if (result) {
			myCountDownTimerObject.cancel();
			no_of_levels++;
			no_of_selected = 0;
			displayPage();

		} else {
			myCountDownTimerObject.cancel();

			Toast.makeText(getApplicationContext(),
					" Just " + no_of_levels + " levels", Toast.LENGTH_LONG)
					.show();
			finish();
		}

	}

}
