package teselas4;
public class Teselas4 {
    public static void main(String[] args) {
        String tablero[][]={
         {"*","*","*","*","*","*"},
         {"*"," "," "," "," ","*"},
         {"*"," "," "," "," ","*"},
         {"*"," "," "," "," ","*"},
         {"*"," "," "," "," ","*"},
         {"*","*","*","*","*","*"},
        };
        int cantidad=1;
        cantidad=llenarTablero(tablero,cantidad);
    }
    
    static int llenarTablero(String tab [][] , int cantidad){
        int lat = (int) (Math.random() * 3) +1;
        int lon = (int) (Math.random() * 3) +1;        
        imprimirTablero(tab);
        System.out.println("Lat "+lat+" Lon "+lon);
        if(tab[lat][lon]==" "){
            if(tab[lat+1][lon]==" "){
                if(tab[lat+1][lon+1]==" "){
                    tab[lat][lon]=String.valueOf(cantidad);
                    tab[lat+1][lon]=String.valueOf(cantidad);
                    tab[lat+1][lon+1]=String.valueOf(cantidad);
                    cantidad+=1;
                }
                else if(tab[lat+1][lon-1]==" "){
                    tab[lat][lon]=String.valueOf(cantidad);
                    tab[lat+1][lon]=String.valueOf(cantidad);
                    tab[lat+1][lon-1]=String.valueOf(cantidad);
                    cantidad+=1;
                }
            }
            else if(tab[lat-1][lon]==" "){
                if(tab[lat-1][lon+1]==" "){
                    tab[lat][lon]=String.valueOf(cantidad);
                    tab[lat-1][lon]=String.valueOf(cantidad);
                    tab[lat-1][lon+1]=String.valueOf(cantidad);
                    cantidad+=1;
                }
                else if(tab[lat-1][lon-1]==" "){
                    tab[lat][lon]=String.valueOf(cantidad);
                    tab[lat-1][lon]=String.valueOf(cantidad);
                    tab[lat-1][lon-1]=String.valueOf(cantidad);
                    cantidad+=1;
                }
            }
        }              
        return llenarTablero(tab, cantidad);
    }
    
    static void imprimirTablero(String tab[][]){
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j]+" ");
            }
            System.out.println("");        
        }
        System.out.println("");
    }    
}
