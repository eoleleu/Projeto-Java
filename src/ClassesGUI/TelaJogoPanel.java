package ClassesGUI;

import ClassesJogo.Imagens;
import Construcoes.Construcao;
import Construcoes.Casa;

import javax.swing.*;
import java.awt.*;

public class TelaJogoPanel extends JPanel {

    public TelaJogoPanel() {
        setLayout(null);
        setVisible(true);
    }

    public void paintComponent(Graphics g) {
        ImageIcon img = new ImageIcon(PathBack.PATH_DESERTO1.getPath());
        int proporcaoImg = TamanhoCompon.DIM_PANEL_JOGO.getTam();
        img.setImage(img.getImage().getScaledInstance(proporcaoImg, proporcaoImg, Image.SCALE_SMOOTH));
        g.drawImage(img.getImage(), 0,0, proporcaoImg,proporcaoImg,null);
    }

    public void addConstrucao(Casa constr){
        JLabel labelImg = constr.getLabelImg();
        labelImg.setBounds(labelImg.getX(), labelImg.getY(), constr.getCoordX(), constr.getCoordY());
        this.add(labelImg);
    }

}
