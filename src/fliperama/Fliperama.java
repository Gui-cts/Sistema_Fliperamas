package fliperama;

public class Fliperama {

    public static void main(String[] args) {
        Cartoes c001 = new Cartoes(0001);
        Terminais t1 = new Terminais(c001);

        c001.playRandomTickets();
        t1.rechargeCard(10);
        c001.playRandomTickets();

    }

}
