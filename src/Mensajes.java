import javax.swing.*;

public class Mensajes {

    public static void disparoRepetido(){

        JOptionPane.showMessageDialog(null,"Disparo repetido. Vuelve a disparar");
    }

    public static void impactoBarcoEspecial() {

        JOptionPane.showMessageDialog(null,"Has impactado en un barco especial. Repite el mismo disparo.");
    }

    public static void agua() {

        JOptionPane.showMessageDialog(null,"AGUA!!");
    }

    public static void tocado() {

        JOptionPane.showMessageDialog(null,"TOCADO!!");
    }

    public static void tocadoHundido() {

        JOptionPane.showMessageDialog(null,"TOCADO y HUNDIDO!!");
    }

    public static void informaGanador(String nomJugador) {
        JOptionPane.showMessageDialog(null,"El ganador es " + nomJugador);
    }

    public static void barcoNoDisponible() {
        JOptionPane.showMessageDialog(null,"Este barco ya ha sido colocado.");
    }

    public static void choque() {

        JOptionPane.showMessageDialog(null,"Hay un choque entre barcos. Por favor, escoge otra posición.");
    }

    public static void sinEspacio() {

        JOptionPane.showMessageDialog(null,"El barco no cabe. Por favor, escoge otra posición.");
    }

    public static void sinBarcos() {

        JOptionPane.showMessageDialog(null,"Aun hay barcos pendientes de colocar.");
    }

    public static void noPasarTurno() {

        JOptionPane.showMessageDialog(null,"Aun no has disparado. Debes fallar para pasar de turno.");
    }

    public static void pasarTurno() {

        JOptionPane.showMessageDialog(null,"Pasar turno");
    }

    public static void informacion() {

        JOptionPane.showMessageDialog(null,"Selecciona el barco deseado, la orientación y clica en la casilla a partir de la que deseas añadir el barco");
    }

    public static void finJuego() {

        JOptionPane.showMessageDialog(null,"El juego ha finalizado. Pulsa volver al menú");
    }
}
