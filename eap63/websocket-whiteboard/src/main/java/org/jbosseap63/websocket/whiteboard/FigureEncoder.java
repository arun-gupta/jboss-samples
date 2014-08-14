package org.jbosseap63.websocket.whiteboard;

import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * @author Arun Gupta
 */
public class FigureEncoder implements Encoder.Text<Figure> {

    private static final Logger LOGGER = Logger.getLogger(FigureDecoder.class.getName());
    
    @Override
    public String encode(Figure figure) throws EncodeException {
        LOGGER.log(Level.CONFIG, "encoding: {0}", figure);
        Gson gson = new Gson();
        return gson.toJson(figure);
    }

    @Override
    public void init(EndpointConfig ec) {
    }

    @Override
    public void destroy() {
    }
}
