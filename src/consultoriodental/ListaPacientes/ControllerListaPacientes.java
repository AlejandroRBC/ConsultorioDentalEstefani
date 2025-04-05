/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package consultoriodental.ListaPacientes;

import com.mysql.jdbc.Statement;
import consultoriodental.ConexionBD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                ResultSet rs = pstmt.executeQuery();
                        ){
             while (rs.next()) {
                String nombre = rs.getString("nombre");
                String paterno = rs.getString("paterno");
                String telefono = rs.getString("nro_telefono");
                
                String adeudado = "deuda ";
                String nrotrat = "5 tratas";
                
                System.out.println("----PACIENTE:");
                ModeloPaciente auxPaciente = new ModeloPaciente(nombre, paterno, telefono,adeudado,nrotrat);
                auxPaciente.toString();
                listapacientes.add(auxPaciente);
            }
            tvPacientes.setItems(listapacientes);
        } catch (Exception e) {
            System.out.println("No se conecto a la BD :" + e);
        }
    }
    
    
}
