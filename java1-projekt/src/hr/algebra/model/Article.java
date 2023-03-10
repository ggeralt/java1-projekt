package hr.algebra.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class Article { 
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @XmlAttribute
    private int id;
    
    @XmlElement(name = "categoryid")
    private int categoryId;
    
    private String title;
    private String link;
    private String description;
    
    @XmlElement(name = "picturepath")
    private String picturePath;
    
    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlElement(name = "publisheddate")
    private LocalDateTime publishedDate;
    
    public Article() {}
    
    public Article(int categoryId, String title, String link, String description, String picturePath, LocalDateTime publishedDate) {
        this.categoryId = categoryId;
        this.title = title;
        this.link = link;
        this.description = description;
        this.picturePath = picturePath;
        this.publishedDate = publishedDate;
    }
    
    public Article(int id, int categoryId, String title, String link, String description, String picturePath, LocalDateTime publishedDate) {
        this(categoryId, title, link, description, picturePath, publishedDate);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category category) {
        this.categoryId = category.getId();
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
    
    @Override
    public String toString() {
        return id + " - " + title;
    }
}