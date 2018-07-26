package police;

import javax.swing.JOptionPane;

public class Police {
    static int lat=0,lon=0;
    public static void main(String[] args) {
        String universo[][]=new String[17][17];        
        int vision[][]= {{-1,-1},{-1,0},{-1,1},
                         {0,-1},{0,0},{0,1},
                         {1,-1},{1,0},{+1,+1}};
        universo=metaUniverso(paredUniverso(policiaUniverso(cercarUniverso(universo),vision)));        
        imprimirUniverso(recorrerUniverso(universo, lat, lon,lat,lon,0));
    }
    
    static String[][] recorrerUniverso(String universo[][],int lad,int lon,int lada,int lona, int stop) {                
        System.out.println("Lad: "+ lad+" Lon: "+lon+" stop= "+stop); 
        imprimirUniverso(universo);        
        if(stop==0){
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    System.out.println("i= "+i+" j="+j+"\nlad= "+(lad-i)+" lon= "+(lon-j));
                    if(universo[lad-i][lon-j]=="F"){    
                        return recorrerUniverso(universo,lad,lon,lad,lon,1);
                    }                                      
                }
            }
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    System.out.println("i= "+i+" j="+j+"\nlad= "+(lad-i)+" lon= "+(lon-j));
                    if(universo[lad-i][lon-j]==" " || (universo[lad-i][lon-j]=="L" && ((lad!=lad-i && (lon!=lon-j)) || (lad-i!=lada && lon-j!=lona)))){
                        universo[lad-i][lon-j]="L";                        
                        return recorrerUniverso(universo,lad-i,lon-j,lad,lon,0);                                         
                    }                    
                }
            }
        }
        System.out.println("\nFelicidades lo robaste");
        return universo;                
    }
    
    static String[][] metaUniverso(String universo[][]){
        imprimirUniverso(universo);
        String inicio=JOptionPane.showInputDialog(null,"Cual es el inicio",JOptionPane.QUESTION_MESSAGE);
        String meta=JOptionPane.showInputDialog(null,"Cual es la meta",JOptionPane.QUESTION_MESSAGE);
        String[] parts = inicio.split(",");
        lat=Integer.valueOf(parts[0]);
        lon=Integer.valueOf(parts[1]);
        universo[Integer.valueOf(parts[0])][Integer.valueOf(parts[1])]="I";
        parts = meta.split(",");
        universo[Integer.valueOf(parts[0])][Integer.valueOf(parts[1])]="F";
        imprimirUniverso(universo);
        return universo;
    }
    
    static String[][] paredUniverso(String universo[][]){
        int x=0;
        while(x<8){
            int lat = (int) (Math.random() * 15) +1;
            int lon = (int) (Math.random() * 15) +1; 
            if(universo[lat][lon]==" "){
                universo[lat][lon]="*";      
                x++;
            }
        }
        return universo;
    }
    
    static String[][] policiaUniverso(String universo[][], int vision[][]){
        int x=0;
        while(x<5){
            int lat = (int) (Math.random() * 15) +1;
            int lon = (int) (Math.random() * 15) +1; 
            if(universo[lat][lon]==" "){
                if(universo[lat][lon]==" "){
                    for (int i = 0; i < vision.length; i++) {
                        if(universo[lat+vision[i][0]][lon+vision[i][1]]==" "){
                            universo[lat+vision[i][0]][lon+vision[i][1]]="V";
                        }
                    }
                    universo[lat][lon]="P";
                    x++;
                }
            }
        }
        return universo;
    }
    
    static String[][] cercarUniverso(String universo[][]){
        for (int i = 0; i < universo.length; i++) {
            for (int j = 0; j < universo[i].length; j++) {
                if((i==0 && j>-1 ) || (i==16 && j>-1)
                    || (i>-1 && j==0 ) || (i>-1 && j==16)){
                    universo[i][j]="*";
                }
                else{
                    universo[i][j]=" ";
                }
            }            
        }  
        return universo;
    }
    
    static void imprimirUniverso(String universo[][]){
        for (int i = 0; i < universo.length; i++) {
            for (int j = 0; j < universo[i].length; j++) {
                System.out.print(" "+universo[i][j]+" ");
            }
            System.out.println("");
        }      
    }
    
}
