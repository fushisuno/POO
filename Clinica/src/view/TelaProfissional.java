package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import model.Pessoa;
import model.Profissional;

public class TelaProfissional extends JFrame {

    private static final long serialVersionUID = 1L;

    // Inicialização dos botões para acessar outras telas
    private JButton btnTelaConsultas, btnTelaProntuarios, btnTelaPacientes;

    public TelaProfissional(Object funcionario) {
        super("Área do Profissional de Saúde");

        // Configuração da janela
        setSize(1024, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // Centraliza a janela

        // Painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(245, 245, 245));

        // Título
        JLabel titleLabel = new JLabel("Bem-vindo, " + ((Pessoa) funcionario).getNome(), SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setForeground(new Color(60, 90, 140));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));

        // Painel de botões
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(3, 1, 20, 20));
        btnPanel.setBorder(BorderFactory.createEmptyBorder(50, 150, 50, 150)); 
        btnPanel.setBackground(new Color(245, 245, 245));

        // Botões
        btnTelaConsultas = new JButton("Gerenciar Consultas");
        btnTelaProntuarios = new JButton("Gerenciar Prontuários");

        btnTelaConsultas.setToolTipText("Clique para gerenciar consultas.");
        btnTelaProntuarios.setToolTipText("Clique para gerenciar prontuários.");

        btnTelaConsultas.setFont(new Font("Arial", Font.BOLD, 18));
        btnTelaProntuarios.setFont(new Font("Arial", Font.BOLD, 18));

        btnTelaConsultas.setBackground(new Color(100, 150, 200));
        btnTelaProntuarios.setBackground(new Color(100, 150, 200));

        btnTelaConsultas.setForeground(Color.WHITE);
        btnTelaProntuarios.setForeground(Color.WHITE);

        btnTelaConsultas.setFocusPainted(false);
        btnTelaProntuarios.setFocusPainted(false);
        btnTelaConsultas = criarBotao("Gerenciar Consultas");
        btnTelaProntuarios = criarBotao("Gerenciar Prontuários");
        btnTelaPacientes = criarBotao("Gerenciar Pacientes");

        // Ações dos botões
        btnTelaConsultas.addActionListener(e -> abrirTelaConsultas(funcionario));
        btnTelaProntuarios.addActionListener(e -> abrirTelaProntuarios(funcionario));
        btnTelaPacientes.addActionListener(e -> abrirTelaPacientes(funcionario));

        // Adiciona os botões ao painel
        btnPanel.add(btnTelaConsultas);
        btnPanel.add(btnTelaProntuarios);
        btnPanel.add(btnTelaPacientes);

        // Adiciona os componentes ao painel principal
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(btnPanel, BorderLayout.CENTER);

        // Adiciona o painel principal à janela
        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    // Método para criar botões com estilo consistente
    private JButton criarBotao(String texto) {
        JButton button = new JButton(texto);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(new Color(100, 150, 200)); 
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0)); 
        return button;
    }

    // Métodos para abrir as telas de Consultas, Prontuários e Pacientes
    private void abrirTelaConsultas(Object profissional) {
        dispose();
        new TelaConsulta(profissional).setVisible(true);
    }

    private void abrirTelaProntuarios(Object profissional) {
        dispose();
        new TelaProntuario(profissional).setVisible(true);
    }

    private void abrirTelaPacientes(Object profissional) {
        dispose();
        new TelaPaciente(profissional).setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaProfissional(null).setVisible(true));
    }
}
