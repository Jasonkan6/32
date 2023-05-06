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

import java.text.DecimalFormat;

import static java.lang.Math.min;

public class functionAController extends SystemMessage {

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
    private Spinner<?> or_scroll_text1;

    @FXML
    private Line vLine3;
    @FXML
    private TextField systemMessageLabel_A;

    int Cap_Labor_Int_A = 0;
    int Cap_Grape_Int_A = 0;
    int Num_Week_A = 0;
    float Prc_Rose_Float_A = 0;
    float Prc_Noir_Float_A = 0;
    int Fixed_Costs_A = 0;

    public void initialize() {
        Num_Week.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
//
                if (Num_Week.getText().isEmpty()) { // input nothing
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("input error");
                    alert.setContentText("Please enter an integer between 0 and 15");
                    alert.showAndWait();
                } else {
                    if (0 > Integer.parseInt(Num_Week.getText()) || 15 < Integer.parseInt(Num_Week.getText())) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("error");
                        alert.setHeaderText("input error");
                        alert.setContentText("Please enter an integer between 0 and 15");
                        alert.showAndWait();
                        Num_Week.setText("");
                    } else { // desired input
                        Num_Week_A = Integer.parseInt(Num_Week.getText());
                        System.out.println("Num_Week_A"+Integer.parseInt(Num_Week.getText()));
                    }
                }

            }
        });
        Cap_Labor.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (Cap_Labor.getText().isEmpty()) { // input nothing
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("input error");
                    alert.setContentText("Please enter an integer greater than 0");
                    alert.showAndWait();
                } else {
                    if (0 > Integer.parseInt(Cap_Labor.getText())) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("error");
                        alert.setHeaderText("input error");
                        alert.setContentText("Please enter an integer greater than 0");
                        alert.showAndWait();
                        Cap_Labor.setText("");
                    } else { // desired input
                        Cap_Labor_Int_A = Integer.parseInt(Cap_Labor.getText());
                        System.out.println("Cap_Labor_A"+Cap_Labor_Int_A);

                    }
                }

            }
        });
        Prc_Rose.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (Prc_Rose.getText().isEmpty()) { // input nothing
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("input error");
                    alert.setContentText("Please enter an integer greater than 0");
                    alert.showAndWait();
                } else {
                    if (0 > Float.parseFloat(Prc_Rose.getText())) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("error");
                        alert.setHeaderText("input error");
                        alert.setContentText("Please enter an integer greater than 0");
                        alert.showAndWait();
                        Prc_Rose.setText("");
                    } else { // desired input
                        Prc_Rose_Float_A = Float.parseFloat(Prc_Rose.getText());
                        System.out.println("Cap_Grape_A"+Prc_Rose_Float_A);
                    }
                }

            }
        });
        Prc_Noir.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (Prc_Noir.getText().isEmpty()) { // input nothing
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("input error");
                    alert.setContentText("Please enter an integer greater than 0");
                    alert.showAndWait();
                } else {
                    if (0 > Float.parseFloat(Prc_Noir.getText())) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("error");
                        alert.setHeaderText("input error");
                        alert.setContentText("Please enter an integer greater than 0");
                        alert.showAndWait();
                        Prc_Noir.setText("");
                    } else { // desired input
                        Prc_Noir_Float_A = Float.parseFloat(Prc_Noir.getText());
                        System.out.println("Cap_Grape_A"+Prc_Noir_Float_A);
                    }
                }

            }
        });
        Cap_Grape.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (Cap_Grape.getText().isEmpty()) { // input nothing
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("input error");
                    alert.setContentText("Please enter an integer greater than 0");
                    alert.showAndWait();
                } else {
                    if (0 > Integer.parseInt(Cap_Grape.getText())) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("error");
                        alert.setHeaderText("input error");
                        alert.setContentText("Please enter an integer greater than 0");
                        alert.showAndWait();
                        Cap_Grape.setText("");
                    } else { // desired input
                        Cap_Grape_Int_A = Integer.parseInt(Cap_Grape.getText());
                        System.out.println("Cap_Grape_A"+Cap_Grape_Int_A);
                    }
                }

            }
        });
        Fixed_Costs.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (Fixed_Costs.getText().isEmpty()) { // input nothing
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("input error");
                    alert.setContentText("Please enter an integer greater than 0");
                    alert.showAndWait();
                } else {
                    if (0 > Integer.parseInt(Fixed_Costs.getText())) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("error");
                        alert.setHeaderText("input error");
                        alert.setContentText("Please enter an integer greater than 0");
                        alert.showAndWait();
                        Fixed_Costs.setText("");
                    } else { // desired input
                        Fixed_Costs_A = Integer.parseInt(Fixed_Costs.getText());
                        System.out.println("Cap_Grape_A"+Fixed_Costs_A);
                    }
                }

            }
        });

    }
    @FXML
    private void getDefaultValue(InputMethodEvent event) {


    }

    public void toexit(ActionEvent actionEvent) {Main.stage.setScene(Main.scene);
    }
    int Labor_Rose = 5; //mins
    int Labor_Noir = 12; //mins
    int Grape_Rose = 6; //kgs
    int Grape_Noir = 4;//kgs
    int Prod_Cap = 5000; //litre
    public void toclick(ActionEvent actionEvent) {
        int Opt_Profit = 0;
        int Labor_Rate  = 935 / (int)(37.5 * 60);
        int x_out = 0;
        int y_out = 0;
        float Opt_Margin = 0;

        for (int i = 0; i <= min(Cap_Grape_Int_A / Grape_Rose, Cap_Labor_Int_A / Labor_Rose); i++) {
            for (int j = 0; j <= min(Cap_Grape_Int_A / Grape_Noir, Cap_Labor_Int_A / Labor_Noir); j++) {
                if (i * Grape_Rose + j * Grape_Noir <= Cap_Grape_Int_A &&
                        i * Labor_Rose + j * Labor_Noir <= Cap_Labor_Int_A) {
                    int VCL = (Labor_Rose * i + Labor_Noir * j) * Labor_Rate ;
                    float SR = i * Prc_Rose_Float_A + j * Prc_Noir_Float_A;
                    float GP = SR - VCL - Fixed_Costs_A;
                    if (GP > Opt_Profit) {
                        Opt_Profit = (int) GP;
                        x_out = i;
                        y_out = j;
                        Opt_Margin = (float)Opt_Profit / SR *100;
                    }
                }
            }
        }
        System.out.println("Opt_Profit:" + Opt_Profit);
        DecimalFormat df = new DecimalFormat("#.#");
        or_Gross_Profit.setText(String.valueOf(Opt_Profit));
        or_Profit_Margin.setText(String.valueOf(df.format(Opt_Margin)));
        or_Prod_Vol_Rose_A.setText(String.valueOf(x_out));
        or_Prod_Vol_Noir_A.setText(String.valueOf(y_out));
        or_Prod_Vol_Total_A.setText(String.valueOf(x_out + y_out));

        //Warning messages condition
        if (x_out + y_out > Prod_Cap * Num_Week_A){
            showSystemMessage("w1: Insufficient production capacity to produce the optimal mix, please reduce or adjust the capacity of labor & grape volum!", systemMessageLabel_A);
        }
        if (x_out*Grape_Rose + y_out*Grape_Noir < 0.9 * Cap_Grape_Int_A){
            showSystemMessage("w2: Insufficient labor supplied to utilize the grape resource (less than 90%)!", systemMessageLabel_A);
        }

    }
}
