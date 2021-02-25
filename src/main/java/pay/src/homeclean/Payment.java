package pay.src.homeclean;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Entity
@Table(name="Payment_table")
public class Payment {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long reservationId;
    private Long pay;
    private String approval;

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

    public Long getPay() {
        return pay;
    }
    public void setPay(Long pay) {
        this.pay = pay;
    }

    public String getApproval() {
        return approval;
    }
    public void setApproval(String status) {
        this.approval = approval;
    }

    @PrePersist
    public void onPrePersist(){

        if("cancel".equals(approval)){
            PaymentCancel paymentCancel = new PaymentCancel();
            BeanUtils.copyProperties(this, paymentCancel);
            paymentCancel.publish();

        }else{
            Approval approval = new Approval();
            BeanUtils.copyProperties(this, approval);

            //바로 이벤트를 보내버리면 주문정보가 커밋되기도 전에 배송발송됨 이벤트가 발송되어 주문테이블의 상태가 바뀌지 않을 수 있다.
            // TX 리스너는 커밋이 완료된 후에 이벤트를 발생하도록 만들어준다.
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void beforeCommit(boolean readOnly) {
                    approval.publish();
                }
            });

            try {
                Thread.currentThread().sleep((long) (400 + Math.random() * 220));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
