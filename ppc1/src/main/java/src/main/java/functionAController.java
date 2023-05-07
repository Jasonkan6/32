package src.main.java;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.text.DecimalFormat;
import java.util.Vector;

import static java.lang.Math.min;

public class functionAController extends Optimization {

    @FXML
    private TextField Cap_Grape;

    @FXML
    private TextField Cap_Labor;

    @FXML
    private TextField Fixed_Costs;

    @FXML
    private Line HLine2;

    @FXML
    private Line HLine3;

    @FXML
    private Line HLine4;

    @FXML
    private Line HLine_1;

    @FXML
    private TextField Num_Week;

    @FXML
    private TextField Prc_Noir;

    @FXML
    private TextField Prc_Rose;

    @FXML
    private Line VLine1;

    @FXML
    private Line VLine2;

    @FXML
    private Button button_exit1;

    @FXML
    private Button button_run1;

    @FXML
    private Label data_input_caption1;

    @FXML
    private Label data_input_caption2;

    @FXML
    private Label data_input_caption2a;

    @FXML
    private Label data_input_caption2b;

    @FXML
    private Label data_input_caption3;

    @FXML
    private Label data_input_caption3a;

    @FXML
    private Label data_input_caption3b;

    @FXML
    private Label data_input_caption4;

    @FXML
    private Label data_input_heading1;

    @FXML
    private Label form_heading1;

    @FXML
    private AnchorPane label_col_heading2;

    @FXML
    private Label label_sysmsg1;

    @FXML
    private Label opt_r_caption1;

    @FXML
    private Label opt_r_caption1a;

    @FXML
    private Label opt_r_caption1b;

    @FXML
    private Label opt_r_caption1c;

    @FXML
    private Label opt_r_caption2;

    @FXML
    private Label opt_r_caption3;

    @FXML
    private Label opt_result_heading1;

    @FXML
    private TextField or_Gross_Profit;

    @FXML
    private TextField or_Prod_Vol_Noir_A;

    @FXML
    private TextField or_Prod_Vol_Rose_A;

    @FXML
    private TextField or_Prod_Vol_Total_A;

    @FXML
    private TextField or_Profit_Margin;

    @FXML
    private Line vLine3;

    @FXML
    private Text systemMessageLabel_A;

    int Cap_Labor_Int_A = -1;
    int Cap_Grape_Int_A = -1;
    int Num_Week_A = -1;
    float Prc_Rose_Float_A = -1;
    float Prc_Noir_Float_A = -1;
    int Fixed_Costs_A = -1;

    public boolean initialize() {
        compInit initializer_A = new compInit();
        Num_Week.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                String init = initializer_A.component_init(Num_Week, true, true, 15, true, 01);
                if (init == "desired")
                {
                    Num_Week_A = Integer.parseInt(Num_Week.getText());
                    System.out.println("Num_Week_A"+Integer.parseInt(Num_Week.getText()));
                }
                else if (init!="")
                {
                    initializer_A.gen_alert(init);
                }
            }
        });

        Cap_Labor.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                String init = initializer_A.component_init(Cap_Labor, true, false, 0, true, 0);
                if (init=="desired")
                {
                    Cap_Labor_Int_A = Integer.parseInt(Cap_Labor.getText());
                    System.out.println("Cap_Labor_A"+Cap_Labor_Int_A);
                }
                else if (init!="")
                {
                    initializer_A.gen_alert(init);
                }
            }
        });
        Cap_Grape.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                String init = initializer_A.component_init(Cap_Grape, true, false, 0, true, 0);
                if (init=="desired")
                {
                    Cap_Grape_Int_A = Integer.parseInt(Cap_Grape.getText());
                    System.out.println("Cap_Grape_A"+Cap_Grape_Int_A);
                }
                else if (init!= "")
                {
                    initializer_A.gen_alert(init);
                }
            }
        });
        Fixed_Costs.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                String init = initializer_A.component_init(Fixed_Costs, true, false, 0, true, 0);
                if (init=="desired")
                {
                    Fixed_Costs_A = Integer.parseInt(Fixed_Costs.getText());
                    System.out.println("Fixed_Costs_A"+Fixed_Costs_A);
                }
                else if (init!="")
                {
                    initializer_A.gen_alert(init);
                }
            }
        });

        Prc_Rose.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                String init = initializer_A.component_init(Prc_Rose, false, false, 0, true, 0);
                if (init=="desired")
                {
                    Prc_Rose_Float_A = Float.parseFloat(Prc_Rose.getText());
                    DecimalFormat df = new DecimalFormat("#,##0.00");
                    String formattedNumber = df.format(Prc_Rose_Float_A);
                    Prc_Rose.setText(formattedNumber);
                    System.out.println("Prc_Rose_Float_A"+formattedNumber);
                }
                else if(init!="")
                {
                    initializer_A.gen_alert(init);
                }
            }
        });

        Prc_Noir.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                String init = initializer_A.component_init(Prc_Rose, false, false, 0, true, 0);
                if (init=="desired")
                {
                    Prc_Rose_Float_A = Float.parseFloat(Prc_Noir.getText());
                    DecimalFormat df = new DecimalFormat("#,##0.00");
                    String formattedNumber = df.format(Prc_Rose_Float_A);
                    Prc_Noir.setText(formattedNumber);
                    System.out.println("Prc_Noir_Float_A"+formattedNumber);
                }
                else if (init!="")
                {
                    initializer_A.gen_alert(init);
                }
            }
        });
        if (Num_Week_A!=-1 && Cap_Grape_Int_A!=-1 && Cap_Labor_Int_A!= -1 && Prc_Noir_Float_A!=-1 && Prc_Rose_Float_A!=-1 && Fixed_Costs_A!=-1)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    @FXML
    private boolean getDefaultValue(InputMethodEvent event) {
        if(Num_Week.getText() == ""){Num_Week.setText("01");Num_Week_A = Integer.parseInt(Num_Week.getText());}
        if(Cap_Grape.getText() == ""){Cap_Grape.setText("5000"); Cap_Grape_Int_A = Integer.parseInt(Cap_Grape.getText());}
        if(Cap_Labor.getText() == ""){Cap_Labor.setText("12000"); Cap_Labor_Int_A = Integer.parseInt(Cap_Labor.getText());}
        if(Prc_Noir.getText() == ""){Prc_Noir.setText("22"); Prc_Noir_Float_A = Float.parseFloat(Prc_Noir.getText());}
        if(Prc_Rose.getText() == ""){Prc_Rose.setText("12"); Prc_Rose_Float_A = Float.parseFloat(Prc_Rose.getText());}
        if(Fixed_Costs.getText() == ""){Fixed_Costs.setText("12000"); Fixed_Costs_A = Integer.parseInt(Fixed_Costs.getText());}
        if (Num_Week_A!=-1 && Cap_Grape_Int_A!=-1 && Cap_Labor_Int_A!= -1 && Prc_Noir_Float_A!=-1 && Prc_Rose_Float_A!=-1 && Fixed_Costs_A!=-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void toexit(ActionEvent actionEvent) {Main.stage.setScene(Main.scene);
    }
    public void toclick(ActionEvent actionEvent) {

        Object[] func_A = Opt_A(Cap_Grape_Int_A, Cap_Labor_Int_A, Prc_Rose_Float_A, Prc_Noir_Float_A, Fixed_Costs_A);
        System.out.println("Opt_Profit:" + func_A[0]);

        DecimalFormat df = new DecimalFormat("#.#");
        or_Gross_Profit.setText(String.valueOf(func_A[0]));
        or_Profit_Margin.setText(String.valueOf(df.format(func_A[3])));
        or_Prod_Vol_Rose_A.setText(String.valueOf(func_A[1]));
        or_Prod_Vol_Noir_A.setText(String.valueOf(func_A[2]));
        or_Prod_Vol_Total_A.setText(String.valueOf((int)func_A[1] + (int)func_A[2]));

        //Warning messages condition
//        SystemMessage s_A = new SystemMessage();
//        s_A.messageNumber = 0;
//
//        if ((int)func_A[1] + (int)func_A[2] > Prod_Cap * Num_Week_A){
//            s_A.showSystemMessage("w1: Insufficient production capacity to produce the optimal mix, please reduce or adjust the capacity of labor & grape volum!", systemMessageLabel_A);
//        }
//        if ((int)func_A[1]*Grape_Rose + (int)func_A[2]*Grape_Noir < 0.9 * Cap_Grape_Int_A){
//            s_A.showSystemMessage("w2: Insufficient labor supplied to utilize the grape resource (less than 90%)!", systemMessageLabel_A);
//        }
        SysMessenger msg = new SysMessenger();
        Vector<String> Sys_Msgs_A = new Vector<>();
        if ((int)func_A[1] + (int)func_A[2] > Prod_Cap * Num_Week_A)
        {
            Sys_Msgs_A.add("w1: Insufficient production capacity to produce the optimal mix, please reduce or adjust the capacity of labor & grape volume!");
        }
        if ((int)func_A[1]*Grape_Rose + (int)func_A[2]*Grape_Noir < 0.9 * Cap_Grape_Int_A)
        {
            Sys_Msgs_A.add("w2: Insufficient labor supplied to utilize the grape resource (less than 90%)!");
        }

        msg.showSystemMessage(systemMessageLabel_A, Sys_Msgs_A);

    }
}
