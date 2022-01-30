
package com.mycompany.sistemab;

import com.mycompany.model.Libro;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AgglibroController implements Initializable {
    private ArrayList<Libro> libros;
    private boolean esNuevo = true;
    @FXML
    private TextField txtcod;
    @FXML
    private Button btonvalidar;
    @FXML
    private VBox vbox;
    @FXML
    private TextField txttitulo;
    @FXML
    private TextField txtautor;
    @FXML
    private TextField txtcant;
    @FXML
    private HBox bloqueA;
    @FXML
    private HBox bloqueB;
    @FXML
    private Label lblcant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        libros = Libro.cargarDatos();
    }    

    @FXML
    private void validar() {
        String codigo = txtcod.getText();
        if(!codigo.isEmpty()){
            Libro lb = new Libro(codigo);
            if(libros.contains(lb)){
                esNuevo = false;
                vbox.getChildren().remove(bloqueA);
                vbox.getChildren().remove(bloqueB);
                lblcant.setText("# de tomos a agregar:");
            }
            txtcod.setDisable(true);
            vbox.setVisible(true);
            btonvalidar.setDisable(true);
            btonvalidar.setVisible(false);
        }
        
    }

    @FXML
    private void guardar() {
        String codigo = txtcod.getText();
        String cantidad = txtcant.getText();
        if(esNuevo){
            String titulo = txttitulo.getText();
            String autor = txtautor.getText();
            if(!titulo.isEmpty() && !autor.isEmpty() && isNumeric(cantidad)){
                libros.add(new Libro(codigo,titulo,autor,Integer.parseInt(cantidad)));
                alerta();
            }else{
                vacio();
            }
        }else{
            if(isNumeric(cantidad)){   
                Libro lb = new Libro(codigo);
                int indice = libros.indexOf(lb);
                libros.get(indice).aumentarTomos(Integer.parseInt(cantidad));
                alerta();
            }else{
                vacio();
            }         
            
        }

    }
    private void vacio(){
        Alert vacio= new Alert(Alert.AlertType.INFORMATION);
        vacio.setTitle("Información de campo no ingresado.");             
        vacio.setHeaderText("Campo sin llenar.");
        vacio.setContentText("Llene todos los campos con sus tipos correspondientes.");
        vacio.showAndWait();
    }
    
    private void alerta(){
        Libro.guardarDatos(libros);
        Alert alerta= new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Guardado exitoso");  
        alerta.setHeaderText("Guardado exitoso");
        alerta.showAndWait();
        try {
            App.setRoot("menuadmin");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void regresar() throws IOException {
        App.setRoot("menuadmin");
    }
    
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
}
