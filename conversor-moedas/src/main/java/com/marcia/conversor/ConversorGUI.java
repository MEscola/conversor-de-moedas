package com.marcia.conversor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConversorGUI extends JFrame {

    private JComboBox<String> baseCombo;
    private JComboBox<String> targetCombo;
    private JTextField amountField;
    private JButton convertButton;
    private JLabel resultLabel;

    public ConversorGUI() {
        super("Conversor de Moedas");

        setLayout(new GridLayout(5, 2, 5, 5));

        add(new JLabel("Moeda base:"));
        baseCombo = new JComboBox<>(new String[]{"BRL", "USD", "EUR", "GBP"});
        add(baseCombo);

        add(new JLabel("Moeda destino:"));
        targetCombo = new JComboBox<>(new String[]{"BRL", "USD", "EUR", "GBP"});
        add(targetCombo);

        add(new JLabel("Valor:"));
        amountField = new JTextField();
        add(amountField);

        convertButton = new JButton("Converter");
        add(convertButton);

        resultLabel = new JLabel("Resultado:");
        add(resultLabel);

        convertButton.addActionListener(this::converter);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void converter(ActionEvent e) {
    try {
        String base = (String) baseCombo.getSelectedItem();
        String target = (String) targetCombo.getSelectedItem();
        double amount = Double.parseDouble(amountField.getText());

        Request request = new Request(); // instanciando
        Rates rates = request.baixaRate(base, target, amount);

        if ("success".equalsIgnoreCase(rates.getResult())) {
            double resultado = rates.getConversion_result();
            resultLabel.setText(String.format("Resultado: %.2f %s", resultado, target));
        } else {
            JOptionPane.showMessageDialog(this, "Erro na conversão. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Digite um valor válido!", "Erro", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Erro ao conectar com API: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(ConversorGUI::new);
    }
}
