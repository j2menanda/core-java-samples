package com.nanda.java.samples.others;

public class BubbleSort
{
	public static void main(String[] args)
	{
		int ar[] = {7, 5, 2, 4, 3, 9};
		for (int i = (ar.length - 1); i >= 0; i--)
		{
			for (int j = 1; j < i; j++)
			{
				if (ar[j-1] > ar[j])
				{
					int temp = ar[j-1];
					ar[j-1] = ar[j];
					ar[j] = temp;
				}
			}
		}
		for (int i = 0; i < ar.length; i++)
		{
			System.out.print(ar[i]);
		}
	}
}