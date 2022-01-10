package fr.ensup.gestionarticle.service;

import fr.ensup.gestionarticle.dao.ArticleDao;
import fr.ensup.gestionarticle.domaine.Article;

import java.util.List;

public class ArticleService {

    private ArticleDao articleDao;

    public ArticleService() {
        super();
        this.articleDao = new ArticleDao();
    }

    public Article recuperation(int id) {
        System.out.println("SERVICE: récupération de l'article id=" + id);

        Article articleRetour = articleDao.getById(id);
        return articleRetour;
    }

    public void creer(Article article) {
        System.out.println("SERVICE: création de l'article " + article.toString());

        articleDao.create(article);
    }

    public Article mettreAJour(Article article) {
        System.out.println("SERVICE: mise à jour de l'article " + article.toString());

        Article articleRetour = articleDao.update(article);
        return articleRetour;
    }

    public void supprimer(Article compte) {
        System.out.println("SERVICE: suppression de l'article " + compte.toString());

        articleDao.delete(compte);
    }

    public List<Article> recuperationListe() {
        System.out.println("SERVICE: récupération de tous les articles");

        List<Article> articleListeRetour = articleDao.getAll();
        return articleListeRetour;
    }

    public void comparaison(Article article1, Article article2) {
        System.out.println("SERVICE: comparaison entre deux articles");
    }
}
