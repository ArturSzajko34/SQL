package Task2;
import javax.persistence.*;
import java.util.Set;

@Table(name = "client")
@Entity

public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "clientEntity", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private AddressEntity addressEntity;


    @ManyToMany
    @JoinTable(
            name = "orders",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "smartphone_id"))
    private Set<SmartphoneEntity> smartphoneEntitySet;




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

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public Set<SmartphoneEntity> getSmartphoneEntitySet() {
        return smartphoneEntitySet;
    }

    public void setSmartphoneEntitySet(Set<SmartphoneEntity> smartphoneEntitySet) {
        this.smartphoneEntitySet = smartphoneEntitySet;
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addressEntity=" + addressEntity +
                '}';
    }
}
