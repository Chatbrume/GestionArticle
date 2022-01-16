package fr.ensup.gestionarticle.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.expression.Lists;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ErrorDetailController implements ErrorController
{
    @RequestMapping("/error")
    public ModelAndView error(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("error");

        List<String> attributes = new ArrayList<String>();
        request.getAttributeNames().asIterator().forEachRemaining(attributes::add);

        /*
        org.springframework.web.context.request.async.WebAsyncManager.WEB_ASYNC_MANAGER
        org.springframework.web.servlet.HandlerMapping.bestMatchingHandler
        org.springframework.web.servlet.DispatcherServlet.CONTEXT
        org.springframework.web.servlet.resource.ResourceUrlProvider
        org.springframework.web.servlet.HandlerMapping.introspectTypeLevelMapping
        org.springframework.web.servlet.HandlerMapping.matrixVariables
        org.springframework.web.servlet.DispatcherServlet.THEME_SOURCE
        org.springframework.web.util.ServletRequestPathUtils.PATH
        org.springframework.web.servlet.DispatcherServlet.LOCALE_RESOLVER
        org.springframework.web.servlet.HandlerMapping.bestMatchingPattern
        requestContextFilter.FILTERED
        org.springframework.web.servlet.DispatcherServlet.OUTPUT_FLASH_MAP
        org.springframework.web.servlet.HandlerMapping.pathWithinHandlerMapping
        org.springframework.web.servlet.DispatcherServlet.FLASH_MAP_MANAGER
        org.springframework.web.servlet.HandlerMapping.uriTemplateVariables
        org.springframework.web.servlet.DispatcherServlet.THEME_RESOLVER
        org.springframework.core.convert.ConversionService*/

        if( ! attributes.contains("javax.servlet.error.status_code") )
            return new ModelAndView("listArticle");

        Integer error_status_code = (Integer) request.getAttribute("javax.servlet.error.status_code");

        CodeHttp codeHttp = CodeHttp.getCodeHttpByCode(error_status_code);
        model.addObject("name_error", codeHttp == null ? "" : codeHttp.getName());
        model.addObject("code_error", codeHttp == null ? "" : codeHttp.getCode());
        model.addObject("signification_error", codeHttp == null ? "" : codeHttp.getSignification());

        Object error_message = request.getAttribute("javax.servlet.error.message");
        if( error_message != null && ((String)error_message) != "")
            model.addObject("message_error", (String) error_message);
        else
            model.addObject("message_error", null);

        return model;
    }

    public String getErrorPath() {
        return "/error";
    }
}