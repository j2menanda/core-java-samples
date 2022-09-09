package com.nanda.java.samples.others;

class SplitStringWithoutTokenizer
{
	public static void main(String[] args) 
	{
		String str="timestamp,ngpslistener,naddlocation,ndatasent,batterylevel;timestamp,ngpslistener,naddlocation,ndatasent,batterylevel;timestamp,ngpslistener,naddlocation,ndatasent,batterylevel;timestamp,ngpslistener,naddlocation,ndatasent,batterylevel;";
		
		str = str.replace( ',' , ' ' );
		String strs[] = str.split( ";" );
		
		int i = 0;
		int j = strs.length;
		
		while( i < j ) {
			System.out.print( strs[i] );
			i++;
			System.out.println( "\n" );
		}
	}
}
