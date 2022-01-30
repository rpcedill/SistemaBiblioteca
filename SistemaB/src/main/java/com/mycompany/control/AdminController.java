/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.control;

import com.mycompany.model.Libro;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    }    

    @FXML
    private void filtrar(ActionEvent event) {
    }

    @FXML
    private void limpiar(ActionEvent event) {
    }
    
}
