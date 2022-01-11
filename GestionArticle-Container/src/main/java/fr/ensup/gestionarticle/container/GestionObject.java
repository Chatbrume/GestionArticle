package fr.ensup.gestionarticle.container;

import fr.ensup.gestionarticle.dao.ArticleDao;
import fr.ensup.gestionarticle.service.ArticleService;
import org.springframework.context.annotation.Bean;

public class GestionObject
{
    @Bean(initMethod = "initialisation", destroyMethod = "destruction")
    public ArticleService articleService() {
        return new ArticleService(articleDao());
    }

    @Bean(initMethod = "initialisation", destroyMethod = "destruction")
    public ArticleDao articleDao() {
        return new ArticleDao();
    }
}
