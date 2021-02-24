package pay.src.main.java.fooddelivery;

public class 결제승인됨 extends AbstractEvent {

    private Long id;
    private String reservationId;
    private Double 금액;

    public 결제승인됨(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getreservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }
    public Double get금액() {
        return 금액;
    }

    public void set금액(Double 금액) {
        this.금액 = 금액;
    }
}
