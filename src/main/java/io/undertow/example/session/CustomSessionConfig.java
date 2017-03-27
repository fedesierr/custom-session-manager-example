package io.undertow.example.session;


import io.undertow.server.HttpServerExchange;
import io.undertow.server.session.SessionCookieConfig;

import java.util.logging.Logger;

/**
 * Created by fsierra on 3/25/17.
 */
public class CustomSessionConfig extends SessionCookieConfig{

    static Logger logger = Logger.getLogger(CustomSessionConfig.class.getName());

    public CustomSessionConfig() {
        super();
    }

    @Override
    public String rewriteUrl(String originalUrl, String sessionId) {
        logger.info("rewriteUrl: "+sessionId);
        return super.rewriteUrl(originalUrl, sessionId);
    }

    @Override
    public void setSessionId(HttpServerExchange exchange, String sessionId) {
        logger.info("setSessionId: "+sessionId);
        super.setSessionId(exchange, sessionId);
    }

    @Override
    public void clearSession(HttpServerExchange exchange, String sessionId) {
        logger.info("clearSession: "+sessionId);
        super.clearSession(exchange, sessionId);
    }

    @Override
    public String findSessionId(HttpServerExchange exchange) {
        logger.info("findSessionId");
        return super.findSessionId(exchange);
    }
}
