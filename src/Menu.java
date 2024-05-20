import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.jar.JarEntry;

public class Menu {
    JPanel introPanel = new JPanel();
    JFrame frame = new JFrame();

    JButton singlePlayer = new JButton("1 Jugador vs IA");
    JButton doublePlayer = new JButton("2 Jugadores");
    public Menu(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setContentPane(introPanel);
        frame.setLayout(null);
        frame.pack();
        frame.setVisible(true);

        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Hundir la flota");


        singlePlayer.setPreferredSize(new Dimension(130,20));
        doublePlayer.setPreferredSize(new Dimension(130,20));
        singlePlayer.setSize(130,20);
        doublePlayer.setSize(130,20);

        introPanel.setPreferredSize(new Dimension(140,60));
        introPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel fondo = new JLabel();

        final String FONDO_IMG = "img/fondo.jpg";

        URL url = getClass().getResource(FONDO_IMG);
        ImageIcon imageIcon = new ImageIcon(url);
        Icon icon = new ImageIcon(imageIcon.getImage());
        fondo.setIcon(icon);


//        final String FONDO_IMG2 = "../img/fondo.jpg";
//
//        fondo.setIcon(new ImageIcon(FONDO_IMG2));
        fondo.setBounds(0,0,400,400);
        fondo.setSize(400,400);
        fondo.setVisible(true);

        fondo.add(singlePlayer);
        fondo.add(doublePlayer);

        singlePlayer.setLocation(frame.getWidth()/2 - singlePlayer.getWidth()/2,frame.getWidth()/2 - singlePlayer.getHeight()*2);
        doublePlayer.setLocation(frame.getWidth()/2 - doublePlayer.getWidth()/2,frame.getWidth()/2 - singlePlayer.getHeight()*2 + 20);

        frame.add(fondo);

        frame.revalidate();
        frame.repaint();

        eventos();
    }

    private void eventos() {

        singlePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Users(1);
                frame.setVisible(false);
            }
        });

        doublePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Users(2);
                frame.setVisible(false);
            }
        });
    }
}
