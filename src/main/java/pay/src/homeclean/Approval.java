package pay.src.homeclean;

public class Approval extends AbstractEvent {

    private Long id;
    private String reservationId;
    private Double pay;

    public Approval(){
        super();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getReservationId() {
        return reservationId;
    }
    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Double getPay() {
        return pay;
    }
    public void setPay(Double pay) {
        this.pay = pay;
    }
}
