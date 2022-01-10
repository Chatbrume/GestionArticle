# Gestion Article v1

Cette version correspond a l'utilisation du couplage fort

## Definition couplage fort
Type de relation entre des composants informatiques.<br/>
Cette relation est dit "fort" car les composants sont très liés entre eux.

## Lancer l'application
Allez chercher le fichier jar "GestionArticle.jar-jar-with-dependencies" du dossier "GestionArticle\GestionArticle-Launcher\target"
Si besoin genere le fichier jar du projet avec la commande "mvn clean install package"
Lancer le fichier jar avec la commande "java -jar GestionArticle.jar-jar-with-dependencies"

Resultat attendu dans la console:
```
SERVICE: création de l'article Article{id=2, name='test', date='10/01/2020', author='test'}
DAO: création de l'article Article{id=2, name='test', date='10/01/2020', author='test'}
SERVICE: récupération de l'article id=2
DAO: récupération de l'article id=2
LAUNCHER: Récuperation du compte réussie Article{id=2, name='test', date='10/01/2020', author='Test'}
```