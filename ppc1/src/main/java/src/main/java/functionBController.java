package src.main.java;

 

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.layout.VBox;
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

    public boolean component_init(TextField textField, boolean int_value, boolean upper_bounded, double upper_bound, boolean lower_bounded, double lower_bound)
    {
        try {
            if (!textField.getText().isEmpty()) {
                if ((lower_bounded && lower_bound > Integer.parseInt(textField.getText())) || (upper_bounded && upper_bound < Integer.parseInt(textField.getText()))) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("error");
                    alert.setHeaderText("input error");
                    String alertStr = "Please enter a";
                    alertStr+=(int_value)?"n integer":" number";
                    alertStr+=(lower_bounded)?(" greater than "):"";
                    alertStr+=(int_value)?((int)lower_bound):"";
                    alertStr+=(lower_bounded&&upper_bounded)?" and":"";
                    alertStr+=(upper_bounded)?(" less than "):".";
                    alertStr+=(int_value)?((int)upper_bound+"."):"";
                    alert.setContentText(alertStr);
                    alert.showAndWait();
                    textField.setText("");
                } else { // desired input
                    return true;
                }
            }
            return false;
        }
        catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("error");
            alert.setHeaderText("input error");
            alert.setContentText("Please enter an integer");
            alert.showAndWait();
            textField.setText("");
            return false;
        }
    }

    public void initialize() {
        weekOfYear_tf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                if (component_init(weekOfYear_tf, true, true, 2315, true, 2301) == true)
                {
                    weekOfYear = Integer.parseInt(weekOfYear_tf.getText());
                }
            }
        });

        Cap_Labor_tf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                if (component_init(Cap_Labor_tf, true, false, 0, true, 0)==true)
                {
                    Cap_Labor = Integer.parseInt(Cap_Labor_tf.getText());
                }
            }
        });

        Cap_Grape_tf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                if (component_init(Cap_Grape_tf, true, false, 0, true, 0)==true)
                {
                    Cap_Grape = Integer.parseInt(Cap_Grape_tf.getText());
                }
            }
        });

        Prc_Rose_tf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                if (component_init(Prc_Rose_tf, true, false, 0, true, 0)==true)
                {
                    Prc_Rose = Double.parseDouble(Prc_Rose_tf.getText());
                    DecimalFormat df = new DecimalFormat("#,##0.00");
                    String formattedNumber = df.format(Prc_Rose);
                    Prc_Rose_tf.setText(formattedNumber);
                    System.out.println("Prc Rose: "+formattedNumber);
                }
            }
        });

        Prc_Noir_tf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                if (component_init(Prc_Noir_tf, true, false, 0, true, 0)==true)
                {
                    Prc_Noir = Double.parseDouble(Prc_Noir_tf.getText());
                    DecimalFormat df = new DecimalFormat("#,##0.00");
                    String formattedNumber = df.format(Prc_Noir);
                    Prc_Noir_tf.setText(formattedNumber);
                    System.out.println("Prc Rose: "+formattedNumber);
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
            System.out.println("weekOfYear: "+weekOfYear);
            System.out.println("Cap_Labor: "+Cap_Labor);
            messageNumber = 0;

            int Labor_Rose = 5;     // mins, labor consumption to make a quart (Litre) of wine
            int Labor_Noir = 12;    // mins
            int Grape_Rose = 6;     // kgs, grape consumption to make a quart (Litre) of wine
            int Grape_Noir = 4;     // kgs
            int Prod_Cap = 5000;    //litre
            double Opt_Total_Revenue = 0;
            int Opt_Noir = 0;
            int Opt_Rose = 0;

            for (int i = 0; i<=Cap_Grape/Grape_Rose; i++) // iterate through possible litres of grape rose
            {
                for (int j = 0; j<=Cap_Grape/Grape_Noir; j++) // iterate through possible litres of grape noir
                {
                    if (Grape_Rose*i+Grape_Noir*j<=Cap_Grape && i*Labor_Rose+j*Labor_Noir<=Cap_Labor)
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

            int Sur_Labor = Cap_Labor-(Opt_Rose*Labor_Rose+Opt_Noir*Labor_Noir);
            int  Sur_Grape = Cap_Grape-(Opt_Rose*Grape_Rose+Opt_Noir*Grape_Noir);

            Opt_Rose_txt.setText(Integer.toString(Opt_Rose));
            Opt_Noir_txt.setText(Integer.toString(Opt_Noir));
            Opt_Total_txt.setText(Integer.toString(Opt_Rose+Opt_Noir));
            Opt_Total_Revenue_txt.setText(Double.toString(Opt_Total_Revenue));
            Opt_Labor_Surplus_txt.setText(Integer.toString(Sur_Labor));
            Opt_Grape_Surplus_txt.setText(Integer.toString(Sur_Grape));

            if (Prod_Cap < Opt_Rose+Opt_Noir)
            {
                showSystemMessage("w1: Insufficient production capacity to produce the optimal mix, please reduce or adjust the capacity of labor & grape volume!");
            }
            if (Opt_Rose*Grape_Rose + Opt_Noir*Grape_Noir < 0.9*Cap_Grape)
            {
                showSystemMessage("w2: Insufficient labor supplied to utilize the grape resource (less than 90%)!");
            }
            if (Sur_Labor<0)
            {
                showSystemMessage("Er1a: Program bug is occurred, Labor Consumption cannot greater than its capacity!");
            }
            if (Sur_Grape<0)
            {
                showSystemMessage("Er1b: Program bug is occurred, Grape Consumption cannot greater than its capacity!");
            }
        }
    }

    int messageNumber = 0;
    private void showSystemMessage(String message) {
        if (message != null && !message.isEmpty()) {
            messageNumber++;
            String messageText = messageNumber + ". " + message;
            if (sys_msg_txt.getText().isEmpty()) {
                sys_msg_txt.setText(messageText);
            } else {
                sys_msg_txt.setText(sys_msg_txt.getText() + "\n" + messageText);
            }
            sys_msg_txt.setVisible(true);
        }
    }

}