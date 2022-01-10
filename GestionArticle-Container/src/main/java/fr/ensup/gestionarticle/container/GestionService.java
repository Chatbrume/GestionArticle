package fr.ensup.gestionarticle.container;

import fr.ensup.gestionarticle.dao.ArticleDao;
import fr.ensup.gestionarticle.dao.ArticleDaoJpa;
import fr.ensup.gestionarticle.service.ArticleService;
import org.springframework.context.annotation.Bean;

public class GestionService
{
    @Bean(initMethod = "initialisation", destroyMethod = "destruction")
    public ArticleService articleService() {
        return new ArticleService((new GestionDao()).articleDaoJpa());
    }

}
