import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Player2{

    public static JFrame frame = new JFrame();
    public static JPanel rootPanel = new JPanel();
    private JLabel lblbarcosJ2 = new JLabel("Barcos " + Users.nombreP2);
    private JLabel lbldisparosJ2 = new JLabel("Disparos " + Users.nombreP2);
    static JPanel player2 = new JPanel();
    static JPanel disparosP2 = new JPanel();
    static JPanel p2Buttons = new JPanel();
    static JButton izquierdaP2 = new JButton("<");
    static JButton derechaP2 = new JButton(">");

    static JLabel tipoBarcoP2 = new JLabel();

    static JLabel nameBarcoP2 = new JLabel();

    static ButtonGroup radioGroupP2 = new ButtonGroup();
    static JRadioButton verticalP2 = new JRadioButton("Vertical");
    static JRadioButton horizontalP2 = new JRadioButton("Horizontal");
    static JLabel tituloBarcosP2 = new JLabel();

    static JButton aceptarP2 = new JButton("Jugar");

    static boolean finJuego = false;
    static boolean acierto = true;
    static boolean disparado = false;

    static boolean superBarco = false;

    static JLabel[][] tableroJ2 = {};
    static JLabel[][] disparosJ2 = {};

    static String[][] ubicacionBarcosP2 = new String[5][5];

    public Player2(){

        JOptionPane.showMessageDialog(null,"Turno de " + Users.nombreP2);

        int fila = 0;
        int columna = 0;
        boolean existe = false;
        String historico = "";
        String coordenada = "";

        vaciaDatos();

        if(Inicio.primeraVez){
            frame = Inicio.setInitialFrame(frame,rootPanel);
        }else{
            frame = Inicio.setPlayFrame(frame,rootPanel);
        }

        inicializarPlayer2();

        player2.add(lblbarcosJ2);
        rootPanel.add(player2);
        disparosP2.add(lbldisparosJ2);
        rootPanel.add(disparosP2);
        if(Inicio.primeraVez){
            player2.add(p2Buttons);
        }else{
            player2.remove(p2Buttons);
        }
        disparosP2.add(aceptarP2);

        if(Inicio.primeraVez){
            tableroJ2 = Inicio.inicializarTablero(2);
            disparosJ2 = Inicio.inicializarTablero(2);
            tableroJ2 = Inicio.rellenarPlayer(player2, tableroJ2, Player1.tableroJ1, Inicio.barcosDisponibles, Users.nombreP2, 2);
            disparosJ2 = Inicio.rellenarPlayer(disparosP2, disparosJ2, Player1.tableroJ1,Inicio.barcosDisponibles, Users.nombreP2, 2);
            eventos();

            if(Users.nombreP2.equals("IA")){
                for(int i=0;i<Inicio.barcosDisponibles.length;i++){
                    Inicio.rellenaJugador(tableroJ2, 0, 0, Users.nombreP2, 0, true, player2, 2, i);
                }
                aceptarP2.doClick();
            }else{
                Mensajes.informacion();
            }
        }else{
            //aceptarP2.setText("Pasar turno");
            aceptarP2.setVisible(false);
            tableroJ2 = Inicio.rellenarPlayer(player2, tableroJ2, Player1.tableroJ1, Inicio.barcosDisponibles, Users.nombreP2, 2);
            disparosJ2 = Inicio.rellenarPlayer(disparosP2, disparosJ2, Player1.tableroJ1,Inicio.barcosDisponibles, Users.nombreP2, 2);

            if(Users.nombreP2.equals("IA")){
                do {
                    if (Player2.acierto) {
                        Player2.disparado = true;

                        if(!Player2.superBarco) {
                            do{
                                fila = Inicio.escogeCoordenadaX();
                                columna = Inicio.escogeCoordenadaY();
                                coordenada = String.valueOf(fila) + String.valueOf(columna);
                                existe = historico.contains(coordenada);
                            }while(existe);
                            historico = historico + coordenada;
                        }

                        Player2.acierto = Jugar.jugar(Player2.disparosP2, Player1.tableroJ1, Player2.disparosJ2, fila, columna, Users.nombreP2, 2);
                        Player2.finJuego = Jugar.checkFinJuego(Player1.tableroJ1);
                    }

                    if (!Player2.acierto) {
                        Player2.aceptarP2.doClick();
                    }

                    if (Player2.finJuego) {
                        Mensajes.informaGanador(Users.nombreP2);
                        Player2.aceptarP2.setText("Volver a menú");
                        Player2.aceptarP2.doClick();
                    }
                }while(Player2.acierto);
            }
        }

        rootPanel.revalidate();
        rootPanel.repaint();
    }

    private void vaciaDatos() {

        rootPanel.removeAll();
        player2.removeAll();
        disparosP2.removeAll();
        p2Buttons.removeAll();
        Player2.finJuego = false;
    }

    private void eventos() {

        Player2.aceptarP2.addActionListener(new ActionListener() {
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
                        Player2.acierto = false;
                    }
                }

                if(!Inicio.primeraVez && continuar && (Player2.acierto || !Player2.disparado) && !Player2.finJuego){
                    Mensajes.noPasarTurno();
                }

                if(!Inicio.primeraVez && continuar && !Player2.acierto){
                    frame.setVisible(false);
                    Player1.acierto = true;
                    Player1.disparado = true;
                    Player2.disparado = true;
                    new Player1();
                }

                if(Inicio.primeraVez && continuar){
                    Inicio.primeraVez = false;
                    frame.setVisible(false);
                    Player1.acierto = true;
                    new Player1();
                }

                if(Player2.finJuego){
                    Player1.frame.dispose();
                    Player2.frame.dispose();
                    new Menu();
                }
            }
        });
    }

    private void inicializarPlayer2() {

        Inicio.barcosDisponibles = Inicio.inicializarListaBarcos();

        lblbarcosJ2 = Inicio.setLabel(lblbarcosJ2);
        lbldisparosJ2 = Inicio.setLabel(lbldisparosJ2);

        player2 = Inicio.setPlayer(player2, "Player2");
        disparosP2 = Inicio.setPlayer(disparosP2, "DisparosP2");

        p2Buttons = Inicio.setPanelButtons(p2Buttons);

        izquierdaP2 = Inicio.setButtons(izquierdaP2, 0, p2Buttons);
        derechaP2 = Inicio.setButtons(derechaP2, 50, p2Buttons);

        izquierdaP2 = Inicio.setImageIndex(izquierdaP2,0);
        derechaP2 = Inicio.setImageIndex(derechaP2,1);
        tipoBarcoP2 = Inicio.setTipoBarco(tipoBarcoP2);

        tituloBarcosP2 = Inicio.setTitulosBarco(tituloBarcosP2);

        nameBarcoP2 = Inicio.setNameBarco(nameBarcoP2);


        verticalP2 = Inicio.setOrientacion(verticalP2,0);
        horizontalP2 = Inicio.setOrientacion(horizontalP2,verticalP2.getWidth());
        horizontalP2.setSelected(true);


        if(Inicio.primeraVez){
            aceptarP2 = Inicio.setAceptar(aceptarP2, "Jugar");
        }else{
            aceptarP2 = Inicio.setPlayAceptar(aceptarP2, "Jugar");
        }

        radioGroupP2.add(verticalP2);
        radioGroupP2.add(horizontalP2);

        p2Buttons.add(tituloBarcosP2);
        p2Buttons.add(tipoBarcoP2);
        p2Buttons.add(nameBarcoP2);
        p2Buttons.add(verticalP2);
        p2Buttons.add(horizontalP2);
        p2Buttons.add(izquierdaP2);
        p2Buttons.add(derechaP2);
    }
}