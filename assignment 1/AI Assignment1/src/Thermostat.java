import java.util.Scanner;

public class Thermostat{
        private boolean power;
        private boolean system;
        private int setTemp;
        private int currTemp;
        private boolean cooler;
        private boolean heater;
        private int windLevel;

        public Thermostat() { // Basic Setting
                Scanner scan = new Scanner(System.in);
                System.out.print("Set Actual Temperature of your room: ");
                currTemp = scan.nextInt();
                power = false;
                system = false;
                setTemp = 500;
                cooler = false;
                heater = false;
                windLevel = 1;
        }

        public void thermostatInfo() { //Thermostat Information Screen
                String PonOffStr = (power) ? "ON" : "OFF";
                String SonOffStr = (system) ? "ON" : "OFF";
                final String[] windStr = {"", "level 1", "level 2", "level 3"};

                System.out.println("\n===============Thermostat Status================");
                System.out.println("Power status:  " + PonOffStr);
                System.out.println("System status: " + SonOffStr);
                System.out.println("Current Temperature (in degree Celsius): " + currTemp);
                System.out.println("Temperature Setting(in degree Celsius):  " + setTemp);
                System.out.println("Wind Level: " + windStr[windLevel]);
        }

        public void setThermostatState() { //System Operation
                Scanner scan = new Scanner(System.in);
                System.out.println("Current Temperature is " + currTemp + ".");
                System.out.print("Set Preferred Temperature: ");
                setTemp = scan.nextInt();
                System.out.print("Set Wind Level: ");
                windLevel = scan.nextInt();

                if (currTemp == setTemp){ // Reached preferred Temperature
                        system = false;
                        power = true;
                        System.out.println("Thermostat stops.");
                        cooler = false;
                        heater = false;

                }else if (currTemp > setTemp) { //HOT
                        system = true;
                        power = true;
                        System.out.println("Cooling system activated.");
                        cooler = true;
                        heater = false;
                } else if (currTemp < setTemp) { //Cold
                        system = true;
                        power = true;
                        System.out.println("Heating system activated.");
                        heater = true;
                        cooler = false;
                }
        }
        public void setSystem(boolean SOnOff) {
                system = SOnOff;
        }
        public void setPower(boolean POnOff) {
                power = POnOff;
        }
        public boolean isHeater() {return heater;}
        public boolean isCooler() {
                return cooler;
        }
        public void setCurrTemp(int n) {
                currTemp += n;
        }
        public int getCurrTemp() {return currTemp;}
        public int getSetTemp() {
                return setTemp;
        }
        public int getWindLevel() {
                return windLevel;
        }
}
