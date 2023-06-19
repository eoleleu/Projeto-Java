package ClassesGUI;

import javax.swing.*;
import java.awt.*;

import ClassesJogo.*;
import Construcoes.Casa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MenuLateralPanel extends JPanel {
    Cidade cidade;
    JLabel pop;
    JLabel din;
    JLabel infra;
    JLabel felic;
    TelaJogoPanel jogoPanel;

    public MenuLateralPanel(Cidade cidade, TelaJogoPanel jogoPanel) {

        this.cidade = cidade;
        this.jogoPanel = jogoPanel;
        GridLayout gridLayout = new GridLayout(5,2);
        setLayout(gridLayout);
        setSize(TamanhoCompon.X_PANEL_LATERAL.getTam(), TamanhoCompon.Y_PANEL_LATERAL.getTam());

        setLabelStats();

        setBotoesConstr();

        setVisible(true);
    }

    private void setBotoesConstr() {

        //ImageIcons para botoes
        ImageIcon imgCasa = new ImageIcon(Imagens.PATH_CASA.getPath());
        ImageIcon imgParque = new ImageIcon(Imagens.PATH_PARQUEARB.getPath());
        ImageIcon imgHosp = new ImageIcon(Imagens.PATH_HOSPITAL.getPath());
        ImageIcon imgDeleg = new ImageIcon(Imagens.PATH_DELEGACIA.getPath());
        ImageIcon imgLoja = new ImageIcon(Imagens.PATH_LOJA.getPath());
        ImageIcon imgIndust = new ImageIcon(Imagens.PATH_INDUSTRIA.getPath());

        ArrayList<ImageIcon> arrayIcons = new ArrayList<>();
        Collections.addAll(arrayIcons, imgCasa, imgParque, imgHosp, imgDeleg, imgLoja, imgIndust);

        int ximg = TamanhoCompon.X_BOTAO_LAT.getTam();
        int yimg = TamanhoCompon.Y_BOTAO_LAT.getTam();

        for (ImageIcon i : arrayIcons) {
            i.setImage(i.getImage().getScaledInstance(ximg, yimg, Image.SCALE_SMOOTH));
        }



        JButton bCasa = new JButton(String.format("Casa: $" + Constantes.PRECO_CASA.getQtd()), imgCasa);
        JButton bParque = new JButton(String.format("Parque arborizado: $" + Constantes.PRECO_PARQUE_ARB.getQtd()), imgParque);
        JButton bHosp = new JButton(String.format("Hospital: $" + Constantes.PRECO_HOSPITAL.getQtd()), imgHosp);
        JButton bDeleg = new JButton(String.format("Delegacia: $" + Constantes.PRECO_DELEGACIA.getQtd()), imgDeleg);
        JButton bLoja = new JButton(String.format("Loja: $" + Constantes.PRECO_LOJA.getQtd()), imgLoja);
        JButton bIndust = new JButton(String.format("Indústria: $" + Constantes.PRECO_INDUSTRIA.getQtd()), imgIndust);



        ArrayList<JButton> arrayBotoes = new ArrayList<>();
        Collections.addAll(arrayBotoes, bCasa, bParque, bHosp, bDeleg, bLoja, bIndust);

        bCasa.addActionListener(new comprarCasa());
        bParque.addActionListener(new comprarParque());
        bHosp.addActionListener(new comprarHospital());
        bDeleg.addActionListener(new comprarDeleg());
        bLoja.addActionListener(new comprarLoja());
        bIndust.addActionListener(new comprarIndust());

        for (JButton b : arrayBotoes) {
            b.setHorizontalTextPosition(SwingConstants.CENTER);
            b.setVerticalTextPosition(SwingConstants.BOTTOM);
            add(b);
        }


    }

    private void setLabelStats() {

        pop = new JLabel(String.format("População: " + cidade.getStats().getPop()));
        din = new JLabel(String.format("Dinheiro: $" + cidade.getStats().getDin()));
        infra = new JLabel(String.format("Infraestrutura: " + cidade.getStats().getInfra()));
        felic = new JLabel(String.format("Felicidade: " + cidade.getStats().getFelic()));

        add(pop);
        add(din);
        add(infra);
        add(felic);
    }

     private void dialogFaltouDin() {
         Font fonte_padrao = new Font("Arial", Font.PLAIN, 23);
         JDialog dialog = new JDialog();
         dialog.setBounds(400,300,300,100);
         JLabel labelErro = new JLabel("Faltou dinheiro!");
         labelErro.setFont(fonte_padrao);
         dialog.add(labelErro);
         dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         dialog.setVisible(true);
     }

    private void dialogComprado() {
        Font fonte_padrao = new Font("Arial", Font.PLAIN, 23);
        JDialog dialog = new JDialog();
        dialog.setBounds(400,300,300,100);
        JLabel labelErro = new JLabel("Comprado com sucesso!");
        labelErro.setFont(fonte_padrao);
        dialog.add(labelErro);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

     class comprarCasa implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cidade.getStats().getDin() >= Constantes.PRECO_CASA.getQtd()){
                cidade.getStats().atualizarDinAtual(-Constantes.PRECO_CASA.getQtd());

                Random gerador = new Random();
                int x = gerador.nextInt(600);
                int y = gerador.nextInt(600);
                Casa casa = new Casa(x, y);
                //MenuSuperiorPanel.addCadaComboBox();
                cidade.listaHabitaveis.add(casa);
                jogoPanel.addConstrucao(casa);
                dialogComprado();
            }else {
                dialogFaltouDin();
            }
        }
    }

    class comprarParque implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cidade.getStats().getDin() >= Constantes.PRECO_PARQUE_ARB.getQtd()) {
                cidade.getStats().atualizarDinAtual(-Constantes.PRECO_PARQUE_ARB.getQtd());
                dialogComprado();
            }else {
                dialogFaltouDin();
            }
        }
    }

    class comprarHospital implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cidade.getStats().getDin() >= Constantes.PRECO_HOSPITAL.getQtd()) {
                cidade.getStats().atualizarDinAtual(-Constantes.PRECO_HOSPITAL.getQtd());
                dialogComprado();
            }else {
                dialogFaltouDin();
            }
        }
    }

    class comprarDeleg implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cidade.getStats().getDin() >= Constantes.PRECO_DELEGACIA.getQtd()) {
                cidade.getStats().atualizarDinAtual(-Constantes.PRECO_DELEGACIA.getQtd());
                dialogComprado();
            }else {
                dialogFaltouDin();
            }
        }
    }

    class comprarLoja implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cidade.getStats().getDin() >= Constantes.PRECO_LOJA.getQtd()) {
                cidade.getStats().atualizarDinAtual(-Constantes.PRECO_LOJA.getQtd());
                dialogComprado();
            }else {
                dialogFaltouDin();
            }
        }
    }

    class comprarIndust implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cidade.getStats().getDin() >= Constantes.PRECO_INDUSTRIA.getQtd()) {
                cidade.getStats().atualizarDinAtual(-Constantes.PRECO_INDUSTRIA.getQtd());
                dialogComprado();
            } else {
                dialogFaltouDin();
            }
        }
    }

}
