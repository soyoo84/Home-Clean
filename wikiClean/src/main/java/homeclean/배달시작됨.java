package homeclean;


public class 배달시작됨 extends AbstractEvent {

    private Long id;
    private String CleanTime;
    private String Address;
    private String reservationId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCleanTime() {
        return CleanTime;
    }

    public void setCleanTime(String CleanTime) {
        this.CleanTime = CleanTime;
    }
    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    public String getreservationId() {
        return reservationId;
    }

    public void setreservationId(String reservationId) {
        this.reservationId = reservationId;
    }
}
