package src.main.java;

 

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.text.Text;

import javafx.beans.value.ChangeListener;

 

public class functionBController {

 

    @FXML

    private TextField Cap_Grape_tf;

 

    @FXML

    private TextField Cap_Labor_tf;

 

    @FXML

    private Text Opt_Grape_Surplus_txt;

 

    @FXML

    private Text Opt_Labor_Surplus_txt;

 

    @FXML

    private Text Opt_Noir_txt;

 

    @FXML

    private Text Opt_Rose_txt;

 

    @FXML

    private Text Opt_Total_Revenue_txt;

 

    @FXML

    private Text Opt_Total_txt;

 

    @FXML

    private TextField Prc_Noir_tf;

 

    @FXML

    private TextField Prx_Rose_tf;

 

    @FXML

    private Button exit_btn;

 

    @FXML

    private Text field_Valid_txt;

 

    @FXML

    private Button run_btn;

 

    @FXML

    private Text sys_msg_txt;

 

    @FXML

    private Text title;

 

    @FXML

    private TextField weekOfYear_tf;

    public void initialize() {
        weekOfYear_tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    if (2301 > Integer.parseInt(newValue) || 2315 < Integer.parseInt(newValue)) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("error");
                        alert.setHeaderText("input error");
                        alert.setContentText("Please enter an integer greater than 2301 and less than 2315");
                        alert.showAndWait();
                        weekOfYear_tf.setText("");
                    } else {
                        Integer weekOfYear = Integer.parseInt(newValue);
                        System.out.println("weekOfYear: "+weekOfYear);
                    }
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("error");
                    alert.setHeaderText("input error");
                    alert.setContentText("Please enter the number greater than 2301 and less than 2315");
                    alert.showAndWait();
                    weekOfYear_tf.setText("");
                }
            }
        });
        Cap_Labor_tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    if (0 > Integer.parseInt(newValue)) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("error");
                        alert.setHeaderText("input error");
                        alert.setContentText("Please enter an integer greater than 0");
                        alert.showAndWait();
                        Cap_Labor_tf.setText("");
                    } else {
                        Integer Cap_Labor = Integer.parseInt(newValue);
                        System.out.println("Cap Labor: "+Cap_Labor);
                    }
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("error");
                    alert.setHeaderText("input error");
                    alert.setContentText("Please enter the number greater than 0");
                    alert.showAndWait();
                    Cap_Labor_tf.setText("");
                }
            }
        });
        Cap_Grape_tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    if (0 > Integer.parseInt(newValue)) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("error");
                        alert.setHeaderText("input error");
                        alert.setContentText("Please enter an integer greater than 0");
                        alert.showAndWait();
                        Cap_Grape_tf.setText("");
                    } else {
                        Integer Cap_Grape = Integer.parseInt(newValue);
                        System.out.println("Cap_Grape: "+Cap_Grape);
                    }
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("error");
                    alert.setHeaderText("input error");
                    alert.setContentText("Please enter the number greater than 0");
                    alert.showAndWait();
                    Cap_Grape_tf.setText("");
                }
            }
        });
    }
 

    @FXML
    void exit_buttonPressed(ActionEvent event) {
        Main.stage.setScene(Main.scene);
    }

 

    @FXML
    void run_buttonPressed(ActionEvent event) {

    }

 

}