package gato;
public class Metodos {
    int total=0;
    public int Validar_Victoria(String aux[][]){
        boolean con=false;
        for (int i = 0; i < aux.length; i++) {
            for (int j = 0; j < aux[i].length-1; j++) {
                if(aux[i][j].equals(aux[i][j+1])){
                    total++;
                }
            }
        }
        return total;
    }
    String [][] turnos(String aux[][]){
        int con=aux.length*aux[0].length;
        for (int i = 0; con > 0; i++, con--) {
            
        }
        return aux;
    }
}
