package hust.soict.dsai.aims.exception;

import javax.swing.*;

public class PlayerException extends Exception{
    public PlayerException(String message){
        super(message);
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(
                frame,
                message,
                "DVD Illegal Length",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public PlayerException(){}

}
