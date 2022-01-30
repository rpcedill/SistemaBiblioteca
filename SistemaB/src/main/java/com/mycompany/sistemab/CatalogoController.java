
package com.mycompany.sistemab;

import com.mycompany.model.Estudiante;
import com.mycompany.model.Libro;
import com.mycompany.model.LibroPrestado;
import com.mycompany.model.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class CatalogoController implements Initializable {
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<LibroPrestado> seleccionados;
    private Estudiante est;
    @FXML
    private FlowPane pane;
    @FXML
    private Button btnreserva;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        seleccionados = new ArrayList<>();
        usuarios = Usuario.cargarDatos();
        libros = Libro.cargarDatos();
        pane.setHgap(10);
        pane.setVgap(10);
        for(Libro lb: libros){
            if(lb.getCantidadDisponible()>0){
                VBox vbox3 = new VBox(10);
                vbox3.setAlignment(Pos.CENTER);
                vbox3.setPrefWidth(180);
                vbox3.setPrefHeight(180);
                Label cod = new Label("Codigo: "+lb.getCodigo()+"\n");
                Label tit = new Label("Titulo: "+lb.getTitulo()+"\n");
                Label aut = new Label("Autor: "+lb.getAutor()+"\n");
                Label can = new Label("Cantidad Disponible: "+lb.getCantidadDisponible()+"\n");
                vbox3.getChildren().add(cod);
                vbox3.getChildren().add(tit);
                vbox3.getChildren().add(aut);
                vbox3.getChildren().add(can);
                vbox3.setStyle("-fx-border-color: black" );
                pane.getChildren().add(vbox3);
                vbox3.setOnMouseClicked(new ManejadorEvento(vbox3,lb,can));
            }
        }
        
        
    }    

    @FXML
    private void regresar() throws IOException {
        FXMLLoader ventana= new FXMLLoader(App.class.getResource("menuestudiante.fxml"));  
        Parent root =(Parent) ventana.load();
        MenuestudianteController c2 = ventana.getController();
        c2.setEst(est);
        App.cambiaRoot(root);
    }

    @FXML
    private void prestar() {
        Alert alerta= new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Confirmación");             
        alerta.setHeaderText("Prestar los libros seleccionados.");
        alerta.setContentText("¿Esta seguro?");
        Optional<ButtonType> resultado = alerta.showAndWait();
        if(resultado.isPresent() && resultado.get()== ButtonType.OK){
            int indice = usuarios.indexOf(est);
            for(LibroPrestado lb: seleccionados){
                est.addLibro(lb);
            }
            usuarios.set(indice, est);
            Usuario.guardarDatos(usuarios);
            Libro.guardarDatos(libros);
            try {
                regresar();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private class ManejadorEvento implements EventHandler{
        private VBox vbox;
        private Libro lb;
        private Label can;

        public ManejadorEvento(VBox vbox, Libro lb, Label can) {
            this.vbox = vbox;
            this.lb = lb;
            this.can = can;
        }
        
        @Override
        public void handle(Event t) {
            LibroPrestado lba = new LibroPrestado(lb.getCodigo(),lb.getTitulo(), lb.getAutor(),lb.getCantidadDisponible());
            int indice = usuarios.indexOf(est);
            Estudiante e = (Estudiante) usuarios.get(indice);
            if(!e.getLibrosP().contains(lba)){
                indice = libros.indexOf(lb);
                libros.get(indice).reservar();
                seleccionados.add(lba);
                can.setText("Cantidad Disponible: "+String.valueOf(lb.getCantidadDisponible())+"\n");
                vbox.setDisable(true);
                vbox.setStyle("-fx-background-color: lightgreen" );
                btnreserva.setDisable(false);
            }else{
                Alert alerta= new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Información Libro.");             
                alerta.setHeaderText("Usuario");
                alerta.setContentText("El usuario: "+est.getUsuario()+" ya ha prestado un ejemplar de este libro.");
                alerta.showAndWait();
            }
            
        }
        
    }

    public void setEst(Estudiante esti) {
        this.est = esti;
    }
}
