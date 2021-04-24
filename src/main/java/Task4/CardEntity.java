package Task4;


import javax.persistence.*;
import java.time.OffsetDateTime;

@Table(name = "card")
@Entity
public class CardEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="valid_from")
    private OffsetDateTime validFrom;

    @Column(name="valid_to")
    private OffsetDateTime validTo;

    @ManyToOne
    @JoinColumn(name="client_id")
    private ClientEntity clientEntity;

    @ManyToOne
    @JoinColumn(name="card_type_id")
    private CardTypeEntity cardTypeEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(OffsetDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public OffsetDateTime getValidTo() {
        return validTo;
    }

    public void setValidTo(OffsetDateTime validTo) {
        this.validTo = validTo;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public CardTypeEntity getCardTypeEntity() {
        return cardTypeEntity;
    }

    public void setCardTypeEntity(CardTypeEntity cardTypeEntity) {
        this.cardTypeEntity = cardTypeEntity;
    }
}
