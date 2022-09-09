package com.nanda.java.samples.others;

public class SelectionSort
{
	public static void main(String[] args)
	{
		int ar[] = {7, 5, 2, 4, 3, 9};
		for (int i = 0; i < ar.length-1; i++)
		{
			int min = i;
			for (int j = i+1; j < ar.length; j++)
			{
				if (ar[j] < ar[min])
					min = j;
				
				int temp = ar[i];
				ar[i] = ar[min];
				ar[min] = temp;
			}
		}
		for (int i = 0; i < ar.length; i++)
		{
			System.out.print(ar[i]);
		}
	}
}