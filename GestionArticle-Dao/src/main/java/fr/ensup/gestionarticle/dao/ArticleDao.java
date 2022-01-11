package fr.ensup.gestionarticle.dao;

import fr.ensup.gestionarticle.domaine.Article;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ArticleDao implements IDao
{
    private static final Logger LOGGER = LogManager.getLogger(ArticleDao.class.getName());
    private Connection cn = null;

    public Article getById(int id) {
        LOGGER.info("récupération de l'article id=" + id);

        if (id == 2) {
            return new Article(2, "test", "10/01/2020", "Test");
        }
        return null;
    }

    public void create(Article article) {

        LOGGER.info("création de l'article " + article.toString());
    }

    public Article update(Article article) {
        LOGGER.info("mise à jour de l'article " + article.toString());
        return null;
    }

    public void delete(Article article) {
        LOGGER.info("suppression de l'article " + article.toString());
    }

    public List<Article> getAll() {
        LOGGER.info("récupération de tous les articles");
        return null;
    }

    @Override
    public void initialisation()
    {
        LOGGER.info("creation spring");
        try {
            String url = "mysql-database:3306/gestionarticle?serverTimezone=UTC";
            String login = "user";
            String passwd = "test";

            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Etape 2 : r�cup�ration de la connexion
            cn = DriverManager.getConnection(url, login, passwd);
        } catch (ClassNotFoundException cnfe) {
            LOGGER.error(cnfe.getMessage());
        } catch (SQLException sqle) {
            LOGGER.error(sqle.getMessage());
        } finally {
            LOGGER.info("Connexion a la base de donnee reussi !");
        }
    }

    @Override
    public void destruction() {
        LOGGER.info("DAO: destruction spring");
        try {
            cn.close();
        } catch (SQLException sqle) {
            LOGGER.error(sqle.getMessage());
        } finally {
            LOGGER.info("Connexion fermer avec succes !");
        }
    }
}
