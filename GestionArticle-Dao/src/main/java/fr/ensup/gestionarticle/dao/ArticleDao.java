package fr.ensup.gestionarticle.dao;

import fr.ensup.gestionarticle.domaine.Article;

import java.util.List;

public class ArticleDao {

    public Article getById(int id) {
        System.out.println("DAO: récupération du article id=" + id);

        if (id == 2) {
            return new Article("test", "10/01/2020", "Test");
        }
        return null;
    }

    public void create(Article article) {
        System.out.println("DAO: création du article " + article.toString());
    }

    public Article update(Article article) {
        System.out.println("DAO: mise à jour du article " + article.toString());
        return null;
    }

    public void delete(Article article) {
        System.out.println("DAO: suppression du article " + article.toString());
    }

    public List<Article> getAll() {
        System.out.println("DAO: récupération de tous les articles");
        return null;
    }
}
