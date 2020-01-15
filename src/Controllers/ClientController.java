package Controllers;

import Domain.Route;
import Service.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ClientController {

    Repository repository;
    String clientName;

    public ClientController(Repository repo,String name){
        this.repository=repo;
        this.clientName=name;
    }

    public ArrayList<Route> get_list_by_source_ctrl(String sourceCity){
         return this.repository.get_route_by_source(sourceCity);
    }

    public ArrayList<Route> get_routes_by_source_destination_ctrl(String sourceCity,String destinationCity){
        return this.repository.get_route_by_source_destination(sourceCity,destinationCity);
    }

    public ArrayList<Route> get_all_routes_ctrl(){
        return this.repository.getRoutes();
    }

    public String getClientName(){ return this.clientName;}
}
