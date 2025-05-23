module co.edu.poli.proyectoe3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.poli.proyectoe3.vista to javafx.fxml;
    opens co.edu.poli.proyectoe3.controlador to javafx.fxml;
    exports co.edu.poli.proyectoe3.vista;
    exports co.edu.poli.proyectoe3.controlador;
}
