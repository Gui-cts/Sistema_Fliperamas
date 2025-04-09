package fliperama;

public class Terminais {
    private Cartoes cartoes;

    public Terminais(Cartoes cartoes) {
        this.cartoes = cartoes;
    }
    
    public void rechargeCard(int qtd){
        double novosCreditos = qtd * 2;
        this.cartoes.setSaldoAtual(novosCreditos);
        System.out.println("Seu cartao " + this.cartoes.getNumCartao() + " agora possue " + this.cartoes.getSaldoAtual() + " Creditos");
    }
}
