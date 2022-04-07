import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    final GridLayout layout = new GridLayout(0, 1);

    public Menu(String name){
        super(name);
        setPreferredSize(Constants.userScreenSize);
        pack();
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void addToPane(final Container c){
        final JPanel pane = new JPanel();
        pane.setLayout(layout);

        JButton buttonPlay = new JButton("Play");
        buttonPlay.addActionListener(e -> {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    GameFrame game = new GameFrame();
                    game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    game.setVisible(true);
                }
            });
        });

        JButton buttonSettings = new JButton("Settings");
        buttonSettings.addActionListener(e -> {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    MenuSettings settings = new MenuSettings();
                    settings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    settings.setVisible(true);
                }
            });
        });

        JButton buttonHelp = new JButton("Help");
        buttonHelp.addActionListener(e -> {
            JOptionPane.showMessageDialog(pane, "Controls: WASD for player one, Arrows for player two. Player one has to chase and overlap player two to win.\n\n" +
                    "Magenta -- Player one\nGreen -- Player two.");
        });

        pane.add(buttonPlay);
        pane.add(buttonSettings);
        pane.add(buttonHelp);

        JPanel footer = new JPanel();
        footer.add(Constants.getLeaveButton());

        final JPanel label = new JPanel();
        JLabel x = new JLabel("Game Title", JLabel.CENTER);
        x.setFont(new Font("Serif", Font.PLAIN, 18));
        label.add(x);

        c.add(label, BorderLayout.PAGE_START);
        c.add(new JSeparator(), BorderLayout.LINE_START);
        c.add(pane, BorderLayout.CENTER);
        c.add(footer, BorderLayout.SOUTH);
    }

    private static void showMenu() {
        Menu menu = new Menu("Game");
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.addToPane(menu.getContentPane());
        menu.pack();
        menu.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        UIManager.put("swing.boldMetal", Boolean.TRUE);
        javax.swing.SwingUtilities.invokeLater(Menu::showMenu);
    }
}