package com.mycompany.sistemab;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"), 640, 480);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
//        ArrayList<Usuario> a = new ArrayList<>();
//        a.add(new Administrador("admin","admin123"));
//        a.add(new Estudiante("estudiante1","123"));
//        a.add(new Estudiante("estudiante2","456"));
//        a.add(new Estudiante("estudiante3","789"));
//        
//        try(ObjectOutputStream bf = new ObjectOutputStream(new FileOutputStream("src/main/resources/com/mycompany/sistemab/usuarios.ser"))){
//            bf.writeObject(a);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        
//        ArrayList<Libro> b = new ArrayList<>();
//        b.add(new Libro("001","Viaje al fin de la noche","Louis-Ferdinand Céline",10));
//        b.add(new Libro("005","Don Quijote de la Mancha","Don Quijote de la Mancha",7));
//        b.add(new Libro("003","Los cuentos de Canterbury","Geoffrey Chaucer",5));
//        b.add(new Libro("010","Relatos cortos","Antón Chéjov",12));
//        b.add(new Libro("015","Divina Comedia","Dante Alighieri",8));
//        try(ObjectOutputStream bf = new ObjectOutputStream(new FileOutputStream("src/main/resources/com/mycompany/sistemab/libros.ser"))){
//            bf.writeObject(b);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
        launch();
    }
    
    static void cambiaRoot (Parent rootnode){
        scene.setRoot(rootnode);
    }

    

}