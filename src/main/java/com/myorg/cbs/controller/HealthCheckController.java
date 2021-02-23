package com.myorg.cbs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    @RequestMapping(value = "/health", method = { RequestMethod.HEAD, RequestMethod.GET })
    public String doPing() {
        return "HTTP 200 - OK";
    }
}
