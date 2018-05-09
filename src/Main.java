import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application
{
    public static void main (String args[])
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("PopUpBoasVindas.fxml"));
        primaryStage.setTitle("Ruas Inteligentes - Trabalho Final Orientação a Objetos");
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }
}