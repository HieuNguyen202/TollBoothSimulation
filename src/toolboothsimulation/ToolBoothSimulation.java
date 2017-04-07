package toolboothsimulation;
public class ToolBoothSimulation {
    public static void main(String[] args) {
        TollBoothLine line1=new TollBoothLine();
        TollBoothLine line2=new TollBoothLine();
         
        AutoVehicle car1=new AutoVehicle(1);
        car1.setArivalTime(2);
        car1.setLeaveTime(4);
        
        AutoVehicle car2=new AutoVehicle(1);
        car2.setArivalTime(3);
        car2.setLeaveTime(6);
        
        AutoVehicle car3=new AutoVehicle(1);
        car3.setArivalTime(10);
        car3.setLeaveTime(15);
        
        ManuVehicle car4=new ManuVehicle(1,4);
        car4.setArivalTime(16);
        car4.setLeaveTime(20);
                           
        line1.addLast(car1);
        line1.addLast(car2);
        line1.addLast(car3);
        line1.addLast(car4);
        
        System.out.println(line1);
    }
}
