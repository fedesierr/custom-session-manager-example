package io.undertow.example.session;

import io.undertow.server.HttpServerExchange;
import io.undertow.server.session.SessionConfig;

import java.util.logging.Logger;

/**
 * Created by fsierra on 3/25/17.
 */
public class CustomSessionConfigWrapper implements SessionConfig{

    static Logger logger = Logger.getLogger(CustomSessionConfigWrapper.class.getName());
    private final SessionConfig config;

    public CustomSessionConfigWrapper(SessionConfig config) {
        this.config = config;
    }

    public void setSessionId(HttpServerExchange httpServerExchange, String s) {
        logger.info("setSessionId: "+s);
        config.setSessionId(httpServerExchange, s);
    }

    public void clearSession(HttpServerExchange httpServerExchange, String s) {
        logger.info("clearSession : "+s);
        config.clearSession(httpServerExchange, s);
    }

    public String findSessionId(HttpServerExchange httpServerExchange) {
        logger.info("findSessionId ");
        return config.findSessionId(httpServerExchange);
    }

    public SessionCookieSource sessionCookieSource(HttpServerExchange httpServerExchange) {
        return config.sessionCookieSource(httpServerExchange);
    }

    public String rewriteUrl(String s, String s1) {
        return config.rewriteUrl(s, s1);
    }
}
