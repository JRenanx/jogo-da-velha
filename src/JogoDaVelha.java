import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

    public class JogoDaVelha implements ActionListener {

        Random random = new Random();
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel button_panel = new JPanel();
        JLabel textfield = new JLabel();
        JButton[] buttons = new JButton[9];
        boolean jogador1_turno;

        JogoDaVelha() {

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(750, 750);
            frame.getContentPane().setBackground(new Color(50, 50, 50));
            frame.setLayout(new BorderLayout());
            frame.setVisible(true);

            textfield.setBackground(new Color(25, 25, 25));
            textfield.setForeground(new Color(255, 255, 255));
            textfield.setFont(new Font("Arial", Font.BOLD, 75));
            textfield.setHorizontalAlignment(JLabel.CENTER);
            textfield.setText("Jogo da Velha");
            textfield.setOpaque(true);

            panel.setLayout(new BorderLayout());
            panel.setBounds(0, 0, 800, 100);

            button_panel.setLayout(new GridLayout(3, 3));
            button_panel.setBackground(new Color(20, 20, 20));

            for (int i = 0; i < 9; i++) {
                buttons[i] = new JButton();
                button_panel.add(buttons[i]);
                buttons[i].setFont(new Font("Arial", Font.BOLD, 120));
                buttons[i].setFocusable(false);
                buttons[i].addActionListener(this);
            }

            panel.add(textfield);
            frame.add(panel, BorderLayout.NORTH);
            frame.add(button_panel);

            firstTurn();

        }


        @Override
        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < 9; i++) {
                if (e.getSource() == buttons[i]) {
                    if (jogador1_turno) {
                        if (buttons[i].getText() == "") {
                            buttons[i].setForeground(new Color(255, 0, 0));
                            buttons[i].setText("X");
                            jogador1_turno = false;
                            textfield.setText("Vez do O");
                            check();
                        }
                    } else {
                        if (buttons[i].getText() == "") {
                            buttons[i].setForeground(new Color(0, 0, 255));
                            buttons[i].setText("O");
                            jogador1_turno = true;
                            textfield.setText("Vez do X");
                            check();

                        }
                    }

                }

            }
        }

        public void firstTurn() {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (random.nextInt(2) == 0) {
                jogador1_turno = true;
                textfield.setText("Vez do X");
            } else {
                jogador1_turno = false;
                textfield.setText("Vez do O");
            }

        }

        public void check() {
            //Condiçoes X
            if ((buttons[0].getText() == "X") &&
                    (buttons[1].getText() == "X") &&
                    (buttons[2].getText() == "X")
            ) {
                xGanhou(0, 1, 2);
            }
            if ((buttons[3].getText() == "X") &&
                    (buttons[4].getText() == "X") &&
                    (buttons[5].getText() == "X")
            ) {
                xGanhou(3, 4, 5);
            }
            if ((buttons[6].getText() == "X") &&
                    (buttons[7].getText() == "X") &&
                    (buttons[8].getText() == "X")
            ) {
                xGanhou(6, 7, 8);
            }
            if ((buttons[0].getText() == "X") &&
                    (buttons[3].getText() == "X") &&
                    (buttons[6].getText() == "X")
            ) {
                xGanhou(0, 3, 6);
            }
            if ((buttons[1].getText() == "X") &&
                    (buttons[4].getText() == "X") &&
                    (buttons[7].getText() == "X")
            ) {
                xGanhou(01, 4, 7);
            }
            if ((buttons[2].getText() == "X") &&
                    (buttons[5].getText() == "X") &&
                    (buttons[8].getText() == "X")
            ) {
                xGanhou(2, 5, 8);
            }
            if ((buttons[0].getText()=="X") &&
                    (buttons[4].getText()=="X") &&
                    (buttons[8].getText()=="X")
            ){
                xGanhou(0,4,8);
            }
            if ((buttons[2].getText()=="X") &&
                    (buttons[4].getText()=="X") &&
                    (buttons[6].getText()=="X")
            ){
                xGanhou(2,4,6);
            }
            //Condiçoes O

            if ((buttons[0].getText() == "O") &&
                    (buttons[1].getText() == "O") &&
                    (buttons[2].getText() == "O")
            ) {
                oGanhou(0, 1, 2);
            }
            if ((buttons[3].getText() == "O") &&
                    (buttons[4].getText() == "O") &&
                    (buttons[5].getText() == "O")
            ) {
                oGanhou(3, 4, 5);
            }
            if ((buttons[6].getText() == "O") &&
                    (buttons[7].getText() == "O") &&
                    (buttons[8].getText() == "O")
            ) {
                oGanhou(6, 7, 8);
            }
            if ((buttons[0].getText() == "O") &&
                    (buttons[3].getText() == "O") &&
                    (buttons[6].getText() == "O")
            ) {
                oGanhou(0, 3, 6);
            }
            if ((buttons[1].getText() == "O") &&
                    (buttons[4].getText() == "O") &&
                    (buttons[7].getText() == "O")
            ) {
                oGanhou(01, 4, 7);
            }
            if ((buttons[2].getText() == "O") &&
                    (buttons[5].getText() == "O") &&
                    (buttons[8].getText() == "O")
            ) {
                oGanhou(2, 5, 8);
            }
            if ((buttons[0].getText()=="O") &&
                    (buttons[4].getText()=="O") &&
                    (buttons[8].getText()=="O")
            ){
                oGanhou(0,4,8);
            }
            if ((buttons[2].getText()=="O") &&
                    (buttons[4].getText()=="O") &&
                    (buttons[6].getText()=="O")
            ){
                oGanhou(2,4,6);
            }
        }

        public void xGanhou(int a, int b, int c) {
            buttons[a].setBackground(Color.GREEN);
            buttons[b].setBackground(Color.GREEN);
            buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("X Ganhou!");

    }
        public void oGanhou(int a, int b, int c) {
            buttons[a].setBackground(Color.GREEN);
            buttons[b].setBackground(Color.GREEN);
            buttons[c].setBackground(Color.GREEN);

            for(int i=0;i<9;i++){
                buttons[i].setEnabled(false);
            }
            textfield.setText("O Ganhou!");

        }

    }

