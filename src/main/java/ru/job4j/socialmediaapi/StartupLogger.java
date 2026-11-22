package ru.job4j.socialmediaapi;

import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.server.context.WebServerApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;

@Component
public class StartupLogger {
    private static final Logger LOG =
            (Logger) LoggerFactory.getLogger(StartupLogger.class);

    private final WebServerApplicationContext context;

    public StartupLogger(WebServerApplicationContext context) {
        this.context = context;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onReady() {
        int port = context.getWebServer().getPort();

        LOG.info("Application is ready!");
        LOG.info("API: http://localhost:{}/api/ping", port);
    }
}
