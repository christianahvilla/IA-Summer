package gato;

import javax.swing.JOptionPane;

public class Menu {
    String PvP[][] = new String[3][3];
    String PvIA[][]=new String[3][3];
    PvP cosa=new PvP();
    PvIA cosa2=new PvIA();
    Menu(){
        for (int i = 0; i < PvP.length; i++) {
            for (int j = 0; j < PvP[i].length; j++) {
                PvP[i][j]="";
                PvIA[i][j]="";
            }
        }
    }
    void MenuJugador(){
        boolean con=true;
        do{
            int op=Integer.parseInt(JOptionPane.showInputDialog(null,"Seleccione Partida\n1.PvP\n2.PvIA3.Salir","Juego del Gato",JOptionPane.QUESTION_MESSAGE));
            switch(op){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Lo siento opcion no valida","Error",JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }while(con);
    }
}
