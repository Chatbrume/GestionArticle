package fr.ensup.gestionarticle.dao;

import fr.ensup.gestionarticle.domaine.Article;

import java.util.List;

public interface IDao {
    public Article getById(int id);

    public void create(Article article);

    public void delete(Article article);

    public Article update(Article article);

    public List<Article> getAll() ;
}
