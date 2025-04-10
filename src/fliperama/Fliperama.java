package fliperama;

public class Fliperama {
    public static void main(String[] args) {
        Terminais terminal = new Terminais();

        Cartoes cartao1 = new Cartoes(1);
        Cartoes cartao2 = new Cartoes(2);
        Cartoes cartao3 = new Cartoes(3);

        terminal.addCartao(cartao1);
        terminal.addCartao(cartao2);
        terminal.addCartao(cartao3);

        terminal.rechargeCard(1, 10); 
        terminal.rechargeCard(2, 20);  
        terminal.rechargeCard(3, 5);   

        cartao1.setTickets(50);
        cartao2.setTickets(30);
        cartao3.setTickets(10);

        terminal.getBalance(1);
        terminal.getBalance(2);
        terminal.getBalance(3);

        terminal.transferSaldo(1, 2, 20);  

        terminal.getBalance(1);
        terminal.getBalance(2);
        terminal.getBalance(3);
    }
}