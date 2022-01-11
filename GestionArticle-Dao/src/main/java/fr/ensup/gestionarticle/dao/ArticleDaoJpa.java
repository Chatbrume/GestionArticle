package fr.ensup.gestionarticle.dao;

import fr.ensup.gestionarticle.domaine.Article;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ArticleDaoJpa implements IDao {
    private static final Logger LOGGER = LogManager.getLogger(ArticleDaoJpa.class.getName());

    @Override
    public Article getById(int id) {
        LOGGER.info("recuperation d article id=" + id);

        if (id == 2) {
            return new Article(2, "Sciences", "10/01/2022", "Amélie Nioche");
        }
        return null;
    }

    @Override
    public void create(Article article) {
        LOGGER.info("creation article " + article.toString());
    }

    @Override
    public Article update(Article article) {
        LOGGER.info("mise a jour d'article' " + article.toString());
        return null;
    }

    @Override
    public void delete(Article article) {
        LOGGER.info("suppression d'article' " + article.toString());
    }

    @Override
    public List<Article> getAll() {
        LOGGER.info("recuperation de tous les articles");
        return null;
    }

    @Override
    public void initialisation() {
        LOGGER.info("creation spring");
    }

    @Override
    public void destruction() {
        LOGGER.info("destruction spring");
    }
}
