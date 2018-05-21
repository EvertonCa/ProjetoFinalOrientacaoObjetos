/**
 / Constrolador dos popups de aviso de veiculos que chegaram no destino
 **/

import javafx.scene.control.*;
import javafx.stage.Stage;

public class PopUpChegou {

    public void fecharTela1()
    {
        Stage stage = (Stage) ok1.getScene().getWindow();
        stage.close();
    }

    public void fecharTela2()
    {
        Stage stage = (Stage) ok2.getScene().getWindow();
        stage.close();
    }

    public void fecharTela3()
    {
        Stage stage = (Stage) ok3.getScene().getWindow();
        stage.close();
    }

    public void fecharTela4()
    {
        Stage stage = (Stage) ok4.getScene().getWindow();
        stage.close();
    }

    public void fecharTela5()
    {
        Stage stage = (Stage) ok5.getScene().getWindow();
        stage.close();
    }

    public Button ok1, ok2, ok3, ok4, ok5;
}
