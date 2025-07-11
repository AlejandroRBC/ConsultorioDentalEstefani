/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package consultoriodental.Paciente.ListaPacientes;

import consultoriodental.Modelos.ModeloPaciente;
import com.mysql.jdbc.Statement;
import consultoriodental.Modelos.ConexionBD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerListaPacientes implements Initializable {
    @FXML
    private TableColumn<ModeloPaciente, String> tcAdeudado;

    @FXML
    private TableColumn<ModeloPaciente, String> tcNroTratamientos;
    
    @FXML
    private TableColumn<ModeloPaciente, String> tcNombre;

    @FXML
    private TableColumn<ModeloPaciente, String> tcPaterno;

    @FXML
    private TableColumn<ModeloPaciente, String> tcTelefono;

    @FXML
    private TableView<ModeloPaciente> tvPacientes;
    
    private ObservableList<ModeloPaciente> listapacientes = FXCollections.observableArrayList();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcPaterno.setCellValueFactory(new PropertyValueFactory<>("paterno"));
        tcTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        
        tcNroTratamientos.setCellValueFactory(celldata -> null);
        tcAdeudado.setCellValueFactory(celldata -> null);   
        Cargarpacientes();
    }
    public void Cargarpacientes(){
        listapacientes.clear();
        String consulta = "SELECT * FROM paciente";
        try (Connection conn = ConexionBD.getConexion();
                PreparedStatement pstmt = conn.prepareStatement(consulta);
                ResultSet rs = pstmt.executeQuery();){
             while (rs.next()) {
                int id = rs.getInt("ID_paciente");
                String nombre = rs.getString("nombre");
                String paterno = rs.getString("paterno");
                String materno = rs.getString("materno");
                String fecha_nac = rs.getString("Fecha_Nac");
                String telefono = rs.getString("nro_telefono");
                ModeloPaciente auxPaciente = new ModeloPaciente(nombre, paterno, materno, fecha_nac, telefono);
                listapacientes.add(auxPaciente);
            }
            tvPacientes.setItems(listapacientes);
        } catch (Exception e) {
            System.out.println("No se conecto a la BD :" + e);
        }
    }

    @FXML
    void SeleccionarPaciente(ActionEvent event) {
        
        ModeloPaciente aux = tvPacientes.getSelectionModel().getSelectedItem();
        if (aux!=null) {
            System.out.println(aux.toString());
        }else{
        }
    }
}
