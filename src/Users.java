import javax.swing.*;

public class Users {

    static String nombreP1;
    static String nombreP2;
    public Users(int opcion){

        if(opcion == 1){
            nombreP1 = "";
            nombreP2 = "IA";
        }else{
            nombreP1 = "";
            nombreP2 = "";
        }


        while(nombreP1 == "" || nombreP1 == null || nombreP1.equals("IA")){
            nombreP1 = JOptionPane.showInputDialog("Introduce nombre del jugador 1");


            //if(nombreP1 == JOptionPane.CANCEL_OPTION){
             //   System.out.println("Cancel is pressed");
            //}
        }

        while(nombreP2 == "" || nombreP2 == null){
            nombreP2 = JOptionPane.showInputDialog("Introduce nombre del jugador 2");
        }

        if(nombreP1 != null){
            if(!nombreP1.equals("")){
                Inicio.primeraVez = true;
                new Player1();
            }
        }

    }
}
