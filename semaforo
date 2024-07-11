package com.mycompany.semaforo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Semaforo {

    private boolean aberto;
    private boolean digital;
    private int tempoAberto;
    private int tempoFechado;
    private String tipo;
    private int tempoRestante;
    private boolean amarelo;
//construtor... valores padroes
    public Semaforo(boolean digital) {
        this.aberto = false;
        this.digital = digital;
        this.tempoAberto = 5000;
        this.tempoFechado = 5000;
        this.tipo = this.digital ? "digital" : "quadrado";
        this.tempoRestante = this.aberto ? this.tempoAberto : this.tempoFechado;
        this.amarelo = false;
    }
//metodos
    public void abre() {
        this.amarelo = false;
        this.aberto = true;
        this.tempoRestante = this.tempoAberto;
    }

    public void fecha() {
        this.amarelo = false;
        this.aberto = false;
        this.tempoRestante = this.tempoFechado;
    }

    public void iniciarAmarelo() {
        this.amarelo = true;
        this.tempoRestante = 5000;
    }

    public void tempo(int t) {
        if (this.aberto) {
            this.tempoAberto = t;
        } else {
            this.tempoFechado = t;
        }
        this.tempoRestante = t;
    }

    public boolean estaAberto() {
        return this.aberto;
    }

    public boolean estaFechado() {
        return !this.aberto;
    }

    public void mudarTipo() {
        this.digital = !this.digital;
        this.tipo = this.digital ? "digital" : "quadrado";
    }

    public String getTipo() {
        return this.tipo;
    }

    public int getTempoAberto() {
        return this.tempoAberto;
    }

    public int getTempoFechado() {
        return this.tempoFechado;
    }

    public int getTempoRestante() {
        return this.tempoRestante / 1000;
    }

    public void decrementarTempo() {
        this.tempoRestante -= 1000;
    }

    public boolean estaExibindoAmarelo() {
        return this.amarelo;
    }

    public void alternarAmarelo() {
        this.amarelo = !this.amarelo;
    }
//classe
    static class Cruzamento extends JPanel {
        //instancias 
        private Semaforo semaforo1;
        private Semaforo semaforo2;

        public Cruzamento() {
            //inicializa como digitais que era pra ser tradicional
            this.semaforo1 = new Semaforo(true);
            this.semaforo2 = new Semaforo(true);
            this.semaforo2.tempo(10000);
            iniciarTemporizador();
        }

        public Semaforo getSemaforo1() {
            return this.semaforo1;
        }

        public Semaforo getSemaforo2() {
            return this.semaforo2;
        }
//muda o tipo dos semáforos e solicita a repintura do painel
        
        public void mudarTipoSemaforo1ParaQuadrado() {
            this.semaforo1.mudarTipo();
            repaint();
        }

        public void mudarTipoSemaforo2ParaQuadrado() {
            this.semaforo2.mudarTipo();
            repaint();
        }
//onde esta sendo desenhado os semaforos
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (semaforo1.getTipo().equals("digital")) {
                desenharSemaforo(g, 50, 50, semaforo1);
            } else {
                desenharSemaforoQuadrado(g, 50, 50, semaforo1);
            }

            if (semaforo2.getTipo().equals("digital")) {
                desenharSemaforo(g, 250, 50, semaforo2);
            } else {
                desenharSemaforoQuadrado(g, 250, 50, semaforo2);
            }
        }

        private void desenharSemaforo(Graphics g, int x, int y, Semaforo semaforo) {
            g.setColor(Color.DARK_GRAY);
            g.fillRoundRect(x, y, 60, 160, 20, 20);
//coordenadas e dimensões utilizadas para desenhar
            g.setColor(Color.GRAY);
            g.fillOval(x + 15, y + 25, 30, 30);
            g.fillOval(x + 15, y + 65, 30, 30);
            g.fillOval(x + 15, y + 105, 30, 30);

            if (semaforo.estaAberto()) {
                if (semaforo.estaExibindoAmarelo()) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(x + 15, y + 65, 30, 30);
                } else {
                    g.setColor(Color.GREEN);
                    g.fillOval(x + 15, y + 105, 30, 30);
                }
            } else {
                if (semaforo.estaExibindoAmarelo()) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(x + 15, y + 65, 30, 30);
                } else {
                    g.setColor(Color.RED);
                    g.fillOval(x + 15, y + 25, 30, 30);
                }
            }
        }

        private void desenharSemaforoQuadrado(Graphics g, int x, int y, Semaforo semaforo) {
            g.setColor(Color.DARK_GRAY);
            g.fillRoundRect(x, y, 120, 160, 20, 20);

            g.setColor(Color.GRAY);
            g.fillOval(x + 15, y + 25, 30, 30);
            g.fillOval(x + 15, y + 65, 30, 30);
            g.fillOval(x + 15, y + 105, 30, 30);

            if (semaforo.estaAberto()) {
                if (semaforo.estaExibindoAmarelo()) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(x + 15, y + 65, 30, 30);
                } else {
                    g.setColor(Color.GREEN);
                    g.fillOval(x + 15, y + 105, 30, 30);
                }
            } else {
                if (semaforo.estaExibindoAmarelo()) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(x + 15, y + 65, 30, 30);
                } else {
                    g.setColor(Color.RED);
                    g.fillOval(x + 15, y + 25, 30, 30);
                }
            }

            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 18));
            g.drawString(String.valueOf(semaforo.getTempoRestante()), x + 55, y + 120);
        }
//alternar entre aberto ou fechado e sincroniza para evitar ficar igual.
        private void iniciarTemporizador() {
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    semaforo1.decrementarTempo();
                    if (semaforo1.getTempoRestante() <= 0) {
                        if (semaforo1.estaExibindoAmarelo()) {
                            if (semaforo1.estaAberto()) {
                                semaforo1.fecha();
                            } else {
                                semaforo1.abre();
                            }
                        } else {
                            semaforo1.iniciarAmarelo();
                        }
                    }

                    semaforo2.decrementarTempo();
                    if (semaforo2.getTempoRestante() <= 0) {
                        if (semaforo2.estaExibindoAmarelo()) {
                            if (semaforo2.estaAberto()) {
                                semaforo2.fecha();
                            } else {
                                semaforo2.abre();
                            }
                        } else {
                            semaforo2.iniciarAmarelo();
                        }
                    }

                    if (semaforo1.estaAberto() && semaforo2.estaAberto()) {
                        semaforo2.fecha();
                    } else if (semaforo1.estaFechado() && semaforo2.estaFechado()) {
                        semaforo2.abre();
                    }

                    repaint();
                }
            });
            timer.start();
        }
    }

    //configura e exibe a interface gráfica, permitindo a interação com os semáforos através de botões.
    public static void main(String[] args) {
        //cria e configura a janela principal (JFrame).
        JFrame frame = new JFrame("Simulação de Semáforo");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Cruzamento cruzamento = new Cruzamento();
        frame.add(cruzamento, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 2));

        JButton btnMudarTipoSemaforo1 = new JButton("Mudar Tipo Semáforo 1");
        JButton btnMudarTipoSemaforo2 = new JButton("Mudar Tipo Semáforo 2");

        controlPanel.add(btnMudarTipoSemaforo1);
        controlPanel.add(btnMudarTipoSemaforo2);

        frame.add(controlPanel, BorderLayout.SOUTH);

        btnMudarTipoSemaforo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cruzamento.getSemaforo1().mudarTipo();
                cruzamento.repaint();
            }
        });

        btnMudarTipoSemaforo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cruzamento.getSemaforo2().mudarTipo();
                cruzamento.repaint();
            }
        });

        frame.setVisible(true);
    }
}
