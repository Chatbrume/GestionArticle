package fr.ensup.gestionarticle.dao;

import fr.ensup.gestionarticle.domaine.Article;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;

public class ArticleDao implements IDao
{
    private static final Logger LOGGER = LogManager.getLogger(ArticleDao.class.getName());
    private Connection cn = null;

    public Article getById(int id) {
        LOGGER.info("récupération de l'article id=" + id);

        Statement st = null;
        ResultSet rs = null;

        try {
            st = cn.createStatement();
            String sql = "SELECT * FROM article WHERE id=" + id;

            rs = st.executeQuery(sql);

            while(rs.next()) {
                return new Article(rs.getInt("id"), rs.getString("name"), rs.getString("date"),
                        rs.getString("author"));
            }
        } catch (SQLException sqle) {
            LOGGER.error(sqle.getMessage());
        } finally {
            try {
                //Liberer ressources de la memoire.
                rs.close();
                st.close();
            } catch (SQLException sqle) {
                LOGGER.error(sqle.getMessage());
            }
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

            Class.forName("com.mysql.cj.jdbc.Driver");
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
            if( cn != null )
                cn.close();
        } catch (SQLException sqle) {
            LOGGER.error(sqle.getMessage());
        } finally {
            LOGGER.info("Connexion fermer avec succes !");
        }
    }
}
