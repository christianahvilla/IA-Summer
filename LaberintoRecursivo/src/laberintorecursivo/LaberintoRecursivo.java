package laberintorecursivo;
public class LaberintoRecursivo {
    public static void main(String[] args) {
        String laberinto[][]=               
        {{"*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*"},
         {"*"," ","*"," "," "," "," "," "," "," ","*"," ","*"," "," ","S"},
         {"*"," ","*"," "," ","*","*"," ","*"," "," "," ","*"," "," ","*"},
         {"*"," ","*","*","*","*","*"," ","*"," ","*"," ","*","*"," ","*"},
         {"*"," "," "," "," "," "," "," ","*"," ","*"," "," "," "," ","*"},
         {"*"," ","*","*","*"," ","*"," ","*"," ","*"," ","*","*"," ","*"},
         {"*"," "," "," ","*"," ","*"," "," "," ","*"," ","*"," "," ","*"},
         {"*"," ","*"," ","*"," ","*","*","*","*","*"," ","*","*"," ","*"},
         {"*"," ","*"," ","*"," "," "," "," "," "," "," "," "," "," ","*"},
         {"*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*"},
        };
        movimientos(laberinto, 1, 1,0);
    }
    
    static void difurcaciones(String laberinto[][], int lad,int lon, int paso){                        
        for (int i = 0; i < laberinto[0].length; i++) {            
            for (int j = 0; j < laberinto.length; j++) {                
                if(laberinto[j][i].equals("D")){
                    System.out.println("Lad: "+ i+" Lon: "+j+" Paso: "+paso);
                    laberinto[j][i]="P";
                    lad=j;
                    lon=i;
                    i=laberinto[0].length;
                    j=laberinto.length;
                }                
            }            
        }        
        movimientos(laberinto, lad, lon,paso);
    }
        
    static String[][] movimientos(String laberinto[][],int lad,int lon,int paso) {        
        System.out.println("Lad: "+ lad+" Lon: "+lon+" Paso: "+paso);
        paso++;
        imprimir(laberinto);
        if(laberinto[lad+1][lon].equals("S") || laberinto[lad][lon+1].equals("S") || laberinto[lad-1][lon].equals("S") || laberinto[lad][lon-1].equals("S")){
            laberinto[lad][lon]="P";
            imprimir(laberinto);
            return null;
        }
        else{
            if(laberinto[lad][lon+1].equals(" ")){
                if(laberinto[lad+1][lon].equals(" ")){
                    System.out.println("1");
                    laberinto[lad][lon]="D";
                    lon++;                
                    movimientos(laberinto, lad, lon,paso);
                }
                else if(laberinto[lad][lon-1].equals(" ")){
                    laberinto[lad][lon]="D";
                    System.out.println("2");
                    lon++;
                    movimientos(laberinto, lad, lon,paso);
                }
                else if(laberinto[lad-1][lon].equals(" ")){
                    laberinto[lad][lon]="D";
                    System.out.println("3");
                    lon++;
                    movimientos(laberinto, lad, lon,paso);
                }
                else{
                    laberinto[lad][lon]="P";
                    System.out.println("4");
                    lon++;
                    movimientos(laberinto, lad, lon,paso);
                }
            }
        
            else if(laberinto[lad+1][lon].equals(" ")){
                if(laberinto[lad][lon-1].equals(" ")){
                    System.out.println("5");
                    laberinto[lad][lon]="D";
                    lad++;
                    movimientos(laberinto, lad, lon,paso);
                }
                else if(laberinto[lad-1][lon].equals(" ")){
                    laberinto[lad][lon]="D";
                    System.out.println("6");
                    lad++;
                    movimientos(laberinto, lad, lon,paso);
                }
                else{
                    laberinto[lad][lon]="P";
                    System.out.println("7");
                    lad++;
                    movimientos(laberinto, lad, lon,paso);
                }
            }
            else if(laberinto[lad][lon-1].equals(" ")){
                if(laberinto[lad-1][lon].equals(" ")){
                    laberinto[lad][lon]="D";
                    System.out.println("8");
                    lon--;
                    movimientos(laberinto, lad, lon,paso);
                }
                else{
                    laberinto[lad][lon]="P";
                    System.out.println("9");
                    lon--;
                    movimientos(laberinto, lad, lon,paso);
                }          
            }
            else if(laberinto[lad-1][lon].equals(" ")){
                laberinto[lad][lon]="P";
                System.out.println("10");
                lad--;
                movimientos(laberinto, lad, lon,paso);
            }
            else{
                System.out.println("Difurcacion");
                laberinto[lad][lon]="P";
                difurcaciones(laberinto, lad, lon, paso);
            }
            return laberinto;
        }
    }
    
    static void imprimir(String laberinto[][]){        
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[i].length; j++) {
                System.out.print(laberinto[i][j]+" ");
            }
            System.out.println("");        
        }
        System.out.println("");
    }
}
