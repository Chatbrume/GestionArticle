package fr.ensup.gestionarticle.container;

import com.zaxxer.hikari.HikariDataSource;
import fr.ensup.gestionarticle.dao.ArticleDao;
import fr.ensup.gestionarticle.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class GestionObject
{
    @Bean()
    public HikariDataSource dataSourceSk() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://@localhost:3306/gestionarticle?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean(initMethod = "initialisation", destroyMethod = "destruction")
    public ArticleDao articleDao() {
        return new ArticleDao(dataSourceSk());
    }

    @Bean(initMethod = "initialisation", destroyMethod = "destruction")
    public ArticleService articleService() {
        return new ArticleService(articleDao());
    }
}
