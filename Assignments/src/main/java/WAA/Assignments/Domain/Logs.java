package WAA.Assignments.Domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
