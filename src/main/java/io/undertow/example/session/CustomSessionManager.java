package io.undertow.example.session;

import io.undertow.server.HttpServerExchange;
import io.undertow.server.session.*;

import java.util.logging.Logger;


/**
 * Created by fsierra on 3/25/17.
 */
public class CustomSessionManager extends InMemorySessionManager {

    static Logger logger = Logger.getLogger(CustomSessionManager.class.getName());

    public CustomSessionManager(String id) {
        super(id);
    }

    @Override
    public Session createSession(HttpServerExchange serverExchange, SessionConfig config) {

        logger.info("Create session in CustomSessionManager with SessionConfig: "+config.getClass().getName());
        return super.createSession(serverExchange, config);
    }
}
