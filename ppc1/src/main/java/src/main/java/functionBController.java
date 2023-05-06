package src.main.java;

 

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.text.Text;

import java.text.DecimalFormat;


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

    private TextField Prc_Rose_tf;

 

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

    Integer weekOfYear = -1;
    Integer Cap_Labor = -1;
    Integer Cap_Grape = -1;
    double Prc_Rose = -1;
    double Prc_Noir = -1;

    public void initialize() {
        weekOfYear_tf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                if (weekOfYear_tf.getText().isEmpty()) { // input nothing
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("input error");
                    alert.setContentText("Please enter an integer greater than 2301 and less than 2315");
                    alert.showAndWait();
                } else {
                    if (2301 > Integer.parseInt(weekOfYear_tf.getText()) || 2315 < Integer.parseInt(weekOfYear_tf.getText())) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("error");
                        alert.setHeaderText("input error");
                        alert.setContentText("Please enter an integer greater than 2301 and less than 2315");
                        alert.showAndWait();
                        weekOfYear_tf.setText("");
                    } else { // desired input
                        weekOfYear = Integer.parseInt(weekOfYear_tf.getText());
                    }
                }
            }
        });

        Cap_Labor_tf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                if (Cap_Labor_tf.getText().isEmpty()) { // input nothing
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("input error");
                    alert.setContentText("Please enter an integer greater than 0");
                    alert.showAndWait();
                } else {
                    if (0 > Integer.parseInt(Cap_Labor_tf.getText())) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("error");
                        alert.setHeaderText("input error");
                        alert.setContentText("Please enter an integer greater than 0");
                        alert.showAndWait();
                        Cap_Labor_tf.setText("");
                    } else { // desired input
                        Cap_Labor = Integer.parseInt(Cap_Labor_tf.getText());
                    }
                }
            }
        });

        Cap_Grape_tf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                if (Cap_Grape_tf.getText().isEmpty()) { // input nothing
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("input error");
                    alert.setContentText("Please enter an integer greater than 0");
                    alert.showAndWait();
                } else {
                    if (0 > Integer.parseInt(Cap_Grape_tf.getText())) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("error");
                        alert.setHeaderText("input error");
                        alert.setContentText("Please enter an integer greater than 0");
                        alert.showAndWait();
                        Cap_Grape_tf.setText("");
                    } else { // desired input
                        Cap_Grape = Integer.parseInt(Cap_Grape_tf.getText());
                    }
                }
            }
        });

        Prc_Rose_tf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                if (Prc_Rose_tf.getText().isEmpty()) { // input nothing
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("input error");
                    alert.setContentText("Please enter a decimal number greater than 0.");
                    alert.showAndWait();
                } else {
                    try {
                        if (0 > Double.parseDouble(Prc_Rose_tf.getText())) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("error");
                            alert.setHeaderText("input error");
                            alert.setContentText("Please enter a decimal number greater than 0.");
                            alert.showAndWait();
                            Prc_Rose_tf.setText("");
                        } else { // desired input
                            Prc_Rose = Double.parseDouble(Prc_Rose_tf.getText());
                            DecimalFormat df = new DecimalFormat("#,##0.00");
                            String formattedNumber = df.format(Prc_Rose);
                            Prc_Rose_tf.setText(formattedNumber);
                            System.out.println("Prc Rose: "+formattedNumber);
                        }
                    }
                    catch (IllegalArgumentException e) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("error");
                        alert.setHeaderText("input error");
                        alert.setContentText("Please enter a decimal number greater than 0.");
                        alert.showAndWait();
                        Prc_Rose_tf.setText("");
                    }
                }
            }
        });

        Prc_Noir_tf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                if (Prc_Noir_tf.getText().isEmpty()) { // input nothing
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("input error");
                    alert.setContentText("Please enter a decimal number greater than 0.");
                    alert.showAndWait();
                } else {
                    try {
                        if (0 > Double.parseDouble(Prc_Noir_tf.getText())) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("error");
                            alert.setHeaderText("input error");
                            alert.setContentText("Please enter a decimal number greater than 0.");
                            alert.showAndWait();
                            Prc_Noir_tf.setText("");
                        } else { // desired input
                            Prc_Noir = Double.parseDouble(Prc_Noir_tf.getText());
                            DecimalFormat df = new DecimalFormat("#,##0.00");
                            String formattedNumber = df.format(Prc_Noir);
                            Prc_Noir_tf.setText(formattedNumber);
                            System.out.println("Prc Rose: "+formattedNumber);
                        }
                    }
                    catch (IllegalArgumentException e) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("error");
                        alert.setHeaderText("input error");
                        alert.setContentText("Please enter a decimal number greater than 0.");
                        alert.showAndWait();
                        Prc_Noir_tf.setText("");
                    }
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
        if (weekOfYear_tf.getText()==""|| Cap_Labor_tf.getText()=="" || Cap_Grape_tf.getText()=="" || Prc_Rose_tf.getText()=="" || Prc_Noir_tf.getText()=="")
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("error");
            alert.setHeaderText("input error");
            alert.setContentText("Please input all the necessary information.");
            alert.showAndWait();
        }
        else {
            System.out.println("run");
            System.out.println("weekOfYear: "+weekOfYear);
            System.out.println("Cap Labor: "+Cap_Labor); // mins
            System.out.println("Cap Grape: "+Cap_Grape); // kgs
            System.out.println("Prc Rose: "+Prc_Rose);
            System.out.println("Prc Noir: "+Prc_Noir);

            int Labor_Rose = 5;     // mins, labor consumption to make a quart (Litre) of wine
            int Labor_Noir = 12;    // mins
            int Grape_Rose = 6;     // kgs, grape consumption to make a quart (Litre) of wine
            int Grape_Noir = 4;     // kgs
            double Opt_Total_Revenue = 0;
            int Opt_Noir = 0;
            int Opt_Rose = 0;

            for (int i = 0; i<=Cap_Grape/Grape_Rose; i++) // iterate through possible litres of grape rose
            {
                for (int j = 0; j<=Cap_Grape/Grape_Noir; j++) // iterate through possible litres of grape noir
                {
                    System.out.println(6*i+4*j<=Cap_Grape && 5*Labor_Rose+12*Labor_Noir<=Cap_Labor);
                    if (6*i+4*j<=Cap_Grape && 5*Labor_Rose+12*Labor_Noir<=Cap_Labor)
                    {
                        double revenue = i*Prc_Rose + j*Prc_Noir;
                        System.out.println("revenue: "+revenue);
                        if (revenue>Opt_Total_Revenue)
                        {
                            Opt_Rose = i;
                            Opt_Noir = j;
                            Opt_Total_Revenue = revenue;
                        }
                    }
                }

            }

            Opt_Rose_txt.setText(Integer.toString(Opt_Rose));
            Opt_Noir_txt.setText(Integer.toString(Opt_Noir));
            Opt_Total_txt.setText(Integer.toString(Opt_Rose+Opt_Noir));
            Opt_Total_Revenue_txt.setText(Double.toString(Opt_Total_Revenue));

        }
    }

}