package org.jbosseap63.websocket.binary;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

/**
 * @author Arun Gupta
 */
@ServerEndpoint("/bytebuffer")
public class MyEndpointByteBuffer {
    private static final Logger LOGGER = Logger.getAnonymousLogger();
    
    @OnOpen
    public void onOpen() {
        LOGGER.log(Level.INFO, "opening connection with /bytebuffer");
    }
    
    @OnMessage
    public ByteBuffer echoBinary(ByteBuffer data) throws IOException {
        LOGGER.log(Level.INFO, "echoBinary(ByteBuffer)");
        return data;
    }
}
