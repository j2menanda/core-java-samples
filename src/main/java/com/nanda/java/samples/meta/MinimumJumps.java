package com.nanda.java.samples.meta;

public class MinimumJumps {

	public static void main(String[] args) {
		MinimumJumpsSolution s = new MinimumJumpsSolution();
		//int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} ; //sol = 3
		int[] arr = {2,3,1,1,2,4,2,0,1,1};
		//int[] arr = {33,76,21,77,100,68,37,8,22,69,81,38,94,57,76,54,65,14,89,69,4,16,24,47,7,21,78,53,17,81,39,50,22,60,93,89,94,30,97,16,65,43,20,24,67,62,78,98,42,67,32,46,49,57,60,56,44,37,75,62,17,13,11,40,40,4,95,100,0,57,82,31,0,1,56,67,30,100,64,72,66,63,18,81,19};
		//int[] arr = {3,25,70,69,33,76,21,77,100,68,37,8,22,69,81,38,94,57,76,54,65,14,89,69,4,16,24,47,7,21,78,53,17,81,39,50,22,60,93,89,94,30,97,16,65,43,20,24,67,62,78,98,42,67,32,46,49,57,60,56,44,37,75,62,17,13,11,40,40,4,95,100,0,57,82,31,0,1,56,67,30,100,64,72,66,63,18,81,19};
		System.out.println("START");
		System.out.println("min is " + s.minJumpsNew(arr));
	}

}

class MinimumJumpsSolution{
    public int minJumpsNew(int[] arr){
        int curStep = 0, nextStep = 0, count = 0, jump = 0, maxVal = 0, tentNextStep = 0;
        boolean notPossible = false, reachedEnd = false;
        while(!reachedEnd && !notPossible && count < 10) {
            System.out.println("cur step is " + arr[curStep]);
        	if(arr[curStep] == 0) {
        		notPossible = true;
        		break;
        	} else if((curStep+arr[curStep]) >= arr.length) {
        		count++;
        		break;
        	} else {
        		maxVal = 0;
        		for(int i=curStep+1; i<=arr[curStep]; i++) {
        			tentNextStep = curStep+i;
        			if(maxVal < arr[tentNextStep]) {
        				maxVal = arr[tentNextStep];
        				nextStep = tentNextStep;
        			}
        		}
                System.out.println("max val is " + maxVal + " next step is " + nextStep);
        		count++;
        		curStep = nextStep;
        	}
        }
        return notPossible ? -1 : count;
    }
	public int minJumps(int[] arr){
        int nextStep = 0, count = 0, jump = 0, maxVal = 0, tentNextStep = 0;
        boolean notPossible = false, reachedEnd = false;
        while(!reachedEnd && !notPossible && count<10){
            jump = arr[nextStep];
            System.out.println("next step is " + arr[nextStep]);
            if(jump == 0){
                notPossible = true;
            } else if (jump >= arr.length){
            	count++;
            	reachedEnd = true;
            } else {
                maxVal = 0;
                for(int i=1; i<=jump; i++){
                    tentNextStep = nextStep + i;
                    if(tentNextStep >= arr.length){
                        reachedEnd = true;
                    }
                    if(tentNextStep < arr.length && arr[tentNextStep] > maxVal){
                        maxVal = arr[tentNextStep];
                        nextStep = tentNextStep;
                    }
                }
                System.out.println("max val is " + maxVal);
                count++;
               	if(reachedEnd && count == 1) {
               		count++;
               	}
            }
        }
        return notPossible ? -1 : count;
    }
}