module com.example.kurwaaa {
    requires javafx.controls;
    requires javafx.fxml;

    requires javafx.graphics;

//    requires org.controlsfx.controls;
//    requires com.dlsc.formsfx;
//    requires org.kordamp.bootstrapfx.core;

    opens com.example.kurwaaa to javafx.fxml;
    exports com.example.kurwaaa;
}