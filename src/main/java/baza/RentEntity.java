package baza;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "rent")
public class RentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private OffsetDateTime rentFrom;
    private OffsetDateTime rentTo;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private CarEntity carEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getRentFrom() {
        return rentFrom;
    }

    public void setRentFrom(OffsetDateTime rentFrom) {
        this.rentFrom = rentFrom;
    }

    public OffsetDateTime getRentTo() {
        return rentTo;
    }

    public void setRentTo(OffsetDateTime rentTo) {
        this.rentTo = rentTo;
    }

    public CarEntity getCarEntity() {
        return carEntity;
    }

    public void setCarEntity(CarEntity carEntity) {
        this.carEntity = carEntity;
    }
}
