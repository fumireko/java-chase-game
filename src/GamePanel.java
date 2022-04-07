import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends JPanel implements ActionListener {
    private final Player player1;
    private final Player player2;
    ImageIcon background = new ImageIcon(
            Objects.requireNonNull(getClass().getResource("/resources/background.png")));

    public GamePanel(){

        setLayout(new BorderLayout());
        add(new JLabel(background), BorderLayout.CENTER);

        player1 = new Player((Constants.userScreenSize.width/2), (Constants.userScreenSize.height/3), Color.GREEN);
        player2 = new Player((Constants.userScreenSize.width/3), (Constants.userScreenSize.height/2), Color.MAGENTA);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                player1.set();
                player2.set();
                repaint();
            }
        }, 0, 20);
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D gtd = (Graphics2D) g;
        player1.draw(gtd);
        player2.draw(gtd);
    }

    public void keyReleased(KeyEvent e) throws InterruptedException {

        JFrame topFrame = (JFrame) SwingUtilities.getRoot(this);
        winCondition(player1, player2, topFrame);

        if(e.getKeyCode() == KeyEvent.VK_LEFT) player1.left = false;
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) player1.right = false;

        if(e.getKeyCode() == KeyEvent.VK_UP) player1.up = false;
        if(e.getKeyCode() == KeyEvent.VK_DOWN) player1.down = false;

        if(e.getKeyChar() == 'w') player2.up = false;
        if(e.getKeyChar() == 's') player2.down = false;

        if(e.getKeyChar() == 'a') player2.left = false;
        if(e.getKeyChar() == 'd') player2.right = false;
    }

    public void keyPressed(KeyEvent e) throws InterruptedException {

        JFrame topFrame = (JFrame) SwingUtilities.getRoot(this);
        winCondition(player1, player2, topFrame);

        if(e.getKeyCode() == KeyEvent.VK_LEFT) player1.left = true;
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) player1.right = true;

        if(e.getKeyCode() == KeyEvent.VK_UP) player1.up = true;
        if(e.getKeyCode() == KeyEvent.VK_DOWN) player1.down = true;

        if(e.getKeyChar() == 'w') player2.up = true;
        if(e.getKeyChar() == 's') player2.down = true;

        if(e.getKeyChar() == 'a') player2.left = true;
        if(e.getKeyChar() == 'd') player2.right = true;
    }

    public void winCondition(Player p1, Player p2, JFrame topFrame) throws InterruptedException {
        if(p1.hitbox.intersects(p2.hitbox)){
            Thread.sleep(250);
            JOptionPane.showMessageDialog(this, "Magenta Wins!");
            topFrame.dispose();
        }
        else if((p1.x <= 0 || p1.x >= Constants.userScreenSize.width) ||
                (p1.y <= 0 || p1.y >= Constants.userScreenSize.height)){
            Thread.sleep(250);
            JOptionPane.showMessageDialog(this, "Green Loses!");
            topFrame.dispose();
        }
        else if((p2.x <= 0 || p2.x >= Constants.userScreenSize.width) ||
                (p2.y <= 0 || p2.y >= Constants.userScreenSize.height)){
            Thread.sleep(250);
            JOptionPane.showMessageDialog(this, "Magenta Loses!");
            topFrame.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
