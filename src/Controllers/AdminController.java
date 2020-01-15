package Controllers;

import Domain.Booking;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class AdminController {

    ArrayList<Booking> bookings=new ArrayList<>();

    public AdminController(){}

    public void admin_add(Booking b){this.bookings.add(b);}

    public void sort_bookings(){
        this.bookings=(ArrayList<Booking>) this.bookings.stream().sorted((o1, o2) -> {
            String sort1=""+o1.getDestinationCity()+Integer.toString(o1.getDeparture()).length()+o1.getDeparture();
            String sort2=""+o2.getDestinationCity()+Integer.toString(o2.getDeparture()).length()+o1.getDeparture();
            return sort1.compareTo(sort2);
        }).collect(Collectors.toList());
    }

    public ArrayList<Booking> getBookings(){return this.bookings;}

}
