package pay.src.main.java.fooddelivery;


public class 주문취소됨 extends AbstractEvent {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
