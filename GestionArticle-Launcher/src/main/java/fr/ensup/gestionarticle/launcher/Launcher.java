package fr.ensup.gestionarticle.launcher;

import fr.ensup.gestionarticle.container.GestionObject;
import fr.ensup.gestionarticle.domaine.Article;
import fr.ensup.gestionarticle.service.ArticleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        // 1. Chargement du conteneur en 4.0.0 Spring
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(GestionObject.class);

        // 2. Recuperation d'un bean du conteneur
        ArticleService articleService = (ArticleService) applicationContext.getBean("articleService");

        // 3. Manipulation du bean avec injection de dependances
        Article article1 = new Article(2, "test", "10/01/2020", "test");
        articleService.create(article1);

        Article article2 = articleService.recuperation(2);
        if (article2 != null) {
            System.out.println("LAUNCHER: Récuperation de l'article réussie " + article2.toString());
        } else {
            System.out.println("LAUNCHER: Récuperation de l'article échouée");
        }

        //4. Destruction des objets
        ((AnnotationConfigApplicationContext)applicationContext).close();
    }
}
