package hr.algebra.model;

import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Article { 
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    private int id;
    private String title;
    private String link;
    private String description;
    private String picturePath;
    private LocalDateTime publishedDate;
    private int categoryId;

    private Repository repository;
    
    public Article() {}
    
    public Article(String title, String link, String description, String picturePath, LocalDateTime publishedDate, int categoryId) {
        try {
            repository = RepositoryFactory.getRepository();
        } catch (Exception ex) {
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.title = title;
        this.link = link;
        this.description = description;
        this.picturePath = picturePath;
        this.publishedDate = publishedDate;
        this.categoryId = categoryId;
    }
    
    public Article(int id, String title, String link, String description, String picturePath, LocalDateTime publishedDate, int categoryId) {
        this(title, link, description, picturePath, publishedDate, categoryId);
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category category) {
        this.categoryId = category.getId();
    }
    
    public String getCategoryName(int categoryId) {
        try {
            Optional<Category> category = repository.selectCategoryByID(categoryId);
            if (category.isPresent()) {
                String categoryName = category.get().getName();
                return categoryName;
            }
        } catch (Exception ex) {
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "(Undefined)";
    }
    
    @Override
    public String toString() {
        return id + " - " + title;
    }
}