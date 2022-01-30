
package com.mycompany.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author USER
 */
public class Usuario implements Serializable{
    protected String usuario;
    protected String password;

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

    
    public static ArrayList<Usuario> cargarDatos(){
        ArrayList<Usuario> lista = new ArrayList<>();
        try(ObjectInputStream ob = new ObjectInputStream(new FileInputStream("src/main/resources/com/mycompany/sistemab/usuarios.ser"))){
            lista = (ArrayList<Usuario>) ob.readObject();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    
    
    public static void guardarDatos(ArrayList<Usuario> lista){
        try(ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("src/main/resources/com/mycompany/sistemab/usuarios.ser"))){
            ob.writeObject(lista);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", password=" + password + '}';
    }
    
    
    
}
