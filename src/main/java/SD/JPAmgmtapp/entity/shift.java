package SD.JPAmgmtapp.entity;

import java.sql.Date;

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
@Table(name="shifts")
public class shift {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(name = "shiftStart", columnDefinition = "DATE")
        private @Getter @Setter String shiftStart;

    @Column(name="shiftEnd", columnDefinition= "DATE")
        private @Getter @Setter Date shiftEnd;

    @Column(name="info", columnDefinition = "TEXT")
        private @Getter @Setter String shiftInfo;

    @Column(name="publishedBy", columnDefinition="VARCHAR(255)")
        private @Getter @Setter String author;

    @Column(name="company", columnDefinition = "VARCHAR(255)")
        private @Getter @Setter String shiftCompany;
    

          }      


