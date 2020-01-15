package sample;

import Controllers.AdminController;
import Controllers.ClientController;
import Domain.Booking;
import Domain.Route;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class GUIController {
    ClientController clientController;
    AdminController adminController;

    public GUIController(ClientController client,AdminController admin){
        this.adminController=admin;
        this.clientController=client;
    }

    // ADMIN PANEL
    @FXML
    private ListView<Booking> routes_listview;

    @FXML
    private Button update_btn;


    // CLIENT PANEL

    @FXML
    private ListView<String> source_listview;

    @FXML
    private ListView<String> destination_listview;

    @FXML
    private ListView<Route> route_listview;

    @FXML
    private Button getsources_btn;

    @FXML
    private Button getdestinations_btn;

    @FXML
    private Button getroutes_btn;

    @FXML
    private Button buy_btn;

    @FXML
    private TextField ticket_textfield;

    @FXML
    private TextField price_textfield;

    @FXML
    void getBookings_handler(ActionEvent event) {
        ObservableList<Booking> obs4=FXCollections.observableArrayList(this.adminController.getBookings());
        this.routes_listview.setItems(obs4);


    }

    @FXML
    void buyTicket_handler(ActionEvent event) {
        Route r=this.route_listview.getSelectionModel().getSelectedItem();
        int howManyTickets=Integer.parseInt(this.ticket_textfield.getText().toString());
        Double finalPrice=r.getTicketPrice()*howManyTickets;
        this.price_textfield.setText(Double.toString(finalPrice));
        Booking b=new Booking(r.getSourceCity(),r.getDestinationCity(),r.getDeparture(),r.getArrival(),r.getNrOfSeats(),r.getTicketPrice(),r.getId(),this.clientController.getClientName());
        this.adminController.admin_add(b);
        this.adminController.sort_bookings();
    }

    @FXML
    void getDestinations_handler(ActionEvent event) {
        String source=this.source_listview.getSelectionModel().getSelectedItem();
        ArrayList<Route> aux=this.clientController.get_list_by_source_ctrl(source);
        ArrayList<String> aux2=new ArrayList<>();
        for(Route r:aux){
            aux2.add(r.getDestinationCity());
        }
        ObservableList<String> obs2=FXCollections.observableArrayList(aux2);
        this.destination_listview.setItems(obs2);

    }

    @FXML
    void getRoutesHandler(ActionEvent event) {
        String source=this.source_listview.getSelectionModel().getSelectedItem();
        String destination=this.destination_listview.getSelectionModel().getSelectedItem();
        ArrayList<Route> routes=this.clientController.get_routes_by_source_destination_ctrl(source,destination);
        ObservableList<Route> obs3=FXCollections.observableArrayList(routes);
        this.route_listview.setItems(obs3);

    }
    
    @FXML
    void getSources_handler(ActionEvent event) {
        ArrayList<String> source = new ArrayList<>();
        for (Route r : this.clientController.get_all_routes_ctrl()) {

            if(!Arrays.asList(source).contains(r.getSourceCity())){
                source.add(r.getSourceCity());
            }
        }
        ObservableList<String> obs = FXCollections.observableArrayList(source);
        this.source_listview.setItems(obs);
    }
}


