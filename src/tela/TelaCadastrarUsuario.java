package tela;

import enums.ObjetivoEnum;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TelaCadastrarUsuario extends JFrame {
    private JPanel contentPane;
    private JTextField txt_nome;
    private JTextField txt_dataNascimento;
    private JTextField txt_peso;
    private JTextField txt_sexo;
    private JTextField txt_objetivo;

    private static final Integer yDefault = 25;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaCadastrarUsuario frame = new TelaCadastrarUsuario();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TelaCadastrarUsuario() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 486, 580);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(12, 12, 70, 15);
        contentPane.add(lblNome);
        txt_nome = new JTextField();
        txt_nome.setBounds(221, 10, 253, 19);
        contentPane.add(txt_nome);
        txt_nome.setColumns(10);

        JLabel lblDataNascimento = new JLabel("Data Nascimento");
        lblDataNascimento.setBounds(12, 12 + yDefault, 110, 15);
        contentPane.add(lblDataNascimento);
        txt_dataNascimento = new JTextField();
        txt_dataNascimento.setBounds(221, 10 + yDefault, 253, 19);
        contentPane.add(txt_dataNascimento);
        txt_dataNascimento.setColumns(10);

        JLabel lblPeso = new JLabel("Peso");
        lblPeso.setBounds(12, 12 + yDefault * 2, 70, 15);
        contentPane.add(lblPeso);
        txt_peso = new JTextField();
        txt_peso.setBounds(221, 10 + yDefault * 2, 253, 19);
        contentPane.add(txt_peso);
        txt_peso.setColumns(10);

        JLabel lblSexo = new JLabel("Sexo");
        lblSexo.setBounds(12, 12 + yDefault * 3, 135, 15);
        contentPane.add(lblSexo);
        txt_sexo = new JTextField();
        txt_sexo.setBounds(221, 10 + yDefault * 3, 253, 19);
        contentPane.add(txt_sexo);
        txt_sexo.setColumns(10);

        JLabel lblObjetivo = new JLabel("Objetivo");
        lblObjetivo.setBounds(12, 12 + yDefault * 4, 135, 15);
        contentPane.add(lblObjetivo);
// Create a JComboBox with enum values
        ObjetivoEnum[] objetivoValues = ObjetivoEnum.values();
        JComboBox<ObjetivoEnum> comboBoxObjetivo = new JComboBox<>(objetivoValues);
        comboBoxObjetivo.setBounds(221, 10 + yDefault * 4, 253, 19);
        contentPane.add(comboBoxObjetivo);
    }
}
