package com.nanda.java.samples.meta;
import java.util.*;
public class ChessKnights{

     public static void main(String []args){
        System.out.println("Hello World");
        SolutionForChessKnigts s = new SolutionForChessKnigts();
        ChessNode src = new ChessNode(1,7,0);
        ChessNode tar = new ChessNode(0,7,0);
        System.out.println("seconds " + s.findShortestTime(src, tar, 8));
     }
     
}
class ChessNode {
    int dist, x, y;

    public ChessNode(int x, int y)    {
        this.x = x;
        this.y = y;
    }
 
    public ChessNode(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
    public boolean isValidNode(){
        return (x>=0) && (x<=7) && (y>=0) && (y<=7);
    }
}
class SolutionForChessKnigts {
    public int findShortestTime(ChessNode src, ChessNode tar, int size){
        int[] xVals = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] yVals = {1, -1, 1, -1, 2, -2, 2, -2};
        int[][] board = new int[8][8];
        Queue<ChessNode> nodes = new ArrayDeque<ChessNode>();
        Set<ChessNode> visited = new HashSet<>();
        nodes.add(src);
        int count = 0;
        while(!nodes.isEmpty() && count < 100){
            ChessNode current = nodes.poll();
            //System.out.println("current node at x= " + current.x + " y= " + current.y);
            if(current.x == tar.x && current.y == tar.y){
                return current.dist;
            }
            if(board[current.x][current.y] == 1){
                 //System.out.println("vis");
                continue;
            }else{
                board[current.x][current.y] = 1;
                for(int i=0; i<size; i++) {
                    ChessNode newNode = new ChessNode(current.x+xVals[i], current.y+yVals[i], current.dist+1);
                    if(newNode.isValidNode()){
                        nodes.add(newNode);
                        //System.out.println("adding node at x= " + newNode.x + " y= " + newNode.y);
                    }
                }
                count++;
            }
        }
        return -1;
    }
}