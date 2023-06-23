package Construcoes;

import ClassesGUI.TamanhoCompon;
import ClassesJogo.Cidade;
import ClassesJogo.Constantes;
import ClassesJogo.Imagens;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class Loja extends Rentavel{

    public Loja(int coordX, int coordY) {
        super(Constantes.FATOR_DIN_LOJA.getQtd(), Constantes.PRECO_LOJA.getQtd() / 2,
                coordX, coordY, Imagens.PATH_LOJA.getPath(), Constantes.PRECO_LOJA.getQtd());

        montarLabelImg();
    }

    public void montarLabelImg() {

        ImageIcon img = new ImageIcon(Imagens.PATH_LOJA.getPath());
        int ximg = TamanhoCompon.X_BOTAO_LAT.getTam();
        int yimg = TamanhoCompon.Y_BOTAO_LAT.getTam();
        img.setImage(img.getImage().getScaledInstance(ximg,yimg, Image.SCALE_SMOOTH));

        //Legenda da identificacao da construcao
        labelImg = new JLabel(String.format("Rentável " + getID()));
        labelImg.setHorizontalTextPosition(SwingConstants.CENTER);
        labelImg.setVerticalTextPosition(SwingConstants.BOTTOM);
        labelImg.setFont(new Font("Arial", Font.BOLD, 15));

        labelImg.setIcon(img);
        labelImg.setSize(2 * ximg,2 * yimg);
    }

    //Hidding
    public static Loja comprarConstr(Cidade cidade) {

        Loja loja = new Loja(cidade.gerarCoordRandom(), cidade.gerarCoordRandom());
        cidade.getListaRentaveis().add(loja);
        return loja;
    }

    //Modifica a aparencia da casa e deixa-a como "ampliada"
    @Override
    public void ampliar() {

        setFlagAmpliado(true);
        labelImg.setBorder(new MatteBorder(2, 2, 2, 2, Color.green));
    }
}
