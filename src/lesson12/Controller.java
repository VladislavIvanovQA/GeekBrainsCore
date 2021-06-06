package lesson12;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class Controller {

    @FXML
    public HBox hbox;
    @FXML
    public TextField enterTextField;
    @FXML
    public HTMLEditor editor;

    @FXML
    public void initialize() {
        HBox.setHgrow(enterTextField, Priority.ALWAYS);
        enterTextField.requestFocus();

        editor.setVisible(false);
        Platform.runLater(() -> {
            Node[] nodes = editor.lookupAll(".tool-bar").toArray(new Node[0]);
            for (Node node : nodes) {
                node.setVisible(false);
                node.setManaged(false);
            }
            editor.setVisible(true);
        });
    }

    @FXML
    public void sendText(ActionEvent actionEvent) {
        enterTextField.requestFocus();
        if (enterTextField.getText().isEmpty()) {
            return;
        }
        editor.setHtmlText(editor.getHtmlText() + "<b>A. Pushkin</b>: " + enterTextField.getText() + "</p>");
        enterTextField.clear();
    }

    @FXML
    public void clickExit(ActionEvent actionEvent) {
        Platform.runLater(() -> {
            Stage stage = (Stage) editor.getScene().getWindow();
            stage.close();
        });
    }

    public void clearTextArea(ActionEvent actionEvent) {
        editor.setHtmlText("");
    }
}
