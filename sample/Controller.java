package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextArea textArea;
    @FXML
    private TextField textField;

    @FXML
    public void clickBtnSend(ActionEvent actionEvent) {
        textArea.appendText("Me: " + textField.getText() + "\n");
        textField.clear();
        textField.requestFocus();
    }
}
