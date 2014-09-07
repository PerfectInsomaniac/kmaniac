package com.example.kmaniac;

import java.util.ArrayList;

public class map {
	public ArrayList selected = new ArrayList();
	 ArrayList temp= new ArrayList();
	 public ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
 public String ques=null ;
 
 public int total_sol=0;
	
	public map(int []sel,int[][]ans,String q)
	{
		for(int i=0;i<sel.length;i++)
		{
			selected.add(sel[i]);

		}
		ques=q;

		for(int i=0 ;i<ans.length;i++)
		{
			for(int j=0;j<ans[i].length;j++)
			{


	temp.add(ans[i][j]);

			}

           answer.add(temp);


		}
		total_sol=answer.size();

		
	}
	
	
}
