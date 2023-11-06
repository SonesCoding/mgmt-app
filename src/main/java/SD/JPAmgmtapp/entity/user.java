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
    
    public static final String setFirstName = null;

    @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

  @Column(name = "fname", columnDefinition = "VARCHAR(255)")
    private static @Getter @Setter String FirstName;

    
  @Column(name = "lname", columnDefinition = "VARCHAR(255)")
    private @Getter static @Setter String LastName;

@Column(unique = true, name = "mobile", columnDefinition = "VARCHAR(255)")
    private @Getter static @Setter String MobileNumber;

@Column(unique = true, name = "email", columnDefinition = "VARCHAR(255)")
    private @Getter static @Setter String EmailAddress;

@Column(name = "username", columnDefinition = "VARCHAR(30)")
    private @Getter static @Setter String username;

@Column(name = "passwrd", columnDefinition = "VARCHAR(255)")
    private @Getter static @Setter String UserPassword;

@Column(name = "info", columnDefinition = "TEXT")
    private @Getter static @Setter String InfoBio;


@Column(name ="role", columnDefinition ="VARCHAR(10)")
    private @Getter static @Setter String UserRole;

@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="role",
            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private List<role> roles = new ArrayList<>();

public user orElseThrow(Object object) {
    return null;
}


    //@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL): 
    //This annotation is from JPA and specifies that the relationship between User and Role entities is many-to-many. 
    //https://www.javaguides.net/2018/10/user-registration-module-using-springboot-springmvc-springsecurity-hibernate5-thymeleaf-mysql.html
    //^^ greatly helped me build this user file. The work after this took heavy influence on what was picked up here
    }

