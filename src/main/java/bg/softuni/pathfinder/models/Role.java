package bg.softuni.pathfinder.models;

import bg.softuni.pathfinder.enums.UserRoles;
import bg.softuni.pathfinder.models.base.BaseEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    @Enumerated(value = EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(255)")
    private UserRoles name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
