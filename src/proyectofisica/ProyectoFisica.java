/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofisica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class ProyectoFisica extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("FXMLMenuPrincipal.fxml"));
Parent root = FXMLLoader.load(getClass().getResource("MenuTeoria.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Física I");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
