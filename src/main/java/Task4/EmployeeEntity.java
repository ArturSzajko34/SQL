package Task4;

import javax.persistence.*;


@Table(name = "employee")
@Entity
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="type")
    private String type;

    @ManyToOne
    @JoinColumn(name="gym_id", nullable=false)
    private GymEntity gymEntity;

    public EmployeeEntity(String name, String type) {
        this.name = name;
        this.type = type;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public GymEntity getGymEntity() {
        return gymEntity;
    }

    public void setGymEntity(GymEntity gymEntity) {
        this.gymEntity = gymEntity;
    }
}
