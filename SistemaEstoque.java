package sistemaestoque;
import java.util.Scanner;
/**
 *
 * @autor Matheus Brito
 */
public class SistemaEstoque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] newMatriz = new String[4][4];
        double quantidade;
        double preco;
        double total;
        
        for (int y = 1; y < 4; y++) {
            System.out.print("Produto: ");
            newMatriz[y][0] = scanner.nextLine();

            System.out.print("Quantidade: ");
            newMatriz[y][1] = scanner.nextLine();

            System.out.print("Preço: ");
            newMatriz[y][2] = scanner.nextLine();
            
            quantidade = Double.parseDouble(newMatriz[y][1]); // Converte uma String para variável tipo Double, para que as contas sejam feitas.
            preco = Double.parseDouble(newMatriz[y][2]);
            total = quantidade * preco; // Nesta linha, os "Double" são somados para o total
            newMatriz[y][3] = String.format("%.2f", total);
            }
            System.out.printf("%-15s %-12s %-10s %-10s\n", "Produto", "Quantidade", "Preço", "Total"); // Os caracteres que sobram de espaço para as palavras
            
            for (int y = 1; y < 4; y++) {
                System.out.printf("%-15s %-12s %-10s %-10s\n",
                        newMatriz[y][0],
                        newMatriz[y][1],
                        newMatriz[y][2],
                        newMatriz[y][3]);
        }
    }
}