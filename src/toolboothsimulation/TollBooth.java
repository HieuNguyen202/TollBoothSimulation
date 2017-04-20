package toolboothsimulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TollBooth {
    private TollBoothLine line;
    private DoneVehicles doneLine;
    private int maxLength;
    private static double timeUntilAvailable;
    public static void tick()//one second has passed
    {
        timeUntilAvailable--; //it's ok to be negative
    }
    public static void setTimeUntilAvailable(double time) //set the delay time after a vehicle is serviced (1 for automatic and numWheel*1 for manual)
    {
        if (time>=0) {
            timeUntilAvailable=time;
        }
    }
    public static boolean isAvailable() //see is there is another car still in the tollbooth
    {
        return timeUntilAvailable==0;
    }
    public TollBooth(){
        line=new TollBoothLine();
        doneLine=new DoneVehicles();
        maxLength=0;
    }
    public int length() {
        return line.length();
    }
    public void arrive(Vehicle car) {
        line.add(car);
        updateMaxLength();
    }
    public void leave(double leaveTime) {
        line.getFirst().setLeaveTime(leaveTime);
        line.transferTo(doneLine);
    }
    public int getMaxLength() {
        return maxLength;
    }
    private void updateMaxLength() {
        if (length()>maxLength) {
            maxLength=length(); 
        }
    }
    public double getMaxWait(){
    return doneLine.getMaxWait();
    }
    public double getAverageWait(){
    return doneLine.getAverageWait();
    }
    public String toString() {
        return "Toll Booth currently has "+length()+" vehicles in its line and served "+doneLine.length()+" vehicles.";
    }
}
