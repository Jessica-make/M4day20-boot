package com.spoto.init;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrPageConf implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage errorPage400 = new ErrorPage(HttpStatus.BAD_REQUEST, "/err/404.html");
        ErrorPage errorPage401 = new ErrorPage(HttpStatus.UNAUTHORIZED, "/err/404.html");
        ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/err/404.html");
        ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/err/500.html");
        registry.addErrorPages(errorPage400, errorPage401, errorPage404, errorPage500);

    }
}
