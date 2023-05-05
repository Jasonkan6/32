package src.main.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

import java.text.DecimalFormat;

import static java.lang.Math.min;

public class functionCController {

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
    private TextField systemMessageLabel;

    @FXML
    private Line vLine3;

    int Cap_Labor_Int = 0;
    int Cap_Grape_Int = 0;
    int Bko_Rose_Int = 0;
    int Bko_Noir_Int = 0;
    float Prc_Rose_Float = 0;
    float Prc_Noir_Float = 0;

    public void initialize() {

        Num_Week_C.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
//
                if (Num_Week_C.getText().isEmpty()) { // input nothing
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("input error");
                    alert.setContentText("Please enter an integer greater than 0");
                    alert.showAndWait();
                } else {
                    if (2301 > Integer.parseInt(Num_Week_C.getText()) || 2315 < Integer.parseInt(Num_Week_C.getText())) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("error");
                        alert.setHeaderText("input error");
                        alert.setContentText("Please enter an integer greater than 0");
                        alert.showAndWait();
                        Num_Week_C.setText("");
                    } else { // desired input
                        System.out.println("Num_Week_C"+Integer.parseInt(Num_Week_C.getText()));
                    }
                }

            }
        });
        Cap_Labor_C.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (Cap_Labor_C.getText().isEmpty()) { // input nothing
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("input error");
                    alert.setContentText("Please enter an integer greater than 0");
                    alert.showAndWait();
                } else {
                    if (0 > Integer.parseInt(Cap_Labor_C.getText())) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("error");
                        alert.setHeaderText("input error");
                        alert.setContentText("Please enter an integer greater than 0");
                        alert.showAndWait();
                        Cap_Labor_C.setText("");
                    } else { // desired input
                        Cap_Labor_Int = Integer.parseInt(Cap_Labor_C.getText());
                        System.out.println("Cap_Labor_C"+Cap_Labor_Int);

                    }
                }

            }
        });
        Prc_Rose_C.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (Prc_Rose_C.getText().isEmpty()) { // input nothing
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("input error");
                    alert.setContentText("Please enter an integer greater than 0");
                    alert.showAndWait();
                } else {
                    if (0 > Float.parseFloat(Prc_Rose_C.getText())) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("error");
                        alert.setHeaderText("input error");
                        alert.setContentText("Please enter an integer greater than 0");
                        alert.showAndWait();
                        Prc_Rose_C.setText("");
                    } else { // desired input
                        Prc_Rose_Float = Float.parseFloat(Prc_Rose_C.getText());
                        System.out.println("Cap_Grape_C"+Prc_Rose_Float);
                    }
                }

            }
        });
        Prc_Noir_C.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (Prc_Noir_C.getText().isEmpty()) { // input nothing
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("input error");
                    alert.setContentText("Please enter an integer greater than 0");
                    alert.showAndWait();
                } else {
                    if (0 > Float.parseFloat(Prc_Noir_C.getText())) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("error");
                        alert.setHeaderText("input error");
                        alert.setContentText("Please enter an integer greater than 0");
                        alert.showAndWait();
                        Prc_Noir_C.setText("");
                    } else { // desired input
                        Prc_Noir_Float = Float.parseFloat(Prc_Noir_C.getText());
                        System.out.println("Cap_Grape_C"+Prc_Noir_Float);
                    }
                }

            }
        });
        Cap_Grape_C.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (Cap_Grape_C.getText().isEmpty()) { // input nothing
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("input error");
                    alert.setContentText("Please enter an integer greater than 0");
                    alert.showAndWait();
                } else {
                    if (0 > Integer.parseInt(Cap_Grape_C.getText())) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("error");
                        alert.setHeaderText("input error");
                        alert.setContentText("Please enter an integer greater than 0");
                        alert.showAndWait();
                        Cap_Grape_C.setText("");
                    } else { // desired input
                        Cap_Grape_Int = Integer.parseInt(Cap_Grape_C.getText());
                        System.out.println("Cap_Grape_C"+Cap_Grape_Int);
                    }
                }

            }
        });
        Bko_Noir_C.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (Bko_Noir_C.getText().isEmpty()) { // input nothing
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("input error");
                    alert.setContentText("Please enter an integer greater than 0");
                    alert.showAndWait();
                } else {
                    if (0 > Integer.parseInt(Bko_Noir_C.getText())) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("error");
                        alert.setHeaderText("input error");
                        alert.setContentText("Please enter an integer greater than 0");
                        alert.showAndWait();
                        Bko_Noir_C.setText("");
                    } else { // desired input
                        Bko_Noir_Int = Integer.parseInt(Bko_Noir_C.getText());
                        System.out.println("Bko_Noir_C"+Bko_Noir_Int);                    }
                }

            }
        });
        Bko_Rose_C.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (Bko_Rose_C.getText().isEmpty()) { // input nothing
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("input error");
                    alert.setContentText("Please enter an integer greater than 0");
                    alert.showAndWait();
                } else {
                    if (0 > Integer.parseInt(Bko_Rose_C.getText())) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("error");
                        alert.setHeaderText("input error");
                        alert.setContentText("Please enter an integer greater than 0");
                        alert.showAndWait();
                        Bko_Rose_C.setText("");
                    } else { // desired input
                        Bko_Rose_Int = Integer.parseInt(Bko_Rose_C.getText());
                        System.out.println("Bko_Rose_C"+Bko_Rose_Int);                     }
                }

            }
        });
    }


    private int messageNumber = 0;
    private void showSystemMessage(String message) {
        if (message != null && !message.isEmpty()) {
            messageNumber++;
            String messageText = messageNumber + ". " + message;
            if (systemMessageLabel.getText().isEmpty()) {
                systemMessageLabel.setText(messageText);
            } else {
                systemMessageLabel.setText(systemMessageLabel.getText() + "\n" + messageText);
            }
            systemMessageLabel.setVisible(true);
        }
    }

    int Labor_Rose = 5; //mins
    int Labor_Noir = 12; //mins
    int Grape_Rose = 6; //kgs
    int Grape_Noir = 4;//kgs
    int Prod_Cap = 5000; //litre
//    int Cap_Labor_Int = Integer.parseInt(Cap_Labor_C != null ? Cap_Labor_C.getText():"0");



    public void run_button_C(ActionEvent event) {
//        ObservableList<String> items = FXCollections.observableArrayList("w1: Insufficient production capacity to produce the optimal mix, please reduce or adjust the capacity of labor & grape volume!", "W2: Insufficient labor supplied to utilize the grape resource (less than 90%).");
//        or_scroll_text1.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<String>(items));
//        // Reserve all resource of both labor and grape to backorders first
//        System.out.println("Hello");
        systemMessageLabel.clear();
        messageNumber = 0;

        System.out.println("Cap_Labor_Int:" + Cap_Labor_Int);

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
//            System.out.println("i:" + max(remainingGrapeCapacity / Grape_Rose, remainingLaborCapacity / Labor_Rose));
//
//            System.out.println("j:" + max(remainingGrapeCapacity / Grape_Noir, remainingLaborCapacity / Labor_Noir));



            for (int i = 0; i <= min(remainingGrapeCapacity / Grape_Rose, remainingLaborCapacity / Labor_Rose); i++) {
                for (int j = 0; j <= min(remainingGrapeCapacity / Grape_Noir, remainingLaborCapacity / Labor_Noir); j++) {
                    if (i * Grape_Rose + j * Grape_Noir <= remainingGrapeCapacity &&
                            i * Labor_Rose + j * Labor_Noir <= remainingLaborCapacity) {
                        float revenue = i * Prc_Rose_Float + j * Prc_Noir_Float;
                        if (revenue > Opt_Revenue) {
                            Opt_Revenue = (int) revenue;
                            Opt_Rose = i;
                            Opt_Noir = j;
                        }
                    }
                }
            }

        }
        System.out.println("revenue:" + Opt_Revenue);

        Bko_fulfill_txt.setText(Bko_fulfill ? "Yes" : "No");
        Revenue_txt.setText(String.valueOf(Opt_Revenue));
        or_Prod_Vol_Rose.setText(String.valueOf(Opt_Rose));
        or_Prod_Vol_Noir.setText(String.valueOf(Opt_Noir));
        or_Prod_Vol_Total.setText(String.valueOf(Opt_Rose + Opt_Noir));
        //Warning messages condition
        if (Opt_Rose + Opt_Noir > Prod_Cap){
            showSystemMessage("w1: Insufficient production capacity to produce the optimal mix, please reduce or adjust the capacity of labor & grape volum!");
        }
        if (Opt_Rose*Grape_Rose + Opt_Noir*Grape_Noir < 0.9 * remainingGrapeCapacity){
            showSystemMessage("w2: Insufficient labor supplied to utilize the grape resource (less than 90%)!");
        }
        if ((Bko_Rose_Int + Bko_Noir_Int) < 0.7 * (Opt_Rose + Opt_Noir)){
            showSystemMessage("w3: According to company policy, ratio of backorder volume should not lower than 70% of the optimal production volume!");
        }


        // Check the total revenue
        assert Opt_Revenue == Opt_Rose * Prc_Rose_Float + Opt_Noir * Prc_Noir_Float;

    }
    @FXML
    private void getDefaultValue(InputMethodEvent event) {
        Num_Week_C.setText("2301");
        Cap_Grape_C.setText("5000");
        Cap_Labor_C.setText("12000");
        Prc_Noir_C.setText("22");
        Prc_Rose_C.setText("12");
        Bko_Rose_C.setText("380");
        Bko_Noir_C.setText("100");

    }

    public void toexit(ActionEvent actionEvent) {Main.stage.setScene(Main.scene);
    }






}