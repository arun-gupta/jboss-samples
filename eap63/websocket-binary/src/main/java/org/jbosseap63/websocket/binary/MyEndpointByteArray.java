package org.jbosseap63.websocket.binary;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

/**
 * @author Arun Gupta
 */
@ServerEndpoint("/bytearray")
public class MyEndpointByteArray {
    private static final Logger LOGGER = Logger.getAnonymousLogger();
    
    @OnOpen
    public void onOpen() {
        LOGGER.log(Level.INFO, "opening connection with /bytearray");
    }
    
    @OnMessage
    public byte[] echoBinary(byte[] data) throws IOException {
        LOGGER.log(Level.INFO, "echoBinary(byte[])");
        return data;
    }
}
