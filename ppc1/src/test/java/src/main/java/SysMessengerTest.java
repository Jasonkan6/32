package src.main.java;

import javafx.embed.swing.JFXPanel;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.*;

public class SysMessengerTest {
    @BeforeClass
    public static void initToolkit() {
        new JFXPanel();
    }

    @BeforeClass
    public static void initToolkit() {
        new JFXPanel();
    }
    @Test
    public void testShowSystemMessage_empty()
    {
        SysMessenger sysMessenger = new SysMessenger();
        TextField sys_msg_txt = new TextField();
        Vector<String> messages = new Vector<String>();
        String messageText = sysMessenger.showSystemMessage(sys_msg_txt, messages);
        assertEquals("", messageText);
        assertTrue(sys_msg_txt.isVisible());
    }

    @Test
    public void testShowSystemMessage_Valid()
    {

        SysMessenger sysMessenger = new SysMessenger();
        TextField sys_msg_txt = new TextField();
        Vector<String> messages = new Vector<String>();
        messages.add("w1: Insufficient production capacity to produce the optimal mix, please reduce or adjust the capacity of labor & grape volume!");
        messages.add("Er1a: Program bug is occurred, Labor Consumption cannot greater than its capacity!");
        String messageText = sysMessenger.showSystemMessage(sys_msg_txt, messages);
        assertEquals("1. w1: Insufficient production capacity to produce the optimal mix, please reduce or adjust the capacity of labor & grape volume!\n2. Er1a: Program bug is occurred, Labor Consumption cannot greater than its capacity!\n", messageText);
        assertTrue(sys_msg_txt.isVisible());
    }

}