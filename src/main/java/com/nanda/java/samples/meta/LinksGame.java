package com.nanda.java.samples.meta;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
public class LinksGame{

     public static void main(String []args){
        System.out.println("Welcome to Links game");
        Links game = new Links(5,10);//first param is min num of links, second is max num of links
        game.prepareChain();
        System.out.println("number of Links is " + game.getLength());
        System.out.println("Links are ");
        game.printLinks();
        System.out.println("\nGame starts");
        Player playerA = new Player();
        Player playerB = new Player();
        int playerToPick = 1;
        for(int i = 0; i<game.getLength(); i++) {
          boolean leftOrRight = game.getLeftOrRight();//get true for left, false for right
          if(playerToPick == 1) {
            playerA.addLinkValue(game.getLinkForPlayer(leftOrRight));
            playerToPick = 2;
          } else {
            playerB.addLinkValue(game.getLinkForPlayer(leftOrRight));
            playerToPick = 1;
          }
        }
        System.out.println("player A sum is " + playerA.getPlayerSum());
        System.out.println("player B sum is " + playerB.getPlayerSum());
     }
}

  class Links {
    int lengthOfChain;
    int leftIndex;
    int rightIndex;
    List links;
    
    public Links(int minLinks, int maxLinks) {
      lengthOfChain = getRandomNumber(minLinks, maxLinks);
      leftIndex = 0;
      rightIndex = lengthOfChain - 1;
      links = new ArrayList<Integer>(lengthOfChain);
    }

    public void prepareChain() {
      for(int i = 0; i < lengthOfChain; i++) {
        links.add(getRandomNumber(-100, 100));
      }
    }
    
    public boolean getLeftOrRight() {
   	  Random rd = new Random();
   	  return rd.nextBoolean();
    }
    
    public Integer getRandomNumber(int min, int max) {
      int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
      return new Integer(randomNum);
    }
    
    public void incrementLeftIndex() {
      leftIndex += 1;
    }

    public void decrementRightIndex() {
      rightIndex -= 1;
    }
    
    public int getLinkForPlayer(boolean leftOrRight) {
      Integer value = 0;
      if(leftOrRight) {
        value = (Integer)links.get(leftIndex);
        incrementLeftIndex();
      } else {
        value = (Integer)links.get(leftIndex);
        incrementLeftIndex();
      }
      return value;
    }
    
    public int getLength(){
      return lengthOfChain;
    }
    
    public void printLinks(){
      for(int i = 0; i < lengthOfChain; i++){
        System.out.print(" " + links.get(i));
      }
    }
  }
  
  class Player {
    int sum;
    boolean leftOrRight;
    
    public Player() {
      sum = 0;
    }
    
    public void addLinkValue(Integer link) {
      sum+= link.intValue();
    }
    
    public int getPlayerSum() {
      return sum;
    }
  }
