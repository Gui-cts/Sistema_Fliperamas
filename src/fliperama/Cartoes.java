package fliperama;

public class Cartoes {
    private double saldoAtual, tickets;
    private int numCartao;

    public Cartoes(int id) {
        this.saldoAtual = 0;
        this.tickets = 0;
        this.numCartao = id;
    }
    
    public void playRandomTickets(){
        double ticketCost = 4.5;
        if (this.saldoAtual >= ticketCost){
            this.setSaldoAtual(this.getSaldoAtual() - ticketCost);
            int ticketsEarned = (int) (1 + Math.random()*10);
            this.setTickets(this.getTickets() + ticketsEarned);
            System.out.println("Cartao numero: " + this.numCartao);
            System.out.println("Recebeu " + ticketsEarned + " tickets");
            System.out.println("Quantidade atual de tickets: " + this.getTickets());
            System.out.println("Quantidade de creditos atual: " + this.getSaldoAtual());
            System.out.println();
        } else {
            System.out.println("Tickets insuficientes para jogar");
        }
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }
     
    public void setSaldoAtual(double qtd) {
        this.saldoAtual = qtd;
    }

    public double getTickets() {
        return tickets;
    }

    public void setTickets(double tickets) {
        this.tickets = tickets;
    }

    public int getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(int numCartao) {
        this.numCartao = numCartao;
    }
    
    
}
