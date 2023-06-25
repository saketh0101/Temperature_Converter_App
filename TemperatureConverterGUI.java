import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConverterGUI extends JFrame implements ActionListener {
    private JButton toCelsiusButton, toFahrenheitButton;
    private JLabel inputLabel, outputLabel, resultLabel;
    private JTextField inputField, outputField;

    public TemperatureConverterGUI() {
        setTitle("Temperature Converter");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        toCelsiusButton = new JButton("To Celsius");
        toFahrenheitButton = new JButton("To Fahrenheit");
        inputLabel = new JLabel("Input Temperature:");
        outputLabel = new JLabel("Converted Temperature:");
        inputField = new JTextField(10);
        outputField = new JTextField(10);
        outputField.setEditable(false);

        // arrange components using GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(inputLabel, gbc);

        gbc.gridx = 1;
        add(inputField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(outputLabel, gbc);

        gbc.gridx = 1;
        add(outputField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(toCelsiusButton, gbc);

        gbc.gridx = 1;
        add(toFahrenheitButton, gbc);

        toCelsiusButton.addActionListener(this);
        toFahrenheitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == toCelsiusButton) {
            double fahrenheit = Double.parseDouble(inputField.getText());
            double celsius = (fahrenheit - 32) * 5 / 9;
            outputField.setText(String.format("%.2f", celsius));
        } else if (e.getSource() == toFahrenheitButton) {
            double celsius = Double.parseDouble(inputField.getText());
            double fahrenheit = celsius * 9 / 5 + 32;
            outputField.setText(String.format("%.2f", fahrenheit));
        }
    }

    public static void main(String[] args) {
        TemperatureConverterGUI gui = new TemperatureConverterGUI();
        gui.setVisible(true);
    }
}