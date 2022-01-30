
package com.mycompany.sistemab;

import com.mycompany.model.Estudiante;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MenuestudianteController{
    private Estudiante est;
    @FXML
    private Label lblnombre;
    /**
     * Initializes the controller class.
     */


    @FXML
    private void catalogo() throws IOException {
        FXMLLoader ventana= new FXMLLoader(App.class.getResource("catalogo.fxml"));  
        Parent root =(Parent) ventana.load();
        CatalogoController c2 = ventana.getController();
        c2.setEst(est);
        App.cambiaRoot(root);
    }

    @FXML
    private void infoprestado() throws IOException {
        FXMLLoader ventana= new FXMLLoader(App.class.getResource("infoprestado.fxml")); 
        Parent root =(Parent) ventana.load();
        InfoprestadoController c2 = ventana.getController();
        c2.setEst(est);
        App.cambiaRoot(root);
    }

    public void setEst(Estudiante esti) {
        this.est = esti;
        lblnombre.setText(est.getUsuario());
    }

    @FXML
    private void cerrar() throws IOException {
        App.setRoot("login");
    }
    
}
