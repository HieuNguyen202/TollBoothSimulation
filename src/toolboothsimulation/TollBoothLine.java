package toolboothsimulation;

import java.util.LinkedList;
import java.util.*;

public class TollBoothLine extends LinkedList<Vehicle> {
    public int length()
    {
        return this.toArray().length;
    }
    public void transferTo(TollBoothLine otherBoothLine) {//move the first element of this line to the other line at the last position
        otherBoothLine.addLast(this.getFirst());
        this.removeFirst();
    }
}
