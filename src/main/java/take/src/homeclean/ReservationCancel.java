package take.src.homeclean;


public class ReservationCancel extends AbstractEvent {
    private Long id;
    private Long reservationId;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getReservationId() {
        return reservationId;
    }
    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

}
