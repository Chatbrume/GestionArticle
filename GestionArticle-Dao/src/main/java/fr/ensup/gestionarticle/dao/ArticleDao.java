package fr.ensup.gestionarticle.dao;

import fr.ensup.gestionarticle.domaine.Article;

import java.util.List;

public class ArticleDao implements IDao {

    public Article getById(int id) {
        System.out.println("DAO: récupération de l'article id=" + id);

        if (id == 2) {
            return new Article(2, "test", "10/01/2020", "Test");
        }
        return null;
    }

    public void create(Article article) {

        System.out.println("DAO: création de l'article " + article.toString());
    }

    public Article update(Article article) {
        System.out.println("DAO: mise à jour de l'article " + article.toString());
        return null;
    }

    public void delete(Article article) {
        System.out.println("DAO: suppression de l'article " + article.toString());
    }

    public List<Article> getAll() {
        System.out.println("DAO: récupération de tous les articles");
        return null;
    }

    @Override
    public void initialisation() {
        System.out.println("DAO: creation spring");
    }

    @Override
    public void destruction() {
        System.out.println("DAO: destruction spring");
    }
}
