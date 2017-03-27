package io.undertow.example.session;

import io.undertow.server.session.SessionConfig;
import io.undertow.servlet.ServletExtension;
import io.undertow.servlet.api.Deployment;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.SessionConfigWrapper;

import javax.servlet.ServletContext;
import java.util.logging.Logger;


public class CustomSessionManagerExtension implements ServletExtension {

    static Logger logger = Logger.getLogger(CustomSessionManagerExtension.class.getName());

    public void handleDeployment(final DeploymentInfo deploymentInfo, ServletContext servletContext) {

        logger.info("Deployment: "+deploymentInfo.getDeploymentName());
        logger.info("Deployment adding custom session manager");
        deploymentInfo.setSessionManagerFactory(new CustomSessionManagerFactory());
        logger.info("Deployment set Session config");


        deploymentInfo.setSessionConfigWrapper(new SessionConfigWrapper() {
            public SessionConfig wrap(SessionConfig sessionConfig, Deployment deployment) {
                logger.info("wrap session config " + sessionConfig.getClass());

                return new CustomSessionConfigWrapper(sessionConfig);
            }
        });

        /*deploymentInfo.addInitialHandlerChainWrapper(new HandlerWrapper() {
            public HttpHandler wrap(HttpHandler httpHandler) {
                return new SessionAttachmentHandler(httpHandler, new CustomSessionManager(deploymentInfo.getDeploymentName()), new CustomSessionConfig());
            }
        });*/

    }
}
