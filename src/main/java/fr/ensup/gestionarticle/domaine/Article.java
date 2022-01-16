package fr.ensup.gestionarticle.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Article
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String date;
    private String author;

    public Article() {
        this.id = -1;
        this.name = null;
        this.date = null;
        this.author = null;
    }

    public Article(Integer id, String name, String date, String author) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.author = author;
    }

    public Article(String name, String date, String author) {
        this.id = null;
        this.name = name;
        this.date = date;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
