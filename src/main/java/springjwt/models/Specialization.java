package springjwt.models;


import javax.persistence.*;

@Entity
@Table(name = "specialization")
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ESpecialization name;

    public Specialization(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ESpecialization getName() {
        return name;
    }

    public void setName(ESpecialization name) {
        this.name = name;
    }
}
