package src.main.java;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.Vector;

public class SysMessenger {
    public String showSystemMessage(TextField sys_msg_txt, Vector<String> messages)
    {
        String messageText = "";
        int idx = 1;
        for (String msg: messages)
        {
            messageText += (idx+". "+msg+"\n");
            idx++;
        }
        sys_msg_txt.setText(messageText);
        sys_msg_txt.setVisible(true);
        return messageText;
    }
}
