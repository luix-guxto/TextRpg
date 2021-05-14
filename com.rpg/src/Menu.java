//finalizado

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Ferramentas ferramentas = new Ferramentas();
    private int erro = 0;
    private int opcaoDoMenu = 0;

    //escolhe uma arma
    public int arma(int nivEspada) {
        int erro = 0;
        int idArma = 1;
        for (boolean escolhe = true; escolhe; ) {

            ferramentas.linhas(50);
            if (erro == 1) {
                System.out.println("Ops!\nEssa Arma não existe, tente outra!");
            }
            erro = 0;
            ferramentas.linhas(1);
            System.out.println("Vamos usar qual arma?");

            ferramentas.linhas(1);

            System.out.println("1.soco              2.espada nv." + nivEspada + "     3.pistola");
            System.out.println("4.metralhadora      5.arco                  6.besta");
            System.out.println("7.granada           8.lança granadas        9.bola de fogo");
            System.out.println("                    10.KAMEHAMEHA!!!");
            try {

                idArma = new Scanner(System.in).nextInt();
                escolhe = false;

            } catch (InputMismatchException e) {
                idArma = -1;
            }
            if (idArma > 10 || idArma < 1) {
                erro = 1;
                escolhe = true;
            }

        }


            return idArma;

    }
    public int menuPrincipal(){
        erro = 0;

            for(boolean escolhendo = true; escolhendo;){
                ferramentas.linhas(50);
                if(erro == 1){ System.out.println("Ops!\nOpção invalida, tente outra!"); }
                erro = 0;
                opcaoDoMenu=0;
                System.out.println("        TextRpg");
                ferramentas.linhas(1);
                System.out.println("Menu principal :)");
                ferramentas.linhas(2);
                System.out.println("1. Começar");
                System.out.println("2. Sobre o Jogo\n3. Placar");
                System.out.println("4. Parar de Jogar :´(");

                try{
                    opcaoDoMenu = new Scanner(System.in).nextInt();
                }catch (InputMismatchException a){
                    opcaoDoMenu = 666;
                    erro=1;
                   continue;
                }
                if(opcaoDoMenu == 1){ escolhendo = false; }
                if(opcaoDoMenu == 2){ gameInfo(); }
                if(opcaoDoMenu == 3){ escolhendo = false; }
                if(opcaoDoMenu == 4){ escolhendo = false; }
                else{
                    erro = 1;
                }

            }
            return opcaoDoMenu;
        } //1 começa 3 termina

    public int gameOver(String nomea, double score, double nivel) {
        gameInfo();
        erro=0;
            for(boolean gameFim = true; gameFim;) {
                    ferramentas.linhas(50);
                    if(erro == 1){ System.out.println("Ops!\nOpção invalida, tente outra!"); }
                    erro = 0;
                System.out.println("                            Game Over" +
                        "\n" +
                        "\n"+nomea+"Você ficou com o score de "+score+" pontos e seu nivel final "+nivel+
                        "\n"+
                        "\n                                     Continue?" +
                        "\n" +
                        "\n                 1. Sim!                                   2. Murri :´(");
                try {
                    opcaoDoMenu=new Scanner(System.in).nextInt();
                }catch (InputMismatchException f){
                    erro = 1;
                }
                if(opcaoDoMenu == 1||opcaoDoMenu ==2){
                    gameFim = false;
                }
                else{
                    erro = 1;
                }
            }
        return opcaoDoMenu;
    } //1 continua 2 termina


    private void gameInfo() {
        ferramentas.linhas(50);
        System.out.println("        Game Info" + "\n" + "\nEsse é um game baseado em O.O. ( Orirentação a Objetos )" + "\nTentando implementar a funcionalidades do solid" + "\nNesse Rpg você possui armas e itens" + "\n" + "\nBy:Luíx_Guxto" + "\n");
        ferramentas.para();
    }
    }



