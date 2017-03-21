package toolboothsimulation;
public class VehicleTest {
    public static void main(String[] args) {
        System.out.println("Car1:");
        AutoVehicle car1=new AutoVehicle(1);
        System.out.println(car1);
        car1.setArivalTime(2);
        System.out.println(car1);
        car1.setLeaveTime(4);
        System.out.println(car1);
        System.out.println("Wait time: "+car1.getWaitTime());
        
        System.out.println("");
        System.out.println("Car 2");
        ManuVehicle car2=new ManuVehicle(2,4);
        System.out.println(car2);
        car2.setArivalTime(2);
        System.out.println(car2);
        car2.setLeaveTime(4);
        System.out.println(car2);
        System.out.println("Wait time: "+car2.getWaitTime());
        car2.setNumWheel(6);
        System.out.println(car2);
        System.out.println("Wait time: "+car2.getWaitTime());
    }
}
