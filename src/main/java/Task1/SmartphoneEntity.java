package Task1;


import javax.persistence.*;

@Entity
@Table(name = "smartphone")
public class SmartphoneEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "model")
    private String model;
    @Column(name ="price")
    private int price;

    public SmartphoneEntity(String name, String model, int price) {
        this.name = name;
        this.model = model;
        this.price = price;
    }

    public SmartphoneEntity() {
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
