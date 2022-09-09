package com.nanda.java.samples.others;

public class FirstCharCap {
	public static void main( String a[] ) {
		String str = "This batch job extracts billable EFU transactions processed through VIP-Connect on a daily basis. The transaction data is made available to BIG through a Flat Data File produced by VIP-Connect";
		str = str.trim();
		str += " ";
		String str1 = "", str2, str3;

		try{
			while( true ) {
				if( str.indexOf( " " ) == -1 )
					break;

				str2 = str.substring( 0, str.indexOf( " " ) ).trim();
				str3 = "" + str2.charAt( 0 );
				str3 = str3.toUpperCase() + str2.substring( 1 ).toLowerCase();

				str1 += str3 + " ";

				str = str.substring( str.indexOf( " " ) + 1 );
			}
		}catch( Exception e ){}

		System.out.println( str1 );
	}
}
// end