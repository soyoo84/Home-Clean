package main.java.homeclean;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name="reservation_table")
public class Reservation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Long id;
    private Integer time;
    private String date;
    private String status;
    private Long pay;
    private String address;
    private Long reservationId;


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


    @PostPersist
    public void onStatusUpdate(){

        if(this.getStatus().equals("RSV")){  //reservation
            Reserved reserved = new Reserved(this);
            BeanUtils.copyProperties(this, reserved);
            reserved.publish();
        }else if(this.getStatus().equals("CCL")){ //cancel
            ReservationCancel reservationCanceled = new ReservationCancel(this);
            BeanUtils.copyProperties(this, reservationCanceled);
            reservationCanceled.publish();
        }else if(this.getStatus().equals("CPT")){ //complete
            Registered registered = new Registered(this);
            BeanUtils.copyProperties(this, registered);
            registered.publish();

        }
    }
}
