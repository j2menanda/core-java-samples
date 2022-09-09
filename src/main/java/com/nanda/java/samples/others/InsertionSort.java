package com.nanda.java.samples.others;

public class InsertionSort
{
	public static void main(String[] args)
	{
		int ar[] = {7, 5, 2, 4, 3, 9};
		{
			for (int i=0; i < ar.length-1; i++)
			{
				int index = ar[i];
				int j = i;
				while (j > 0 && ar[j-1] > index)
				{
					ar[j] = ar[j-1];
					j--;
				}
				ar[j] = index;
			}
			for (int i = 0; i < ar.length; i++)
			{
				System.out.print(ar[i]);
			}
		}
	}
}