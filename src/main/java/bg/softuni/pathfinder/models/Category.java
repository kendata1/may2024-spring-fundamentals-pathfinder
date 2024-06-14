package bg.softuni.pathfinder.models;

import bg.softuni.pathfinder.enums.CategoryName;
import bg.softuni.pathfinder.models.base.BaseEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    @Column(columnDefinition = "TEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    private CategoryName name;
    @ManyToMany(mappedBy = "categories")
    private Set<Route> routes;
}
