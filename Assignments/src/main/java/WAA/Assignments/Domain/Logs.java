package WAA.Assignments.Domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Logs {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;

    String date;
    String time;
    int Principle;
    String operation;


}
