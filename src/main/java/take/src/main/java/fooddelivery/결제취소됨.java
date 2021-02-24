package take.src.main.java.fooddelivery;


public class 결제취소됨 extends AbstractEvent {

    private Long id;
    private Long reservationId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getreservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
}
