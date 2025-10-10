import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraRosa extends JFrame implements ActionListener {
    // Campos e botões
    private JTextField tela;
    private double num1, num2, resultado;
    private char operador;

    public CalculadoraRosa() {
        // Configurações da janela
        setTitle("Calculadora Rosa 💗");
        setSize(350, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(255, 182, 193)); // Rosa claro

        // Campo de texto (tela)
        tela = new JTextField();
        tela.setBounds(30, 40, 280, 50);
        tela.setEditable(false);
        tela.setFont(new Font("Arial", Font.BOLD, 22));
        tela.setBackground(Color.WHITE);
        tela.setHorizontalAlignment(SwingConstants.RIGHT);
        add(tela);

        // Painel de botões
        JPanel painel = new JPanel();
        painel.setBounds(30, 110, 280, 320);
        painel.setLayout(new GridLayout(5, 4, 10, 10));
        painel.setBackground(new Color(255, 192, 203));

        // Botões
        String[] botoes = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C"
        };

        for (String texto : botoes) {
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Arial", Font.BOLD, 20));
            botao.setBackground(new Color(255, 105, 180)); // Rosa forte
            botao.setForeground(Color.WHITE);
            botao.setFocusPainted(false);
            botao.addActionListener(this);
            painel.add(botao);
        }

        add(painel);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if ((comando.charAt(0) >= '0' && comando.charAt(0) <= '9') || comando.equals(".")) {
            tela.setText(tela.getText() + comando);
        } else if (comando.equals("C")) {
            tela.setText("");
            num1 = num2 = resultado = 0;
        } else if (comando.equals("=")) {
            num2 = Double.parseDouble(tela.getText());
            switch (operador) {
                case '+': resultado = num1 + num2; break;
                case '-': resultado = num1 - num2; break;
                case '*': resultado = num1 * num2; break;
                case '/': 
                    if (num2 == 0) {
                        tela.setText("Erro");
                        return;
                    }
                    resultado = num1 / num2; 
                    break;
            }
            tela.setText(String.valueOf(resultado));
        } else { 
            if (!tela.getText().isEmpty()) {
                num1 = Double.parseDouble(tela.getText());
                operador = comando.charAt(0);
                tela.setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculadoraRosa().setVisible(true);
        });
    }
}
