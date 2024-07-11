package com.mycompany.restaurante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Restaurante extends JFrame {

    private List<String>[] comidasSemana = new ArrayList[5];
    private List<String>[] bebidasSemana = new ArrayList[5];

    public Restaurante() {
        setTitle("Restaurante");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializa as listas para cada dia da semana
        for (int i = 0; i < 5; i++) {
            comidasSemana[i] = new ArrayList<>();
            bebidasSemana[i] = new ArrayList<>();
        }

        // Configuração do layout
        setLayout(new BorderLayout());

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        // Botões
        JButton btnInserirCardapio = new JButton("Inserir cardápio");
        JButton btnVerCardapio = new JButton("Ver cardápio da semana inteira");
        JButton btnSair = new JButton("Sair");

        // Adiciona os botões ao painel
        panel.add(btnInserirCardapio);
        panel.add(btnVerCardapio);
        panel.add(btnSair);

        // Adiciona o painel principal ao frame
        add(panel, BorderLayout.CENTER);

        // Ação dos botões
        btnInserirCardapio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inserirCardapio();
            }
        });

        btnVerCardapio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verCardapio();
            }
        });

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void inserirCardapio() {
        String[] diasSemana = {"Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira"};
        String dia = (String) JOptionPane.showInputDialog(null, "Escolha o dia da semana:",
                "Inserir Cardápio", JOptionPane.QUESTION_MESSAGE, null, diasSemana, diasSemana[0]);

        if (dia == null) return;

        int indice = -1;
        for (int i = 0; i < diasSemana.length; i++) {
            if (dia.equals(diasSemana[i])) {
                indice = i;
                break;
            }
        }

        if (indice == -1) {
            JOptionPane.showMessageDialog(null, "Dia inválido.");
            return;
        }

        String comidas = JOptionPane.showInputDialog("Digite as comidas separadas por vírgula:");
        if (comidas != null) {
            String[] comidasArray = comidas.split(",");
            for (String comida : comidasArray) {
                comidasSemana[indice].add(comida.trim());
            }
        }

        String bebidas = JOptionPane.showInputDialog("Digite as bebidas separadas por vírgula:");
        if (bebidas != null) {
            String[] bebidasArray = bebidas.split(",");
            for (String bebida : bebidasArray) {
                bebidasSemana[indice].add(bebida.trim());
            }
        }

        JOptionPane.showMessageDialog(null, "Cardápio atualizado para " + dia + ".");
    }

    private void verCardapio() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(getDiaSemana(i + 1)).append(":\n");
            sb.append("Comidas: ").append(comidasSemana[i]).append("\n");
            sb.append("Bebidas: ").append(bebidasSemana[i]).append("\n\n");
        }
        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 300));
        JOptionPane.showMessageDialog(null, scrollPane, "Cardápio da Semana", JOptionPane.INFORMATION_MESSAGE);
    }

    public static String getDiaSemana(int dia) {
        switch (dia) {
            case 1:
                return "Segunda-feira";
            case 2:
                return "Terça-feira";
            case 3:
                return "Quarta-feira";
            case 4:
                return "Quinta-feira";
            case 5:
                return "Sexta-feira";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Restaurante().setVisible(true);
            }
        });
    }
}

