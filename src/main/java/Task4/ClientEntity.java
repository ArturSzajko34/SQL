package Task4;


import javax.persistence.*;
import java.util.List;

@Table(name = "client")
@Entity
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "clientEntity")
    private List<CardEntity> cardEntityList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CardEntity> getCardEntityList() {
        return cardEntityList;
    }

    public void setCardEntityList(List<CardEntity> cardEntityList) {
        this.cardEntityList = cardEntityList;
    }
}
