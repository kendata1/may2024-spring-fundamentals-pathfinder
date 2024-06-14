package bg.softuni.pathfinder.models;

import bg.softuni.pathfinder.enums.Level;
import bg.softuni.pathfinder.models.base.BaseEntity;
import jakarta.persistence.*;

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
}
