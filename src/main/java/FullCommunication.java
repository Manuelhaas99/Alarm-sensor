import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FullCommunication {

    //Variable for COM PORT
    String COM = "PON TU COM AQUI";
    int baudRate = 9600;

    private final PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
    private final SerialPortEventListener listener = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
            try {
                if (ino.isMessageAvailable()) {
                    //jLabelOutput.setText("Resultado: " + ino.printMessage());
                    System.out.println("Resultado: " + ino.printMessage());
                }
            } catch (SerialPortException | ArduinoException ex) {
                Logger.getLogger(FullCommunication.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    //Default constructor
    FullCommunication(){
        try{
            ino.arduinoRXTX(COM, baudRate, listener);
        }catch (ArduinoException ex){
            Logger.getLogger(FullCommunication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Constructor with parameters
    FullCommunication(String comPort, int baudRate){
        try{
            ino.arduinoRXTX(comPort, baudRate, listener);
        }catch (ArduinoException ex){
            Logger.getLogger(FullCommunication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendDataToArduino(String data){
        try{
            ino.sendData(data);
        }catch (ArduinoException | SerialPortException ex){
            Logger.getLogger(FullCommunication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
