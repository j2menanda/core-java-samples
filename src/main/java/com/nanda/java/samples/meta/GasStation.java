package com.nanda.java.samples.meta;
class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0;
        boolean canCompleteCircuit = false;
        for(int i = 0; i < gas.length; i++){
            boolean status = checkStartingFromStationI(i, gas, cost);
            if(status){
                System.out.println("Station " + i);
                index = i;
                canCompleteCircuit = true;
                break;
            }
        }
        if(canCompleteCircuit){
            return index;
        } else {
            return -1;
        }
    }
    
    public boolean checkStartingFromStationI(int startingStation, int[] gas, int[] cost){
        boolean loopCompleted = false;
        int currentStation = startingStation;
        int gasInCar = gas[currentStation];
        while(gasInCar >= cost[currentStation]){
            gasInCar -= cost[currentStation];
            currentStation = getNextStation(currentStation, gas.length);
            loopCompleted = startingStation == currentStation;
            if(loopCompleted) {
                break;
            }
            gasInCar += gas[currentStation];
        }
        return loopCompleted;
    }
    
    private int getNextStation(int index, int length){
        if(index < length-1) {
            index++;
        } else{
            index = 0;
        }
        return index;
    }
}