package model;

import model.User;

import javax.persistence.*;
import java.sql.Date;
@Entity
public class RoomReservation {

    @ManyToOne
    private User user;
    //    private String name;
//    private String lastName;
//    private int nationalCode;
    @Column
    private int capacity;
    @Column
    private java.sql.Date startDate;
    @Column
    private java.sql.Date endDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reserveCode;
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int roomNumber;

    public RoomReservation() {
    }

    public RoomReservation(User user, int capacity, Date startDate, Date endDate,int roomNumber) {
        this.user = user;
        this.capacity = capacity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomNumber=roomNumber;

    }

    //
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public int getNationalCode() {
//        return nationalCode;
//    }
//
//    public void setNationalCode(int nationalCode) {
//        this.nationalCode = nationalCode;
//    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    @Override
//    public String toString() {
//        return "reserves : {" +
//                "name=" + name +
//                "\nlastName='" + lastName +
//                "\nnationalCode=" + nationalCode +
//                "\ncapacity=" + capacity +
//                "\nstartDate=" + startDate +
//                "\nendDate=" + endDate +
//                '}';
//    }


    @Override
    public String toString() {
        return "RoomReservation{" +
                "user=" + user +
                ", capacity=" + capacity +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", reserveCode=" + reserveCode +
                ", roomNumber=" + roomNumber +
                '}';
    }
}
