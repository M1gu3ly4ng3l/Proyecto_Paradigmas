package co.edu.poli.proyectoe3.controlador;

import co.edu.poli.proyectoe3.modelo.*;
import co.edu.poli.proyectoe3.servicios.ImplementacionOperacion;
import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FormularioController {

    private ImplementacionOperacion operacion;
    private ImplementacionOperacion operacionSerializacion;
    Cuidado[] cuidados = {
        new Cuidado(1, "Riego", "Riego diario por la mañana", 1),
        new Cuidado(2, "Fertilización", "Abono orgánico semanal", 7)
    };

    RegistroCosecha[] registros = {
        new RegistroCosecha(101, "2024-10-1", 10.5, "Primera cosecha del ciclo"),
        new RegistroCosecha(102, "2024-11-1", 12.0, "Fruta madura y dulce")
    };

    @FXML
    private Button btnBuscar;

    @FXML
    private Button bttAgregar;

    @FXML
    private Button bttBorrar;

    @FXML
    private Button bttEditar;

    @FXML
    private Button bttSerializar;

    @FXML
    private Button bttdeserializar;

    @FXML
    private Button bttread;

    @FXML
    private Button bttreadAll;

    @FXML
    private TextField mostrarSerializar;

    @FXML
    private TextField mostrarborrar;

    @FXML
    private TextField mostrarcrear;

    @FXML
    private TextField mostrareditar;

    @FXML
    private Spinner<Integer> spinnerAnioCreacion;

    @FXML
    private Spinner<Integer> spinnerCantidadEditar;

    @FXML
    private Spinner<Double> spinnerPesoPromedio;

    @FXML
    private TextField txtCuidados, txtDescripcion, txtFrutaABorrar, txtFrutaEditar, txtFrutaleer, txtID, txtNombre,
            txtNombreRegistro, txtRegistros, txtVariedad;

    @FXML
    private TextArea txtListadoDeFrutas;

    @FXML
    private ComboBox<String> comboTipoFruta;

    @FXML
    private ComboBox<String> comboTipoFruta1;

    @FXML
    public void initialize() {
        operacion = new ImplementacionOperacion();
        operacionSerializacion = new ImplementacionOperacion();

        spinnerAnioCreacion.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1900, 2100, 2024));
        spinnerCantidadEditar.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, 1));
        spinnerPesoPromedio.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.1, 10.0, 0.5, 0.1));

        comboTipoFruta.getItems().addAll("Organica", "Exotica");
        comboTipoFruta1.getItems().addAll("Organica", "Exotica");
    }

    @FXML
    void buscar(ActionEvent event) {
        try {
            int id = Integer.parseInt(txtFrutaEditar.getText());
            Fruta f = operacion.read(id);
            if (f != null) {
                txtNombre.setText(f.getNombre());
                txtVariedad.setText(f.getVariedad());
                txtDescripcion.setText(f.getDescripcion());
                if (f instanceof FrutaOrganica) {
                    comboTipoFruta1.setValue("Organica");
                } else if (f instanceof FrutaExotica) {
                    comboTipoFruta1.setValue("Exotica");
                } else {
                    comboTipoFruta1.setValue("");
                }

                spinnerPesoPromedio.getValueFactory().setValue(f.getPesoPromedio());
                spinnerCantidadEditar.getValueFactory().setValue((int) f.getCantidadCosechada());
                spinnerAnioCreacion.getValueFactory().setValue(f.getAnioCreacion());
                mostrareditar.setText("Fruta encontrada");
                txtCuidados.setText(Arrays.toString(cuidados));
                txtRegistros.setText(Arrays.toString(registros));
            } else {
                mostrareditar.setText("No se encontró fruta");
            }
        } catch (Exception e) {
            mostrareditar.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    void delete(ActionEvent event) {
        try {
            int id = Integer.parseInt(txtFrutaABorrar.getText());
            Fruta f = operacion.delete(id);
            mostrarborrar.setText(f != null ? "Fruta eliminada" : "No se encontró fruta");
        } catch (Exception e) {
            mostrarborrar.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    void read(ActionEvent event) {
        try {
            int id = Integer.parseInt(txtFrutaleer.getText());
            Fruta f = operacion.read(id);
            txtListadoDeFrutas.setText(f != null ? f.toString() : "Fruta no encontrada");
        } catch (Exception e) {
            txtListadoDeFrutas.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    void readAll(ActionEvent event) {
        try {
            StringBuilder sb = new StringBuilder();
            for (Fruta f : operacion.readAll()) {
                sb.append(f.toString()).append("\n");
            }
            txtListadoDeFrutas.setText(sb.toString());
        } catch (Exception e) {
            txtListadoDeFrutas.setText("Error al leer todas las frutas");
        }
    }

    @FXML
    void create(ActionEvent event) {
        try {
            int id = Integer.parseInt(txtID.getText());
            String nombre = txtNombreRegistro.getText();
            String tipo = comboTipoFruta.getValue();

            Fruta nueva = null;

            if ("Organica".equalsIgnoreCase(tipo)) {
                nueva = new FrutaOrganica("Colombia", id, nombre, "", "", 0, 0, cuidados, registros, 0);
            } else if ("Exotica".equalsIgnoreCase(tipo)) {
                nueva = new FrutaExotica(true, id, nombre, "", "", 0, 0, cuidados, registros, 0);
            }

            if (nueva != null) {
                String msg = operacion.create(nueva);
                mostrarcrear.setText(msg);
            } else {
                mostrarcrear.setText("Tipo de fruta inválido");
            }
        } catch (Exception e) {
            mostrarcrear.setText("Error al crear: " + e.getMessage());
        }
    }

    @FXML
    void update(ActionEvent event) {
        try {
            int id = Integer.parseInt(txtFrutaEditar.getText());
            Fruta existente = operacion.read(id);

            if (existente != null) {
                String nombre = txtNombre.getText();
                String variedad = txtVariedad.getText();
                String descripcion = txtDescripcion.getText();
                double peso = spinnerPesoPromedio.getValue();
                double cantidad = spinnerCantidadEditar.getValue();
                int anio = spinnerAnioCreacion.getValue();
                String tipo = comboTipoFruta1.getValue();

                Fruta nueva = null;

                if ("Organica".equalsIgnoreCase(tipo)) {
                    nueva = new FrutaOrganica("Colombia", id, nombre, variedad, descripcion, peso, cantidad, cuidados, registros, anio);
                } else if ("Exotica".equalsIgnoreCase(tipo)) {
                    nueva = new FrutaExotica(true, id, nombre, variedad, descripcion, peso, cantidad, cuidados, registros, anio);
                }

                if (nueva != null) {
                    operacion.update(id, nueva);
                    mostrareditar.setText("Fruta actualizada");
                }
            } else {
                mostrareditar.setText("Fruta no encontrada para editar");
            }
        } catch (Exception e) {
            mostrareditar.setText("Error al editar: " + e.getMessage());
        }
    }

    @FXML
    void serializar(ActionEvent event) {
        Fruta[] frutas = operacion.readAll();
        String resultado = operacionSerializacion.serializar(frutas, "", "Frutas.dat");
        mostrarSerializar.setText(resultado);
    }

    @FXML
    void deserializar(ActionEvent event) {
        try {
            Fruta[] des = operacionSerializacion.deserializar("", "Frutas.dat");
            if (des != null) {
                operacion = new ImplementacionOperacion();
                for (Fruta f : des) {
                    operacion.create(f);
                }
                mostrarSerializar.setText("Frutas cargadas desde archivo");
            } else {
                mostrarSerializar.setText("No se pudieron cargar frutas");
            }
        } catch (Exception e) {
            mostrarSerializar.setText("Error: " + e.getMessage());
        }
    }
}
