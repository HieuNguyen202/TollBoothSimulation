package toolboothsimulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class TollBooth {
    private TollBoothLine line;
    private DoneVihicles doneLine;
    private int maxLength;
    public TollBooth()
    {
        line=new TollBoothLine();
        doneLine=new DoneVihicles();
        maxLength=0;
    }
    public int getLength() {
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
        if (getLength()>maxLength) {
            maxLength=getLength(); 
        }
    }
    public String toString() {
        return "Toll Booth currently has "+getLength()+"vehicles in line and served "+doneLine.length()+" vehicles.";
    }  
}
