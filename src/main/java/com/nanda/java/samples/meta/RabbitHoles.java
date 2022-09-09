package com.nanda.java.samples.meta;
/*
You're having a grand old time clicking through the rabbit hole that is your favorite online encyclopedia.
The encyclopedia consists of N different web pages, numbered from 1 to N. Each page i contains nothing but a single link to a different page Li.
A session spent on this website involves beginning on one of the N pages, and then navigating around using the links until you decide to stop. That is, while on page i, you may either move to page Li, or stop your browsing session.
Assuming you can choose which page you begin the session on, what's the maximum number of different pages you can visit in a single session? Note that a page only counts once even if visited multiple times during the session.
Constraints
2≤N≤500,000
1≤Li≤N
Li <> ≠i
Sample test case #1
N = 4
L = [4, 1, 2, 1]
Expected Return Value = 4
Sample test case #2
N = 5
L = [4, 3, 5, 1, 2]
Expected Return Value = 3
Sample test case #3
N = 5
L = [2, 4, 2, 2, 3]
Expected Return Value = 4
Sample Explanation
In the first case, you can visit all 4 pages in a single browsing session if you begin on page 3. For example, you can visit the sequence of pages 3→2→1→4.
In the second case, you can only visit at most 3 different pages -− for example, the sequence of pages 3→5→2.
In the third case, you can only visit at most 4 different pages -− for example, the sequence of pages 5→3→2→4.
*/


import java.util.*;
class HelloWorldRabbit{

     public static void main(String []args){
        System.out.println("Hello World");
        RabbitHoles s = new RabbitHoles();
        //int N = 4; int[] L = {4,1,2,1};
        //int N = 5; int[] L = {4,3,5,1,2};
        //int N = 5; int[] L = {2,4,2,2,3};
        int N = 8; int[] L = {2,4,2,2,3,1,5,3};
        //int N = 5; int[] L = {2,4,2,2,4};
        System.out.println(s.getMaxVisitableWebpages(N, L));
     }
}
public class RabbitHoles {

    public int getMaxVisitableWebpages(int N, int[] L) {
        int pages = 0;
        int maxPages = 0;
        for(int i=0; i<N; i++){
            int pageNum = i+1;
            addLink(pageNum, L[i]);
        }
        for(int i=1; i<=N; i++){
            pages = getDestinations(i);
            if(maxPages < pages){
                maxPages = pages;
            }
        }
        return maxPages;
    }
    
    Map<Integer, Integer> links = new HashMap<>();

    public void addLink(int src, int dest){
        links.put(src, dest);
    }
    
    public int getDestinations(int src){
        List<Integer> visited = new ArrayList<>();
        visited.add(src);
        boolean notVisited = true;

        while(notVisited){
            int dest = links.get(src);
            if(visited.contains(dest)){
                notVisited = false;
            } else {
                visited.add(dest);
            }
            src = dest;
        }
        return visited.size();
    }
}


/*

import java.util.*;
public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        Solution s = new Solution();
        //int N = 4; int[] L = {4,1,2,1};
        int N = 5; int[] L = {4,3,5,1,2};
        //int N = 5; int[] L = {2,4,2,2,3};
        //int N = 8; int[] L = {2,4,2,2,3,1,5,3};
        //int N = 5; int[] L = {2,4,2,2,4};
        System.out.println(s.getMaxVisitableWebpages(N, L));
     }
}
class Solution {

    public int getMaxVisitableWebpages(int N, int[] L) {
        int pages = 0;
        int maxPages = 0;
        int start = -1;
        GraphHoles g = new GraphHoles();
        for(int i=1; i<=N; i++){
            int pageNum = i;
            g.addPage(pageNum);
        }
        for(int i=0; i<N; i++){
            int pageNum = i+1;
            g.addLink(pageNum, L[i]);
        }
        for(int i=0; i<N; i++){
            pages = g.getDestinations(new Page(i+1));
            if(maxPages < pages){
                maxPages = pages;
                start = i;
            }
        }
        return maxPages;
    }
    
    public void sop(String str){
        System.out.println(str);
    }
}

class GraphHoles {
    Map<Page, List<Page>> links = new HashMap<>();

    public void addPage(int index){
        links.putIfAbsent(new Page(index), new ArrayList<>());
    }
    
    public void addLink(int src, int dest){
        Page srcP = new Page(src);
        Page destP = new Page(dest);
        links.get(srcP).add(destP);
    }
    
    public int getDestinations(Page src){
        List<Page> visited = new ArrayList<>();
        visited.add(src);
        boolean notVisited = true;

        while(notVisited){
            Page dest = links.get(src).get(0);
            if(visited.contains(dest)){
                notVisited = false;
            } else {
                visited.add(dest);
            }
            src = dest;
        }
        return visited.size();
    }
}
class Page {
    int index;
    public Page(int x){
        index = x;
    }
    @Override
    public boolean equals(Object other){
        Page dest = (Page) other;
        return this.index == dest.index;
    }
    
    @Override
    public int hashCode(){
        return index;
    }
}*/