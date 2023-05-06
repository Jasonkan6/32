package src.main.java;

 

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.text.DecimalFormat;
import java.util.Vector;


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
    int Labor_Rose = 5;     // mins, labor consumption to make a quart (Litre) of wine
    int Labor_Noir = 12;    // mins
    int Grape_Rose = 6;     // kgs, grape consumption to make a quart (Litre) of wine
    int Grape_Noir = 4;     // kgs
    int Prod_Cap = 5000;    // litre

    public void initialize() {
        compInit initializer = new compInit();
        weekOfYear_tf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                if (initializer.component_init(weekOfYear_tf, true, true, 2315, true, 2301) == true)
                {
                    weekOfYear = Integer.parseInt(weekOfYear_tf.getText());
                }
            }
        });

        Cap_Labor_tf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                if (initializer.component_init(Cap_Labor_tf, true, false, 0, true, 0)==true)
                {
                    Cap_Labor = Integer.parseInt(Cap_Labor_tf.getText());
                }
            }
        });

        Cap_Grape_tf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                if (initializer.component_init(Cap_Grape_tf, true, false, 0, true, 0)==true)
                {
                    Cap_Grape = Integer.parseInt(Cap_Grape_tf.getText());
                }
            }
        });

        Prc_Rose_tf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                if (initializer.component_init(Prc_Rose_tf, false, false, 0, true, 0)==true)
                {
                    Prc_Rose = Double.parseDouble(Prc_Rose_tf.getText());
                    DecimalFormat df = new DecimalFormat("#,##0.00");
                    String formattedNumber = df.format(Prc_Rose);
                    Prc_Rose_tf.setText(formattedNumber);
                }
            }
        });

        Prc_Noir_tf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                if (initializer.component_init(Prc_Noir_tf, false, false, 0, true, 0)==true)
                {
                    Prc_Noir = Double.parseDouble(Prc_Noir_tf.getText());
                    DecimalFormat df = new DecimalFormat("#,##0.00");
                    String formattedNumber = df.format(Prc_Noir);
                    Prc_Noir_tf.setText(formattedNumber);
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
        else { // All user input is filled
            getDefaultValue();

            Vector<Integer> Opt_Sol = getOpt(Cap_Grape, Grape_Rose, Grape_Noir, Labor_Rose, Labor_Noir, Cap_Labor, Prc_Rose, Prc_Noir);
            Integer Opt_Rose = Opt_Sol.get(0);
            Integer Opt_Noir = Opt_Sol.get(1);
            Integer Opt_Total_Revenue = Opt_Sol.get(2);

            int Sur_Labor = Cap_Labor-(Opt_Rose*Labor_Rose+Opt_Noir*Labor_Noir);
            int  Sur_Grape = Cap_Grape-(Opt_Rose*Grape_Rose+Opt_Noir*Grape_Noir);

            if (Sur_Labor>0 && Sur_Labor<Labor_Rose && Sur_Labor<Labor_Noir)
            {
                Sur_Labor = 0;
            }
            if (Sur_Grape>0 && Sur_Grape<Grape_Rose && Sur_Grape<Grape_Noir)
            {
                Sur_Grape = 0;
            }

            Opt_Rose_txt.setText(Integer.toString(Opt_Rose));
            Opt_Noir_txt.setText(Integer.toString(Opt_Noir));
            Opt_Total_txt.setText(Integer.toString(Opt_Rose+Opt_Noir));
            Opt_Total_Revenue_txt.setText(Integer.toString(Opt_Total_Revenue));
            Opt_Labor_Surplus_txt.setText(Integer.toString(Sur_Labor));
            Opt_Grape_Surplus_txt.setText(Integer.toString(Sur_Grape));

            // System message
            SysMessenger msg = new SysMessenger();
            Vector<String> Sys_Msgs = new Vector<>();
            if (Prod_Cap < Opt_Rose+Opt_Noir)
            {
                Sys_Msgs.add("w1: Insufficient production capacity to produce the optimal mix, please reduce or adjust the capacity of labor & grape volume!");
            }
            if (Opt_Rose*Grape_Rose + Opt_Noir*Grape_Noir < 0.9*Cap_Grape)
            {
                Sys_Msgs.add("w2: Insufficient labor supplied to utilize the grape resource (less than 90%)!");
            }
            if (Sur_Labor<0)
            {
                Sys_Msgs.add("Er1a: Program bug is occurred, Labor Consumption cannot greater than its capacity!");
            }
            if (Sur_Grape<0)
            {
                Sys_Msgs.add("Er1b: Program bug is occurred, Grape Consumption cannot greater than its capacity!");
            }
            msg.showSystemMessage(sys_msg_txt, Sys_Msgs);
        }
    }


    @FXML
    private void getDefaultValue()
    {
        if(weekOfYear_tf.getText() == ""){weekOfYear_tf.setText("2301");}
        if(Cap_Labor_tf.getText() == ""){Cap_Labor_tf.setText("12000"); Cap_Labor = Integer.parseInt(Cap_Labor_tf.getText());}
        if(Cap_Grape_tf.getText() == ""){Cap_Grape_tf.setText("5000"); Cap_Grape = Integer.parseInt(Cap_Grape_tf.getText());}
        if(Prc_Rose_tf.getText() == ""){Prc_Rose_tf.setText("12"); Prc_Rose = Double.parseDouble(Prc_Rose_tf.getText());}
        if(Prc_Noir_tf.getText() == ""){Prc_Noir_tf.setText("22"); Prc_Noir = Double.parseDouble(Prc_Noir_tf.getText());}
    }

    public Vector<Integer> getOpt(int Grape_Cap, int Rose_Grape, int Noir_Grape, int Rose_Labor, int Noir_Labor, int Labor_Cap, double Rose_Prc, double Noir_Prc)
    {
        int opt_rose = 0;
        int opt_noir = 0;
        double opt_rev = 0;
        for (int i = 0; i<=Grape_Cap/Rose_Grape; i++) // iterate through possible litres of grape rose
        {
            for (int j = 0; j<=Grape_Cap/Noir_Grape; j++) // iterate through possible litres of grape noir
            {
                if (Rose_Grape*i+Noir_Grape*j<=Grape_Cap && i*Rose_Labor+j*Noir_Labor<=Labor_Cap)
                {
                    double revenue = i*Rose_Prc + j*Noir_Prc;
                    if (revenue>opt_rev)
                    {
                        opt_rose = i;
                        opt_noir = j;
                        opt_rev = revenue;
                    }
                }
            }
        }
        Vector<Integer> Opt = new Vector<>();
        Opt.add(opt_rose);
        Opt.add(opt_noir);
        Opt.add((int)opt_rev);
        return Opt;
    }


}