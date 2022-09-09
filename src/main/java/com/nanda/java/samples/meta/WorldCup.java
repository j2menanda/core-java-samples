package com.nanda.java.samples.meta;
import java.util.List;
import java.util.ArrayList;
public class WorldCup{

    public static void main(String []args){
        System.out.println("Hello World");
        CricketWorldCup year2021 = new CricketWorldCup();
        year2021.prepareContinentsList();
        long n = 10;
        List<String> team = year2021.getWorldCupTeam(n);
        for(int i = 0; i < team.size(); i++){
            System.out.println(team.get(i));
        }
    }
    
}

class CricketWorldCup {
    
    List<String> countriesInAsia = new ArrayList<>();
    List<String> countriesInEurope = new ArrayList<>();
    List<String> countriesInAfrica = new ArrayList<>();
    
    public void prepareContinentsList(){
        for(int i = 0; i < 20; i++){
            countriesInAsia.add("Asia" + i);
        }
        for(int i = 0; i < 20; i++){
            countriesInEurope.add("Europe" + i);
        }
        for(int i = 0; i < 20; i++){
            countriesInAfrica.add("Africa" + i);
        }
    }
    
    public List<String> getWorldCupTeam(long num){
        List<String> team = new ArrayList<>();
        int asiaCounter = 0;
        int europeCounter = 0;
        int africaCounter = 0;
        for(int i = 0; i < num; i++){
            if(i%3 == 0){
                team.add(countriesInAsia.get(asiaCounter));
                asiaCounter +=1;
            }
            if(i%3 == 1){
                team.add(countriesInEurope.get(europeCounter));
                europeCounter +=1;
            }
            if(i%3 == 2){
                team.add(countriesInAfrica.get(africaCounter));
                africaCounter +=1;
            }
        }
        return team;
    }

}