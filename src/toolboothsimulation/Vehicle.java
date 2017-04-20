package toolboothsimulation;
 abstract class Vehicle {
     private double arivalTime;
     private double leaveTime;
     public Vehicle(double arivalTime)
     {
         setArivalTime(arivalTime);
     }
     public Vehicle(){}
     public double getArivalTime() {return arivalTime;}
     public double getLeaveTime() {return leaveTime;}
     public double getWaitTime(){return leaveTime-arivalTime;}
     public void setArivalTime(double arivalTime) {
         if (arivalTime >= 0) {
             this.arivalTime = arivalTime;
         }
     }
     public void setLeaveTime(double leaveTime) {
         if (leaveTime >= 0) {
             this.leaveTime = leaveTime;
         }
     }
     public String toString() {return "Arival Time: "+getArivalTime()+" Leave Time: "+getLeaveTime();}
     public abstract double getDelayTime();
}
