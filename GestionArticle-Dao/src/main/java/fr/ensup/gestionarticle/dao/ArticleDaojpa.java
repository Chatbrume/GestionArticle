package fr.ensup.gestionarticle.dao;

import fr.ensup.gestionarticle.domaine.Article;

import java.util.List;

public class ArticleDaojpa implements IDao {
    @Override
    public Article getById(int id) {
        System.out.println("DAO JPA: r�cup�ration d article id=" + id);

        if (id == 2) {
            return new Article(2, "Sciences", "10/01/2022", "Amélie Nioche");
        }
        return null;
    }

    @Override
    public void create(Article article) {

        System.out.println("DAO JPA: cr�ation article " + article.toString());
    }

    @Override
    public Article update(Article article) {
        System.out.println("DAO JPA: mise � jour d'article' " + article.toString());
        return null;
    }

    @Override
    public void delete(Article article) {
        System.out.println("DAO JPA: suppression d'article' " + article.toString());
    }

    @Override
    public List<Article> getAll() {
        System.out.println("DAO JPA: r�cup�ration de tous les articles");
        return null;
    }
}
