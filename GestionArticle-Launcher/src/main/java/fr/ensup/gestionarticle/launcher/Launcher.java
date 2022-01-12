package fr.ensup.gestionarticle.launcher;

import fr.ensup.gestionarticle.domaine.Article;
import fr.ensup.gestionarticle.service.ArticleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="fr.ensup.gestionarticle")
public class Launcher implements CommandLineRunner
{
    public static final Logger LOGGER = LogManager.getLogger(Launcher.class.getName());

    @Autowired
    private ArticleService articleService;

    public ArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    public void run(String... args) {
        // 3. Manipulation du bean avec injection de dependances
        //Article article1 = new Article("test", "10/01/2020", "test");
        //articleService.create(article1);

        Article article2 = articleService.recuperation(1);
        if (article2 != null) {
            LOGGER.info("Récuperation de l'article réussie " + article2.toString());
        } else {
            LOGGER.info("Récuperation de l'article échouée");
        }

        article2.setAuthor(article2.getAuthor().equals("Moi") ? "Toi" : "Moi");
        articleService.update(article2);

        for (Article articleCourant : articleService.getAll()) {
            System.out.println(articleCourant.toString());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }
}
