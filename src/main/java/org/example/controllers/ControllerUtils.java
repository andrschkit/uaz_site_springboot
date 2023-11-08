package org.example.controllers;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class ControllerUtils {

    protected static Optional<String> getPreviousPageByRequest(HttpServletRequest request)
    {
        return Optional.ofNullable(request.getHeader("Referer")).map(requestUrl -> "redirect:" + requestUrl);
    }
}
