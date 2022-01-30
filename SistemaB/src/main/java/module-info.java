module com.mycompany.sistemab {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.sistemab to javafx.fxml;
    exports com.mycompany.sistemab;
    
    opens com.mycompany.model to javafx.fxml;
    exports com.mycompany.model;
}
