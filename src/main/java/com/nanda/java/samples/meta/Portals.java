package com.nanda.java.samples.meta;
/*
You've found yourself in a grid of cells with R rows and C columns. The cell in the ith row from the top and jth column from the left contains one of the following (indicated by the character G_{i,j}
​
If G_{i,j} = ".", the cell is empty.
If G_{i,j} = "S", the cell contains your starting position. There is exactly one such cell.
If G_{i,j} = "E", the cell contains an exit. There is at least one such cell.
If G_{i,j} = "#", the cell contains a wall.
Otherwise, if G_{i,j} is a lowercase letter (between "a" and "z", inclusive), the cell contains a portal marked with that letter.
Your objective is to reach any exit from your starting position as quickly as possible. Each second, you may take either of the following actions:
Walk to a cell adjacent to your current one (directly above, below, to the left, or to the right), as long as you remain within the grid and that cell does not contain a wall.
If your current cell contains a portal, teleport to any other cell in the grid containing a portal marked with the same letter as your current cell's portal.
Determine the minimum number of seconds required to reach any exit, if it's possible to do so at all. If it's not possible, return -1 instead.
Constraints
1≤R,C≤50
G_{i,j} in {".", "S", "E", "#", "a"..."z"}
Sample test case #1
R = 3
C = 3
G = .E.
    .#E
    .S#
Expected Return Value = 4
Sample test case #2
R = 3
C = 4
G = a.Sa
    ####
    Eb.b
Expected Return Value = -1
Sample test case #3
R = 3
C = 4
G = aS.b
    ####
    Eb.a
Expected Return Value = 4
Sample test case #4
R = 1
C = 9
G = xS..x..Ex
Expected Return Value = 3
Sample Explanation
In the first case, you can reach an exit in 4 seconds by walking left once, then up twice, and then finally right once.
In the second case, you can never reach the exit.
In the third case, you should walk right twice, then teleport to the cell in the 3rd row and 2nd column, and finally walk left once.
In the fourth case, you should walk left once, teleport to the cell in the last column, and walk left once more.
*/
import java.util.*;
public class Portals{

     public static void main(String []args){
        System.out.println("Hello World");
        SolutionForPortals s = new SolutionForPortals();
        //char[][] grid = {{'.','E','.'},{'.','#','E'},{'.','S','#'}};int R = 3, C = 3;// o = 4
        //char[][] grid = {{'a','.','S','a'},{'#','#','#','#'},{'E','b','.','b'}};int R = 3, C = 4;// o = -1
        //char[][] grid = {{'a','S','.','b'},{'#','#','#','#'},{'E','b','.','a'}};int R = 3, C = 4;// o = 4
        //char[][] grid = {{'x','S','.','.','x','.','.','E','x'}};int R = 1, C = 9;// o = 3
        //char[][] grid = {{'x'},{'S'},{'.'},{'.'},{'x'},{'.'},{'.'},{'E'},{'x'}};int R = 9, C = 1;//o = 3
        char[][] grid = {{'.','#','.','E','b','b','.','E'},
                         {'E','.','.','a','.','#','.','#'},
                         {'.','d','.','#','d','a','.','#'},
                         {'.','C','#','b','S','c','.','E'},
                         {'#','E','#','.','b','#','#','.'},
                         {'#','.','d','.','#','.','.','#'}};int R = 6, C = 8; // o = 3
        System.out.println("seconds " + s.findShortestTime(grid, R, C));
     }
     
}
class SolutionForPortals {
    Map<Character, List<NodePortal>> letterNodesMap = new HashMap<>();
    
    public int findShortestTime(char[][] g, int R, int C){
        int[][] board = new int[R][C];
        Queue<NodePortal> nodes = new ArrayDeque<NodePortal>();
        NodePortal start = scanGridAndReturnStart(g, R, C);
        nodes.add(start);
        board[start.x][start.y] = 1;
        boolean exitFound = false;
        int[] xVals = {1, -1, 0, 0};
        int[] yVals = {0, 0, 1, -1};
        int cx = -1, cy = -1, newX = -1, newY = -1, dist = 0;
        while(!exitFound){
            NodePortal currentNode = nodes.poll();
            if(currentNode == null){
                return -1;
            }
            cx = currentNode.x;
            cy = currentNode.y;
            dist = currentNode.dist;
            for(int i=0; i<4; i++){
                newX = cx+xVals[i];
                newY = cy+yVals[i];
                if(newX >=0 && newX <R && newY >=0 && newY <C){
                    if(g[newX][newY] != '#' && board[newX][newY] != 1){
                        if(g[newX][newY] == 'E'){
                            exitFound = true;
                            return dist+1;
                        }else if(g[newX][newY] == '.') {
                            nodes.add(new NodePortal(newX, newY, dist+1));
                            board[newX][newY] = 1;
                        } else {
                            nodes.add(new NodePortal(newX, newY, dist+1));
                            board[newX][newY] = 1;
                            addSameLetterNodes(nodes, g[newX][newY], board, dist+2);
                        }
                    }
                }
            }
        }
        return -1;
    }
    public NodePortal scanGridAndReturnStart(char[][] grid, int R, int C){
        NodePortal start = null;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(grid[i][j] == 'S'){
                    start = new NodePortal(i,j);
                } else if(grid[i][j] != '.' && grid[i][j] != 'E' && grid[i][j] != '#'){
                    List<NodePortal> letterNodes = letterNodesMap.getOrDefault(grid[i][j], new ArrayList<>());
                    letterNodes.add(new NodePortal(i,j));
                    letterNodesMap.put(grid[i][j], letterNodes);
                }
            }
        }
        return start;
    }
    
    public void addSameLetterNodes(Queue<NodePortal> nodes, char letter, int[][] board, int dist){
        List<NodePortal> letterNodes = letterNodesMap.get(letter);
        if(letterNodes != null){
            for(NodePortal node : letterNodes){
                if(board[node.x][node.y] != 1){
                    node.setDistance(dist);
                    nodes.add(node);
                }
            }
        }
    }
    public void sop(String str){
        System.out.println(str);
    }
}

class NodePortal {
    int dist, x, y;

    public NodePortal(int x, int y)    {
        this.x = x;
        this.y = y;
    }
 
    public NodePortal(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
    public boolean isValidNode(){
        return (x>=0) && (x<=3) && (y>=0) && (y<=3);
    }
    public void setDistance(int dist){
        this.dist = dist;
    }
}
