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


public class functionBController extends Optimization{

 

    @FXML

    private TextField Cap_Grape_tf;

 

    @FXML

    private TextField Cap_Labor_tf;

 

    @FXML

    private TextField Opt_Grape_Surplus_txt;

 

    @FXML

    private TextField Opt_Labor_Surplus_txt;

 

    @FXML

    private TextField Opt_Noir_txt;

 

    @FXML

    private TextField Opt_Rose_txt;

 

    @FXML

    private TextField Opt_Total_Revenue_txt;

 

    @FXML

    private TextField Opt_Total_txt;

 

    @FXML

    private TextField Prc_Noir_tf;

 

    @FXML

    private TextField Prc_Rose_tf;

 

    @FXML

    private Button exit_btn;

 

    @FXML

    private TextField field_Valid_txt;

 

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

    public boolean initialize() {
        compInit initializer = new compInit();
        weekOfYear_tf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                String init = initializer.component_init(weekOfYear_tf, true, true, 2315, true, 2301);
                if (init == "desired")
                {
                    weekOfYear = Integer.parseInt(weekOfYear_tf.getText());
                }
                else if (init!="")
                {
                    initializer.gen_alert(init);
                }
            }
        });

        Cap_Labor_tf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                String init = initializer.component_init(Cap_Labor_tf, true, false, 0, true, 0);
                if (init == "desired")
                {
                    Cap_Labor = Integer.parseInt(Cap_Labor_tf.getText());
                }
                else if (init!="")
                {
                    initializer.gen_alert(init);
                }
            }
        });

        Cap_Grape_tf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                String init = initializer.component_init(Cap_Grape_tf, true, false, 0, true, 0);
                if (init=="desired")
                {
                    Cap_Grape = Integer.parseInt(Cap_Grape_tf.getText());
                }
                else if (init!="")
                {
                    initializer.gen_alert(init);
                }
            }
        });

        Prc_Rose_tf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                String init = initializer.component_init(Prc_Rose_tf, false, false, 0, true, 0);
                if (init=="desired")
                {
                    Prc_Rose = Double.parseDouble(Prc_Rose_tf.getText());
                    DecimalFormat df = new DecimalFormat("#,##0.00");
                    String formattedNumber = df.format(Prc_Rose);
                    Prc_Rose_tf.setText(formattedNumber);
                }
                else if (init!="")
                {
                    initializer.gen_alert(init);
                }
            }
        });

        Prc_Noir_tf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                String init = initializer.component_init(Prc_Noir_tf, false, false, 0, true, 0);
                if (init=="desired")
                {
                    Prc_Noir = Double.parseDouble(Prc_Noir_tf.getText());
                    DecimalFormat df = new DecimalFormat("#,##0.00");
                    String formattedNumber = df.format(Prc_Noir);
                    Prc_Noir_tf.setText(formattedNumber);
                }
                else if (init!="")
                {
                    initializer.gen_alert(init);
                }
            }
        });

        if (weekOfYear!=-1 && Cap_Labor!=-1 && Cap_Grape!= -1 && Prc_Rose!=-1 && Prc_Noir!=-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @FXML
    void exit_buttonPressed(ActionEvent event) {
        Main.stage.setScene(Main.scene);
    }

    @FXML
    void run_buttonPressed(ActionEvent event) {

        getDefaultValue();
        Object[] func_B = Opt_BC(Cap_Grape, Cap_Labor, Prc_Rose, Prc_Noir);
        int Opt_Rose = (int)func_B[1];
        int Opt_Noir = (int)func_B[2];
        int Opt_Total_Revenue = (int)func_B[0];

        int Sur_Labor = Cap_Labor-(Opt_Rose*Labor_Rose+Opt_Noir*Labor_Noir);
        int Sur_Grape = Cap_Grape-(Opt_Rose*Grape_Rose+Opt_Noir*Grape_Noir);

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


    @FXML
    private boolean getDefaultValue()
    {
        if(weekOfYear_tf.getText() == ""){weekOfYear_tf.setText("2301");}
        if(Cap_Labor_tf.getText() == ""){Cap_Labor_tf.setText("12000"); Cap_Labor = Integer.parseInt(Cap_Labor_tf.getText());}
        if(Cap_Grape_tf.getText() == ""){Cap_Grape_tf.setText("5000"); Cap_Grape = Integer.parseInt(Cap_Grape_tf.getText());}
        if(Prc_Rose_tf.getText() == ""){Prc_Rose_tf.setText("12"); Prc_Rose = Double.parseDouble(Prc_Rose_tf.getText());}
        if(Prc_Noir_tf.getText() == ""){Prc_Noir_tf.setText("22"); Prc_Noir = Double.parseDouble(Prc_Noir_tf.getText());}

        if (weekOfYear!=-1 && Cap_Labor!=-1 && Cap_Grape!=-1 && Prc_Rose!=-1 && Prc_Noir!=-1)
        {
            return true; // all the input values are initialized
        }
        else
        {
            return false; // not all the input values are initialized
        }
    }

}