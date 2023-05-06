package src.main.java;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class compInit {
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
                    alertStr+=(lower_bounded&&int_value)?((int)lower_bound):"";
                    alertStr+=(lower_bounded&&!int_value)?(lower_bound):"";
                    alertStr+=(lower_bounded&&upper_bounded)?" and":"";
                    alertStr+=(upper_bounded)?(" less than "):".";
                    alertStr+=(upper_bounded&&int_value)?((int)upper_bound+"."):"";
                    alertStr+=(upper_bounded&&!int_value)?(upper_bound+"."):"";
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
}
