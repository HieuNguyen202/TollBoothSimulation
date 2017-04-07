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
        car4.setArivalTime(15);
        car4.setLeaveTime(20);
                           
        line1.addLast(car1);
        line1.addLast(car2);
        
        line2.addLast(car3);
        line2.addLast(car4);
        
        System.out.println("List 1:");
        System.out.println(line1);
        System.out.println("List 2");
        System.out.println(line2);
        
        line1.transferTo(line2);
        
        System.out.println("List 1");
        System.out.println(line1);
        System.out.println("List 2");
        System.out.println(line2);
    }
}
