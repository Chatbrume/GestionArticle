package fr.ensup.gestionarticle.launcher;

import fr.ensup.gestionarticle.domaine.Article;
import fr.ensup.gestionarticle.service.ArticleService;

public class Launcher {
    public static void main(String[] args) {
        Article article1 = new Article(2, "test", "10/01/2020", "test");

        ArticleService articleService = new ArticleService();
        articleService.creer(article1);

        Article article2 = articleService.recuperation(2);
        if (article2 != null) {
            System.out.println("LAUNCHER: Récuperation du compte réussie " + article2.toString());
        } else {
            System.out.println("LAUNCHER: Récuperation du compte échouée");
        }
    }
}
