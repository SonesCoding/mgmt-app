package SD.JPAmgmtapp.entity;

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
@Table(name="companies")
public class company {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@Column(name="info", columnDefinition = "TEXT")
    private @Getter @Setter String companyInfo;

@Column(name="createdBy", columnDefinition="VARCHAR(255)")
    private @Getter @Setter String author;

@Column(name="=name", columnDefinition = "VARCHAR(255)")
    private @Getter @Setter String name;

}