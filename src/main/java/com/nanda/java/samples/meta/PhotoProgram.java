package com.nanda.java.samples.meta;
class HelloWorld1{

     public static void main(String []args){
    	 PhotoProgram a = new PhotoProgram();
        int N = 5;
        //String C = "APABA"; int X = 1; int Y = 3;
        String C = ".PBAAP.B"; int X = 1; int Y = 3;
        System.out.println("PHotos : " + a.getArtisticPhotos(N, C, X, Y));
     }
}

public class PhotoProgram {
    public int getArtisticPhotos(int N, String C, int X, int Y){
        int sol = 0;
        for(int i = 0; i < C.length(); i++){
            char c = C.charAt(i);
            if(c == 'P'){
                int temp = artistExists(C.substring(i), X, Y, "A", "B");
                if(temp > 0){
                    sol += temp;
                }
            }
            if(c == 'B'){
                int temp = artistExists(C.substring(i), X, Y, "A", "P");
                if(temp > 0){
                    sol += temp;
                }
            }
        }
        return sol;
    }
    
    public int artistExists(String str, int X, int Y, String ch, String end){
        System.out.println("String for artist is : " +str);
        int exists = 0;
        int count = 0;
        int indexOfA = str.indexOf(ch);
        while(indexOfA >= 0){
            System.out.println("A exists at " + indexOfA);
            if(indexOfA >=X && indexOfA <= Y){
                exists = endExists(str.substring(indexOfA), X, Y, end);
                if(exists == 1){
                    System.out.println("Artistic photo found");
                    count++;
                }
            }
            indexOfA = str.indexOf(ch, indexOfA+1);
        }
        return count;
    }
    
    public int endExists(String str, int X, int Y, String ch){
        System.out.println("String for end is " +str);
        int exists = 0;
        int count = 0;
        int indexOfA = str.indexOf(ch);
        System.out.println(ch + " exists at " + indexOfA);
        if(indexOfA >=X && indexOfA <= Y){
            count++;
        }
        return count;
    }
}