package toolboothsimulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TollBooth {

    private TollBoothLine line;
    private char type;
    private DoneVehicles doneLine;
    private int maxLength;
    private double timeUntilAvailable = 0.0;

    public TollBooth() {
        line = new TollBoothLine();
        doneLine = new DoneVehicles();
        maxLength = 0;
    }
    public char getType()
    {
        return type;
    }
    public void setType(char type)
    {
        if (type=='A'||type=='M') {
            this.type=type;
        }
    }
    
    //WhatItDoes: Reduce timeUntilAvailable by one.   
    public void tick() {
        timeUntilAvailable--; //it's ok to be negative
    }

    //INPUT: time - delay time after a vehicle is serviced (1 for automatic and numWheel*1 for manual)
    public void setTimeUntilAvailable(double time) {
        if (time >= 0) {
            timeUntilAvailable = time;
        }
    }

    public double getTimeUntilAvailable() {
        return timeUntilAvailable;
    }

    //OUTPUT: return true if the next car can be processed.
    //            return false if the next car still needs to wait for his fellow in front of him to get out of the TollBooth.
    public boolean isAvailable()
    {
        tick();//decrement timeUntilAvailable before compare 
        return timeUntilAvailable <= 0.0;
    }

    //OUTPUT: Length of the line waiting for service
    public int length() {
        return line.length();
    }
    
    //OUTPUT: Length of the serviced line.
    public int lengthDone() {
        return doneLine.length();
    }

    //INPUT: vehicle - a Vehicle to be added to the line.
    public void arrive(Vehicle vehicle) {
        if (vehicle != null) {
            line.add(vehicle);
            updateMaxLength();
        }
    }

    //INPUT: clock - time to set to the leave time of the first vehicle in the line.
    public void leave(double clock) {//Fix update max length? //data verification
        if (length() > 0 && clock > line.getFirst().getArivalTime()) { //Conditions: has at least one vehicle in the line and clock is larger than arrival time
            line.getFirst().setLeaveTime(clock);
            setTimeUntilAvailable(line.getFirst().getDelayTime());//set delay time untill the TollBooth will process the next car
            line.transferTo(doneLine); //The first car of wating line -> last position of the serviced line.
        }
    }

    public int getMaxLength() {
        return maxLength;
    }

    private void updateMaxLength() {
        if (length() > maxLength) {
            maxLength = length();
        }
    }

    public double getMaxWait() {
        return doneLine.getMaxWait();
    }

    public double getAverageWait() {
        return doneLine.getAverageWait();
    }

    public String toString() {
        return "Toll Booth currently has " + length() + " vehicles in its line and serviced " + lengthDone() + " vehicles.";
    }
}
