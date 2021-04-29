import com.panamahitek.ArduinoException;
import jssc.SerialPortException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static ArduinoToJava arduinoToJava = new ArduinoToJava();
    static FullCommunication fullCommunication = new FullCommunication();

    public static void main(String[] args) throws IOException, ArduinoException, SerialPortException {
        arduinoToJava.getMessage();
        System.out.println("Select 1 to turn on the led or 0 to turn off");

        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        String dataToSend = "0";

        while (dataToSend.equals("0") || dataToSend.equals("1")){
            dataToSend = reader.readLine();
            fullCommunication.sendDataToArduino(dataToSend);
        }

        System.out.println("Thanks!");
    }

}
