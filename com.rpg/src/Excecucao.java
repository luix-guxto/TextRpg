import java.util.Calendar;

public class Excecucao {
    public static void main(String[] args){
        //instancia os objetos
        Limpeza console = new Limpeza();
        Placar placar = new Placar();

        //pega o tempo atual de agora
        Calendar hoje = Calendar.getInstance();
        int diaHoje = hoje.get(Calendar.DAY_OF_MONTH),
            mesHoje=hoje.get(Calendar.MONTH),
            anoHoje=hoje.get(Calendar.YEAR),
            horaHoje=hoje.get(Calendar.HOUR_OF_DAY),
            minutoHoje=hoje.get(Calendar.MINUTE);

        //loop de execução
        for(boolean loopGame=true; loopGame;) {

            //instancia os objetos do jogador
            Jogador jogador1 = new Jogador();
            Armas arma = new Armas();
            Mochila mochila = new Mochila();

            //começa o jogo
            for (boolean jogando = true; jogando; ) {
                jogador1.setNome();
                jogador1.setXp(2000.0);
                jogador1.setNv();
                jogador1.setKill(50000.0);
                jogador1.setVida(500);
                jogador1.setDamage(jogador1.getVida());
                arma.setIdArma();
                if (jogador1.getVida() <= 0) {
                    jogando = false;
                    jogador1.setScore();


                    if (jogador1.getScore() > placar.getMenor()) {
                        placar.setPlacarNome(jogador1.getNome());
                        placar.setPlacarScore(jogador1.getScore());
                    }

                    placar.imprimePlacar();

                }
            }

        }

//
    }
}//