
import java.util.Scanner;

public class Jogador {
    Limpeza pula = new Limpeza();
    private String nome;
    private double nv=1;
    private double xp, vidaLimite=100, vida=100, limitXp=100;
    private double kill;
    private double score =0;
    private double danoBase=7;

    public void pause(){
        setScore();
        for(boolean pausado = true; pausado;){
            System.out.println("Jogo pausado");
           pula.linhas(1);
           System.out.println(nome);
           System.out.println("Sua pontuação é: "+score);
           System.out.println("Life: "+vida+"/"+vidaLimite);
           System.out.println("Você matou "+kill+" monstros");
        }
    }

    public void setNome(){
        System.out.println("Qual seu nome meu bravo heroi?");
        pula.linhas(1);
        nome=new Scanner(System.in).nextLine()+" ";
    }

    public void setDamage(double damage){ this.vida=vida-damage; }
    public void setVida(double coracao){
        this.vida=vida+coracao;
        if(vida<vidaLimite){ vida=vidaLimite; }
    }

    public double getDano(double danoArma){ return danoBase*danoArma; }

    public void setNv(){
        while(xp>=limitXp){
            nv++            ;
            danoBase=Math.floor(danoBase + danoBase * 0.5);
            vidaLimite+=10  ;
            vida=vidaLimite ;
            xp-=limitXp     ;
            limitXp = Math.floor(limitXp + limitXp * 0.1);
        }
    }

    public void     setScore    ()                  { score = Math.floor((xp+nv+kill)/100)      ;   }
    public double   getScore    ()                  { return score                              ;   }
    public void     setXp       (double experiencia){ this.xp=xp+experiencia                    ;   }
    public void     setKill     (double matou)      { this.kill=kill+matou                      ;   }
    public String   getNome     ()                  { return nome                               ;   }
    public double   getVida     ()                  { return vida                               ;   }
}
