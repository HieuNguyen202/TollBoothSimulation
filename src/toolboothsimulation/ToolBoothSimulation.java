package toolboothsimulation;

import java.util.*;
import java.io.*;

public class ToolBoothSimulation {

    public static void main(String[] args) throws FileNotFoundException {

        TollBoothLine allVehicle = new TollBoothLine();
        String filePath = "rushhour.txt";
        Scanner scan = new Scanner(new File(filePath));
        while (scan.hasNext()) {
            StringTokenizer elements = new StringTokenizer(scan.nextLine(), ",");
            Double arrivalTime = Double.parseDouble(elements.nextToken());
            String type = elements.nextToken();
            if (type.toLowerCase().equals("m")) {
                int numWheel = Integer.parseInt(elements.nextToken());
                allVehicle.addLast(new ManuVehicle(arrivalTime, numWheel));
            } else {
                allVehicle.addLast(new AutoVehicle(arrivalTime));
            }
            System.out.println(allVehicle);
        }
    }   
}
