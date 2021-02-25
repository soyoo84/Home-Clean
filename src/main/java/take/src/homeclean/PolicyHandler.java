package take.src.homeclean;

import homeclean.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{

    @Autowired ManageReservationRepository manageReservationRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    //예약완료시 청소담당자 배정
    public void wheneverReservationApproval_takeCleaner(@Payload ReservationApproval reservationApproval){

        if(reservationApproval.isMe()){
            System.out.println("##### listener reservationApproval : " + reservationApproval.toJson());

            ManageReservation manageReservation = new ManageReservation();
            manageReservation.setId(Long.valueOf(reservationApproval.getId()));
            manageReservation.setReservationId(Long.valueOf(reservationApproval.getReservationId()));
            manageReservation.setCleanerId(Long.valueOf(reservationApproval.getCleanerId()));
            manageReservationRepository.save(manageReservation);
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    //예약변경시 청소담당자 취소삭제
    public void wheneverReservationCancel_backCleaner(@Payload ReservationCancel reservationCancel){

        if(reservationCancel.isMe()){
            System.out.println("##### listener reservationCancel : " + reservationCancel.toJson());

            manageReservationRepository.findById(reservationCancel.getReservationId()).ifPresent(manageReservation->{
                manageReservationRepository.delete(manageReservation);
            });

        }
    }

}
