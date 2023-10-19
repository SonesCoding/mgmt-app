package SD.JPAmgmtapp.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="users")
public class user {
    
    @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

  @Column(name = "fname", columnDefinition = "VARCHAR(255)")
    private @Getter @Setter String firstName;

    
  @Column(name = "lname", columnDefinition = "VARCHAR(255)")
    private @Getter @Setter String lastName;

@Column(unique = true, name = "mobile", columnDefinition = "VARCHAR(255)")
    private @Getter @Setter String mobileNumber;

@Column(unique = true, name = "email", columnDefinition = "VARCHAR(255)")
    private @Getter @Setter String emailAddress;

@Column(name = "username", columnDefinition = "VARCHAR(30)")
    private @Getter @Setter String username;

@Column(name = "passwrd", columnDefinition = "VARCHAR(255)")
    private @Getter @Setter String userPassword;

@Column(name = "info", columnDefinition = "TEXT")
    private @Getter @Setter String infoBio;


@Column(name ="role", columnDefinition ="VARCHAR(10)")
    private @Getter @Setter String userRole;

@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="role",
            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private List<role> roles = new ArrayList<>();

    //@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL): 
    //This annotation is from JPA and specifies that the relationship between User and Role entities is many-to-many. 
    //https://www.javaguides.net/2018/10/user-registration-module-using-springboot-springmvc-springsecurity-hibernate5-thymeleaf-mysql.html
    //^^ greatly helped me build this user file. The work after this took heavy influence on what was picked up here
    }

