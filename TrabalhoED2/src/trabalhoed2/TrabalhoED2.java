package trabalhoed2;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.*;

public class TrabalhoED2 {

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
            
            int tamanho = Array.getLength(textoDividido);
            System.out.println(tamanho);         
            
            String palavrasUnicas[] = new String[textoDividido.length];
            int quantidade = 0;
            for( int i = 0 ; i < textoDividido.length ; i++ ) {
                boolean existe = false;
                for( int j = 0 ; j < quantidade ; j++ ) {
                    if(palavrasUnicas[ j ].equals(textoDividido[ i ])) {    
                        existe = true;
                        palavrasIguais++;
                        break;
                    }
                }
                if( !existe ) {
                    palavrasUnicas[ quantidade++ ] = textoDividido[ i ]; 
                }              
            }
            
            
            
            palavrasUnicas = Arrays.copyOf( palavrasUnicas , quantidade );
            for ( int i = 0 ; i < palavrasUnicas.length ; i++ ){
                palavras.add(i,palavrasUnicas[i]);
            } 
            
            
            System.out.println("numero de palavas: " + palavrasUnicas.length);
            System.out.println("palavras iguais: " + palavrasIguais);
            int i = 0;
            while ( i < palavrasUnicas.length ){
                System.out.println(palavras.get(i));  
                i++;
            }
            
            
            //pular linha .newLine();
            //escreverArquivoResposta.write(texto);            
            //escreverArquivoResposta.flush();
            
        } catch (IOException ex) {
            Logger.getLogger(TrabalhoED2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
