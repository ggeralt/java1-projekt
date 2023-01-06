package hr.algebra.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Article { 
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    private int id;
    private String title;
    private String link;
    private String description;
    private String picturePath;
    private LocalDateTime publishedDate;
    private Category category;

    public Article() {}
    
    public Article(String title, String link, String description, String picturePath, LocalDateTime publishedDate, Category category) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.picturePath = picturePath;
        this.publishedDate = publishedDate;
        this.category = category;
    }
    
    public Article(int id, String title, String link, String description, String picturePath, LocalDateTime publishedDate, Category category) {
        this(title, link, description, picturePath, publishedDate, category);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    @Override
    public String toString() {
        return id + " - " + title;
    }
}