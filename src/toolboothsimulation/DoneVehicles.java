package toolboothsimulation;

import java.util.LinkedList;
import java.util.ListIterator;

public class DoneVehicles extends TollBoothLine {
//OUTPUT: Max wait time of all vehicles in this list.
    public double getMaxWait() {
        double maxWait = 0;
        ListIterator<Vehicle> iterator = listIterator();
        while (iterator.hasNext()) {
            Vehicle next = iterator.next();
            if (maxWait < next.getWaitTime()) {
                maxWait = next.getWaitTime();
            }
        }
        return maxWait;
    }
//OUTPUT: Average wait time of all vehicles in this list.
    public double getAverageWait() {
        double total = 0;
        int count = 0;
        ListIterator<Vehicle> iterator = listIterator();
        while (iterator.hasNext()) {
            Vehicle next = iterator.next();
            total += next.getWaitTime();
            count++;
        }
        if (count > 0) return total / count;
        else return 0;
    }
}