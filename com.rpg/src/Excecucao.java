//fazer o roteiro de execução
public class Excecucao {
    public static void main(String[] args){
        //instancia os objetos
        Jogo jogo = new Jogo();
        Menu menu = new Menu();

        for (boolean loopGame = true; loopGame;){
            int principal = menu.menuPrincipal();
            if(principal == 1){
                jogo.setJogador();
                for(boolean loopJogador = true; loopJogador;){
                    jogo.andar();
                    if(jogo.jogadorVivo()){
                        loopJogador=false;
                        jogo.gameOver();
                        principal = menu.gameOver(jogo.jogador.getNome(),jogo.jogador.getScore(),jogo.jogador.getNv());
                        if(principal == 2){
                            loopGame = false;
                        }
                    }
                }
                jogo.placar.imprimePlacar();
            }
            if (principal == 3){
                jogo.placar.imprimePlacar();
            }
            else {loopGame = false;}
        }

//
    }
}//