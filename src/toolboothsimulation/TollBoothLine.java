package toolboothsimulation;

import java.util.LinkedList;
import java.util.*;

public class TollBoothLine {
    private LinkedList<Vehicle> line; 
    private final int MAX_LENGTH_LIMIT=25;
    public TollBoothLine()
    {
        line= new LinkedList();
    }
    public int getLength()
    {
        return line.toArray().length;
    }
    public void add(Vehicle car) {
        line.addLast(car);
    }
    public void remove() {
        line.removeFirst();
    }
    public void transferTo(TollBoothLine otherBoothLine) {//move the first element of this line to the other line at the last position
        otherBoothLine.add(this.line.getFirst());
        this.remove();
    }
    public Vehicle getFirstVehicle() {
        return line.getFirst();
    }
    public LinkedList getLine() {
        return new LinkedList(line);
    }
    public String toString() {
        return "";
    }
    
}
