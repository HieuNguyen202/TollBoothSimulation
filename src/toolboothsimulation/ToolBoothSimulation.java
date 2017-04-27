package toolboothsimulation;

import java.util.*;
import java.io.*;
import static toolboothsimulation.TollBoothTest.autoTollBooths;
import static toolboothsimulation.TollBoothTest.manuTollBooths;

public class ToolBoothSimulation {
    public static int numManu;
    public static int numAuto;
    public static TollBooth[] autoTollBooths;
    public static TollBooth[] manuTollBooths;
    public static TollBoothLine overflowVehicles = new TollBoothLine();
    public static TollBoothLine allVehicles = new TollBoothLine();

    public static void main(String[] args) throws FileNotFoundException {
        double clock=0; // Keep time.
        double simulationTime=15000;  //Total time the simulation will run on.
        String fileName = "";
        
        //File name prompt
        boolean continue_flag = false;
        Scanner keyBoard = new Scanner(System.in);
        System.out.print("Please enter the name of the file:");
        while (!continue_flag) {
            fileName = keyBoard.next();
            if (new File(fileName).exists()) {
                continue_flag = true;
            } else {
                System.out.print("Simulation can not find \"" + fileName + "\". Please enter a different file name: ");
            }
        }
        
        //Number of TollBooth prompt
        do {
            System.out.println("");
            System.out.println("Please enter the number of automatic TollBooth and manual TollBooth.");
            System.out.println("Remember! There must be at least one of each type and the total number");
            System.out.println("of tollbooths must be equal to 6 tollbooths.");
            System.out.println("");
            //Number of Auto TollBooth prompt
            continue_flag = false;
            System.out.print("Please enter the number of automatic TollBooth:");
            while (!continue_flag) {
                try {
                    numAuto = keyBoard.nextInt();
                    continue_flag = true;
                } catch (InputMismatchException e) {
                    String garbage = keyBoard.nextLine();
                    System.out.print("Error! Please enter the number of automatic TollBooth again:");
                }
            }

            //Number of Manu TollBooth prompt
            continue_flag = false;
            System.out.print("Please enter the number of manual TollBooth:");
            while (!continue_flag) {
                try {
                    numManu = keyBoard.nextInt();
                    continue_flag = true;
                } catch (InputMismatchException e) {
                    String garbage = keyBoard.nextLine();
                    System.out.print("Error! Please enter the number of manual TollBooth again:");
                }
            }
        } while (!(numAuto>0 && numManu >0 && numAuto + numManu ==6));
        
        //create TollBooth arrays
        autoTollBooths = new TollBooth[numAuto];
        manuTollBooths = new TollBooth[numManu];
        for (int i = 0; i < numAuto; i++) {
            autoTollBooths[i]=new TollBooth();
        }
        for (int i = 0; i < numManu; i++) {
            manuTollBooths[i]=new TollBooth();
        }
        
        //Input from file
        System.out.println("");
        System.out.println("Simulation is in progress!");
        System.out.println("");
        Scanner fileScanner = new Scanner(new File(fileName));
        while (fileScanner.hasNext()) {
            StringTokenizer elements = new StringTokenizer(fileScanner.nextLine(), ",");
            double arrivalTime = Double.parseDouble(elements.nextToken());
            String type = elements.nextToken();
            if (type.toLowerCase().equals("m")) {
                int numWheel = Integer.parseInt(elements.nextToken());
                allVehicles.addLast(new ManuVehicle(arrivalTime, numWheel));
            } else {
                allVehicles.addLast(new AutoVehicle(arrivalTime));
            }
        }
        System.out.println(allVehicles); //Uncomment this to see all vehicles in allVehicles.

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
                    arrive(autoTollBooths,allVehicles.getFirst());
                }
                else{//Assuming there are only two types of vehicles.
                    arrive(manuTollBooths,allVehicles.getFirst());
                }
                allVehicles.removeFirst();
            }
            
            //cars leave
            leave(autoTollBooths,clock);
            leave(manuTollBooths,clock);
            
            //System.out.println("Clock: "+ clock);
            for (int i = 0; i < autoTollBooths.length; i++) {
                //System.out.println("Auto "+ (i+1) +" "+autoTollBooths[i]);
            }
            for (int i = 0; i < manuTollBooths.length; i++) {
                //System.out.println("Manu "+ (i+1) +" "+manuTollBooths[i]);
            }
            clock++;
        }
        
        System.out.println("Simulation complete!");
        System.out.println("");
        System.out.println("Results:");
        System.out.println("");
        //Output statistic
        double sumOfManuAverages=0;
        double sumOfAutoAverages=0;
        double maxManuWait=0;
        double maxAutoWait=0;

        //Max Length manual
        for (int i = 0; i < manuTollBooths.length; i++) {
            System.out.println("Manual Line #"+(i+1)+" Maximum Length=" + manuTollBooths[i].getMaxLength());//Max length
            sumOfManuAverages+=manuTollBooths[i].getAverageWait(); //sumOfManuAverages
            if (maxManuWait<manuTollBooths[i].getMaxWait()) {
                maxManuWait=manuTollBooths[i].getMaxWait(); //maxManuWait
            }
        }
        
        //Max Length Automatic
        for (int i = 0; i < autoTollBooths.length; i++) {
            System.out.println("Automatic Line #"+(i+1)+" Maximum Length=" + autoTollBooths[i].getMaxLength()); //Max length
            sumOfAutoAverages+=autoTollBooths[i].getAverageWait(); //sumOfAutoAverages
            if (maxAutoWait<autoTollBooths[i].getMaxWait()) {
                maxAutoWait=autoTollBooths[i].getMaxWait(); //maxAutoWait
            }
        }
        //Wait data
        System.out.println("Max Manual Wait: " + maxManuWait);
        System.out.println("Max Auto Wait: " + maxAutoWait);
                
        if (numManu>0)
            System.out.println("Avg Manual Wait: " + sumOfManuAverages/numManu);
        if (numAuto>0)
            System.out.println("Avg Auto Wait: " + sumOfAutoAverages/numAuto);

        System.out.println("Number of overflown vehicles: "+overflowVehicles.length());
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
