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
            
            String unicos[] = new String[textoDividido.length];
            int qtd = 0;
            for( int i = 0 ; i < textoDividido.length ; i++ ) {
                boolean existe = false;
                for( int j = 0 ; j < qtd ; j++ ) {
                    if(unicos[ j ].equals(textoDividido[ i ])) {    
                        System.out.println("entrou if");
                        existe = true;
                        palavrasIguais++;
                        break;
                    }
                }
                if( !existe ) {
                    unicos[ qtd++ ] = textoDividido[ i ]; 
                }              
            }
            
            unicos = Arrays.copyOf( unicos , qtd );
            for ( int i = 0 ; i < unicos.length ; i++ ){
                palavras.add(i,unicos[i]);
            } 
            
            
            System.out.println("numero de palavas: " + unicos.length);
            System.out.println("palavras iguais: " + palavrasIguais);
            int i = 0;
            while ( i < unicos.length ){
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
