/**
 / Constrolador dos popups "Sobre"
 **/

import javafx.scene.control.*;
import javafx.stage.Stage;


public class PopUpSobreController {

    public void fecharTela()
    {
        Stage stage = (Stage) botaoFechar.getScene().getWindow();
        stage.close();
    }

    public Button botaoFechar;
}
