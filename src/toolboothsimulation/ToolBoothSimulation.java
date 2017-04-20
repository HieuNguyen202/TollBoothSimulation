package toolboothsimulation;

import java.util.*;
import java.io.*;

public class ToolBoothSimulation {
    public static TollBooth[] aTollBooth = new TollBooth[3];
    public static TollBooth[] mTollBooth = new TollBooth[3];
    public static TollBoothLine overflowVehicle = new TollBoothLine();
    public static TollBoothLine allVehicle = new TollBoothLine();
    public static void main(String[] args) throws FileNotFoundException {
        double clock=0;
        double simulationTime=2000;
        //create tollbooths

        for (int i = 0; i < 3; i++) {
            aTollBooth[i]=new TollBooth();
        }
        for (int i = 0; i < 3; i++) {
            mTollBooth[i]=new TollBooth();
        }
        String filePath = "rushhour.txt";
        Scanner scan = new Scanner(new File(filePath));
        //Input from file
        while (scan.hasNext()) {
            StringTokenizer elements = new StringTokenizer(scan.nextLine(), ",");
            Double arrivalTime = Double.parseDouble(elements.nextToken());
            String type = elements.nextToken();
            if (type.toLowerCase().equals("m")) {
                int numWheel = Integer.parseInt(elements.nextToken());
                allVehicle.addLast(new ManuVehicle(arrivalTime, numWheel));
            } else {
                allVehicle.addLast(new AutoVehicle(arrivalTime));
            }
        }
        //Time loop
        while(clock <=simulationTime)
        {
            //cars arrive
           
                // find shorstest tollbooth
                // if null, stick the next car to the overflow line
                // if a index/reference of a tollbooth is returned.
                    //stick the next car to that tollbooth
                //remove the car after
                        //cars leave
                //for each tollbotth
                    //check if the tollbooth is available
                        //if not, decrement timeUntilAvailable of the tollbooth
                        //if it is, process the next car
                            //set clock -> car's leaveTime
                            //transfer the car to doneVehicle
            while (allVehicle.length()>0 && allVehicle.getFirst().getArivalTime()==clock)// two or more cars can arrive at the same time
            {
                if (allVehicle.getFirst() instanceof AutoVehicle) {   
                    arrive(aTollBooth,allVehicle.getFirst(),clock);
                }
                else if (allVehicle.getFirst() instanceof ManuVehicle) {
                    arrive(mTollBooth,allVehicle.getFirst(),clock);
                }
                allVehicle.removeFirst();
            }
            leave(aTollBooth,clock);
            leave(mTollBooth,clock);
            clock++;
        }
        //Output statistic
        for (int i = 0; i < aTollBooth.length; i++) {
            System.out.println("Average wait time " + i + ": " + aTollBooth[i].getAverageWait());
            System.out.println("Max wait time " + i + ": " + aTollBooth[i].getMaxWait());
        }
        for (int i = 0; i < mTollBooth.length; i++) {
            System.out.println("Average wait time " + i + ": " + mTollBooth[i].getAverageWait());
            System.out.println("Max wait time " + i + ": " + mTollBooth[i].getMaxWait());
        }
    }

    public static TollBooth getShortestTollBooth(TollBooth[] tollBooths) {
        TollBooth shorstTestTollBooth = null;
        int shorstTestTollBoothIndex = 0;
        //find the shorstest index
        for (int i = 0; i < tollBooths.length; i++) {
            if (tollBooths[i].length() < tollBooths[shorstTestTollBoothIndex].length()) {
                shorstTestTollBoothIndex = i;
            }
        }
        //if the shorstest line is greater than 25, overflow, return shorstTestTollBooth as null; otherwise return the shorstTestTollBooth
        if (tollBooths[shorstTestTollBoothIndex].length() < 25) {
            shorstTestTollBooth = tollBooths[shorstTestTollBoothIndex];
        }
        return shorstTestTollBooth;
    }
    public static void leave(TollBooth[] tollBooths, double clock) {
        for (int i = 0; i < tollBooths.length; i++) {
            leave(tollBooths[i], clock);
        }
    }
    public static void leave(TollBooth tollBooth, double clock) {
        if (tollBooth.length()>0 && tollBooth.isAvailable()) {
            tollBooth.leave(clock);
        } else {
            tollBooth.tick();
        }
    }
    public static void arrive(TollBooth[] tollBooths, Vehicle vehicle, double clock) {
        TollBooth shorstestAutoTollBooth = getShortestTollBooth(tollBooths);
        if (shorstestAutoTollBooth==null) {//overflow
            overflowVehicle.addLast(vehicle); //transfer currentAutoVehicle to the overflow line
        }
        else//has a available spot
        {
            shorstestAutoTollBooth.arrive(vehicle);
        }
    }
}
