package com.example.demo.undertow;

import com.example.demo.HelloHttpHandler;
import io.undertow.server.HttpHandler;
import io.undertow.server.handlers.PathHandler;
import org.springframework.boot.web.embedded.undertow.HttpHandlerFactory;

public class PathHttpHandlerFactory implements HttpHandlerFactory {

    private final HelloHttpHandler helloHttpHandler;

    public PathHttpHandlerFactory(HelloHttpHandler helloHttpHandler) {
        this.helloHttpHandler = helloHttpHandler;
    }

    @Override
    public HttpHandler getHandler(HttpHandler next) {
        PathHandler pathHandler = new PathHandler(next);
        pathHandler.addExactPath("/hello-optimized", helloHttpHandler);
        return pathHandler;
    }
}
