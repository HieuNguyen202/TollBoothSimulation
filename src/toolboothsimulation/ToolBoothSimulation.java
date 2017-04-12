package toolboothsimulation;
public class ToolBoothSimulation {
    public static void main(String[] args) {
        TollBooth[] autoTollBooths = new TollBooth[4];
        TollBooth[] manuTollBooths = new TollBooth[2];

        AutoVehicle[] autoCars = new AutoVehicle[100];
        ManuVehicle[] manuCars = new ManuVehicle[100];
        
        //create 4 auto tollbooth
        for (int i = 0; i < 4; i++) {
            autoTollBooths[i]=new TollBooth();
        }
        
        //create 2 manu tollbooth
        for (int i = 0; i < 2; i++) {
            manuTollBooths[i]=new TollBooth();
        }
        
        //create 100 auto cars
        for (int i = 0; i < 100; i++) {
            autoCars[i]=new AutoVehicle(i);        
        }
        
        //create 100 manu cars
        for (int i = 0; i < 100; i++) {
            manuCars[i]=new ManuVehicle(i,4);        
        }
        
        //add 10 auto vehicles to the first auto tollbooth
        for (int i = 0; i < 10; i++) {
            autoTollBooths[0].arrive(autoCars[i]);
        }
        System.out.println(autoTollBooths[0]);
        System.out.println("Max length: "+autoTollBooths[0].getMaxLength());
        
        //5 cars leave
        for (int i = 10; i < 15; i++) {
            autoTollBooths[0].leave(i);
        }
        System.out.println(autoTollBooths[0]);  
        System.out.println("Max length: "+autoTollBooths[0].getMaxLength());
        
        //add 10 auto vehicles to the first auto tollbooth
        for (int i = 15; i < 25; i++) {
            autoTollBooths[0].arrive(autoCars[i]);
        }
        System.out.println(autoTollBooths[0]);
        System.out.println("Max length: "+autoTollBooths[0].getMaxLength());
        
        //15 cars leave
        for (int i = 25; i < 40; i++) {
            autoTollBooths[0].leave(i);
        }
        System.out.println(autoTollBooths[0]);  
        System.out.println("Max length: "+autoTollBooths[0].getMaxLength());
        
        System.out.println("Max Wait: "+autoTollBooths[0].getMaxWait());
        System.out.println("Average Wait: "+autoTollBooths[0].getAverageWait());

        
        //add 10 auto vehicles to the first auto tollbooth
        for (int i = 0; i < 10; i++) {
            autoTollBooths[0].arrive(autoCars[i]);
        }
        System.out.println(autoTollBooths[0]);
        System.out.println("Max length: "+autoTollBooths[0].getMaxLength());
        
        //5 cars leave
        for (int i = 10; i < 15; i++) {
            autoTollBooths[0].leave(i);
        }
        System.out.println(autoTollBooths[0]);  
        System.out.println("Max length: "+autoTollBooths[0].getMaxLength());
        
        //add 10 auto vehicles to the first auto tollbooth
        for (int i = 15; i < 25; i++) {
            autoTollBooths[0].arrive(autoCars[i]);
        }
        System.out.println(autoTollBooths[0]);
        System.out.println("Max length: "+autoTollBooths[0].getMaxLength());
        
        //15 cars leave
        for (int i = 25; i < 40; i++) {
            autoTollBooths[0].leave(i);
        }
        System.out.println(autoTollBooths[0]);  
        System.out.println("Max length: "+autoTollBooths[0].getMaxLength());
        
        System.out.println("Max Wait: "+autoTollBooths[0].getMaxWait());
        System.out.println("Average Wait: "+autoTollBooths[0].getAverageWait());
        
        
        //manu
        //add 10 auto vehicles to the first auto tollbooth
        for (int i = 0; i < 10; i++) {
            manuTollBooths[0].arrive(manuCars[i]);
        }
        System.out.println(manuTollBooths[0]);
        System.out.println("Max length: "+manuTollBooths[0].getMaxLength());
        
        //5 cars leave
        for (int i = 10; i < 15; i++) {
            manuTollBooths[0].leave(i);
        }
        System.out.println(manuTollBooths[0]);  
        System.out.println("Max length: "+manuTollBooths[0].getMaxLength());
        
        //add 10 auto vehicles to the first auto tollbooth
        for (int i = 15; i < 25; i++) {
            manuTollBooths[0].arrive(manuCars[i]);
        }
        System.out.println(manuTollBooths[0]);
        System.out.println("Max length: "+manuTollBooths[0].getMaxLength());
        
        //15 cars leave
        for (int i = 25; i < 40; i++) {
            manuTollBooths[0].leave(i);
        }
        System.out.println(manuTollBooths[0]);  
        System.out.println("Max length: "+manuTollBooths[0].getMaxLength());
        
        System.out.println("Max Wait: "+manuTollBooths[0].getMaxWait());
        System.out.println("Average Wait: "+manuTollBooths[0].getAverageWait());

        
        //add 10 auto vehicles to the first auto tollbooth
        for (int i = 0; i < 10; i++) {
            manuTollBooths[0].arrive(manuCars[i]);
        }
        System.out.println(manuTollBooths[0]);
        System.out.println("Max length: "+manuTollBooths[0].getMaxLength());
        
        //5 cars leave
        for (int i = 10; i < 15; i++) {
            manuTollBooths[0].leave(i);
        }
        System.out.println(manuTollBooths[0]);  
        System.out.println("Max length: "+manuTollBooths[0].getMaxLength());
        
        //add 10 auto vehicles to the first auto tollbooth
        for (int i = 15; i < 25; i++) {
            manuTollBooths[0].arrive(manuCars[i]);
        }
        System.out.println(manuTollBooths[0]);
        System.out.println("Max length: "+manuTollBooths[0].getMaxLength());
        
        //15 cars leave
        for (int i = 25; i < 40; i++) {
            manuTollBooths[0].leave(i);
        }
        System.out.println(manuTollBooths[0]);  
        System.out.println("Max length: "+manuTollBooths[0].getMaxLength());
        
        System.out.println("Max Wait: "+manuTollBooths[0].getMaxWait());
        System.out.println("Average Wait: "+manuTollBooths[0].getAverageWait());
    }
}
