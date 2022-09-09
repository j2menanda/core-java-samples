package com.nanda.java.samples.meta;
import java.util.*;
public class ConsecutivePrimes{

     public static void main(String []args){
        System.out.println("Hello World");
        SolutionForConsecutivePrimes s = new SolutionForConsecutivePrimes();
        int N = 8;
        System.out.println(s.numberOfCombs(N));
     }
}
class SolutionForConsecutivePrimes {
    public int numberOfCombs(int num){
        int sum = 0;
        List<PrimeNode> pairs = new ArrayList<>();
        for(int i=1; i<num; i++){
            for(int j=i+1; j<=num; j++){
                sum = i + j;
                if(isPrime(sum)){
                    pairs.add(new PrimeNode(i, j));
                }
            }
        }
        return getCombs(pairs);
    }
    
    public int getCombs(List<PrimeNode> nodes){
        int count = 0;
        for(PrimeNode node1 : nodes){
            for(PrimeNode node2 : nodes){
                if(node1.y == node2.x){
                    
                }
            }
            System.out.println(" " + node1.x + " " + node1.y);
        }
        return count;
        
    }
    public boolean isPrime(int n){
        if(n ==2){
            return true;
        }
        boolean isPrime = false;
        for(int i=2;i<=n/2;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
class PrimeNode {
    int x, y;
    public PrimeNode(int x, int y){
        this.x = x;
        this.y = y;
    }
}