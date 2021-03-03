import java.sql.Date;

public class RoomReservation {
    private String name;
    private String lastName;
    private int nationalCode;
    private int capacity;
    private Date startDate;
    private Date endDate;
    private int reserveCode;
    private int roomNumber;

    public RoomReservation(String name, String lastName, int nationalCode, int capacity, Date startDate, Date endDate,int reserveCode) {
        this.name = name;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.capacity = capacity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reserveCode=reserveCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(int nationalCode) {
        this.nationalCode = nationalCode;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public int getReserveCode() {
        return reserveCode;
    }

    public void setReserveCode(int reserveCode) {
        this.reserveCode = reserveCode;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
