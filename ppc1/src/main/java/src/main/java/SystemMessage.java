//package src.main.java;
//
//import javafx.scene.control.TextField;
//
//public class SystemMessage {
//    public int messageNumber = 0;
//    public void showSystemMessage(String message, TextField systemMessageLabel) {
//        // implementation of the method
//        if (message != null && !message.isEmpty()) {
//            messageNumber++;
//            String messageText = messageNumber + ". " + message;
//            if (systemMessageLabel.getText().isEmpty()) {
//                systemMessageLabel.setText(messageText);
//            } else {
//                systemMessageLabel.setText(systemMessageLabel.getText() + "\n" + messageText);
//            }
//            systemMessageLabel.setVisible(true);
//        }
//    }
//}