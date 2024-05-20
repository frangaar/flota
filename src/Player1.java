import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Player1{

    public static JFrame frame = new JFrame();
    public static JPanel rootPanel = new JPanel();

    private JLabel lblbarcosJ1 = new JLabel("Barcos " + Users.nombreP1);
    private JLabel lbldisparosJ1 = new JLabel("Disparos " + Users.nombreP1);
    static JPanel player1 = new JPanel();
    static JPanel disparosP1 = new JPanel();
    static JPanel p1Buttons = new JPanel();
    static JButton izquierdaP1 = new JButton("<");
    static JButton derechaP1 = new JButton(">");

    static JLabel tipoBarcoP1 = new JLabel();

    static JLabel nameBarcoP1 = new JLabel();

    static ButtonGroup radioGroupP1 = new ButtonGroup();
    static JRadioButton verticalP1 = new JRadioButton("Vertical");
    static JRadioButton horizontalP1 = new JRadioButton("Horizontal");
    static JLabel tituloBarcosP1 = new JLabel();

    static JButton aceptarP1 = new JButton();

    static boolean finJuego = false;
    static boolean acierto = true;
    static boolean disparado = false;

    static boolean superBarco = false;

    static JLabel[][] tableroJ1 = {};
    static JLabel[][] disparosJ1 = {};

    static String[][] ubicacionBarcosP1 = new String[5][5];

    public Player1(){

        JOptionPane.showMessageDialog(null,"Turno de " + Users.nombreP1);

        vaciaDatos();

        if(Inicio.primeraVez){
            frame = Inicio.setInitialFrame(frame,rootPanel);
        }else{
            frame = Inicio.setPlayFrame(frame,rootPanel);
        }

        inicializarPlayer1();


        player1.add(lblbarcosJ1);
        rootPanel.add(player1);
        disparosP1.add(lbldisparosJ1);
        rootPanel.add(disparosP1);
        if(Inicio.primeraVez){
            player1.add(p1Buttons);
        }else{
            player1.remove(p1Buttons);
        }
        disparosP1.add(aceptarP1);

        //do {
        if(Inicio.primeraVez){
            tableroJ1 = Inicio.inicializarTablero(1);
            disparosJ1 = Inicio.inicializarTablero(1);
            tableroJ1 = Inicio.rellenarPlayer(player1, tableroJ1, Player2.tableroJ2,Inicio.barcosDisponibles, Users.nombreP1, 1);
            disparosJ1 = Inicio.rellenarPlayer(disparosP1, disparosJ1, Player2.tableroJ2,Inicio.barcosDisponibles, Users.nombreP1, 1);
            eventos();
            Mensajes.informacion();
        }else{
            //aceptarP1.setText("Pasar turno");
            aceptarP1.setVisible(false);
            tableroJ1 = Inicio.rellenarPlayer(player1, tableroJ1, Player2.tableroJ2,Inicio.barcosDisponibles, Users.nombreP1, 1);

            try {
                Socket cliente = new Socket("192.168.51.6", 6666);

                ObjectOutputStream dout = new ObjectOutputStream(cliente.getOutputStream());

                dout.writeObject(tableroJ1);

                cliente.close();

            } catch (Exception e) {
                System.out.println(e);
            }

            disparosJ1 = Inicio.rellenarPlayer(disparosP1, disparosJ1, Player2.tableroJ2,Inicio.barcosDisponibles, Users.nombreP1, 1);
        }

        rootPanel.revalidate();
        rootPanel.repaint();
    }

    private void vaciaDatos() {

        rootPanel.removeAll();
        player1.removeAll();
        disparosP1.removeAll();
        p1Buttons.removeAll();
        Player1.finJuego = false;
    }

    private void eventos() {

        aceptarP1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean continuar = true;
                int index = 0;

                if(Inicio.primeraVez){
                    while(continuar && index < Inicio.barcosDisponibles.length ){
                        if(Integer.parseInt(String.valueOf(Inicio.barcosDisponibles[index][2])) != 0){
                            continuar = false;
                            Mensajes.sinBarcos();
                        }
                        index++;
                        Player1.acierto = false;
                    }
                }

                if(!Inicio.primeraVez && continuar && (Player1.acierto || !Player1.disparado) && !Player1.finJuego){
                    Mensajes.noPasarTurno();
                }

                if(!Inicio.primeraVez && continuar && !Player1.acierto){
                    frame.setVisible(false);
                    Player2.acierto = true;
                    Player1.disparado = true;
                    Player2.disparado = true;
                    new Player2();
                }

                if(Inicio.primeraVez && continuar){
                    frame.setVisible(false);
                    Player2.acierto = true;
                    new Player2();
                }

                if(Player1.finJuego){
                    Player1.frame.dispose();
                    Player2.frame.dispose();
                    new Menu();
                }
            }
        });
    }

    private void inicializarPlayer1() {

        Inicio.barcosDisponibles = Inicio.inicializarListaBarcos();

        lblbarcosJ1 = Inicio.setLabel(lblbarcosJ1);
        lbldisparosJ1 = Inicio.setLabel(lbldisparosJ1);

        player1 = Inicio.setPlayer(player1, "Player1");
        disparosP1 = Inicio.setPlayer(disparosP1, "DisparosP1");

        p1Buttons = Inicio.setPanelButtons(p1Buttons);

        izquierdaP1 = Inicio.setButtons(izquierdaP1, 0, p1Buttons);
        derechaP1 = Inicio.setButtons(derechaP1, 50, p1Buttons);

        izquierdaP1 = Inicio.setImageIndex(izquierdaP1,0);
        derechaP1 = Inicio.setImageIndex(derechaP1,1);
        tipoBarcoP1 = Inicio.setTipoBarco(tipoBarcoP1);

        tituloBarcosP1 = Inicio.setTitulosBarco(tituloBarcosP1);

        nameBarcoP1 = Inicio.setNameBarco(nameBarcoP1);


        verticalP1 = Inicio.setOrientacion(verticalP1,0);
        horizontalP1 = Inicio.setOrientacion(horizontalP1,verticalP1.getWidth());
        horizontalP1.setSelected(true);

        if(Inicio.primeraVez){
            aceptarP1 = Inicio.setAceptar(aceptarP1, "Continuar");
        }else{
            aceptarP1 = Inicio.setPlayAceptar(aceptarP1, "Continuar");
        }

        radioGroupP1.add(verticalP1);
        radioGroupP1.add(horizontalP1);

        p1Buttons.add(tituloBarcosP1);
        p1Buttons.add(tipoBarcoP1);
        p1Buttons.add(nameBarcoP1);
        p1Buttons.add(verticalP1);
        p1Buttons.add(horizontalP1);
        p1Buttons.add(izquierdaP1);
        p1Buttons.add(derechaP1);
    }
}