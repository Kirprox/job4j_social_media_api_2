package ru.job4j.socialmediaapi;

import org.slf4j.LoggerFactory;
import org.springframework.boot.web.server.context.WebServerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;

@Component
public class StartupLogger {
    private static final Logger LOG =
            (Logger) LoggerFactory.getLogger(StartupLogger.class);

    @EventListener()
    public void onReady(WebServerInitializedEvent event) {
        int port = event.getWebServer().getPort();

        LOG.info("Application is ready!");
        LOG.info("API: http://localhost:{}/api/ping", port);
    }
}
