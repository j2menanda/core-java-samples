package com.nanda.java.samples.meta;
/*Note: Chapter 1 is an easier version of this puzzle. The only difference is a smaller constraint on N.
A photography set consists of N cells in a row, numbered from 1 to N in order, and can be represented by a string C of length N. Each cell i is one of the following types (indicated by Ci, the ith character of C):
A photograph consists of a photographer, an actor, and a backdrop, such that each of them is placed in a valid cell, and such that the actor is between the photographer and the backdrop. Such a photograph is considered artistic if the distance between the photographer and the actor is between X and Y cells (inclusive), and the distance between the actor and the backdrop is also between X and Y cells (inclusive). The distance between cells i and j is |i - j| (the absolute value of the difference between their indices).
Determine the number of different artistic photographs which could potentially be taken at the set. Two photographs are considered different if they involve a different photographer cell, actor cell, and/or backdrop cell.
Constraints
1≤N≤300,000
1≤X≤Y≤N
Sample test case #1
N = 5
C = APABA
X = 1
Y = 2
Expected Return Value = 1
Sample test case #2
N = 5
C = APABA
X = 2
Y = 3
Expected Return Value = 0
Sample test case #3
N = 8
C = .PBAAP.B
X = 1
Y = 3
Expected Return Value = 3
Sample Explanation
In the first case, the absolute distances between photographer/actor and actor/backdrop must be between 1 and 2. The only possible photograph that can be taken is with the 3 middle cells, and it happens to be artistic.
In the second case, the only possible photograph is again taken with the 3 middle cells. However, as the distance requirement is between 2 and 3, it is not possible to take an artistic photograph.
In the third case, there are 4 possible photographs, illustrated as follows:
.P.A...B
.P..A..B
..BA.P..
..B.AP..
All are artistic except the first, where the artist and backdrop exceed the maximum distance of 3.*/

import java.util.List;
import java.util.ArrayList;
public class DirectorOfPhotography{

     public static void main(String []args){
        Photo a = new Photo();
        int N = 1;
        //String C = "APABA"; int X = 1; int Y = 2;
        String t = "..PBAAP.B.";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(t);
        }
        int X = 1; int Y = 3;
        String C = sb.toString();
        N = C.length();
        System.out.println("Total possible Strings are : " + a.getArtisticPhotographCount(N, C, X, Y));
     }
}

class Photo {
    public long getArtisticPhotographCount(int N, String C, int X, int Y) {
        long count = 0;
        String charA = "A";
        int indexOfA = C.indexOf(charA);
        
        while(indexOfA >= 0){
            count += getPhotosForAatIndex(indexOfA, X, Y, C, "P", "B");
            count += getPhotosForAatIndex(indexOfA, X, Y, C, "B", "P");
            indexOfA = C.indexOf(charA, indexOfA+1);
        }
        return count;
    }
    
    public long getPhotosForAatIndex(int indexOfA, int X, int Y, String C, String start, String end){
        int indexOfStart = C.indexOf(start, indexOfA - Y);
        int countStart = 0;
        int countEnd = 0;
        if(C.indexOf(end, indexOfA+X) < 0){
            return 0;
        }
        while(indexOfStart >= 0 && indexOfStart <= indexOfA - X){
            countStart++;
            indexOfStart = C.indexOf(start, indexOfStart+1);
        }
        if(countStart > 0){
            int indexOfEnd = C.indexOf(end, indexOfA + X);
            while(indexOfEnd >= 0 && indexOfEnd <= indexOfA + Y){
                countEnd++;
                indexOfEnd = C.indexOf(end, indexOfEnd+1);
            }
        }
        return countStart * countEnd;
    }
}

// Solution 2
/*
	public long getArtisticPhotographCount(int N, String C, int X, int Y) {
        long count = getArtisticPhotos(N, X, Y, 'P', 'B', C);
        count += getArtisticPhotos(N, X, Y, 'B', 'P', C);
        return count;
    }
    
    public long getArtisticPhotos(int N, int X, int Y, char start, char end, String C){
        long count = 0;
        StringBuilder newComb = new StringBuilder(N);
        int indexOfA = 0;
        char charA = 'A';
        for(int i=0; i < N; i++){
            if(C.charAt(i) == start){
                indexOfA = i+X;
                while(indexOfA < N && indexOfA-i <= Y){
                    if(C.charAt(indexOfA) == charA){
                        int indexOfEnd = indexOfA + X;
                        while(indexOfEnd < N && indexOfEnd-indexOfA <= Y){
                            if(C.charAt(indexOfEnd) == end){
                                count++;
                            }
                            indexOfEnd++;
                        }
                    }
                    indexOfA++;
                }
            }
        }
        return count;
    }
	*/
//Solution 3 :
/*class Photo {
    public long getArtisticPhotographCount(int N, String C, int X, int Y) {
        long count = getArtisticPhotos(N, X, Y, 'P', 'B', C);
        count += getArtisticPhotos(N, X, Y, 'B', 'P', C);
        return count;
    }
    
    public long getArtisticPhotos(int N, int X, int Y, char start, char end, String C){
        long count = 0;
        StringBuilder newComb = new StringBuilder(N);
        int indexOfA = 0;
        int indexOfEnd = 0;
        char charA = 'A';
        for(int indexOfS = C.indexOf(start); indexOfS < N; indexOfS = C.indexOf(start, indexOfS+1)){
            indexOfA = C.indexOf(charA, indexOfS+X);
            while(indexOfA < N && indexOfA-indexOfS <= Y){
                indexOfEnd = C.indexOf(end, indexOfA+X);
                while(indexOfEnd < N && indexOfEnd-indexOfA <= Y){
                    count++;
                    indexOfEnd = C.indexOf(end, indexOfEnd+1);
                }
                indexOfA = C.indexOf(start, indexOfS+1);
            }
        }
        return count;
    }
}*/