package fr.ensup.gestionarticle.container;

import fr.ensup.gestionarticle.dao.ArticleDao;
import fr.ensup.gestionarticle.dao.ArticleDaoJpa;
import fr.ensup.gestionarticle.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(GestionDao.class)
public class GestionService
{
    @Autowired
    ArticleDaoJpa articleDaoJpa;

    @Bean(initMethod = "initialisation", destroyMethod = "destruction")
    public ArticleService articleService() {
        return new ArticleService(articleDaoJpa);
    }

}
