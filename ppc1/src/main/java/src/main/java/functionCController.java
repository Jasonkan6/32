package src.main.java;

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

public class functionCController extends Optimization {

    @FXML
    private TextField Bko_Noir_C;

    @FXML
    private TextField Bko_Rose_C;

    @FXML
    private TextField Bko_fulfill_txt;

    @FXML
    private TextField Cap_Grape_C;

    @FXML
    private TextField Cap_Labor_C;

    @FXML
    private Line HLine2;

    @FXML
    private Line HLine3;

    @FXML
    private Line HLine4;

    @FXML
    private Line HLine_1;

    @FXML
    private TextField Num_Week_C;

    @FXML
    private TextField Prc_Noir_C;

    @FXML
    private TextField Prc_Rose_C;

    @FXML
    private TextField Revenue_txt;

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
    private Label data_input_caption3a1;

    @FXML
    private Label data_input_caption3a11;

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
    private Label opt_r_caption21;

    @FXML
    private Label opt_result_heading1;

    @FXML
    private TextField or_Prod_Vol_Noir;

    @FXML
    private TextField or_Prod_Vol_Rose;

    @FXML
    private TextField or_Prod_Vol_Total;

    @FXML
    private Text systemMessageLabel;

    @FXML
    private Line vLine3;
    int Num_Weeks_Int = -1;
    int Cap_Labor_Int = -1;
    int Cap_Grape_Int = -1;
    int Bko_Rose_Int = -1;
    int Bko_Noir_Int = -1;
    float Prc_Rose_Float = -1;
    float Prc_Noir_Float = -1;
    public boolean initialize() {
        compInit initializer = new compInit();
        Num_Week_C.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                String init = initializer.component_init(Num_Week_C, true, true, 2315, true, 2301);
                if (init == "desired")
                {
                    Num_Weeks_Int = Integer.parseInt(Num_Week_C.getText());
                }
                else if (init!="")
                {
                    initializer.gen_alert(init);
                }
            }
        });

        Cap_Labor_C.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                String init = initializer.component_init(Cap_Labor_C, true, false, 0, true, 0);
                if (init=="desired")
                {
                    Cap_Labor_Int = Integer.parseInt(Cap_Labor_C.getText());
                    System.out.println("Cap_Labor_C"+Cap_Labor_Int);
                }
                else if (init!="")
                {
                    initializer.gen_alert(init);
                }
            }
        });

        Cap_Grape_C.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                String init = initializer.component_init(Cap_Grape_C, true, false, 0, true, 0);
                if (init=="desired")
                {
                    Cap_Grape_Int = Integer.parseInt(Cap_Grape_C.getText());
                    System.out.println("Cap_Grape_C"+Cap_Grape_Int);
                }
                else if (init!="")
                {
                    initializer.gen_alert(init);
                }
            }
        });

        Prc_Rose_C.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                String init = initializer.component_init(Prc_Rose_C, false, false, 0, true, 0);
                if (init=="desired")
                {
                    Prc_Rose_Float = Float.parseFloat(Prc_Rose_C.getText());
                    DecimalFormat df = new DecimalFormat("#,##0.00");
                    String formattedNumber = df.format(Prc_Rose_Float);
                    Prc_Rose_C.setText(formattedNumber);
                    System.out.println("Prc_Rose_C"+formattedNumber);
                }
                else if (init!="")
                {
                    initializer.gen_alert(init);
                }
            }
        });

        Prc_Noir_C.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                String init = initializer.component_init(Prc_Noir_C, false, false, 0, true, 0);
                if (init=="desired")
                {
                    Prc_Noir_Float = Float.parseFloat(Prc_Noir_C.getText());
                    DecimalFormat df = new DecimalFormat("#,##0.00");
                    String formattedNumber = df.format(Prc_Noir_Float);
                    Prc_Noir_C.setText(formattedNumber);
                    System.out.println("Prc_Noir_C"+formattedNumber);

                }
                else if (init!="")
                {
                    initializer.gen_alert(init);
                }
            }
        });
        Bko_Noir_C.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                String init = initializer.component_init(Bko_Noir_C, true, false, 0, true, 0);
                if (init=="desired")
                {
                    Bko_Noir_Int = Integer.parseInt(Bko_Noir_C.getText());
                    System.out.println("Bko_Noir_C"+Bko_Noir_Int);
                }
                else if (init!="")
                {
                    initializer.gen_alert(init);
                }
            }
        });
        Bko_Rose_C.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // this component loses focus
                String init = initializer.component_init(Bko_Rose_C, true, false, 0, true, 0);
                if (init=="desired")
                {
                    Bko_Rose_Int = Integer.parseInt(Bko_Rose_C.getText());
                    System.out.println("Bko_Rose_C"+Bko_Rose_Int);
                }
                else if (init!="")
                {
                    initializer.gen_alert(init);
                }
            }
        });
        if (Num_Weeks_Int!=-1 && Cap_Labor_Int!=-1 && Cap_Grape_Int!= -1 && Prc_Noir_Float!=-1 && Prc_Rose_Float!=-1 && Bko_Rose_Int!=-1 && Bko_Noir_Int!=-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public void run_button_C(ActionEvent event) {
//        ObservableList<String> items = FXCollections.observableArrayList("w1: Insufficient production capacity to produce the optimal mix, please reduce or adjust the capacity of labor & grape volume!", "W2: Insufficient labor supplied to utilize the grape resource (less than 90%).");
//        or_scroll_text1.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<String>(items));
//        // Reserve all resource of both labor and grape to backorders first
        getDefaultValue();
//        systemMessageLabel.clear();
        int remainingLaborCapacity = Cap_Labor_Int - Bko_Rose_Int * Labor_Rose - Bko_Noir_Int * Labor_Noir;
        System.out.println("remainingLaborCapacity:" + remainingLaborCapacity);

        int remainingGrapeCapacity = Cap_Grape_Int - Bko_Rose_Int * Grape_Rose - Bko_Noir_Int * Grape_Noir;
        System.out.println("remainingGrapeCapacity:" + remainingGrapeCapacity);

        // Check if backorder fulfillment constraint is satisfied
        boolean Bko_fulfill = remainingLaborCapacity > 0 && remainingGrapeCapacity > 0;
        System.out.println("Bko_fulfill:" + Bko_fulfill);
        int Opt_Rose = 0;
        int Opt_Noir = 0;
        int Opt_Revenue = 0;
        if (Bko_fulfill) {
            // Compute the optimal mix of wines with the remaining resource of both labor and grape capacity
            Object[] func_C = Opt_BC(remainingGrapeCapacity, remainingLaborCapacity, Prc_Rose_Float, Prc_Noir_Float);
            Opt_Rose = (int)func_C[1];
            Opt_Noir = (int)func_C[2];
            Opt_Revenue = (int)func_C[0];
        }

        System.out.println("revenue:" + Opt_Revenue);

        Bko_fulfill_txt.setText(Bko_fulfill ? "Yes" : "No");
        Revenue_txt.setText(String.valueOf(Opt_Revenue));
        or_Prod_Vol_Rose.setText(String.valueOf(Opt_Rose));
        or_Prod_Vol_Noir.setText(String.valueOf(Opt_Noir));
        or_Prod_Vol_Total.setText(String.valueOf(Opt_Rose + Opt_Noir));

        //Warning messages condition
        SysMessenger s_C = new SysMessenger();
        Vector<String> Sys_Msgs_C = new Vector<>();
        if (Opt_Rose + Opt_Noir > Prod_Cap){
            Sys_Msgs_C.add("w1: Insufficient production capacity to produce the optimal mix, please reduce or adjust the capacity of labor & grape volum!");
        }
        if (Opt_Rose*Grape_Rose + Opt_Noir*Grape_Noir < 0.9 * remainingGrapeCapacity){
            Sys_Msgs_C.add("w2: Insufficient labor supplied to utilize the grape resource (less than 90%)!");
        }
        if ((Bko_Rose_Int + Bko_Noir_Int) < 0.7 * (Opt_Rose + Opt_Noir)){
            Sys_Msgs_C.add("w3: According to company policy, ratio of backorder volume should not lower than 70% of the optimal production volume!");
        }
        s_C.showSystemMessage(systemMessageLabel, Sys_Msgs_C);

        // Check the total revenue
//        assert Opt_Revenue == Opt_Rose * Prc_Rose_Float + Opt_Noir * Prc_Noir_Float;

    }
    @FXML
    private boolean getDefaultValue() {
        if(Num_Week_C.getText() == ""){Num_Week_C.setText("2301");}
        if(Cap_Grape_C.getText() == ""){Cap_Grape_C.setText("5000"); Cap_Grape_Int = Integer.parseInt(Cap_Grape_C.getText());}
        if(Cap_Labor_C.getText() == ""){Cap_Labor_C.setText("12000"); Cap_Labor_Int = Integer.parseInt(Cap_Labor_C.getText());}
        if(Prc_Noir_C.getText() == ""){Prc_Noir_C.setText("22"); Prc_Noir_Float = Float.parseFloat(Prc_Noir_C.getText());}
        if(Prc_Rose_C.getText() == ""){Prc_Rose_C.setText("12"); Prc_Rose_Float = Float.parseFloat(Prc_Rose_C.getText());}
        if(Bko_Rose_C.getText() == ""){Bko_Rose_C.setText("380");Bko_Rose_Int = Integer.parseInt(Bko_Rose_C.getText());}
        if(Bko_Noir_C.getText() == ""){Bko_Noir_C.setText("100"); Bko_Noir_Int = Integer.parseInt(Bko_Noir_C.getText());}

        if (Num_Weeks_Int!=-1 && Cap_Labor_Int!=-1 && Cap_Grape_Int!= -1 && Prc_Noir_Float!=-1 && Prc_Rose_Float!=-1 && Bko_Rose_Int!=-1 && Bko_Noir_Int!=-1)
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
}