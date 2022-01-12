package fr.ensup.gestionarticle.container;

import com.zaxxer.hikari.HikariDataSource;
import fr.ensup.gestionarticle.dao.ArticleDao;
import fr.ensup.gestionarticle.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.BeanProperty;

@PropertySource({"classpath:datasource.properties"})
public class GestionObject
{
    @Autowired
    Environment env;

    @Bean()
    public HikariDataSource dataSourceSk() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(env.getProperty("database.sk.driver"));
        dataSource.setJdbcUrl(env.getProperty("database.sk.url"));
        dataSource.setUsername(env.getProperty("database.sk.username"));
        dataSource.setPassword(env.getProperty("database.sk.password"));
        return dataSource;
    }

    @Bean()
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSourceSk());
    }

    @Bean(initMethod = "initialisation", destroyMethod = "destruction")
    public ArticleDao articleDao() {
        return new ArticleDao(jdbcTemplate());
    }

    @Bean(initMethod = "initialisation", destroyMethod = "destruction")
    public ArticleService articleService() {
        return new ArticleService(articleDao());
    }
}
