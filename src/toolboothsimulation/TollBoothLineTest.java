/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolboothsimulation;

/**
 *
 * @author edwar
 */
public class TollBoothLineTest {
    public static void main(String[] args) {
        //create 2 TollBoothLine2
        TollBoothLine line1=new TollBoothLine();
        TollBoothLine line2=new TollBoothLine();
         
        //create 4 cars (3 auto and 1 manu)and set their leave and arrival time.
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
        car4.setArivalTime(15);
        car4.setLeaveTime(20);
        
        //add car1 and car 2 to line1        
        line1.addLast(car1);
        line1.addLast(car2);
        
        //add car 3 and car 4 to line1        
        line2.addLast(car3);
        line2.addLast(car4);
        
        //ouput all cars in each line
        System.out.println("List 1 has " + line1.length()+" cars:");
        System.out.println(line1);
        System.out.println("List 2 has " + line2.length()+" cars:");
        System.out.println(line2);
        
        //transferTo of TollBoothLine uses removeFirst and addLast of its parent (LinkedList)
        line1.transferTo(line2);
        
        System.out.println("List 1 has " + line1.length()+" cars:");
        System.out.println(line1);
        System.out.println("List 2 has " + line2.length()+" cars:");
        System.out.println(line2);
    }
}
