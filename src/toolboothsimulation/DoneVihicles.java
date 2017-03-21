package toolboothsimulation;

import java.util.LinkedList;

public class DoneVihicles extends TollBoothLine {
    public double getMaxWait() {
        double maxWait = 0;
        LinkedList<Vehicle> vehicles = getLine();
        for (Vehicle vehicle : vehicles) {
            if (maxWait < vehicle.getWaitTime()) {
                maxWait = vehicle.getWaitTime();
            }
        }
        return maxWait;
    }
    public double getAverageWait() {
        double total = 0;
        int count = 0;
        LinkedList<Vehicle> vehicles = getLine();
        for (Vehicle vehicle : vehicles) {
            total += vehicle.getWaitTime();
            count++;
        }
        if (count > 0) {
            return total / count;
        } else {
            return 0;
        }

    }

}
