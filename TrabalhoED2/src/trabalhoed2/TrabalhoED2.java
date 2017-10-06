package trabalhoed2;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.*;

public class TrabalhoED2 {

    public static void main(String[] args) {        
        File arquivoResposta = new File("C:\\Users\\Neal\\Desktop\\RespostaTrabalhoED2.txt");
        String texto = new String();        
        Set<String> palavras = new HashSet<>();
        
        
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
            
            for ( int i = 0 ; i < tamanho ; i++ ){
                if (palavras.add(textoDividido[i]) == false ){
                    tamanho--;
                    palavrasIguais++;
                }
                else palavras.add(textoDividido[i]);
            } 
            String[] textoDefinitivo = palavras.toArray ( new String [palavras.size()] );
            
            System.out.println("numero de palavas: " + tamanho);
            System.out.println("palavras iguais: " + palavrasIguais);
            int i = 0;
            while ( i < palavras.size() ){
                System.out.println(textoDefinitivo[i]);  
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
