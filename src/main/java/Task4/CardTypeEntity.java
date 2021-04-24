package Task4;

import Task2.ClientEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Table(name = "cardType")
@Entity
public class CardTypeEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private int price;

    @ManyToMany(mappedBy = "cardTypeEntitySet")
    Set<GymEntity> gymEntitySet;

    @OneToMany(mappedBy = "cardTypeEntity")
    private List<CardEntity> cardEntities;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<GymEntity> getGymEntitySet() {
        return gymEntitySet;
    }

    public void setGymEntitySet(Set<GymEntity> gymEntitySet) {
        this.gymEntitySet = gymEntitySet;
    }

    public List<CardEntity> getCardEntities() {
        return cardEntities;
    }

    public void setCardEntities(List<CardEntity> cardEntities) {
        this.cardEntities = cardEntities;
    }
}
