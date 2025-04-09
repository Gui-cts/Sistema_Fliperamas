package fliperama;

import java.util.HashMap;
import java.util.Map;

public class Terminais {
    // Usando um mapa para armazenar os cartões por número de cartão
    private Map<Integer, Cartoes> cartoesMap;

    public Terminais() {
        // Inicializando o mapa
        this.cartoesMap = new HashMap<>();
    }

    public void addCartao(Cartoes cartao) {
        cartoesMap.put(cartao.getNumCartao(), cartao);
        System.out.println("Cartao " + cartao.getNumCartao() + " foi adicionado ao terminal.");
    }

    public void rechargeCard(int numCartao, int qtd) {
        Cartoes cartao = cartoesMap.get(numCartao); 
        if (cartao != null) {
            double novosCreditos = qtd * 2;
            cartao.setSaldoAtual(cartao.getSaldoAtual() + novosCreditos); 
            System.out.println("O cartao " + cartao.getNumCartao() + " agora possui " + cartao.getSaldoAtual() + " creditos.");
        } else {
            System.out.println("Cartao nao encontrado!");
        }
    }

    public void getBalance(int numCartao) {
        Cartoes cartao = cartoesMap.get(numCartao);
        if (cartao != null) {
            System.out.println("---------------------------------------");
            System.out.println("Cartao numero: " + cartao.getNumCartao());
            System.out.println("Saldo atual: " + cartao.getSaldoAtual());
            System.out.println("---------------------------------------");
        } else {
            System.out.println("Cartao não encontrado!");
        }
    }

    public void transferTickets(int numCartaoOrigem, int numCartaoDestino, int quantity) {
        Cartoes origem = cartoesMap.get(numCartaoOrigem);
        Cartoes destino = cartoesMap.get(numCartaoDestino);

        if (origem != null && destino != null) {

            if (origem.getTickets() >= quantity) {
                origem.setTickets(origem.getTickets() - quantity);  
                destino.setTickets(destino.getTickets() + quantity);  // Adicionar os tickets ao cartão de destino
                System.out.println("Transferencia de " + quantity + " tickets concluida.");
                System.out.println("Cartao de origem (num " + origem.getNumCartao() + ") agora possui " + origem.getTickets() + " tickets.");
                System.out.println("Cartao de destino (num " + destino.getNumCartao() + ") agora possui " + destino.getTickets() + " tickets.");
            } else {
                System.out.println("Saldo insuficiente de tickets no cartao de origem.");
            }
        } else {
            System.out.println("Cartao de origem ou destino nao encontrado!");
        }
    }
    
    public void buyPrize(int numCartao, int size){
        Cartoes cartao = cartoesMap.get(numCartao);
    }
}