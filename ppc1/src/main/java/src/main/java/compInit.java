package src.main.java;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class compInit {
    public void gen_alert(String alertStr)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("error");
        alert.setHeaderText("input error");
        alert.setContentText(alertStr);
        alert.showAndWait();
    }
    public String component_init(TextField textField, boolean int_value, boolean upper_bounded, double upper_bound, boolean lower_bounded, double lower_bound)
    {
        try {
            if (!textField.getText().isEmpty()) { // do nothing when the textfield is left empty
                if (int_value==true)
                {
                    if ((lower_bounded && lower_bound > Integer.parseInt(textField.getText())) || (upper_bounded && upper_bound < Integer.parseInt(textField.getText()))) {
                        String alertStr = "Please enter an integer";
                        alertStr+=(lower_bounded)?(" >= "+(int)lower_bound):"";
                        alertStr+=(lower_bounded&&upper_bounded)?" and":"";
                        alertStr+=(upper_bounded)?(" <= "+(int)upper_bound):".";
//                        gen_alert(alertStr);
                        textField.setText("");
                        return alertStr;
                    }
                    else { // desired input
                        return "desired";
                    }
                }
                else // decimal number
                {
                    if ((lower_bounded && lower_bound > Double.parseDouble(textField.getText())) || (upper_bounded && upper_bound < Double.parseDouble(textField.getText()))) {
                        String alertStr = "Please enter a number";
                        alertStr+=(lower_bounded)?(" >= "+lower_bound):"";
                        alertStr+=(lower_bounded&&upper_bounded)?" and":"";
                        alertStr+=(upper_bounded)?(" <= "+upper_bound):".";
//                        gen_alert(alertStr);
                        textField.setText("");
                        return alertStr;
                    }
                    else { // desired input
                        return "desired";
                    }
                }
            }
            return "";
        }
        catch (NumberFormatException e) {
            String alertStr;
            if (int_value)
            {
                alertStr = "Please enter an integer.";
            }
            else
            {
                alertStr = "Please enter a number.";
            }
//            gen_alert(alertStr);
            textField.setText("");
            return alertStr;
        }
    }
}
