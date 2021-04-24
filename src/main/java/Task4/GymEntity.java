package Task4;


import Task2.SmartphoneEntity;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;

@Table(name = "gym")
@Entity
public class GymEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="city")
    private String city;

    @Column(name="openFrom")
    private OffsetDateTime openFrom;

    @Column(name="openTo")
    private OffsetDateTime openTo;

    @OneToMany(mappedBy = "gymEntity")
    private List<EmployeeEntity> employeeEntities;

    @ManyToMany
    @JoinTable(
            name = "gymcardtype",
            joinColumns = @JoinColumn(name = "gym_id"),
            inverseJoinColumns = @JoinColumn(name = "card_type_id"))
    private Set<CardTypeEntity> cardTypeEntitySet;


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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public OffsetDateTime getOpenFrom() {
        return openFrom;
    }

    public void setOpenFrom(OffsetDateTime openFrom) {
        this.openFrom = openFrom;
    }

    public OffsetDateTime getOpenTo() {
        return openTo;
    }

    public void setOpenTo(OffsetDateTime openTo) {
        this.openTo = openTo;
    }

    public List<EmployeeEntity> getEmployeeEntities() {
        return employeeEntities;
    }

    public void setEmployeeEntities(List<EmployeeEntity> employeeEntities) {
        this.employeeEntities = employeeEntities;
    }

    public Set<CardTypeEntity> getCardTypeEntitySet() {
        return cardTypeEntitySet;
    }

    public void setCardTypeEntitySet(Set<CardTypeEntity> cardTypeEntitySet) {
        this.cardTypeEntitySet = cardTypeEntitySet;
    }
}
