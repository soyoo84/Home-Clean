package pay.src.homeclean;

import pay.src.homeclean.config.kafka.KafkaProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{

    @Autowired PaymentRepository PaymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    //결제 취소시 예약취소
    public void wheneverPaymentCancel_ReservationCancel(@Payload PaymentCancel PaymentCancel){

        if(PaymentCancel.isMe()){
            System.out.println("##### Reservation Canceled : " + PaymentCancel.toJson());
            ReservationCancel reservationCancel = new ReservationCancel();
            reservationCancel.setId(PaymentCancel.getId());
            //reservationCancel.setStatus(PaymentRepository.findById(PaymentCancel.getId()).get().getApproval());
            reservationCancel.setStatus(PaymentCancel.getStatus());
            BeanUtils.copyProperties(this, reservationCancel);
            reservationCancel.publish();
        }
    }

}
