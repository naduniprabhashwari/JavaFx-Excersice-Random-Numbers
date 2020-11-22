package sample;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class Controller {

    @FXML
    private GridPane gridPane;
    @FXML
    private Label lblone;
    @FXML
    private Label lbltwo;
    @FXML
    private Label lblthree;
    @FXML
    private Label lblfour;
    @FXML
    private Label lblfive;
    @FXML
    private Label lblsix;
    @FXML
    private Label lblseven;
    @FXML
    private Label lbleight;
    @FXML
    private Label lblnine;

    static List<Integer> finalist = new ArrayList<>();


    public void listing(){
        int number = 0;
        number = (int) (Math.random()*(9 - 1)) + 1;

        while ((finalist.contains(number))) {
            number = 1 + (int) (Math.random() * ((9 - 1) + 1));
        }

        finalist.add(number);
    }

    static int number = 0;
    public void showplaces(){
        List<Node> nodes = gridPane.getChildren().subList(9,18);

        if (!(finalist.size() == 9)){
            listing();
            Label label = (Label) nodes.get(number);
            label.setText(Integer.toString(finalist.get(number)));
            number++;
        }else {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("Finished filling the labels");
            a.showAndWait();
            Stage primaryStage = (Stage) gridPane.getScene().getWindow();
            primaryStage.close();
        }

    }
}
