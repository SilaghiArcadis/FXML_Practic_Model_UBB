package Service;

import Domain.Route;

import java.io.*;
import java.util.ArrayList;

public class Repository {

    private ArrayList<Route>  routes=new ArrayList<>();

    public int routeExists(int id){

        for(int i=0;i<routes.size();i++) {
            if(id==this.routes.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }


    public void add_route(Route r) throws Exception {
        if(this.routeExists(r.getId())!=-1){
            this.routes.add(r);
        }
        else{
            throw new Exception("Route allready exists !");
        }
    }

    public void delete_route(int id) throws Exception {
        if(this.routeExists(id)!=-1){
            this.routes.remove(routeExists(id));
        }
        else{
            throw new Exception("Route doesn't exist!");
        }
    }

    public void read_from_file(String filename){
        BufferedReader br=null;

        try{
            br=new BufferedReader(new FileReader(filename));
            String line;
            while((line=br.readLine())!=null){
                this.add_route(new Route(line));
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void write_to_file(String filename){
        BufferedWriter wr=null;
        try{
            wr=new BufferedWriter(new FileWriter(filename));
            for(Route r:this.routes){
                wr.write(r.getSourceCity());
                wr.write(",");

                wr.write(r.getDestinationCity());
                wr.write(",");

                wr.write(Integer.toString(r.getDeparture()));
                wr.write(",");

                wr.write(Integer.toString(r.getArrival()));
                wr.write(",");

                wr.write(Integer.toString(r.getNrOfSeats()));
                wr.write(",");

                wr.write(Double.toString(r.getTicketPrice()));
                wr.write(",");

                wr.write(Integer.toString(r.getId()));
                wr.newLine();

            }
            wr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Route> get_route_by_source(String sourceCity){
        ArrayList<Route> aux=new ArrayList<>();
        for(Route r:this.routes){
            if(r.getSourceCity().equals(sourceCity)){
                aux.add(r);
            }
        }
        return aux;
    }


    public ArrayList<Route> get_route_by_source_destination(String sourceCity,String destinationCity){
        ArrayList<Route> aux=new ArrayList<>();
        for(Route r:get_route_by_source(sourceCity)){
            if(r.getSourceCity().equals(sourceCity) && r.getDestinationCity().equals(destinationCity))
                aux.add(r);
        }
        return aux;
    }


    public ArrayList<Route> getRoutes() {
        return routes;
    }
}
