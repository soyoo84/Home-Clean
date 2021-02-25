package take.src.homeclean;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name="ManageReservation_table")
public class ManageReservation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    Long reservationId;
    Long cleanerId; // 청소담당자


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

    public Long getCleanerId() {
        return cleanerId;
    }
    public void setCleanerId(Long cleanerId) {
        this.cleanerId = cleanerId;
    }


    @PostUpdate
    //예약완료후 청소담당자 배정Update
    public void onCleanerUpdate(){
        ReservationApproval reservationApproval = new ReservationApproval();
        reservationApproval.setReservationId(Long.valueOf(getReservationId())); //예약번호 받아옴
        BeanUtils.copyProperties(this, reservationApproval);
        reservationApproval.publish();

    }

    @PostRemove
    //예약취소시 청소담당자 삭제
    public void onPrePersist(){
        ReservationCancel reservationCancel = new ReservationCancel();
        reservationCancel.setReservationId(Long.valueOf(getReservationId())); //예약번호 받아옴
        BeanUtils.copyProperties(this, reservationCancel);
        reservationCancel.publish();

    }

}
