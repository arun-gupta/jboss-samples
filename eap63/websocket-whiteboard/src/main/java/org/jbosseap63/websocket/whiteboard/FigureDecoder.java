package org.jbosseap63.websocket.whiteboard;

import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 * @author Arun Gupta
 */
public class FigureDecoder implements Decoder.Text<Figure> {

    private static final Logger LOGGER = Logger.getLogger(FigureDecoder.class.getName());

    @Override
    public Figure decode(String json) throws DecodeException {
        LOGGER.log(Level.INFO, "decoding: {0}", json);
        Gson gson = new Gson();
        return gson.fromJson(json, Figure.class);
    }

    @Override
    public boolean willDecode(String json) {
        return true;
    }

    @Override
    public void init(EndpointConfig ec) {
    }

    @Override
    public void destroy() {
    }
}
