import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BoasVindasController implements Initializable
{
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        new SplashScreen().start();
    }

    class SplashScreen extends Thread
    {
        @Override
        public void run()
        {
            try
            {
                Thread.sleep(1000);

                Platform.runLater(new Runnable() {
                    @Override
                    public void run()
                    {
                        Parent root = null;
                        try
                        {
                            root = FXMLLoader.load(getClass().getResource("AreaPrincipal.fxml"));
                        }catch (IOException ex)
                        {
                            return;
                        }
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setTitle("Ruas Inteligentes - Trabalho Final Orientação a Objetos");
                        stage.setScene(scene);
                        stage.show();
                        popup.getScene().getWindow().hide();
                    }
                });
            }catch (InterruptedException ex)
            {
                return;
            }
        }
    }

    public Pane popup;
}
