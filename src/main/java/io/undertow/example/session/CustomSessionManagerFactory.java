package io.undertow.example.session;

import io.undertow.server.session.SessionManager;
import io.undertow.servlet.api.Deployment;
import io.undertow.servlet.api.SessionManagerFactory;

/**
 * Created by fsierra on 3/25/17.
 */
public class CustomSessionManagerFactory implements SessionManagerFactory {

    public SessionManager createSessionManager(Deployment deployment) {
        return new CustomSessionManager(deployment.getDeploymentInfo().getDeploymentName());
    }
}
