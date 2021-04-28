import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ArduinoToJava {
    //Se crea una instancia de la librería PanamaHitek_Arduino
    private static final PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
    private static final SerialPortEventListener listener = spe -> {
        try {
            if (ino.isMessageAvailable()) {
                //Se imprime el mensaje recibido en la consola
                System.out.println(ino.printMessage());
            }
        } catch (SerialPortException | ArduinoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    };

    public void getMessage(){
        try {
            ino.arduinoRX("COM4", 9600, listener);
        } catch (ArduinoException | SerialPortException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
