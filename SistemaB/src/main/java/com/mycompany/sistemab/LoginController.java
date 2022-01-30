
package com.mycompany.sistemab;

import com.mycompany.model.Administrador;
import com.mycompany.model.Estudiante;
import com.mycompany.model.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class LoginController implements Initializable {
    private ArrayList<Usuario> usuarios;
    @FXML
    private TextField txtuser;
    @FXML
    private PasswordField txtpass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        usuarios = Usuario.cargarDatos();
    }    

    @FXML
    private void iniciar() {
        String user = txtuser.getText();
        String pass = txtpass.getText();
        if(!user.isEmpty() && !pass.isEmpty()){
            try {
                validar(user,pass);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }else{
            Alert vacio= new Alert(Alert.AlertType.INFORMATION);
            vacio.setTitle("Información de campo no ingresado.");             
            vacio.setHeaderText("Campo sin llenar.");
            vacio.setContentText("Llene todos los campos.");
            vacio.showAndWait();
        }
    }
    
    private void validar(String user, String pass) throws IOException{
        if(usuarios.contains(new Estudiante(user,pass))){
            int i = usuarios.indexOf(new Estudiante(user,pass));
            System.out.println(usuarios.get(i));
            FXMLLoader ventana= new FXMLLoader(App.class.getResource("menuestudiante.fxml"));  
            Parent root =(Parent) ventana.load();
            MenuestudianteController c2 = ventana.getController();
            c2.setEst((Estudiante) usuarios.get(i));
            App.cambiaRoot(root);
            
        }else if(usuarios.contains(new Administrador(user,pass))){
            App.setRoot("menuadmin");
        
        }else{
            Alert vacio= new Alert(Alert.AlertType.INFORMATION);
            vacio.setTitle("Información.");             
            vacio.setHeaderText("Usuario.");
            vacio.setContentText("Credenciales inválidas.");
            vacio.showAndWait();
        }
    }
    
    
}
