import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class Main{

    public static void main(String[] args) {
        initComponents();
    }

    public static void initComponents(){
        Inicio.eventos();
        //new Inicio();
        //new Player1();
        new Menu();
    }
}