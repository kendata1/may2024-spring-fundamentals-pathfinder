package bg.softuni.pathfinder.models;

import bg.softuni.pathfinder.enums.Level;
import bg.softuni.pathfinder.models.base.BaseEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private int age;
    private String username;

    private String password;
    @Column(name = "full_name")
    private String fullName;

    private String email;
    @ManyToMany
    @JoinTable(name = "users_roles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Role> roles;
    @Enumerated(value = EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(255)")
    private Level level;
    @OneToMany(mappedBy = "author")
    Set<Comment> comments;
    @OneToMany(mappedBy = "author")
    Set<Picture> pictures;
    @OneToMany(mappedBy = "author")
    Set<Route> routes;
    @OneToMany(mappedBy = "author")
    Set<Message> sentMessages;
    @OneToMany(mappedBy = "recipient")
    Set<Message> receivedMessages;

}
