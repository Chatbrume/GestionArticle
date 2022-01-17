package fr.ensup.gestionarticle.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.LinkedList;

@RestController
public class AppRestController
{
    private static LinkedList<String> previousUrls = new LinkedList();

    public static String addUrl(String actualPath)
    {
        String last = null;
        
        if( ! previousUrls.isEmpty()  && previousUrls.getLast().equals(actualPath) )
            previousUrls.removeLast();

        if( ! previousUrls.isEmpty() )
            last = previousUrls.getLast();

        previousUrls.addLast(actualPath);

        return last;
    }

    @RequestMapping("/previous")
    public RedirectView previous()
    {
        RedirectView view = new RedirectView("/");
        previousUrls.removeLast();
        if( ! previousUrls.isEmpty() ) {
            view.setUrl(previousUrls.getLast());
            previousUrls.removeLast();
        }
        return view;
    }

    @RequestMapping("/")
    public RedirectView home()
    {
        RedirectView view = new RedirectView("/article/all");
        view.addStaticAttribute("previousUrl", addUrl("/"));
        return view;
    }

    @RequestMapping("/articles")
    public RedirectView articles()
    {
        RedirectView view = new RedirectView("/article/all");
        view.addStaticAttribute("previousUrl", addUrl("/articles"));
        return view;
    }
}