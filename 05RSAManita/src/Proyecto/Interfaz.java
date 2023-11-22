package Proyecto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import javax.swing.*;

public class Interfaz extends JFrame {

    private final JPanel principal;
    private final JPanel encabezado;
    private final JLabel titulo;
    private final JPanel cuerpo;
    private final JTextField entrada;
    private final JButton cifrador;
    private final JButton vaciar;
    private final JTextArea salida;
    private final JLabel indicacionCifrado;
    private final JTextField textoDescifrado;
    private final JLabel indicacionDescifrado;

    public Interfaz() {
        titulo = new JLabel();
        encabezado = new JPanel();
        principal = new JPanel();
        cuerpo = new JPanel();
        indicacionDescifrado = new JLabel();
        cifrador = new JButton();
        salida = new JTextArea();
        textoDescifrado = new JTextField();
        indicacionCifrado = new JLabel();
        vaciar = new JButton();
        entrada = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("RSA a Manuela");
        setResizable(false);

        principal.setBackground(new Color(255, 255, 255));

        encabezado.setBackground(new Color(0, 102, 204));
        titulo.setFont(new Font("Arial", Font.BOLD, 36));
        titulo.setForeground(new Color(255, 255, 255));
        titulo.setText("Cifrado RSA");

        cuerpo.setBackground(new Color(240, 248, 255));
        indicacionCifrado.setFont(new Font("Arial", Font.PLAIN, 24));
        indicacionCifrado.setForeground(new Color(0, 0, 102));
        indicacionCifrado.setText("Texto a Cifrar");

        entrada.setBackground(new Color(255, 255, 255));
        entrada.setFont(new Font("Arial", Font.PLAIN, 18));
        entrada.setForeground(new Color(0, 0, 102));

        cifrador.setBackground(new Color(135, 206, 250));
        cifrador.setFont(new Font("Arial", Font.BOLD, 18));
        cifrador.setForeground(Color.BLACK);
        cifrador.setText("Cifrar");
        cifrador.setBorder(BorderFactory.createRaisedBevelBorder());
        cifrador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cifradorActionPerformed(evt);
            }
        });

        vaciar.setBackground(new Color(135, 206, 250));
        vaciar.setFont(new Font("Arial", Font.BOLD, 18));
        vaciar.setForeground(Color.BLACK);
        vaciar.setText("Borrar");
        vaciar.setBorder(BorderFactory.createRaisedBevelBorder());
        vaciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                vaciarActionPerformed(evt);
            }
        });

        salida.setEditable(false);
        salida.setBackground(new Color(255, 255, 255));
        salida.setFont(new Font("Arial", Font.PLAIN, 18));
        salida.setForeground(new Color(0, 0, 102));

        indicacionDescifrado.setFont(new Font("Arial", Font.PLAIN, 24));
        indicacionDescifrado.setForeground(new Color(0, 0, 102));
        indicacionDescifrado.setText("Texto Descifrado");

        textoDescifrado.setEditable(false);
        textoDescifrado.setBackground(new Color(255, 255, 255));
        textoDescifrado.setFont(new Font("Arial", Font.PLAIN, 18));
        textoDescifrado.setForeground(new Color(0, 0, 102));

        GroupLayout cuerpoLayout = new GroupLayout(cuerpo);
        cuerpo.setLayout(cuerpoLayout);
        cuerpoLayout.setHorizontalGroup(
            cuerpoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(cuerpoLayout.createSequentialGroup()
                    .addContainerGap(50, Short.MAX_VALUE)
                    .addGroup(cuerpoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(cuerpoLayout.createSequentialGroup()
                            .addGroup(cuerpoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(indicacionCifrado)
                                .addComponent(entrada, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(cuerpoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(vaciar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cifrador, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(cuerpoLayout.createSequentialGroup()
                            .addGroup(cuerpoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(salida, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                .addComponent(indicacionDescifrado)
                                .addComponent(textoDescifrado, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                            .addGap(50, 50, 50)))
                    .addContainerGap(50, Short.MAX_VALUE))
        );
        cuerpoLayout.setVerticalGroup(
            cuerpoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(cuerpoLayout.createSequentialGroup()
                    .addContainerGap(30, Short.MAX_VALUE)
                    .addGroup(cuerpoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, cuerpoLayout.createSequentialGroup()
                            .addComponent(indicacionCifrado)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(entrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(GroupLayout.Alignment.TRAILING, cuerpoLayout.createSequentialGroup()
                            .addComponent(cifrador)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(vaciar)))
                    .addGap(18, 18, 18)
                    .addComponent(salida, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(indicacionDescifrado)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textoDescifrado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(30, Short.MAX_VALUE))
        );

        GroupLayout principalLayout = new GroupLayout(principal);
        principal.setLayout(principalLayout);
        principalLayout.setHorizontalGroup(
            principalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(encabezado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cuerpo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        principalLayout.setVerticalGroup(
            principalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(principalLayout.createSequentialGroup()
                    .addComponent(encabezado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cuerpo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(principal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(principal, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void cifradorActionPerformed(ActionEvent evt) {
        try {
            String mensaje = entrada.getText();
            RSA rsa = new RSA(1024);

            rsa.generarPrimos();
            rsa.generarClaves();

            BigInteger[] mensajeCifrado = rsa.cifrar(mensaje);

            StringBuilder textoCifrado = new StringBuilder();
            for (BigInteger num : mensajeCifrado) {
                textoCifrado.append(num).append(" ");
            }

            String formattedText = textoCifrado.toString();
            StringBuilder finalText = new StringBuilder();
            int charsPerLine = 75;

            for (int i = 0; i < formattedText.length(); i += charsPerLine) {
                finalText.append(formattedText, i, Math.min(formattedText.length(), i + charsPerLine)).append("\n");
            }

            salida.setText(finalText.toString());

            String mensajeDescifrado = rsa.descifrar(mensajeCifrado);

            textoDescifrado.setText(mensajeDescifrado);
        } catch (Exception e) {
            String mensajeError = "Se produjo un error al cifrar/descifrar el mensaje.\nDetalles: " + e.getMessage();
            JOptionPane.showMessageDialog(this, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void vaciarActionPerformed(ActionEvent evt) {
        entrada.setText("");
        salida.setText("");
        textoDescifrado.setText("");
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(() -> {
            new Interfaz().setVisible(true);
        });
    }
}
