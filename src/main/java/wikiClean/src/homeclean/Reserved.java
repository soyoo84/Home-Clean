package homeclean;


import pay.src.homeclean.AbstractEvent;

//예약됨
public class Reserved extends AbstractEvent {

    private Long id;
    private Integer time;
    private String date;
    private String status;
    private Long pay;
    private String address;
    private Long reservationId;

    public Reserved(){
        super();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTime() {
        return time;
    }
    public void setTime(Integer time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPay() {
        return pay;
    }
    public void setPay(Long pay) {
        this.pay = pay;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public Long getReservationId() {
        return reservationId;
    }
    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Reserved(Reservation reservation){
        this();
        this.setId(reservation.getId());
        this.setTime(reservation.getTime());
        this.setDate(reservation.getDate());
        this.setStatus(reservation.getStatus());
        this.setPay(reservation.getPay());
        this.setAddress(reservation.getAddress());
        this.setReservationId(reservation.getReservationId());
    }

}
