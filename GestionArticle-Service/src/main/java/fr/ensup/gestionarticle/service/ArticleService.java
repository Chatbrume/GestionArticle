package fr.ensup.gestionarticle.service;

import fr.ensup.gestionarticle.dao.ArticleDao;
import fr.ensup.gestionarticle.dao.IDao;
import fr.ensup.gestionarticle.domaine.Article;

import java.util.List;

public class ArticleService {

    private IDao iDao;

    public ArticleService(IDao iDao) {
        super();
        this.iDao = iDao;
    }

    public Article recuperation(int id) {
        System.out.println("SERVICE: récupération d'article' id=" + id);

        Article articleRetour = iDao.getById(id);
        return articleRetour;
    }

    public void create(Article article) {
        System.out.println("SERVICE: création d'article " + article.toString());

        iDao.create(article);
    }

    public Article update(Article article) {
        System.out.println("SERVICE: mise à jour d'article " + article.toString());

        Article articleRetour = iDao.update(article);
        return articleRetour;
    }

    public void delete(Article article) {
        System.out.println("SERVICE: suppression d'article' " + article.toString());

        iDao.delete(article);
    }

    public List<Article> getAll() {
        System.out.println("SERVICE: récupération de tous les articles");

        List<Article> articlesListeRetour = iDao.getAll();
        return articlesListeRetour;
    }

}
