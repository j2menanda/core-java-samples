package com.nanda.java.samples.meta;
/*
A photography set consists of N cells in a row, numbered from 1 to N in order, and can be represented by a string C of length N. Each cell i is one of the following types (indicated by Ci, the ith character of C):
A photograph consists of a photographer, an actor, and a backdrop, such that each of them is placed in a valid cell, and such that the actor is between the photographer and the backdrop. Such a photograph is considered artistic if the distance between the photographer and the actor is between X and Y cells (inclusive), and the distance between the actor and the backdrop is also between X and Y cells (inclusive). The distance between cells i and j is ∣i−j∣ (the absolute value of the difference between their indices).
Determine the number of different artistic photographs which could potentially be taken at the set. Two photographs are considered different if they involve a different photographer cell, actor cell, and/or backdrop cell.
Constraints
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
All are artistic except the first, where the artist and backdrop exceed the maximum distance of 3.
*/
import java.util.List;
import java.util.ArrayList;
class HelloWorld2{

     public static void main(String []args){
    	 PhotoOptimalSol a = new PhotoOptimalSol();
        int N = 8;
        //String C = "APABA"; int X = 1; int Y = 3;
        String C = ".PBAAP.B"; int X = 1; int Y = 3;
        List<String> combs = a.getArtisticPhotos(N, X, Y, 'P', 'B');
        combs.addAll(a.getArtisticPhotos(N, X, Y, 'B', 'P'));
        System.out.println("Total possible Strings are : " + combs.size());
        System.out.println("Matching strings are " + a.getMatchingStrings(combs, C));
     }
}

public class PhotoOptimalSol {
    public List<String> getArtisticPhotos(int N, int X, int Y, char start, char end){
        int count = 0;
        List<String> combs = new ArrayList<String>();
        for(int i=0; i < N; i++){
            char[] chars = new char[N];
            for(int j=0; j<N; j++){
                chars[j] = '.';
            }
            chars[i] = start;
            int indexOfA = i+X;
            String newComb = null;
            while(indexOfA < N && indexOfA-i <= Y){
                chars[indexOfA] = 'A';
                int indexOfEnd = indexOfA + X;
                while(indexOfEnd < N && indexOfEnd-indexOfA <= Y){
                    chars[indexOfEnd] = end;
                    newComb = new String(chars);
                    combs.add(newComb);
                    chars[indexOfEnd] = '.';
                    indexOfEnd++;
                }
                chars[indexOfA] = '.';
                indexOfA++;
            }
        }
        return combs;
    }
    
    public int getMatchingStrings(List<String> combs, String C){
        int count = 0;
        for(int i=0; i<combs.size();i++){
            boolean matched = true;
            for(int j=0; j<C.length();j++){
                if(combs.get(i).charAt(j) != '.' && combs.get(i).charAt(j) != C.charAt(j)){
                    matched = false;
                    break;
                }
            }
            if(matched){
                System.out.println(combs.get(i));
                count++;
            }
        }
        return count;
    }
}