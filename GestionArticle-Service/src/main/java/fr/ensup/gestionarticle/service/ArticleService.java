package fr.ensup.gestionarticle.service;

import fr.ensup.gestionarticle.dao.ArticleDao;
import fr.ensup.gestionarticle.dao.IDao;
import fr.ensup.gestionarticle.domaine.Article;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ArticleService {
    private static final Logger LOGGER = LogManager.getLogger(ArticleService.class.getName());

    private IDao iDao;

    public ArticleService() {
        super();
        this.iDao = null;
    }

    public ArticleService(IDao iDao) {
        super();
        this.iDao = iDao;
    }

    public Article recuperation(int id) {
        LOGGER.info("récupération d'article' id=" + id);

        Article articleRetour = iDao.getById(id);
        return articleRetour;
    }

    public void create(Article article) {
        LOGGER.info("création d'article " + article.toString());

        iDao.create(article);
    }

    public Article update(Article article) {
        LOGGER.info("mise à jour d'article " + article.toString());

        Article articleRetour = iDao.update(article);
        return articleRetour;
    }

    public void delete(Article article) {
        LOGGER.info("suppression d'article' " + article.toString());

        iDao.delete(article);
    }

    public List<Article> getAll() {
        LOGGER.info("récupération de tous les articles");

        List<Article> articlesListeRetour = iDao.getAll();
        return articlesListeRetour;
    }

    public IDao getiDao() {
        return iDao;
    }

    public void setiDao(IDao iDao) {
        this.iDao = iDao;
    }

    public void initialisation() {
        LOGGER.info("creation spring");
    }

    public void destruction() {
        LOGGER.info("destruction spring");
    }
}
