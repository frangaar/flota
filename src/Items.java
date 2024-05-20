import javax.swing.*;
import java.awt.*;

public class Items {

    final static String BARCO_IMG = "img/centro.jpg";
    final static String AGUA_IMG = "img/agua.jpg";
    final static String ROJO_IMG = "img/rojo.jpg"; //T
    final static String AMARILLO_IMG = "img/amarillo.jpg"; //D
    final static String AZUL_IMG = "img/azul.jpg"; //A
    final static String VERDE_IMG = "img/verde.jpg"; //I

    public static JLabel cabecera(String valor){

        JLabel cabecera = new JLabel();
        cabecera.setText(valor);
        cabecera.setToolTipText("Cabecera");
        cabecera.setSize(45,45);

        return cabecera;
    }
    public static JLabel agua(){

        JLabel agua = new JLabel();

        ImageIcon image = new ImageIcon(AGUA_IMG);

        agua.setIcon(image);
        agua.setToolTipText("Agua");
        agua.setSize(45,45);

        return agua;
    }

    public static JLabel barco(String tipo){

        JLabel barco = new JLabel();

        if(tipo.equals("SuperBarcoDanyado")){
            barco.setIcon(new ImageIcon(AMARILLO_IMG));
            barco.setToolTipText(tipo);
        }else if(tipo.equals("SuperBarco")){
            barco.setIcon(new ImageIcon(BARCO_IMG));
            barco.setToolTipText(tipo);
        }else{
            barco.setIcon(new ImageIcon(BARCO_IMG));
            barco.setToolTipText(tipo);
        }

        barco.setSize(45,45);
        barco.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        return barco;
    }

    public static JLabel tocado(String tipo){

        JLabel disparo = new JLabel();

        if(tipo.equals("Tocado")){
            disparo.setIcon(new ImageIcon(ROJO_IMG));
            disparo.setToolTipText("Tocado");
        }else if(tipo.equals("Danyado")){
            disparo.setIcon(new ImageIcon(AMARILLO_IMG));
            disparo.setToolTipText("Danyado");
        }else if(tipo.equals("Impacto")){
            disparo.setIcon(new ImageIcon(VERDE_IMG));
            disparo.setToolTipText("Impacto");
        }else if(tipo.equals("Agua")){
            disparo.setIcon(new ImageIcon(AZUL_IMG));
            disparo.setToolTipText("Fallo");
        }

        disparo.setText(tipo);
        disparo.setSize(45,45);
        disparo.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        return disparo;
    }
}
