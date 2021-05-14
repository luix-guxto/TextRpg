//fazer o roteiro de execuÃ§Ã£o
package com.rpg;
public class Excecucao {
    public static void main(String[] args){
        //instancia os objetos
        Jogo jogo = new Jogo();
        Menu menu = new Menu();

        for (boolean loopGame = true; loopGame;){
int principal = menu.menuPrincipal();
            if(principal==4){loopGame = false;}
            if(principal == 1){
                jogo.setJogador();
                for(boolean loopJogador = true; loopJogador;){
                    jogo.andar();
                    if(jogo.jogador.getVida()<=0){
                        loopJogador=false;
                        jogo.jogador.setScore(10);
                        if(jogo.jogador.getScore()>=jogo.placar.getMenorScore()) {
                        	jogo.placar.setPlacarNome(jogo.jogador.getNome());
                        	jogo.placar.setPlacarScore(jogo.jogador.getScore());
                        	
                        }else {
                        	jogo.ferramentas.linhas(50);
                        	System.out.println("Que pena seu score é muito baixo :(\n Mais sorte na proxima vez");
                        	jogo.ferramentas.para();
                        }
                       int principalGameOver = menu.gameOver(jogo.jogador.getNome(),jogo.jogador.getScore(),jogo.jogador.getNv());
                        loopGame = principalGameOver != 2;
                    }
                    else {
                    	jogo.mochila.menuMochila(jogo.jogador.getNome());
                    }
                }
                jogo.placar.imprimePlacar();
            }
            if (principal == 3){
                jogo.placar.imprimePlacar();
            }
        }
        System.out.println("Até a proxima!!!");

//
    }
}//