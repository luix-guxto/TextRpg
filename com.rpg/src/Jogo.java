import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/*

definir a batalha
definir roteiro
[ideia] fazer um mecanismo andar, onde aleatoriamente aparece um inimigo, ou aparece um loot
//\\opcional definir save game
 */
public class Jogo {
    Random aleatorio = new Random();
    Jogador jogador = new Jogador();
    Mochila mochila = new Mochila();
    Inimigos inimigos = new Inimigos();
    Placar placar = new Placar();
    Ferramentas ferramentas = new Ferramentas();
    private int bau = 0;

    //imprime no placar seu score, caso ele seja maior que o menor score
    private void escrevePlacar(){
        placar.setPosicaoMenor();
        jogador.setScore(mochila.getNvEspada());
        if(jogador.getScore()>placar.getMenorScore()){
            placar.setPlacarNome(jogador.getNome());
            placar.setPlacarScore(jogador.getScore());
        }
        else{
            System.out.println("Que pena, seu score é muito baixo :(");
        }
    }

    //verifica de morreu
    public boolean inimigoVivo(){
        return !(inimigos.getVida() > 0);
    }
    public boolean jogadorVivo(){
        return !(jogador.getVida() > 0);
    }

    //distribui os danos
    private void jogadorInfligeDano(){
        double danoDaArma = mochila.danoArma();
        ferramentas.linhas(50);
        System.out.println(jogador.getNome()+"Atacou o "+inimigos.nomeInimigo()+" usando a "+mochila.getNomeArma()+"\n");
        System.out.println(inimigos.nomeInimigo()+" tomou "+jogador.getDano(danoDaArma)+" de dano");
        inimigos.setVida(jogador.getDano(danoDaArma));
        System.out.println(inimigos.nomeInimigo()+" ficou com "+inimigos.vida());
        ferramentas.para();
    }
    private void jogadorRecebeDano(){
        if(inimigos.getVida()>0){
            ferramentas.linhas(50);
            System.out.println(inimigos.nomeInimigo()+" Atacou o "+jogador.getNome());
            System.out.println(jogador.getNome()+"tomou -"+inimigos.getDano()+" de dano");
            jogador.tomaDano(inimigos.getDano());
            System.out.println("\nVida restante: "+jogador.getVida()+"/"+jogador.getVidaLimite());
            ferramentas.para();
        }
    }

    //loot inimigo
    private void inimigoMorreu(){
        ferramentas.linhas(50);
        double xp = inimigos.giveXp();
            System.out.println("Inimigo morreu :D");
            getLoot(inimigos.getIdInimigo());
            jogador.setKill();
            jogador.setXp(xp);
            ferramentas.linhas(50);
            System.out.println("Você recebeu "+xp+" de XP");
            jogador.setNv();
            ferramentas.para();
    }
    private void getLoot(int idInimigo){
        int item = aleatorio.nextInt(8)+1;
        /*
        1. pano
        2. minerio
        3. erva
        4. bala
        5. flecha
        6. granadas
        7. mana
        8. pocao 25%(25%)
         */
        if (item == 1){
            mochila.setPano(aleatorio.nextInt(20)+idInimigo);
        }
        if (item == 2){
            mochila.setMinerio(aleatorio.nextInt(20)+idInimigo);
        }
        if (item == 3){
            mochila.setErvas(aleatorio.nextInt(10)+idInimigo);
        }
        if (item == 4){
            mochila.setBala(aleatorio.nextInt(5)+idInimigo);
        }
        if (item == 5){
            mochila.setFlecha(aleatorio.nextInt(4)+idInimigo);
        }
        if (item == 6){
            mochila.setGranada(aleatorio.nextInt(3)+idInimigo);
        }
        if (item == 7){
            mochila.setMana(aleatorio.nextInt(100)+idInimigo);
        }
        if (item == 8){
            item = aleatorio.nextInt(8)+1;
            if (item == 1){
                mochila.setPano(aleatorio.nextInt(20)+idInimigo);
            }
            if (item == 2){
                mochila.setMinerio(aleatorio.nextInt(20)+idInimigo);
            }
            if (item == 3){
                mochila.setErvas(aleatorio.nextInt(10)+idInimigo);
            }
            if (item == 4){
                mochila.setBala(aleatorio.nextInt(5)+idInimigo);
            }
            if (item == 5){
                mochila.setFlecha(aleatorio.nextInt(4)+idInimigo);
            }
            if (item == 6){
                mochila.setGranada(aleatorio.nextInt(3)+idInimigo);
            }
            if (item == 7){
                mochila.setMana(aleatorio.nextInt(100)+idInimigo);
            }
            if (item == 8){
                mochila.setPocao(aleatorio.nextInt(3)+idInimigo);
            }
        }
    }

    //andar
    public void andar(){
        ferramentas.linhas(50);
        System.out.println("você anda para frente e encontra");
        int andei = aleatorio.nextInt(2)+1;
        if(andei == 1){
            inimigos.setIdInimigo(jogador.getNv(), jogador.getVidaLimite());
            System.out.println("Você encontrou um novo inimigo! :O\num "+inimigos.nomeInimigo());
            ferramentas.para();
            batalhar();
            bau=0;
        }
        if(andei == 2 && bau<=2){
            System.out.println("Você achou um bau!");
            ferramentas.para();
            getLoot(10);
            bau++;
        }
        else {andar();}

    }

    //inicia o game
    public void setJogador(){
        jogador.setNome();
        mochila.reinicia();
    }

    //termina o game
    public void gameOver(){
        jogador.setScore(mochila.getNvEspada());
        escrevePlacar();
    }

    //batalha
    public void batalhar(){
        jogador.setScore(mochila.getNvEspada());
        int erro = 0;
        int opcao;
        for(boolean batalhaRolando = true; batalhaRolando; ){
        //menu
            for(boolean menu = true; menu ;) {
                ferramentas.linhas(50);
                if(erro == 1){ System.out.println("Ops!\nOpção invalida, tente outra!"); }
                if(erro == 2){ System.out.println("Ops!\nAcabou a munição, tente trocar de arma!"); }
                erro = 0;
                System.out.println("        Batalhando contra " + inimigos.nomeInimigo());
                ferramentas.linhas(3);
                System.out.println("1. Escolher arma        2. atacar       3.usar poção    4. Mochila      5. Morrer :´(");
                System.out.println(
                        "\nVida: " + jogador.getVida() + "/" + jogador.getVidaLimite() +
                                "   Score: " + jogador.getScore() +
                                "   Nivel: " + jogador.getNv() +
                                "   Kills: " + jogador.getKill()+
                                "   Poções: "+ mochila.getPocao());
                try {
                        opcao = new Scanner(System.in).nextInt();
                    }catch (InputMismatchException h){
                        opcao = 5;
                }
                if(opcao == 1){
                    mochila.escolheArma();
                }
                if(opcao == 2){
                    if(mochila.temMunicao()){ menu = false; }else{ erro = 2;}
                }
                if (opcao == 3){
                    jogador.recuperaVida(mochila.usaPocao(jogador.getVidaLimite(), jogador.getNome()));
                }
                if (opcao==4){
                    mochila.menuMochila(jogador.getNome());
                }
                if(opcao==5){
                    jogador.tomaDano(jogador.getVida());
                    menu=false;
                }
                if(opcao!=1 && opcao!=2 && opcao!=3 && opcao!=4){
                    erro =1;
                }
            }
        //ataque
            if(!(jogadorVivo())){
                jogadorInfligeDano();
                    if (!(inimigoVivo())){
                        jogadorRecebeDano();
                    }
            }
        //batalha acabou
                if(inimigoVivo()){
                    inimigoMorreu();
                    batalhaRolando = false;
                }
                if (jogadorVivo()){
                batalhaRolando = false;
                }
            }
    }
}
