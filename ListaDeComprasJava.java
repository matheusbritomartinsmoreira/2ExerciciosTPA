package listadecomprasjava;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @autor Matheus Brito Martins Moreira
 */
public class ListaDeComprasJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList<>();
        int opcao;
        String item = ""; // Os nomes de cada item
        String nome = "";
        String remove = ""; // O nome do item para removê-lo
        String sair = ""; // Usuário digita "s" ou "n" para sair
        String apagar = "";
        String trocarPalavra = "";
        String novaPalavra = "";
        System.out.println("Bem-vindo à sua lista de compras.");
        
        do {
        System.out.println("Digite uma opção:");
        System.out.println("1. Adicionar item");
        System.out.println("2. Remover item");
        System.out.println("3. Visualizar lista atual");
        System.out.println("4. Alterar itens");
        System.out.println("5. Deletar lista inteira");
        System.out.println("6. Opção Sair");
        opcao = scanner.nextInt();
        scanner.nextLine();
        
        switch(opcao) {
            case 1 -> { // Adicionar item
                System.out.print("Digite o item para adicionar \n");
                item = scanner.nextLine(); // Item agora vai ter o valor do input do usuário
                lista.add(item); // Esta palavra será adicionada à lista
            }
            case 2 -> { // Remover item
                if (lista.isEmpty()) {
                    System.out.println("Sua lista está vazia.");
                } else {
                    System.out.print("Digite o item para remover: ");
                    remove = scanner.nextLine().trim(); // Essa String vai receber o valor. E Trim() remove espaços digitados no início e fim da String.
                    boolean procurar = false;
                    // (SOBRE ESTE BOOLEAN) Aqui foi criado o boolean dentro do case porque ele precisa ser reiniciado como "false" sempre que...
                    // ...o usuário tentar remover um item.
                    // Ela serve para indicar se algum item da lista foi encontrado
                    // Se permanecesse fora do switch, poderia manter o valor "true" de uma REMOÇÃO ANTERIOR e isso daria resultados incorretos.
                    for (int i = 0; i < lista.size(); i++) { // Enquanto a contagem não alcançar cada item, continua contando. Para numerar todos os itens.
                        if (lista.get(i).equalsIgnoreCase(remove)) { // Se tal String de um lista.get(i)  estiver igual à palavra para remover...
                            lista.remove(i); // ...ela é removida(e desconsiderando letras maiúsculas ou espaços
                            procurar = true;
                            System.out.printf("Item '%s' foi removido. \n", remove);
                            i--; // Para diminuir 1 número de cada item, arrumando a lista.
                        }
                        }
                            if (!procurar) { // Se NÃO for encontrado nenhum item com nome igual.
                            System.out.printf("O item '%s' não foi encontrado.\n", remove);
                            procurar = false;
                    }
                }
            }
            case 3 -> { // Visualizar lista atual
                if (lista.isEmpty()) {
                System.out.println("A lista está vazia. \n");
                } else {
                    System.out.println("Lista atual: \n");
                    for (int i = 0; i < lista.size(); i++) { // A cada item adicionado, conta mais um número
                        nome = lista.get(i); // Busca os itens da lista
                        System.out.printf("%d. %s\n", i + 1, nome); // Para numerar os itens
                        System.out.println(""); // Separar visualmente a lista e as opções
                    }
                }
            }
            case 4 -> { // Alterar itens
                if (lista.isEmpty()) {
                    System.out.println("Sua lista está vazia.");   
                } else {
                    System.out.print("Digite o nome do item que deseja alterar: ");
                trocarPalavra = scanner.nextLine().trim().toLowerCase();
                boolean palavraEncontrada = false;
                // Mais um caso onde é necessário o valor ser reiniciado como "falso"
                for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equalsIgnoreCase(trocarPalavra)) { // Se o item digitado for igual a um da lista...
                System.out.print("Digite o novo nome para o item: ");
                novaPalavra = scanner.nextLine().trim().toLowerCase();
                lista.set(i, novaPalavra);
                palavraEncontrada = true;
                
                System.out.printf("Item '%s' foi alterado para '%s'.\n", trocarPalavra, novaPalavra);
                break;
            } else if (!palavraEncontrada) {
                System.out.println("Este item não está na lista.");
            }
                }
                }
            }
            case 5 -> { // Deletar lista inteira
                System.out.println("Certeza que deseja apagar toda a lista? (s/n)");
                apagar = scanner.nextLine().trim().toLowerCase();
                if (apagar.equals("s")) {
                    lista.clear();
                    System.out.println("Lista apagada.");
                } else if (apagar.equals("n")){
                    System.out.println("Remoção total cancelada.");                    
                }
                }
            case 6 -> { // Opção Sair
                System.out.print("\nDeseja mesmo sair? (s/n) ");
                sair = scanner.nextLine().trim().toLowerCase(); // Vai receber se o usuário quer sair ou não, ignorando espaços e colocando em minúsculas.
                
                if (sair.equals("n")) { // Se sair for igual a n...
                    System.out.println("Continuando o sistema..."); // ...exibe esta mensagem e continua.
                } else if (sair.equals("s")) { // Se for igual a s, mostra essa mensagem e sai do loop.
                    System.out.println("Saindo...");
                } else {
                          System.out.println("Resposta desconhecida. Somente s/n. "); // Não fecha o sistema. Continua.
            }
        }
            default -> {
                System.out.println("Opção inválida. Somente entre 1 e 6.");
            }
        }
        } while (!sair.equals("s"));
        scanner.close();
    }
}