import java.util.Scanner;
import static java.lang.Thread.sleep;

public class ThermostatMain {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        Thermostat Thermostat = new Thermostat();
        int elapsedTime = 0;
        boolean SetTemp = false;
        boolean SetPower = true;
        System.out.print("Turn the Thermostat On?[yes/no]: ");
        String PowerOn = scan.next();

        if(PowerOn.equalsIgnoreCase("YES")) {
            Thermostat.setSystem(true);
            Thermostat.setPower(true);
            Thermostat.setThermostatState();
            while(SetPower) {
                sleep(1000);
                elapsedTime++;
                switch(Thermostat.getWindLevel()) {
                    case 1 :
                        if(elapsedTime >= 5) SetTemp = true; break;
                    case 2 :
                        if(elapsedTime >= 3) SetTemp = true; break;
                    case 3 :
                        if(elapsedTime >= 1) SetTemp = true; break;
                    default:
                }
                if (SetTemp) {
                    if (Thermostat.getCurrTemp() == Thermostat.getSetTemp()) {
                        Thermostat.setCurrTemp(0);
                        Thermostat.setSystem(false);
                        System.out.print("Do you want to turn the Thermostat Power OFF?[yes/no]: ");
                        String PowerOFF = scan.next();
                        if (PowerOFF.equalsIgnoreCase("YES")) {
                            SetPower = false;
                            break;
                        }else {
                            SetPower = true;
                        }
                    }else if (Thermostat.isHeater()) {
                        Thermostat.setCurrTemp(1);
                        Thermostat.setSystem(true);
                        Thermostat.setPower(true);
                    }else if (Thermostat.isCooler()) {
                        Thermostat.setCurrTemp(-1);
                        Thermostat.setSystem(true);
                        Thermostat.setPower(true);
                    }
                    Thermostat.thermostatInfo();
                    SetTemp = false;
                    elapsedTime = 0;
                }
            }
        }
    }
}
