package fr.ensup.gestionarticle.dao;

import fr.ensup.gestionarticle.domaine.Article;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao implements IDao
{
    private static final Logger LOGGER = LogManager.getLogger(ArticleDao.class.getName());

    private JdbcTemplate jdbcTemplate;

    public ArticleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void initialisation() {
        LOGGER.info("Initialisation");
    }

    @Override
    public void destruction() {
        LOGGER.info("Destruction");
    }

    public Article getById(int id) {
        LOGGER.info("récupération de l'article id=" + id);

        return jdbcTemplate.queryForObject("SELECT * FROM article WHERE id=" + id, (resultSet, rowNum) -> {
            return new Article(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("date"),
                    resultSet.getString("author"));
        });
    }

    public void create(Article article) {
        LOGGER.info("création de l'article " + article.toString());
        if( article == null ) return;

        Object[] arguments = new Object[3];
        arguments[0] = article.getName();
        arguments[1] = article.getDate();
        arguments[2] = article.getAuthor();
        jdbcTemplate.update("INSERT INTO Article (name, date, author) VALUES ( ?, ?, ? )", arguments);
    }

    public Article update(Article article) {
        LOGGER.info("mise à jour de l'article " + article.toString());
        if( article == null ) return null;

        Article prevArticle = getById(article.getId());

        String question = "";
        if( ! stringAreEquals(article.getName(), prevArticle.getName()) )
            question += "name='" + article.getName() + "'";
        if( ! stringAreEquals(article.getDate(), prevArticle.getDate()) )
            question += (question.equals("") ? "" : ", ") + "date='" + article.getDate() + "'";
        if( ! stringAreEquals(article.getAuthor(), prevArticle.getAuthor()) )
            question += (question.equals("") ? "" : ", ") + "author='" + article.getAuthor() + "'";

        if( question.equals("") ) return null;

        jdbcTemplate.update("UPDATE article SET "+question+" WHERE id="+article.getId());
        return null;
    }

    public void delete(Article article) {
        LOGGER.info("suppression de l'article " + article.toString());
        if( article == null || article.getId() == null ) return;

        jdbcTemplate.update("DELETE FROM article WHERE id="+article.getId());
    }

    public List<Article> getAll() {
        LOGGER.info("récupération de tous les articles");

        return jdbcTemplate.query("SELECT * FROM article", (resultSet, rowNum) -> {
            return new Article(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("date"),
                    resultSet.getString("author"));
        });
    }

    private boolean stringAreEquals(String st1, String st2)
    {
        if( st1 == null && st2 == null || (st1 != null && st2 != null && st1.equals(st2)) )
            return true;
        return false;
    }
}
