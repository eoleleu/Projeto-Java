package ClassesGUI;

import ClassesJogo.Imagens;
import Construcoes.Construcao;
import Construcoes.Casa;

import javax.swing.*;
import java.awt.*;

public class TelaJogoPanel extends JPanel {
    private String pathBackground;
    public TelaJogoPanel(String pathBackground) {
        this.pathBackground = pathBackground;
        setLayout(null);
        int proporcaoImg = TamanhoCompon.DIM_PANEL_JOGO.getTam();
        setPreferredSize(new Dimension(proporcaoImg, proporcaoImg));
        setVisible(true);
    }

    //Pintando o background
    public void paintComponent(Graphics g) {
        ImageIcon img = new ImageIcon(pathBackground);
        int proporcaoImg = TamanhoCompon.DIM_PANEL_JOGO.getTam();
        img.setImage(img.getImage().getScaledInstance(proporcaoImg, proporcaoImg, Image.SCALE_SMOOTH));
        g.drawImage(img.getImage(), 0,0, proporcaoImg,proporcaoImg,null);
    }

    //Funcao de adicionar a construcao na tela grafica
    public void addConstrucao(Construcao constr){
        JLabel labelImg = constr.getLabelImg();
        labelImg.setBounds(constr.getCoordX(), constr.getCoordY(),constr.getLabelImg().getWidth(),
                            constr.getLabelImg().getHeight());
        this.add(labelImg);
        labelImg.setVisible(true);
        revalidate(); //refresh do panel
        repaint();
    }

    //Funcao para remover construcao da tela grafica
    public void removeConstrucao(Construcao constr) {
        JLabel labelImg = constr.getLabelImg();
        labelImg.setVisible(false);
        this.remove(labelImg);
        revalidate(); //refresh do panel
        repaint();
    }

}
