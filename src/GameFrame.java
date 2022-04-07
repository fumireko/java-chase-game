import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame () {
        super();
        initialize();
    }

    private JPanel getGamePanel(){
        if(gamePanel == null){
            gamePanel = new GamePanel();
        }
        return gamePanel;
    }

    void initialize(){
        this.setResizable(false);
        this.setSize(Constants.userScreenSize);
        this.setContentPane(getGamePanel());
        this.setTitle("Game");
        this.setLocationRelativeTo(null);
        this.addKeyListener(new InputHandler(gamePanel));
    }

    private GamePanel gamePanel = null;
}
