package sample;

import Controllers.AdminController;
import Controllers.ClientController;
import Service.Repository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Repository repo=new Repository();
        repo.read_from_file("K:\\MAP\\Examplu Practic\\res\\Routes.txt");
        ClientController clientController=new ClientController(repo,"Lenuta");
        AdminController adminController=new AdminController();
        GUIController guiController=new GUIController(clientController,adminController);
        FXMLLoader loader=new FXMLLoader(getClass().getResource("user.fxml"));
        loader.setController(guiController);
        Parent root = loader.load();
        primaryStage.setTitle("Lenuta");
        primaryStage.setScene(new Scene(root, 1088, 613));
        primaryStage.show();


        ClientController clientController1=new ClientController(repo,"Mihai");
        GUIController guiController1=new GUIController(clientController1,adminController);
        FXMLLoader loader1=new FXMLLoader(getClass().getResource("user.fxml"));
        loader1.setController(guiController1);
        Parent root1=loader1.load();
        Stage primaryStage1=new Stage();
        primaryStage1.setTitle("Mihai");
        primaryStage1.setScene(new Scene(root1, 1088, 613));
        primaryStage1.show();


        ClientController clientController3=new ClientController(repo,"Sergiu");
        GUIController guiController3=new GUIController(clientController3,adminController);
        FXMLLoader loader3=new FXMLLoader(getClass().getResource("user.fxml"));
        loader3.setController(guiController3);
        Parent root3=loader3.load();
        Stage primaryStage3=new Stage();
        primaryStage3.setTitle("Sergiu");
        primaryStage3.setScene(new Scene(root3, 1088, 613));
        primaryStage3.show();


        FXMLLoader loader2=new FXMLLoader(getClass().getResource("admin.fxml"));
        loader2.setController(guiController1);
        Parent root2=loader2.load();
        Stage primaryStage2=new Stage();
        primaryStage2.setTitle("Admin");
        primaryStage2.setScene(new Scene(root2, 1156, 520));
        primaryStage2.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
