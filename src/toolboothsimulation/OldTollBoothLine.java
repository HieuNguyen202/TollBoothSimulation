package toolboothsimulation;

import java.util.LinkedList;
import java.util.*;

public class OldTollBoothLine extends LinkedList<Vehicle> {
    //private LinkedList<Vehicle> line; 
    //private final int MAX_LENGTH_LIMIT=25;


    public int length()
    {
        return this.toArray().length;
    }
    public void transferTo(TollBoothLine otherBoothLine) {//move the first element of this line to the other line at the last position
        otherBoothLine.addLast(this.getFirst());
        this.removeFirst();
    }
    //public Vehicle getFirstVehicle() {
    //    return line.getFirst();
    //}
    //public LinkedList getLine() {
    //    return new LinkedList(line);
    //}
    //public String toString() {
    //    return "";
    //}
    //public void add(Vehicle car) {
    //    line.addLast(car);
    //}
    //public void remove() {
    //    line.removeFirst();
    //}
    //public TollBoothLine()
   // {
    //}

}
