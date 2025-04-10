package fliperama;

import java.util.HashMap;
import java.util.Map;

public class Terminais {
    // Usando um mapa para armazenar os cartões por número de cartão
    private Map<Integer, Cartoes> cartoesMap;
    private Premios premios;

    public Terminais() {
        // Inicializando o mapa
        this.cartoesMap = new HashMap<>();
        this.premios = new Premios();

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

    public void transferSaldo(int numCartaoOrigem, int numCartaoDestino, int quantity) {
        Cartoes origem = cartoesMap.get(numCartaoOrigem);
        Cartoes destino = cartoesMap.get(numCartaoDestino);

        if (origem != null && destino != null) {

            if (origem.getSaldoAtual()>= quantity) {
                origem.setSaldoAtual(origem.getSaldoAtual()- quantity);  
                destino.setSaldoAtual(destino.getSaldoAtual()+ quantity);
                System.out.println("Transferencia de " + quantity + " creditos concluida.");
                System.out.println("Cartao de origem (num " + origem.getNumCartao() + ") agora possui " + origem.getSaldoAtual()+ " creditos.");
                System.out.println("Cartao de destino (num " + destino.getNumCartao() + ") agora possui " + destino.getSaldoAtual()+ " creditos.");
            } else {
                System.out.println("Saldo insuficiente no cartao de origem.");
            }
        } else {
            System.out.println("Cartao de origem ou destino nao encontrado!");
        }
    }
    
    public void buyPrize(int numCartao, int size){
        Cartoes cartao = cartoesMap.get(numCartao);
        if (cartao != null){
            int ticketsRequired = 0;
            
            switch(size){
                case 1:
                    ticketsRequired = premios.getTICKETS_TO_SMALL();
                    break;
                case 2:
                    ticketsRequired = premios.getTICKETS_TO_MEDIUM();
                    break;
                case 3:
                    ticketsRequired = premios.getTICKETS_TO_BIG();
                default:
                    System.out.println("Premio invalido.");
            }
            if (cartao.getTickets() >= ticketsRequired){
                if (size == 1 && premios.getSmallRemaining() > 0){
                    cartao.setTickets(cartao.getTickets() - ticketsRequired);
                    premios.setSmallRemaining(premios.getSmallRemaining() - 1);
                    System.out.println("Voce comprou um " + premios.getSMALL_PRIZE() + "!");
                    System.out.println(premios.getSmallRemaining() + " " + premios.getSMALL_PRIZE() + " restante(s)");
                } else if (size == 2 && premios.getMediumRemaining() > 0) {
                    cartao.setTickets(cartao.getTickets() - ticketsRequired);
                    premios.setMediumRemaining(premios.getMediumRemaining() - 1);
                    System.out.println("Voce comprou um " + premios.getMEDIUM_PRIZE() + "!");
                    System.out.println(premios.getMediumRemaining() + " " + premios.getMEDIUM_PRIZE() + " restante(s)");
                } else if (size == 3 && premios.getBigRemaining() > 0){
                    cartao.setTickets(cartao.getTickets() - ticketsRequired);
                    premios.setBigRemaining(premios.getBigRemaining() - 1);
                    System.out.println("Voce comprou um " + premios.getBIG_PRIZE() + "!");
                    System.out.println(premios.getBigRemaining() + " " + premios.getBIG_PRIZE() + " restante(s)");
                } else {
                    System.out.println("Desculpe, o premio desejado esta esgotado.");
                }
            } else {
                System.out.println("Voce nao tem tickets suficientes para comprar este premio");
            }
        } else {
            System.out.println("Cartao nao encontrado");
        }
    }
}