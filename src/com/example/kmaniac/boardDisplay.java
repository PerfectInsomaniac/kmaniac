package com.example.kmaniac;

import java.security.SecureRandom;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class boardDisplay  extends Activity {

	
	 CountDownTimer myCountDownTimerObject;
	 TextView tv1= (TextView)findViewById(R.id.textView1);
	 Button b1 =(Button)findViewById(R.id.button1); 
	 
	 int no_of_levels=0;
	
	  
	   protected void onCreate(Bundle savedInstanceState)
	    {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
         setContentView(R.layout.game_board);
		}
	   
	   
	   
	   public void generate()
	   {
		   
		   
			
			SecureRandom r= new SecureRandom();
			int i =r.nextInt(4)+1;
			switch(i)
			{
			case 1: b1.setText("Eliminate A");
			        break;
			        
			case 2: b1.setText("Eliminate B");        
			         break;
			       
			case 3:b1.setTag("Eliminate C");
			          break;
			  
			case 4: b1.setText("Eliminate D")  ;
			         break;
			
		     }
			
		int [][] sol=new int[4][4];
		
		
		switch(i)
		{
		
		
		}
			
	     
			
	   }
	
}
   