//fazer o roteiro de execução
import java.util.Calendar;

public class Excecucao {
    public static void main(String[] args){
        //instancia os objetos
        Ferramentas ferramentas = new Ferramentas();
        Jogo jogo = new Jogo();

        //pega o tempo atual de agora
        Calendar hoje = Calendar.getInstance();
        int diaHoje = hoje.get(Calendar.DAY_OF_MONTH),
            mesHoje=hoje.get(Calendar.MONTH),
            anoHoje=hoje.get(Calendar.YEAR),
            horaHoje=hoje.get(Calendar.HOUR_OF_DAY),
            minutoHoje=hoje.get(Calendar.MINUTE);


        //testando ainda
        jogo.mochila.menuMochila("pedro");







//
    }
}//