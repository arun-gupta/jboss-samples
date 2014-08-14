package org.jbosseap63.websocket.whiteboard;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
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
    public void broadcastSnapshot(ByteBuffer data, Session session) throws IOException {
        LOGGER.log(Level.INFO, "broadcastBinary: {0}", data);
        for (Session peer : session.getOpenSessions()) {
            if (!peer.equals(session)) {
                peer.getBasicRemote().sendBinary(data);
            }
        }
    }
}
