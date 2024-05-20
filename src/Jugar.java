import javax.swing.*;
public class Jugar {

    public Jugar(){

    }

    public static boolean jugar(JPanel panel, JLabel[][] jugadorAtacado, JLabel[][] disparos,int horizontal, int vertical, String nomPlayer, int idPlayer) {

        return comprobarDisparo(panel, jugadorAtacado, disparos, horizontal, vertical, nomPlayer, idPlayer);
    }

    private static boolean comprobarDisparo(JPanel panel, JLabel[][] jugadorAtacado,JLabel[][] disparos, int horizontal, int vertical, String nomPlayer, int idPlayer) {

        return actualizarTableros(panel, jugadorAtacado, disparos, horizontal, vertical, nomPlayer, idPlayer);
    }

    private static boolean actualizarTableros(JPanel panel, JLabel[][] jugadorAtacado, JLabel[][] disparos, int horizontal, int vertical, String nomPlayer, int idPlayer) {

        boolean hundido = false;

        if(jugadorAtacado[horizontal][vertical].getToolTipText().equals("Barco")){

            jugadorAtacado[horizontal][vertical] = Items.tocado("Tocado");
            panel.remove(disparos[horizontal][vertical]);
            disparos[horizontal][vertical] = Items.tocado("Impacto");

            Inicio.rellenarPlayer(panel, disparos, jugadorAtacado,Inicio.barcosDisponibles, nomPlayer, idPlayer);
            panel.repaint();

            hundido = comprobarHundido(jugadorAtacado, horizontal, vertical,nomPlayer);

//            if(nomPlayer.equals("IA")){
//                Player2.superBarco = false;
//            }

            return true;
        }else if(disparos[horizontal][vertical].getToolTipText().equals("Impacto") || disparos[horizontal][vertical].getToolTipText().equals("Fallo")){
            if(!nomPlayer.equals("IA")){
                Mensajes.disparoRepetido();
            }
            return true;
        }else{
            if(!nomPlayer.equals("IA")){
                Mensajes.agua();
            }

            panel.remove(disparos[horizontal][vertical]);
            disparos[horizontal][vertical] = Items.tocado("Agua");

            Inicio.rellenarPlayer(panel, disparos, jugadorAtacado,Inicio.barcosDisponibles, nomPlayer, idPlayer);
            panel.repaint();

//            if(nomPlayer.equals("IA")){
//                Player2.superBarco = false;
//            }

            return false;
        }
    }

    private static boolean comprobarHundido(JLabel[][] jugadorAtacado, int horizontal, int vertical, String nomPlayer) {

        int x = horizontal;
        int y = vertical;
        int decremento = 1;
        int incremento = 1;
        boolean hundidoX = true;
        boolean hundidoY = true;
        boolean primeraIteracion = true;

        // X arriba
        do{
            if(jugadorAtacado[x-decremento][y].getToolTipText().equals("Barco")){
                hundidoX = false;
            }
            if(x > 1 && !primeraIteracion){
                decremento++;
            }
            primeraIteracion = false;
        }while((!jugadorAtacado[x-decremento][y].getToolTipText().equals("Agua") && !jugadorAtacado[x-decremento][y].getToolTipText().equals("Cabecera")));

        decremento = 1;
        primeraIteracion = true;

        if(x==10) incremento = 0;
        // X abajo
        do{
            if(jugadorAtacado[x+incremento][y].getToolTipText().equals("Barco")){
                hundidoX = false;
            }
            if(x < 9 && !primeraIteracion && ((x + incremento) < jugadorAtacado.length-1)){
                incremento++;
            }
            primeraIteracion = false;
        }while(!jugadorAtacado[x+incremento][y].getToolTipText().equals("Agua") && ((x + incremento) < jugadorAtacado.length-1));

        incremento = 1;
        primeraIteracion = true;

        if(y==10) incremento = 0;

        // Y izquierda
        do{
            if(jugadorAtacado[x][y-decremento].getToolTipText().equals("Barco")){
                hundidoY = false;
            }
            if(y > 1 && !primeraIteracion){
                decremento++;
            }
            primeraIteracion = false;
        }while((!jugadorAtacado[x][y-decremento].getToolTipText().equals("Agua") && !jugadorAtacado[x][y-decremento].getToolTipText().equals("Cabecera")));

        primeraIteracion = true;
        // Y derecha
        do{
            if(jugadorAtacado[x][y+incremento].getToolTipText().equals("Barco")){
                hundidoY = false;
            }
            if((y < 9 && !primeraIteracion && (y + incremento) < jugadorAtacado.length-1)){
                incremento++;
            }
            primeraIteracion = false;
        }while(!jugadorAtacado[x][y+incremento].getToolTipText().equals("Agua")  && ((y + incremento) < jugadorAtacado.length-1));

        primeraIteracion = true;

        if(!nomPlayer.equals("IA")){
            if(!(hundidoX && hundidoY)){
                Mensajes.tocado();
            }else{
                Mensajes.tocadoHundido();
            }
        }

        return hundidoX && hundidoY;
    }

    public static boolean checkFinJuego(JLabel[][] jugador) {
        boolean finJuego = true;
        int i = 1;
        int j = 1;
        do{
            do{
                if(jugador[i][j].getToolTipText().equals("Barco") || jugador[i][j].getToolTipText().equals("SuperBarco") || jugador[i][j].getToolTipText().equals("SuperBarcoDanyado")){
                    finJuego = false;
                }
                j++;
            }while(finJuego && (j<jugador.length));
            i++;
            j=1;
        }while(finJuego && (i<jugador.length));

        return finJuego;
    }
}
