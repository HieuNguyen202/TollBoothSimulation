package toolboothsimulation;

import java.util.*;
import java.io.*;

public class ToolBoothSimulation {
    public static int numManu=1;
    public static int numAuto=5;
    public static TollBooth[] aTollBooths = new TollBooth[numAuto];
    public static TollBooth[] mTollBooths = new TollBooth[numManu];
    public static TollBoothLine overflowVehicles = new TollBoothLine();
    public static TollBoothLine allVehicles = new TollBoothLine();
    
    public static void main(String[] args) throws FileNotFoundException {
        double clock=0; // Keep time.
        double simulationTime=12000;  //Total time the simulation will run on.
        
        //create TollBooth arrays
        for (int i = 0; i < numAuto; i++) {
            aTollBooths[i]=new TollBooth();
        }
        for (int i = 0; i < numManu; i++) {
            mTollBooths[i]=new TollBooth();
        }
        
        //Input from file
        String filePath = "nonrushhour.txt";
        Scanner scan = new Scanner(new File(filePath));
        while (scan.hasNext()) {
            StringTokenizer elements = new StringTokenizer(scan.nextLine(), ",");
            double arrivalTime = Double.parseDouble(elements.nextToken());
            String type = elements.nextToken();
            if (type.toLowerCase().equals("m")) {
                int numWheel = Integer.parseInt(elements.nextToken());
                allVehicles.addLast(new ManuVehicle(arrivalTime, numWheel));
            } else {
                allVehicles.addLast(new AutoVehicle(arrivalTime));
            }
        }
        //System.out.println(allVehicles); //Uncomment this to see all vehicles in allVehicles.
  
        //Time loop
        while(clock <=simulationTime)
        {
            //cars arrive
                //while arrive time of the next car is equal to clock
                    // find shorstestTollBooth
                    // if shorstestTollBooth is null
                    //      car -> overflowVehicles
                    // else
                    //      car -> shorstestTollBooth
                    // remove a car from allVehicles
            //cars leave
                //for each TollBooth
                //    if the TollBooth is available (delay time of the previous car is over).
                //          1. set leave time of the first car in line to clock
                //          2. set timeUntilAvailable of the current TollBooth to delay time of the car being processed.
                //          3. transfer the current car from the TollBooth line to DoneVehicle line.
            
            //cars arrive
            while (allVehicles.length()>0 && allVehicles.getFirst().getArivalTime()==clock)// two or more cars can arrive at the same time
            {
                if (allVehicles.getFirst() instanceof AutoVehicle) {   
                    arrive(aTollBooths,allVehicles.getFirst());
                }
                else{//Assuming there are only two types of vehicles.
                    arrive(mTollBooths,allVehicles.getFirst());
                }
                allVehicles.removeFirst();
            }
            
            //cars leave
            leave(aTollBooths,clock);
            leave(mTollBooths,clock);
            clock++;
        }
        
        //Output statistic
        double sumOfManuAverages=0;
        double sumOfAutoAverages=0;
        double maxManuWait=0;
        double maxAutoWait=0;

        for (int i = 0; i < aTollBooths.length; i++) {
            System.out.println("Auto "+i+" maxLength " + i + ": " + aTollBooths[i].getMaxLength()); //Max length
            sumOfAutoAverages+=aTollBooths[i].getAverageWait(); //sumOfAutoAverages
            if (maxAutoWait<aTollBooths[i].getMaxWait()) {
                maxAutoWait=aTollBooths[i].getMaxWait(); //maxAutoWait
            }
        }
        
        for (int i = 0; i < mTollBooths.length; i++) {
            System.out.println("Manu "+i+" maxLength " + i + ": " + mTollBooths[i].getMaxLength());//Max length
            sumOfManuAverages+=mTollBooths[i].getAverageWait(); //sumOfManuAverages
            if (maxManuWait<mTollBooths[i].getMaxWait()) {
                maxManuWait=mTollBooths[i].getMaxWait(); //maxManuWait
            }
        }
        
        if (numAuto>0)
            System.out.println("Auto average wait time: " + sumOfAutoAverages/numAuto);
        if (numManu>0)
            System.out.println("Manu average wait time: " + sumOfManuAverages/numManu);
        
        System.out.println("Auto max wait time: " + maxAutoWait);
        System.out.println("Manu max wait time: " + maxManuWait);
        System.out.println("Number of overflow vehicles: "+overflowVehicles.length());
    }
    
    //INPUT: tollBooths - An array of TollBooth
    //OUTPUT: The reference to the shorstest TollBooth in the array
    //        Null if all TollBooth in the array have reached their capacity (25 cars)              
    public static TollBooth getShortestTollBooth(TollBooth[] tollBooths) {
        TollBooth shortestTollBooth = null;
        int shortestTollBoothIndex = 0;
        for (int i = 0; i < tollBooths.length; i++) {//find the shorstest TollBooth index
            if (tollBooths[i].length() < tollBooths[shortestTollBoothIndex].length()) {
                shortestTollBoothIndex = i;
            }
        }
        //if the shorstest TollBooth is greater than 25 (overflow)
        //then return shorstTestTollBooth as null
        //otherwise return the reference of the shortestTollBooth
        if (tollBooths[shortestTollBoothIndex].length() < 25) {
            shortestTollBooth = tollBooths[shortestTollBoothIndex];
        }
        return shortestTollBooth;
    }
    //INPUT: tollBooths - An array of TollBooth whose first cars need to be process.
    //       clock - leaving time of the first cars in the lines.
    public static void leave(TollBooth[] tollBooths, double clock) {
        for (int i = 0; i < tollBooths.length; i++) {
            leave(tollBooths[i], clock);
        }
    }
    //INPUT: tollBooth - A TollBooth whose first car need to be process.
    //       clock - leaving time of the first car of the TollBooth line.
    public static void leave(TollBooth tollBooth, double clock) {
        //Conditions: 1. Tollbooth has at least one car
        //            2. Delay time of the previous car is over.
        if (tollBooth.length() > 0 && tollBooth.isAvailable()) {
                tollBooth.leave(clock);
                // Three things are done when tollBooth.leave(clock) is called:
                //  1. set leave time of the first car in line to clock
                //  2. set timeUntilAvailable of the current TollBooth to delay time of the car being processed.
                //  3. transfer the current car from the TollBooth line to DoneVehicle line.
        }
    }
    //INPUT: tollBooth - An array of all manual TollBooths/automatic TollBooths
    //       vehicle - Reference to the car to be added to the TollBooths
    //WhatItDoes:
    //      If all ToolBooth are full (25 vehicles in the lines), add the vehicle to overflowVehicles line.
    //      Otherwise, add the vehicle to the shorstest TollBooth.
    public static void arrive(TollBooth[] tollBooths, Vehicle vehicle) {
        TollBooth shortestTollBooth = getShortestTollBooth(tollBooths);
        if (shortestTollBooth==null) {//overflow
            overflowVehicles.addLast(vehicle); //transfer current vehicle to the overflow line.
        }
        else//has a available spot
        {
            shortestTollBooth.arrive(vehicle);
        }
    }
}
