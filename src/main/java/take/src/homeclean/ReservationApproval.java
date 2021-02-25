
package take.src.homeclean;

import take.src.homeclean.AbstractEvent;

import javax.persistence.PrePersist;

public class ReservationApproval extends AbstractEvent {

    private Long id;
    private Long reservationId;
    private Long cleanerId; // 청소담당자

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

    @PrePersist //처음 호출시 딜레이 실행
    public void delay(){
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
