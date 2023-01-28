package WAA.Assignments.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;

    @JsonBackReference
    @BatchSize(size = 2)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    Post post;
}
