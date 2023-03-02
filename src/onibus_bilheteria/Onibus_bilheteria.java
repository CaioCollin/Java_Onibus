
package Onibus_bilheteria;

import java.util.Scanner;

public class Onibus_bilheteria {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] arr = {{1,1},{0,1},{1,1}};
        
        Status();
        int opc = input.nextInt();
            switch(opc) {
                case 1:
                   comprar(arr);
                  break;
                case 2:
                  break;
                default:
            }        
    }

    public static void comprar(int arr[][]){
        Scanner input =  new Scanner(System.in);
        int cont = 0;
        int acento;
        for(int i = 0;  i < arr.length; i++){
                for(int j = 0;  j < arr.length - 1;j++){
                    if(arr[i][j] == 0){
                        cont++;                       
                    }
                }
            }
        do{

            System.err.println("    Janela |   Corredor");
            for(int i = 0;  i < arr.length; i++){
                for(int j = 0;  j < arr.length - 1;j++){
                    System.out.printf("  %5d    |", arr[i][j]);                   
                }
                System.out.println();
            }

            System.out.println("\n  Numero de vagas Disponiveis: "+cont);
            System.out.println("\nEscolha Qual lugar deseja Comprar:  Janela: 00 | Corredor: 01 | Sair: 03");      
            acento = input.nextInt();
            if(acento == 3){
                   System.exit(cont);
            }

            for(int i = 0;  i < arr.length; i++){
                for(int j = 0;  j < arr.length - 1;j++){
                    if(acento == 0){
                            //filtrando caso seja janela - 00
                        if(j == 0){                    
                           System.out.println("Janela | Posição : " + i + " |    "  + arr[i][j]);                        
                        }                 

                    }else if(acento == 1){
                            //filtrando caso seja corredor - 01
                        if(j == 1){                    
                            System.out.println("Corredor | Posição : " + i + " |    "  + arr[i][j]);              
                        }
                    }                    
                }
            }

            for(int i = 0;  i < 1; i++){
                //janela       / corredor    =>> cont conta quantos 
                if(cont != 0){
                    System.out.println("\nDigite o numero da posição que deseja Comprar: ");        
                    int acentoComprar = input.nextInt();
                    if(acento == 0){
                        if(arr[acentoComprar][0] == 1){
                            System.err.println("Acento já está ocupado -  janela ");                    
                        }else if(arr[acentoComprar][0] == 0){
                            System.out.println("Obrigado , comprado com sucesso !! -  janela"); 
                            arr[acentoComprar][0] = 1;
                            cont--;
                        }else{
                            System.err.println("Janela - Vaga Não foi encontrada");
                        }
                    }

                    if(acento == 1){
                        if(arr[acentoComprar][1] == 1){
                            System.err.println("Acento já está ocupado -  corredor");                    
                        }else if(arr[acentoComprar][1] == 0){
                            System.out.println("Obrigado , comprado com sucesso !! -  corredor"); 
                            arr[acentoComprar][1] = 1;
                            cont--;
                        }else{
                            System.out.println("Corredor - Vaga Não foi encontrada");
                        }
                    }   
                }else{
                    System.out.println("\n Não  a vagas no momento \n");                    
                }
            }

            System.out.println();
            
        }while(cont != 0);
    }
       
    public static void Status(){

        System.err.println("    Menu");
        System.out.println("    01 - Comprar ou visualizar");
        System.out.println("    02 - Sair");
    }
    
}
