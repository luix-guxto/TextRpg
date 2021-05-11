import java.util.Scanner;
import java.util.Calendar;
import java.util.Random;
import java.util.InputMismatchException;
public class Excecucao {
    public static void main(String[] args){
        Limpeza console = new Limpeza();
        //pega o tempo atual de agora
        Calendar hoje = Calendar.getInstance();
        Placar placar = new Placar();
        Armas arma = new Armas();
        int diaHoje = hoje.get(Calendar.DAY_OF_MONTH),
            mesHoje=hoje.get(Calendar.MONTH),
            anoHoje=hoje.get(Calendar.YEAR),
            horaHoje=hoje.get(Calendar.HOUR_OF_DAY),
            minutoHoje=hoje.get(Calendar.MINUTE);

        for(boolean loopGame=true; loopGame;){

         Jogador jogador1 = new Jogador();
            jogador1.setNome();
            jogador1.setXp(2000.0);
            jogador1.setNv();
            jogador1.setKill(50000.0);
            jogador1.setVida(500);
            jogador1.setDamage(jogador1.getVida());
            arma.setIdArma();
         if(jogador1.getVida()<=0) {
             loopGame = false;
             jogador1.setScore();


            if(jogador1.getScore()>placar.getMenor()) {
                placar.setPlacarNome(jogador1.getNome());
                placar.setPlacarScore(jogador1.getScore());
            }

            placar.imprimePlacar();

         }
        }

    }
}