import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {
    GamePanel panel;

    InputHandler(GamePanel panel){
        this.panel = panel;
    }

    @Override
    public void keyPressed(KeyEvent e){
        try {
            panel.keyPressed(e);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        try {
            panel.keyReleased(e);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}