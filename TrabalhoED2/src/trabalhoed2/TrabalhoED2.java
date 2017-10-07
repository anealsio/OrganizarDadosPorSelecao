package trabalhoed2;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.*;

public class TrabalhoED2 {
    
    public static void trocarComMenor(String [] palavrasUnicas, int menorPalavra, int palavraDaVez){
        String palavraAux = new String();
        palavraAux = palavrasUnicas[menorPalavra];
        palavrasUnicas[menorPalavra] = palavrasUnicas[palavraDaVez];
        palavrasUnicas[palavraDaVez] = palavraAux; 
        //if ( palavraDaVez < palavrasUnicas.length ){
            palavraDaVez++;
        //}        
    }
    
    public static int procurarMenor(String [] palavrasUnicas, int menorPalavra){        
            for ( int i = 0 ; i < (palavrasUnicas.length-1) ; i ++ ){
                //System.out.println("entroufor");
                if ( palavrasUnicas[i].compareTo( palavrasUnicas[menorPalavra] ) < 0 ){
                    System.out.println("entrou if: " + palavrasUnicas[i] + " e "+ palavrasUnicas[i+1]);
                    menorPalavra = i;                    
                }
            }
            
        System.out.println(menorPalavra);            
            return menorPalavra;
    }
    
    public static void main(String[] args) {        
        File arquivoResposta = new File("C:\\Users\\Neal\\Desktop\\RespostaTrabalhoED2.txt");
        String texto = new String();    
        ArrayList<String> palavras = new ArrayList<String>();
        
        
        try (BufferedWriter escreverArquivoResposta = new BufferedWriter ( new FileWriter(arquivoResposta) );
                BufferedReader lerArquivoPergunta = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Neal\\Desktop\\TextoED2.txt"), "ISO-8859-1"))){
            
            arquivoResposta.createNewFile();
            texto = lerArquivoPergunta.readLine();
            texto = texto.toLowerCase();
            int palavrasIguais = 0;
            
            int indicesIguais[] = new int[1000];
            Arrays.fill(indicesIguais, -1);
            
            System.out.println(texto);
            
            texto = texto.replace(",","");
            texto = texto.replace(".","");
            texto = texto.replace(":","");
            texto = texto.replace(";","");
            texto = texto.replace("!","");
            texto = texto.replace("\"","");
            texto = texto.replace("\'","");
            
            String textoDividido[] = texto.split(" ");
            
            
            System.out.println(Array.getLength(textoDividido));         
            
            String palavrasUnicas[] = new String[textoDividido.length];
            int quantidade = 0;
            for (String textoDividido1 : textoDividido) {
                boolean existe = false;
                for (int j = 0; j < quantidade; j++) {
                    if (palavrasUnicas[ j ].equals(textoDividido1)) {    
                        existe = true;
                        palavrasIguais++;
                        break;
                    }
                }
                if (!existe) {
                    palavrasUnicas[ quantidade++ ] = textoDividido1;
                }              
            }
            
            
            
            palavrasUnicas = Arrays.copyOf( palavrasUnicas , quantidade );
            
            
            
            System.out.println("numero de palavas: " + palavrasUnicas.length);
            System.out.println("palavras iguais: " + palavrasIguais);
            
            
                        
            //*
            
            int menorPalavra = 0;
            int palavraDaVez = 0;
            do {  
                //Procurando menor palavra
                for ( int i = palavraDaVez ; i < (palavrasUnicas.length-1) ; i ++ ){
                //System.out.println("entroufor");
                    if ( palavrasUnicas[i].compareTo( palavrasUnicas[menorPalavra] ) < 0 ){
                        //System.out.println("entrou if: " + palavrasUnicas[i] + " e "+ palavrasUnicas[i+1]);
                        menorPalavra = i;                    
                    }
                }
                
                System.out.println("Menor Palavra: " + palavrasUnicas [ menorPalavra]);
                
                 //trocando com a primeira palavra
                String palavraAux = new String();
                palavraAux = palavrasUnicas[menorPalavra];
                palavrasUnicas[menorPalavra] = palavrasUnicas[palavraDaVez];
                palavrasUnicas[palavraDaVez] = palavraAux;         
                palavraDaVez++;
                //menorPalavra = procurarMenor(palavrasUnicas,menorPalavra);
               // System.out.println(menorPalavra);
                //trocarComMenor(palavrasUnicas,menorPalavra,palavraDaVez);                
            } while ( palavraDaVez != palavrasUnicas.length );
            System.out.println("menor : "+menorPalavra);
            System.out.println("palavra da vez: " + palavraDaVez);
            //System.out.println("menor palavra de todas: " + palavrasUnicas[menorPalavra]);  
                   
            //*/
            /*
            for ( int i = 0 ; i < palavrasUnicas.length ; i++ )
                palavras.add(i,palavrasUnicas[i]);
             
            for( int i = 0 ; i < palavrasUnicas.length ; i++ )
                System.out.println(palavras.get(i));
            //*/
            //pular linha .newLine();
            //escreverArquivoResposta.write(texto);            
            //escreverArquivoResposta.flush();
            
        } catch (IOException ex) {
            Logger.getLogger(TrabalhoED2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
