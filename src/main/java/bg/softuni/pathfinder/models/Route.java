package bg.softuni.pathfinder.models;

import bg.softuni.pathfinder.models.enums.Level;
import bg.softuni.pathfinder.models.base.BaseEntity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "routes")
public class Route extends BaseEntity {
    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT ")
    private String gpxCoordinates;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(255)")
    private Level level;
    private String name;
    @Column (name = "video_url")
    private String videoUrl;
    @ManyToMany
    @JoinTable(name = "routes_categories",
    joinColumns = @JoinColumn(name = "route_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @OneToMany(mappedBy = "route")
    Set<Comment> comments;

    @OneToMany(mappedBy = "route")
    Set<Picture> pictures;

    public Route () {
        this.categories = new HashSet<>();
        this.comments = new HashSet<>();
        this.pictures = new HashSet<>();
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }
}
