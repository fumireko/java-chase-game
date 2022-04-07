import javax.swing.*;
import java.awt.*;

public class MenuSettings extends JFrame{

    public MenuSettings(){
        super();
        initialize();
    }

    private JPanel getJContentPane(){
        if(jContentPane == null){
            jContentPane = new JPanel();
            jContentPane.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            jContentPane.add(getLabelWidth(), gbc);
            jContentPane.add(getCbWidth(), gbc);
            jContentPane.add(getLabelHeight(), gbc);
            jContentPane.add(getCbHeight(), gbc);
            gbc.insets = new Insets(10, 0, 0, 0);
            jContentPane.add(new JSeparator());
            jContentPane.add(getLabelVolume(), gbc);
            jContentPane.add(getVolumeSlider(), gbc);
            jContentPane.add(getApplyButton(), gbc);
            jContentPane.add(Constants.getLeaveButton(), gbc);
        }
        return jContentPane;
    }

    private JLabel getLabelWidth() {
        if (labelWidth == null) {
            labelWidth = new JLabel();
            labelWidth.setText("Width");
        }
        return labelWidth;
    }

    private JLabel getLabelHeight() {
        if (labelHeight == null) {
            labelHeight = new JLabel();
            labelHeight.setText("Height");
        }
        return labelHeight;
    }

    private JLabel getLabelVolume() {
        if (labelVolume == null) {
            labelVolume = new JLabel();
            labelVolume.setText("Volume: " + Constants.curVolume);
        }
        return labelVolume;
    }

    private JButton getApplyButton(){
        if (applyButton == null){
            applyButton = new JButton();
            applyButton.setText("Apply");

            applyButton.addActionListener(e1 -> {
                Constants.setScreenWidthDivisor(getCbWidth().getSelectedIndex() + 1);
                Constants.setScreenHeightDivisor(getCbHeight().getSelectedIndex() + 1);
                JFrame topFrame = (JFrame) SwingUtilities.getRoot(getJContentPane());
                topFrame.setSize(Constants.userScreenSize);
                topFrame.setLocationRelativeTo(null);
            });
        }
        return applyButton;
    }

    private JSlider getVolumeSlider(){
        if(volumeSlider == null){
            volumeSlider = new JSlider(JSlider.HORIZONTAL, Constants.minVolume, Constants.maxVolume, Constants.curVolume);
            volumeSlider.setMajorTickSpacing(5);
            volumeSlider.setMinorTickSpacing(1);
            volumeSlider.setPaintTicks(true);
            volumeSlider.setPaintLabels(true);
            volumeSlider.addChangeListener(e -> {
                Constants.setCurVolume(volumeSlider.getValue());
                getLabelVolume().setText("Volume: " + Constants.curVolume);
            });
        }
        return volumeSlider;
    }

    private JComboBox<Double> getCbWidth(){
        if (cbWidth == null){
            Double[] divisorValuesWidth = {Constants.screenSize.getWidth(), Constants.screenSize.getWidth() / 2, Constants.screenSize.getWidth() / 3, Constants.screenSize.getWidth() / 4};
            cbWidth = new JComboBox<>(divisorValuesWidth);
        }
        return cbWidth;
    }

    private JComboBox<Double> getCbHeight(){
        if (cbHeight == null){
            Double[] divisorValuesHeight = {Constants.screenSize.getHeight(), Constants.screenSize.getHeight() / 2, Constants.screenSize.getHeight() / 3, Constants.screenSize.getHeight() / 4};
            cbHeight = new JComboBox<>(divisorValuesHeight);
        }
        return cbHeight;
    }

    private void initialize(){
        this.setSize(Constants.userScreenSize);
        this.setContentPane(getJContentPane());
        this.setTitle("Settings");
        this.setLocationRelativeTo(null);
    }

    JPanel jContentPane = null;

    JComboBox<Double> cbWidth = null;
    JComboBox<Double> cbHeight = null;

    JButton applyButton = null;

    JSlider volumeSlider = null;

    JLabel labelWidth = null;
    JLabel labelHeight = null;
    JLabel labelVolume = null;
}
