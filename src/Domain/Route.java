package Domain;

import java.util.Objects;

public class Route {

    String sourceCity;
    String destinationCity;
    int departure;
    int arrival;
    int nrOfSeats;
    double ticketPrice;
    int id;


    public Route(String source,String destination,int dep,int arrival,int seats,double price,int i){

        this.sourceCity=source;
        this.destinationCity=destination;
        this.departure=dep;
        this.arrival=arrival;
        this.nrOfSeats=seats;
        this.ticketPrice=price;
        this.id=i;
    }

    public Route(String csv) {
        String token[] = csv.split(",");
        this.sourceCity = token[0];
        this.destinationCity = token[1];
        this.departure = Integer.parseInt(token[2]);
        this.arrival = Integer.parseInt(token[3]);
        this.nrOfSeats = Integer.parseInt(token[4]);
        this.ticketPrice = Double.parseDouble(token[5]);
        this.id = Integer.parseInt(token[6]);
    }

    public String getSourceCity() {
        return sourceCity;
    }

    public void setSourceCity(String sourceCity) {
        this.sourceCity = sourceCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public int getDeparture() {
        return departure;
    }

    public void setDeparture(int departure) {
        this.departure = departure;
    }

    public int getArrival() {
        return arrival;
    }

    public void setArrival(int arrival) {
        this.arrival = arrival;
    }

    public int getNrOfSeats() {
        return nrOfSeats;
    }

    public void setNrOfSeats(int nrOfSeats) {
        this.nrOfSeats = nrOfSeats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Route{" +
                "sourceCity='" + sourceCity + '\'' +
                ", destinationCity='" + destinationCity + '\'' +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", nrOfSeats=" + nrOfSeats +
                ", ticketPrice=" + ticketPrice +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return id == route.id ;

    }

}
