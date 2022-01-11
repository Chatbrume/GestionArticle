package fr.ensup.gestionarticle.dao;

import fr.ensup.gestionarticle.domaine.Article;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class ArticleDao implements IDao
{
    private static final Logger LOGGER = LogManager.getLogger(ArticleDao.class.getName());
    private Connection cn = null;

    public Article getById(int id) {
        LOGGER.info("récupération de l'article id=" + id);
        if( cn == null ) initialisation();

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
        if( cn == null ) initialisation();

        PreparedStatement pstmt = null;

        try {
            pstmt = cn.prepareStatement("INSERT INTO Article (name, date, author) VALUES ( ?, ?, ? )");
            pstmt.setString(1, article.getName());
            pstmt.setString(2, article.getDate());
            pstmt.setString(3, article.getAuthor());

            pstmt.execute();

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            try {
                if( pstmt != null ) pstmt.close();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
        }
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
        try {
            String url = "jdbc:mysql://@localhost:3306/gestionarticle?serverTimezone=UTC";
            String login = "root";
            String passwd = "";

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
