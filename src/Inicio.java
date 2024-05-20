import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Inicio {
    public static String[][] barcosDisponibles;
    static boolean primeraVez = true;

    public Inicio() {

    }

    public static void eventos() {

        Player1.izquierdaP1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!(Integer.parseInt(String.valueOf(Player1.izquierdaP1.getToolTipText())) < 1)){
                    int indexIzquierdaP1 = Integer.parseInt(String.valueOf(Player1.izquierdaP1.getToolTipText())) - 1;
                    int indexDerechaP1 = Integer.parseInt(String.valueOf(Player1.derechaP1.getToolTipText())) - 1;
                    Player1.derechaP1.setToolTipText(String.valueOf(indexDerechaP1));
                    Player1.izquierdaP1.setToolTipText(String.valueOf(indexIzquierdaP1));
                    ImageIcon image = new ImageIcon(barcosDisponibles[indexIzquierdaP1][3]);
                    Player1.tipoBarcoP1.setIcon(image);
                    Player1.tipoBarcoP1.setToolTipText(String.valueOf(indexIzquierdaP1));

                    Player1.tituloBarcosP1.setText("Cantidad de barcos: " + Integer.parseInt(String.valueOf(barcosDisponibles[indexIzquierdaP1][2])));
                    Player1.nameBarcoP1.setText(barcosDisponibles[indexIzquierdaP1][0]);
                }

            }
        });
        Player1.derechaP1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!(Integer.parseInt(String.valueOf(Player1.derechaP1.getToolTipText())) == 5)){
                    int indexDerechaP1 = Integer.parseInt(String.valueOf(Player1.derechaP1.getToolTipText())) + 1;
                    int indexIzquierdaP1 = Integer.parseInt(String.valueOf(Player1.izquierdaP1.getToolTipText())) + 1;
                    Player1.izquierdaP1.setToolTipText(String.valueOf(indexIzquierdaP1));
                    Player1.derechaP1.setToolTipText(String.valueOf(indexDerechaP1));
                    ImageIcon image = new ImageIcon(barcosDisponibles[indexDerechaP1-1][3]);
                    Player1.tipoBarcoP1.setIcon(image);
                    Player1.tipoBarcoP1.setToolTipText(String.valueOf(indexIzquierdaP1));

                    Player1.tituloBarcosP1.setText("Cantidad de barcos: " + Integer.parseInt(String.valueOf(barcosDisponibles[indexDerechaP1-1][2])));
                    Player1.nameBarcoP1.setText(barcosDisponibles[indexDerechaP1-1][0]);
                }
            }
        });

        Player2.izquierdaP2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!(Integer.parseInt(String.valueOf(Player2.izquierdaP2.getToolTipText())) < 1)){
                    int indexIzquierdaP2 = Integer.parseInt(String.valueOf(Player2.izquierdaP2.getToolTipText())) - 1;
                    int indexDerechaP2 = Integer.parseInt(String.valueOf(Player2.derechaP2.getToolTipText())) - 1;
                    Player2.derechaP2.setToolTipText(String.valueOf(indexDerechaP2));
                    Player2.izquierdaP2.setToolTipText(String.valueOf(indexIzquierdaP2));
                    ImageIcon image = new ImageIcon(barcosDisponibles[indexIzquierdaP2][3]);
                    Player2.tipoBarcoP2.setIcon(image);
                    Player2.tipoBarcoP2.setToolTipText(String.valueOf(indexIzquierdaP2));

                    Player2.tituloBarcosP2.setText("Cantidad de barcos: " + Integer.parseInt(String.valueOf(barcosDisponibles[indexIzquierdaP2][2])));
                    Player2.nameBarcoP2.setText(barcosDisponibles[indexIzquierdaP2][0]);
                }
            }
        });
        Player2.derechaP2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!(Integer.parseInt(String.valueOf(Player2.derechaP2.getToolTipText())) == 5)){
                    int indexDerechaP2 = Integer.parseInt(String.valueOf(Player2.derechaP2.getToolTipText())) + 1;
                    int indexIzquierdaP2 = Integer.parseInt(String.valueOf(Player2.izquierdaP2.getToolTipText())) + 1;
                    Player2.izquierdaP2.setToolTipText(String.valueOf(indexIzquierdaP2));
                    Player2.derechaP2.setToolTipText(String.valueOf(indexDerechaP2));
                    ImageIcon image = new ImageIcon(barcosDisponibles[indexDerechaP2-1][3]);
                    Player2.tipoBarcoP2.setIcon(image);
                    Player2.tipoBarcoP2.setToolTipText(String.valueOf(indexIzquierdaP2));

                    Player2.tituloBarcosP2.setText("Cantidad de barcos: " + Integer.parseInt(String.valueOf(barcosDisponibles[indexDerechaP2-1][2])));
                    Player2.nameBarcoP2.setText(barcosDisponibles[indexDerechaP2-1][0]);
                }
            }
        });
    }

    public static JLabel[][] inicializarTablero(int tablero) {

        if(tablero == 1){
            JLabel[][] player1 = {{Items.cabecera(""),Items.cabecera("0"), Items.cabecera("1"), Items.cabecera("2"), Items.cabecera("3"), Items.cabecera("4"), Items.cabecera("5"), Items.cabecera("6"), Items.cabecera("7"), Items.cabecera("8"), Items.cabecera("9")},
                    {Items.cabecera("A"), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua()},
                    {Items.cabecera("B"), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua()},
                    {Items.cabecera("C"), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua()},
                    {Items.cabecera("D"), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua()},
                    {Items.cabecera("E"), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua()},
                    {Items.cabecera("F"), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua()},
                    {Items.cabecera("G"), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua()},
                    {Items.cabecera("H"), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua()},
                    {Items.cabecera("I"), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua()},
                    {Items.cabecera("J"), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua()}};

            return player1;

        }else{
            JLabel[][] player2 = {{Items.cabecera(""),Items.cabecera("0"), Items.cabecera("1"), Items.cabecera("2"), Items.cabecera("3"), Items.cabecera("4"), Items.cabecera("5"), Items.cabecera("6"), Items.cabecera("7"), Items.cabecera("8"), Items.cabecera("9")},
                    {Items.cabecera("A"),Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua()},
                    {Items.cabecera("B"),Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua()},
                    {Items.cabecera("C"),Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua()},
                    {Items.cabecera("D"),Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua()},
                    {Items.cabecera("E"),Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua()},
                    {Items.cabecera("F"),Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua()},
                    {Items.cabecera("G"),Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua()},
                    {Items.cabecera("H"),Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua()},
                    {Items.cabecera("I"),Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua()},
                    {Items.cabecera("J"),Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua(), Items.agua()}};

            return player2;
        }
    }

    public static JLabel[][] rellenarPlayer(JPanel panel, JLabel[][] tablero, JLabel[][] tableroContrario, String[][] barcosDisponibles, String namePlayer,int idPlayer) {

        int x = 0;
        int y = 45;

        for(int i=0;i<tablero.length;i++){
            if (x >= 450) {
                y = y + 45;
                x = 0;
            }

            for(int j=0;j<tablero.length;j++){
                tablero[i][j].setBounds(x, y, 45, 45);
                tablero[i][j].setPreferredSize(new Dimension(45, 45));

                panel.remove(tablero[i][j]);
                panel.add(tablero[i][j]);

                if((i == 0 && j >= 0) || (i > 0 && j == 0)){
                    tablero[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                    tablero[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }

                if(i > 0 && j > 0){

                    int fila = i;
                    int columna = j;

                    if(tablero[i][j].getMouseListeners().length < 2){
                        tablero[i][j].addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                super.mouseClicked(e);

                                if(Player1.finJuego || Player2.finJuego) {
                                    Mensajes.finJuego();
                                }else{
                                    if (idPlayer == 1) {
                                        if (primeraVez) {
                                            if (panel.getName().equals("Player1")) {
                                                int barco = 0;
                                                boolean vertical = true;
                                                barco = Integer.parseInt(String.valueOf(Player1.tipoBarcoP1.getToolTipText()));
                                                vertical = Player1.verticalP1.isSelected();
                                                rellenaJugador(tablero, fila, columna, namePlayer, barco, vertical, Player1.player1, idPlayer, 0);
                                            }
                                        } else {
                                            if (panel.getName().equals("DisparosP1")) {
                                                if (Player1.acierto) {
                                                    Player1.disparado = true;
                                                    Player1.acierto = Jugar.jugar(Player1.disparosP1, Player2.tableroJ2, Player1.disparosJ1, fila, columna, namePlayer, idPlayer);
                                                    Player1.finJuego = Jugar.checkFinJuego(Player2.tableroJ2);
                                                }

                                                if (!Player1.acierto && Player1.disparado) {
                                                    Mensajes.pasarTurno();
                                                    Player1.aceptarP1.doClick();
                                                }

                                                if (Player1.finJuego) {
                                                    Mensajes.informaGanador(Users.nombreP1);
                                                    Player1.aceptarP1.setVisible(true);
                                                    Player1.aceptarP1.setText("Volver a menú");
                                                }
                                            }
                                        }
                                    } else {
                                        if (primeraVez) {
                                            if (panel.getName().equals("Player2")) {
                                                int barco = 0;
                                                boolean vertical = true;
                                                barco = Integer.parseInt(String.valueOf(Player2.tipoBarcoP2.getToolTipText()));
                                                vertical = Player2.verticalP2.isSelected();
                                                rellenaJugador(tablero, fila, columna, namePlayer, barco, vertical, Player2.player2, idPlayer, 0);
                                            }
                                        } else {
                                            if (panel.getName().equals("DisparosP2")) {
                                                if (Player2.acierto) {
                                                    Player2.disparado = true;
                                                    Player2.acierto = Jugar.jugar(Player2.disparosP2, Player1.tableroJ1, Player2.disparosJ2, fila, columna, namePlayer, idPlayer);
                                                    Player2.finJuego = Jugar.checkFinJuego(Player1.tableroJ1);
                                                }

                                                if (!Player2.acierto && Player2.disparado) {
                                                    Mensajes.pasarTurno();
                                                    Player2.aceptarP2.doClick();
                                                }

                                                if (Player2.finJuego) {
                                                    Mensajes.informaGanador(Users.nombreP2);
                                                    Player2.aceptarP2.setVisible(true);
                                                    Player2.aceptarP2.setText("Volver a menú");
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {
                                super.mouseEntered(e);
                                tablero[fila][columna].setCursor(new Cursor(Cursor.HAND_CURSOR));
                            }

                            public void mouseExited(MouseEvent e) {
                                super.mouseExited(e);
                                tablero[fila][columna].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            }
                        });
                    }
                }
                x = x + 45;
            }
        }
        return tablero;
    }

    public static String[][] inicializarListaBarcos() {

        String[][] barcosDisponibles = new String[5][4];

        barcosDisponibles[0][0] = "Boat";
        barcosDisponibles[0][1] = "1";
        barcosDisponibles[0][2] = "1";
        barcosDisponibles[0][3] = ".\\img\\1.jpg";
        barcosDisponibles[1][0] = "Patrol boats";
        barcosDisponibles[1][1] = "2";
        barcosDisponibles[1][2] = "1";
        barcosDisponibles[1][3] = ".\\img\\2.jpg";
        barcosDisponibles[2][0] = "Destroyers";
        barcosDisponibles[2][1] = "3";
        barcosDisponibles[2][2] = "1";
        barcosDisponibles[2][3] = ".\\img\\3.jpg";
        barcosDisponibles[3][0] = "Battleships ";
        barcosDisponibles[3][1] = "4";
        barcosDisponibles[3][2] = "1";
        barcosDisponibles[3][3] = ".\\img\\4.jpg";
        barcosDisponibles[4][0] = "Aircarrier ";
        barcosDisponibles[4][1] = "5";
        barcosDisponibles[4][2] = "1";
        barcosDisponibles[4][3] = ".\\img\\5.jpg";

        return barcosDisponibles;
    }

    public static JLabel[][] rellenaJugador(JLabel[][] tablero, int x, int y,String nomPlayer, int tipoBarco, boolean vertical, JPanel panel, int idPlayer, int indice) {
        int barco = 0;

        char orientacion = 'h';
        int aux = 0;
        int espaciosBarco = 0;

        boolean noCabe = false;
        boolean choque = false;

        do{
            if(nomPlayer.equals("IA")){
                barco = indice;
                orientacion = escogeOrientacion();

                x = escogeCoordenadaX();
                y = escogeCoordenadaY();

                espaciosBarco = Integer.valueOf(barcosDisponibles[barco][1]);
            }else{
                barco = tipoBarco;

                if(vertical){
                    orientacion = 'V';
                }else{
                    orientacion = 'H';
                }
            espaciosBarco = Integer.valueOf(barcosDisponibles[barco][1]);
            }


            if(barcosDisponibles[barco][2].equals("0")){
                Mensajes.barcoNoDisponible();
            }else{
                if(orientacion == 'H') {
                    if ((y + espaciosBarco) <= 11) {
                        // aux es una variable para detener el while cuando se llegue a los espacios a llenar
                        aux = y;
                        do{
                            choque = comprobarChoque(x, aux, tablero);
                            aux++;
                        } while (!choque && (aux < (y + espaciosBarco)));
                        if(!choque){
                            noCabe = false;
                            for (int j = 0; j < espaciosBarco; j++) {
                                try{
//                                     if(barco == 0){
//                                         panel.remove(tablero[x][y + j]);
//                                         tablero[x][y + j] = Items.barco("SuperBarco");
//                                         tablero[x][y + j].setToolTipText("SuperBarco");
//                                     }else{
                                         panel.remove(tablero[x][y + j]);
                                         tablero[x][y + j] = Items.barco("Barco");
                                         tablero[x][y + j].setToolTipText("Barco");
//                                     }
                                     if(idPlayer == 1){
                                         Player1.ubicacionBarcosP1[barco][j] = String.valueOf(x) + String.valueOf(y+j);
                                     }else{
                                         Player2.ubicacionBarcosP2[barco][j] = String.valueOf(x) + String.valueOf(y+j);
                                     }
                                    Inicio.rellenarPlayer(panel, tablero, Player2.tableroJ2, Inicio.barcosDisponibles, nomPlayer, idPlayer);
                                    panel.repaint();
                                }catch(Exception ex){
                                    System.out.println("Error!!");
                                }
                            }
                            barcosDisponibles[barco][2] = String.valueOf(Integer.valueOf(barcosDisponibles[barco][2]) - 1);
                            if(idPlayer == 1){
                                Player1.tituloBarcosP1.setText("Cantidad de barcos: " + Integer.parseInt(String.valueOf(barcosDisponibles[barco][2])));
                            }else{
                                Player2.tituloBarcosP2.setText("Cantidad de barcos: " + Integer.parseInt(String.valueOf(barcosDisponibles[barco][2])));
                            }
                        }else{
                            if(!nomPlayer.equals("IA")){
                                Mensajes.choque();
                            }
                            noCabe = true;
                        }
                    } else {
                        if(!nomPlayer.equals("IA")){
                            Mensajes.sinEspacio();
                        }
                        noCabe = true;
                    }
                }else{
                    if ((x + espaciosBarco) <= 11) {
                        // aux es una variable para detener el while cuando se llegue a los espacios a llenar
                        aux = x;
                        do {
                            choque = comprobarChoque(aux, y, tablero);
                            aux++;
                        } while (!choque && (aux < (x + espaciosBarco)));
                        if(!choque){
                            noCabe = false;
                            for (int j = 0; j < espaciosBarco; j++) {
                                try{
//                                    if(barco == 0){
//                                        panel.remove(tablero[x + j][y]);
//                                        tablero[x + j][y] = Items.barco("SuperBarco");
//                                        tablero[x + j][y].setToolTipText("SuperBarco");
//                                    }else{
                                        panel.remove(tablero[x + j][y]);
                                        tablero[x + j][y] = Items.barco("Barco");
                                        tablero[x + j][y].setToolTipText("Barco");
//                                    }
                                    if(idPlayer == 1){
                                        Player1.ubicacionBarcosP1[barco][j] = String.valueOf(x + j) + String.valueOf(y);
                                    }else{
                                        Player2.ubicacionBarcosP2[barco][j] = String.valueOf(x + j) + String.valueOf(y);
                                    }

                                    Inicio.rellenarPlayer(panel, tablero, Player2.tableroJ2, Inicio.barcosDisponibles, nomPlayer, idPlayer);
                                    panel.repaint();
                                }catch(Exception ex){
                                    System.out.println("Error!!");
                                }
                            }
                            barcosDisponibles[barco][2] = String.valueOf(Integer.valueOf(barcosDisponibles[barco][2]) - 1);
                            if(idPlayer == 1){
                                Player1.tituloBarcosP1.setText("Cantidad de barcos: " + Integer.parseInt(String.valueOf(barcosDisponibles[barco][2])));
                            }else{
                                Player2.tituloBarcosP2.setText("Cantidad de barcos: " + Integer.parseInt(String.valueOf(barcosDisponibles[barco][2])));
                            }
                        }else{
                            if(!nomPlayer.equals("IA")){
                                Mensajes.choque();
                            }
                            noCabe = true;
                        }
                    } else {
                        if(!nomPlayer.equals("IA")){
                            Mensajes.sinEspacio();
                        }
                        noCabe = true;
                    }
                }
            }
        }while(noCabe && nomPlayer.equals("IA"));
        return tablero;
    }

    private static boolean comprobarChoque(int x, int y, JLabel[][] tablero) {

        int minX = 1;
        int minY = 1;
        int maxX = 1;
        int maxY = 1;
        boolean choque = false;


        if(x==10) maxX = 0;
        if(y==10) maxY = 0;


        if(tablero[x][y].getToolTipText().equals("Barco") || tablero[x-minX][y].getToolTipText().equals("Barco") || tablero[x+maxX][y].getToolTipText().equals("Barco") ||
                tablero[x][y-minY].getToolTipText().equals("Barco") || tablero[x][y+maxY].getToolTipText().equals("Barco") || tablero[x][y].getToolTipText().equals("SuperBarco") ||
                tablero[x-minX][y].getToolTipText().equals("SuperBarco") || tablero[x+maxX][y].getToolTipText().equals("SuperBarco") || tablero[x][y-minY].getToolTipText().equals("SuperBarco") ||
                tablero[x][y+maxY].getToolTipText().equals("SuperBarco")){
            choque = true;
        }else{
            choque = false;
        }

        return choque;
    }

    public static JFrame setInitialFrame(JFrame frame, JPanel rootPanel){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        frame.setContentPane(rootPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(630, 570);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle("Hundir la flota");

        return frame;
    }

    public static JFrame setPlayFrame(JFrame frame, JPanel rootPanel){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        frame.setContentPane(rootPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(630, 400);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle("Hundir la flota");

        return frame;
    }

    public static JLabel setLabel(JLabel title) {

        title.setSize(145,20);
        Border border = title.getBorder();
        Border margin = new EmptyBorder(5,5,0,0);
        title.setBorder(new CompoundBorder(border, margin));

        return title;
    }
    public static JLabel setNameBarco(JLabel name) {

        name.setSize(200,40);
        Border border = name.getBorder();
        Border margin = new EmptyBorder(5,5,0,0);
        name.setBorder(new CompoundBorder(border, margin));
        name.setLocation(0,40);
        name.setText(Inicio.barcosDisponibles[0][0]);

        return name;
    }

    public static JRadioButton setOrientacion(JRadioButton orientacion, int x) {

        orientacion.setPreferredSize(new Dimension(100,20));
        orientacion.setSize(100,20);
        orientacion.setLocation(0 + x,80);

        return orientacion;
    }

    public static JLabel setTitulosBarco(JLabel titulo) {

        titulo.setSize(200,30);
        Border border = titulo.getBorder();
        Border margin = new EmptyBorder(0,5,0,0);
        titulo.setBorder(new CompoundBorder(border, margin));
        titulo.setText("Cantidad de barcos: " + Inicio.barcosDisponibles[0][2]);

        return titulo;
    }

    public static JButton setImageIndex(JButton button, int image) {

        button.setToolTipText(String.valueOf(image));

        return button;
    }

    public static JLabel setTipoBarco(JLabel tipoBarco) {
        tipoBarco.setPreferredSize(new Dimension(100,20));
        tipoBarco.setSize(275,40);
        tipoBarco.setLocation(20,20);
        tipoBarco.setVisible(true);
        ImageIcon image = new ImageIcon(Inicio.barcosDisponibles[0][3]);
        tipoBarco.setIcon(image);
        tipoBarco.setToolTipText("0");

        return tipoBarco;
    }

    public static JButton setButtons(JButton buttons, int x, JPanel buttonPanel) {
        buttons.setVisible(true);
        buttons.setSize(50,20);
        buttons.setLocation(x,buttonPanel.getHeight()-buttons.getHeight());

        return buttons;
    }

    public static JButton setAceptar(JButton boton, String texto) {

        boton.setVisible(true);
        boton.setSize(125,20);
        boton.setLocation(0,550);
        boton.setText(texto);
        return boton;
    }


    public static JButton setPlayAceptar(JButton boton, String texto) {

        boton.setVisible(true);
        boton.setSize(125,20);
        boton.setLocation(0,550);
        boton.setText(texto);
        return boton;
    }

    public static JPanel setPanelButtons(JPanel buttons) {
        buttons.setPreferredSize(new Dimension(495,130));
        buttons.setLayout(null);
        buttons.setSize(495,130);
        buttons.setLocation(0,550);
        buttons.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        return buttons;
    }

    public static JPanel setPlayer(JPanel player, String name) {
        player.setPreferredSize(new Dimension(550,1000));
        player.setLayout(null);
        player.setName(name);

        return player;
    }

    public static int escogeCoordenadaX() {

        Random rand = new Random();
        final int MINVALUE = 1;
        final int MAXVALUE = 10;

        return rand.nextInt(MAXVALUE - MINVALUE) + MINVALUE;
    }

    public static int escogeCoordenadaY() {

        Random rand = new Random();
        final int MINVALUE = 1;
        final int MAXVALUE = 10;

        return rand.nextInt(MAXVALUE - MINVALUE) + MINVALUE;
    }


    private static char escogeOrientacion() {

        Random rand = new Random();
        char orientacion = 'h';
        char[] orientacionList = {'H','V'};

        orientacion = orientacionList[rand.nextInt(orientacionList.length)];

        return orientacion;
    }
}