package main.java.homeclean;

import main.java.homeclean.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{

    @Autowired
    ReservationRepository ReservationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPay_ChangeStatus(@Payload Reserved reserved){ //결제완료시 예약

        try {
            if(reserved.isMe() && reserved.getReservationId()!=null){
                //            try {
                //                // 원래 데이터가 트랜잭션 커밋되기도 전에 이벤트가 너무 빨리 도달하는 경우를 막기 위함
                //                Thread.currentThread().sleep(3000); //  no good. --> pay 가 TX 를 마친 후에만 실행되도록 수정함
                //            } catch (InterruptedException e) {
                //                e.printStackTrace();
                //            }

                System.out.println("reservationId = " + reserved.getReservationId());

                // Correlation id 는 'reservationId' 임
                Reservation reservation = ReservationRepository.findById(pointUsed.getBookId()).get();
                bookRentalSystem.setBookStatus("Reserved Complete");
                bookRentalSystemRepository.save(bookRentalSystem);

                주문Repository.findById(Long.valueOf(reserved.getReservationId())).ifPresent((주문)->{
                    주문.set상태("배달시작됨");
                    주문Repository.save(주문);
                });

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT) //청소 완료후 상태변경
    public void wheneverRegistered_ChangeStatus(@Payload Registered registered){
        try{
            if(registered.isMe()){
                System.out.print("####book registered: " +  registered.toJson());
                BookRentalSystem bookRentalSystem = new BookRentalSystem();
                bookRentalSystem.setId(registered.getId());
                bookRentalSystem.setBookName(registered.getBookName());
                bookRentalSystem.setBookStatus(Registered.class.getSimpleName());
                bookRentalSystemRepository.save(bookRentalSystem);

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
