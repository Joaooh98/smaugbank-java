package domain.Repository;

public class ts {
    public static void main(String[] args) {
        String texto = "Exemplo de texto";

        // Obtém o último índice da string
        int ultimoIndice = texto.lastIndexOf('t');

        if (ultimoIndice != -1) {
            // Divide a string em duas partes
            String parte1 = texto.substring(0, ultimoIndice);  // Até o último espaço
            String parte2 = texto.substring(ultimoIndice + 1);  // Depois do último espaço

            // Exibe as duas partes
            System.out.println("Parte 1: " + parte1);
            System.out.println("Parte 2: " + parte2);
        } else {
            System.out.println("A string não contém espaços.");
        }
    }

    // exemplo para criar um metodo que vai dividir o ultimo digito gerado 
    
}
