package fr.ensup.gestionarticle.repository;

import fr.ensup.gestionarticle.domaine.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArticleRepository extends JpaRepository<Article, Integer>
{
}
