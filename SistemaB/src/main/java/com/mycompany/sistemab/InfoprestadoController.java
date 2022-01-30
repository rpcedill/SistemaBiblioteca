
package com.mycompany.sistemab;

import com.mycompany.model.Estudiante;
import com.mycompany.model.LibroPrestado;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class InfoprestadoController implements Initializable {
    private ArrayList<LibroPrestado> librosPrestados;
    private Estudiante est;
    @FXML
    private Label lblnombre;
    @FXML
    private TableView<LibroPrestado> loslibros;
    @FXML
    private TableColumn<LibroPrestado, String> coltitulo;
    @FXML
    private TableColumn<LibroPrestado, String> colautor;
    @FXML
    private TableColumn<LibroPrestado, LocalDate> colemision;
    @FXML
    private TableColumn<LibroPrestado, LocalDate> colDevolucion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void regresar() throws IOException {
        FXMLLoader ventana= new FXMLLoader(App.class.getResource("menuestudiante.fxml"));  
        Parent root =(Parent) ventana.load();
        MenuestudianteController c2 = ventana.getController();
        c2.setEst(est);
        App.cambiaRoot(root);
    }

    public void setEst(Estudiante esti) {
        this.est = esti;
        carga();
        
    }
    private void carga(){
        librosPrestados = est.getLibrosP();
        coltitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colautor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colemision.setCellValueFactory(new PropertyValueFactory<>("fechaEmision"));
        colDevolucion.setCellValueFactory(new PropertyValueFactory<>("fechaDevolución"));
        loslibros.getItems().setAll(librosPrestados);
        lblnombre.setText(est.getUsuario());
    }
    
    
}
