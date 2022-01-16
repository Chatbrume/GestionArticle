package fr.ensup.gestionarticle.controller;

import fr.ensup.gestionarticle.domaine.Article;
import fr.ensup.gestionarticle.repository.IArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.*;

@Controller
@RequestMapping("article")
public class ArticleController
{
    private IArticleRepository repo;

    @Autowired
    public ArticleController(IArticleRepository repo)
    {
        this.repo = repo;
    }

    @RequestMapping()
    public RedirectView listerArticle() {
        return new RedirectView("/article/all");
    }

    @RequestMapping(value="all")
    public String listerArticle(Model model)
    {
        model.addAttribute("previousUrl", AppRestController.addUrl("/article/all"));

        List<Article> articles =  repo.findAll();
        if (articles != null) {
            model.addAttribute("articles", articles);
        }
        return "listArticle";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public RedirectView recuperation(@PathVariable("id") int id) {
        return new RedirectView("/article/get/"+id);
    }

    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public String recuperation(@PathVariable("id") int id,  Model model) {
        model.addAttribute("previousUrl", AppRestController.addUrl("/article/get/"+id));
        if( repo.existsById(id) ) {
            model.addAttribute("article", repo.findById(id).get());
        }
        else {
            model.addAttribute("error","The id "+id+" n'existe pas");
        }
        return "getArticle";
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public RedirectView supprimer(@PathVariable("id") int id,  Model model) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }
        else {
            model.addAttribute("error","The id "+id+" n'existe pas");
        }
        return new RedirectView("/article/all");
    }

    @RequestMapping(value="/create", method=RequestMethod.GET)
    public ModelAndView creer() {
        ModelAndView model = new ModelAndView("saveArticle", "article", new Article());
        model.addObject("previousUrl", AppRestController.addUrl("/article/create"));
        return model;
    }

    @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
    public String mettreAJour(@PathVariable("id") Integer id,  Model model)
    {
        model.addAttribute("previousUrl", AppRestController.addUrl("/article/update/"+id));
        if( repo.existsById(id) ) {
            model.addAttribute("article", repo.findById(id).get());
            return "saveArticle";
        }
        else {
            model.addAttribute("error","The id "+id+" n'existe pas");
            return "listArticle";
        }
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public RedirectView save(@RequestParam("id") int id,
                              @RequestParam("name") String name,
                              @RequestParam("date") String date,
                              @RequestParam("author") String author)
    {
        if( id == -1 ) {
            repo.save(new Article(name, date, author));
            return new RedirectView("/article/all");
        }
        else {
            repo.save(new Article(id, name, date, author));
            return new RedirectView("/article/get/" + id);
        }
    }
}