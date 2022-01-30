
package com.mycompany.sistemab;

import java.io.IOException;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MenuadminController{
   

    @FXML
    private void verlibros() throws IOException {
        App.setRoot("admin");
    }

    @FXML
    private void agglibro() throws IOException {
        App.setRoot("agglibro");
        
    }

    @FXML
    private void cerrar() throws IOException {
        App.setRoot("login");
    }
    
}
