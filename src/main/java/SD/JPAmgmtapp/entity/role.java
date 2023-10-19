package SD.JPAmgmtapp.entity;
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
@Table(name="roles")
public class role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;

    @Column(nullable=false, name="role",columnDefinition = "VARCHAR(10)")
    private @Getter @Setter String roleValue;

    @ManyToMany(mappedBy="roles")
    private List<user> users;
}      


