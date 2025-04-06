
package consultoriodental;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AppPrincipal extends Application{
    
    
    @Override
    public void start(Stage PrincipalStage)throws Exception{
        //throw new UnsupportedOperationException("Aun no soportado"); // al activar esto muere el parent root
       
        //Parent root = FXMLLoader.load(getClass().getResource("/Login/VistaLogin.fxml"));

        //Parent root = FXMLLoader.load(getClass().getResource("ListaPacientes/VistaListaPacientes.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("AgendarCita/VistaAgendarCita.fxml"));
        PrincipalStage.setTitle("Inicio Sesion");
        PrincipalStage.setScene(new Scene(root));
        PrincipalStage.setResizable(false);

        PrincipalStage.show();   
    }
    public static void main(String[] args) {
        launch(args);
    }
}
