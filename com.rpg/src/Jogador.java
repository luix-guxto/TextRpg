//finalizado
//\\opcional, apos aprender banco de dados, usar para criar um save game

import java.util.Random;
import java.util.Scanner;

public class Jogador{
    Ferramentas ferramentas = new Ferramentas();
    Random aleatorio = new Random();
    private String nome;
    private double nv=1;
    private double xp=0, vidaLimite=20, vida=20, limitXp=10;
    private double kill;
    private double score =0;
    private double danoBase=2;

    public double getKill() {
        return kill;
    }

    public double getVidaLimite() {
        return vidaLimite;
    }

    public double getNv() {
        return nv;
    }

    public void setNome(){
        ferramentas.linhas(50);
        System.out.println("Qual seu nome meu bravo heroi?");
        ferramentas.linhas(1);
        nome=new Scanner(System.in).nextLine()+" ";
    }

    public void tomaDano(double damage){ this.vida=vida-damage; }
    public void recuperaVida(double recupera){
        this.vida=vida+recupera;
        if(vida>vidaLimite){ vida=vidaLimite; }
    }

    public double getDano(double danoArma){
        return danoBase+danoArma;
    }

    public void setNv(){
        int vezes = 0;
        while(xp>=limitXp){
            nv++            ;
            danoBase=danoBase++;
            vidaLimite+=aleatorio.nextInt(15);
            vida=vidaLimite ;
            xp-=limitXp     ;
            vezes++;
            limitXp = Math.floor(limitXp + (limitXp * aleatorio.nextDouble()));
        }
        if(vezes>0) {
            System.out.println(nome + "você subiu de nivel "+vezes+" vezes! :D");
        }else{
            System.out.println("Você não subiu de nivel : |");
        }
    }

    public void     setScore    (int nivelEspada)                  { score = nv+kill+nivelEspada  ;   }
    public double   getScore    ()                  { return score                              ;   }
    public void     setXp       (double experiencia){ xp=xp+experiencia                         ;   }
    public void     setKill     ()                  { kill++                                    ;   }
    public String   getNome     ()                  { return nome                               ;   }
    public double   getVida     ()                  { return vida                               ;   }
}
