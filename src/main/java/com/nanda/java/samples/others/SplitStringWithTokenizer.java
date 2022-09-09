package com.nanda.java.samples.others;

import java.util.StringTokenizer;

class SplitStringWithTokenizer
{
	public static void main(String[] args) 
	{
		String str="timestamp,ngpslistener,naddlocation,ndatasent,batterylevel;timestamp,ngpslistener,naddlocation,ndatasent,batterylevel;timestamp,ngpslistener,naddlocation,ndatasent,batterylevel;timestamp,ngpslistener,naddlocation,ndatasent,batterylevel;";
	/*
		String newstr = str.replace(',',' ');
		StringTokenizer line = new StringTokenizer(newstr, ";");
		String temp = "";
		while (line.hasMoreTokens()) {
			temp = line.nextToken();
			System.out.println(temp);
		}
	*/
		
		StringTokenizer rowTokenizer = new StringTokenizer(str, ";");
		while (rowTokenizer.hasMoreTokens())
		{
			String row = rowTokenizer.nextToken();
			StringTokenizer columnTokenizer = new StringTokenizer(row, ",");
			String rowData[] = new String[5];
			int i=0;
			
			while( columnTokenizer.hasMoreTokens() ) {
				rowData[i++] = columnTokenizer.nextToken();
			}
			
			for( int j=0; j<5; j++ ) {
				System.out.print(rowData[j] + "  ");
			}
			
			System.out.println("\n");
		}
	}
}
