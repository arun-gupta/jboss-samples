package org.jbosseap63.websocket.whiteboard;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.EncodeException;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * @author Arun Gupta
 */
@ServerEndpoint(value = "/websocket",
        encoders = {FigureEncoder.class},
        decoders = {FigureDecoder.class})
public class Whiteboard {

    private static final Logger LOGGER = Logger.getLogger(Whiteboard.class.getName());

    @OnOpen
    public void onOpen(Session s) {
        LOGGER.log(Level.INFO, s.getId());
        s.setMaxBinaryMessageBufferSize(150*150*4); // the amount is counted based on the canvas size (width*height*number of RGB channels) 
    }
    
    @OnMessage
    public void broadcastFigure(Figure figure, Session session) throws IOException, EncodeException {
        LOGGER.log(Level.INFO, "broadcastFigure: {0}", figure);
        for (Session peer : session.getOpenSessions()) {
            if (!peer.equals(session)) {
                peer.getBasicRemote().sendObject(figure);
            }
        }
    }

    @OnMessage
    public void broadcastSnapshot(byte[] data, Session session) throws IOException {
        LOGGER.log(Level.INFO, "broadcastBinary: {0}", data);
        for (Session peer : session.getOpenSessions()) {
            if (!peer.equals(session)) {
                peer.getBasicRemote().sendBinary(ByteBuffer.wrap(data));
            }
        }
    }
    
    @OnError
    public void onError(Throwable t) {
        LOGGER.log(Level.SEVERE, t.getMessage());
    }
}
