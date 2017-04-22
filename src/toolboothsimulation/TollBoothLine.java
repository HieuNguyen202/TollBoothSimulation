package toolboothsimulation;

import java.util.LinkedList;
import java.util.*;
// This class is a child class of LinkedList class:
// Reference: https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html
public class TollBoothLine extends LinkedList<Vehicle> {
    public int length()
    {
        return this.toArray().length;
    }
    //INPUT: that - the TollBoothLine to which the first vehicle of this TollBoothLine is transfered to.
    //Notes: The car will be removed from this TollBoothLine.
    public void transferTo(TollBoothLine that) {
        if (this.length()>0) {
            that.addLast(this.getFirst());
            this.removeFirst();
        }
    }
    //OUTOUT: A String contains info of all vehicles in this TollBoothLine.
    public String toString()
    {
        String output="";
        ListIterator<Vehicle> iterator = listIterator();
        while (iterator.hasNext()) {
            Vehicle next = iterator.next();
            output+=next.toString()+"\n";
        }
        return output;
    }
}
