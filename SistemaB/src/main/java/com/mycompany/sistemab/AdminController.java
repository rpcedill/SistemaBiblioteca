
package com.mycompany.sistemab;

import com.mycompany.model.Libro;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AdminController implements Initializable {
    private ArrayList<Libro> libros;
    @FXML
    private TextField txtcod;
    @FXML
    private TableView<Libro> loslibros;
    @FXML
    private TableColumn<Libro, String> colcod;
    @FXML
    private TableColumn<Libro, String> coltitulo;
    @FXML
    private TableColumn<Libro, String> colautor;
    @FXML
    private TableColumn<Libro, Integer> colcant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        libros = Libro.cargarDatos();
        colcod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        coltitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colautor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colcant.setCellValueFactory(new PropertyValueFactory<>("cantidadDisponible"));
        loslibros.getItems().setAll(libros);
    }    

    @FXML
    private void filtrar() {
        String codigo = txtcod.getText();
        if(!codigo.isEmpty()){
            ArrayList<Libro> libros2 = new ArrayList<>();
            Libro lb = new Libro(codigo);
            if(libros.contains(lb)){
                int indice = libros.indexOf(lb);
                libros2.add(libros.get(indice));
                loslibros.getItems().setAll(libros2);
            }else{
                Alert vacio= new Alert(Alert.AlertType.INFORMATION);
                vacio.setTitle("Información.");             
                vacio.setHeaderText("Libro.");
                vacio.setContentText("Código no encontrado en el sistema.\nIngrese el código exacto.");
                vacio.showAndWait();
            }
        }else{
            Alert vacio= new Alert(Alert.AlertType.INFORMATION);
            vacio.setTitle("Información de campo no ingresado.");             
            vacio.setHeaderText("Campo sin llenar.");
            vacio.setContentText("Llene el campo del código.");
            vacio.showAndWait();
        }
    }

    @FXML
    private void limpiar() {
        loslibros.getItems().setAll(libros);        
    }

    @FXML
    private void regresar() throws IOException {
        App.setRoot("menuadmin");
    }
    
}
