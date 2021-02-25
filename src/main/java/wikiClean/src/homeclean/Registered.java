package homeclean;

import pay.src.homeclean.AbstractEvent;

//예약기록
public class Registered extends AbstractEvent {

    private Long id;
    private Long reservationId;
    private String status;

    public Registered(){
        super();
    }

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

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


    public Registered(Reservation reservation){
        this();
        this.setId(reservation.getId());
        this.setReservationId(reservation.getReservationId());
        this.setStatus(reservation.getStatus());

    }
}
