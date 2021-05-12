import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Limpeza limpa = new Limpeza();

    //escolhe uma arma
    public int arma(int nivEspada) {
        int erro = 0;
        int idArma = 1;
        for (boolean escolhe = true; escolhe; ) {

            limpa.linhas(50);
            if (erro == 1) {
                System.out.println("Ops!\nEssa Arma não existe, tente outra!");
            }
            if (erro == 2) {
                System.out.println("Tente colocar um numero inteiro sem espaço");
            }
            erro = 0;
            limpa.linhas(1);
            System.out.println("Vamos usar qual arma?");

            limpa.linhas(1);

            System.out.println("1.soco              2.espada nv." + nivEspada + "       3.pistola");
            System.out.println("4.metralhadora      5.arco                  6.besta");
            System.out.println("7.granada           8.lança granadas        9.bola de fogo");
            System.out.println("                    10.KAMEHAMEHA!!!");
            try {

                idArma = new Scanner(System.in).nextInt();
                escolhe = false;

            } catch (InputMismatchException e) {

                erro = 2;
                idArma = -1;
                escolhe = true;

            }
            if (idArma > 10 || idArma < 1) {
                erro = 1;
                escolhe = true;
            }

        }


            return idArma;

    }
}



