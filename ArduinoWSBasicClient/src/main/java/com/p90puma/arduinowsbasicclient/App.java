/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.p90puma.arduinowsbasicclient;

import com.p90puma.arduinows.ArduinoWS;
import com.p90puma.arduinows.ArduinoWSService;

/**
 *
 * @author P90Puma
 */
public class App {



public static void main(String [ ] args)
{


          
           try { // Call Web Service Operation
               ArduinoWSService service = new ArduinoWSService();
               ArduinoWS port = service.getArduinoWSPort();
               // TODO initialize WS operation arguments here
               java.lang.String input = "10EF08F7";
               // TODO process result here
               java.lang.String result = port.sendSerialInput(input);
               System.out.println("Result = "+result);
           } catch (Exception ex) {
               // TODO handle custom exceptions here
           }

}
}
