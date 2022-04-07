import javax.swing.*;
import java.awt.*;

public class Constants {
    public static JButton leaveButton = null;
    public static int minVolume = 0;
    public static int maxVolume = 10;
    public static int curVolume = 5;
    public static double ScreenWidthDivisor = 3;
    public static double ScreenHeightDivisor = 2;
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static Dimension userScreenSize = new Dimension(
            (int) (screenSize.getWidth() / ScreenWidthDivisor), (int) (screenSize.getHeight() / ScreenHeightDivisor)
    );

    public static JButton getLeaveButton(){
        if(leaveButton == null){
            leaveButton = new JButton("Leave");
            leaveButton.addActionListener(e -> {
                JFrame topFrame = (JFrame) SwingUtilities.getRoot(leaveButton);
                topFrame.dispose();
            });
        }
        return leaveButton;
    }

    public static void setScreenWidthDivisor(int value){
        ScreenWidthDivisor = value;
        userScreenSize = new Dimension(
                (int) (screenSize.getWidth() / Constants.ScreenWidthDivisor), (int) (screenSize.getHeight() / ScreenHeightDivisor)
        );
    }

    public static void setScreenHeightDivisor(int value){
        ScreenHeightDivisor = value;
        userScreenSize = new Dimension(
                (int) (screenSize.getWidth() / ScreenWidthDivisor), (int) (screenSize.getHeight() / ScreenHeightDivisor)
        );
    }

    public static void setCurVolume(int value){
        curVolume = value;
    }
}
