package toolboothsimulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class TollBooth {
    private TollBoothLine line;
    private DoneVehicles doneLine;
    private int maxLength;
    public TollBooth()
    {
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
    public String toString() {
        return "Toll Booth currently has "+length()+"vehicles in line and served "+doneLine.length()+" vehicles.";
    }  
}
