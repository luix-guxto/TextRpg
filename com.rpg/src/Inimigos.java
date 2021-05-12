//finalizado
import java.util.Random;
public class Inimigos {
    Random aleatorio = new Random();
    //variaveis inimigo
    /* 1 = slime        < 10 vida  02 ataque>
     * 2 = esqueleto    < 05 vida  10 ataque>
     * 3 = zumbi        < 10 vida  10 ataque>
     * 4 = guerreiro    < 15 vida  10 ataque>
     * 5 = lobizomem    < 20 vida  15 ataque>
     * 6 = mago         < 15 vida  25 ataque>
     * 7 = militar      < 30 vida  30 ataque>
     * 8 = exercito     < 50 vida 100 ataque>
     * 9 = fantasma     <100 vida  50 ataque>
     ----------------------------------------
     * 10 = boss        <limite de vida do jogador 120 ataque>
     */
    private int idInimigo = 0;
    private double vida;
    private double vidaLimite;
    private double dano;


    //retorna os dados do inimigo
    public String nomeInimigo(){
        switch (idInimigo){
            case  1:{ return "Slime"; }
            case  2:{ return "Esqueleto"; }
            case  3:{ return "Zumbi"; }
            case  4:{ return "Guerreiro"; }
            case  5:{ return "Lobizomem"; }
            case  6:{ return "Mago"; }
            case  7:{ return "Militar"; }
            case  8:{ return "Exercíto"; }
            case  9:{ return "Fantasma"; }
            case 10:{ return "Chefão"; }
            default:{ return "nenhum inimigo"; }
        }
    }
    public double getVida(){ return vida; }
    public double getVidaLimite(){ return vidaLimite; }
    public String vida(){ return vida+"/"+vidaLimite; }

    //define qual inimigo o jogador vai enfrentar
    public void setIdInimigo(int nivelJogador, double vidaJogador) {
        //conforme o nivel do jogador sobe, aparece inimigos mais fortes
        if(nivelJogador >=0  && nivelJogador <=  2){ idInimigo = aleatorio.nextInt( 2); } //nenhum ou slime
        if(nivelJogador > 2  && nivelJogador <=  5){ idInimigo = aleatorio.nextInt( 3); }
        if(nivelJogador > 5  && nivelJogador <=  8){ idInimigo = aleatorio.nextInt( 4); }
        if(nivelJogador > 8  && nivelJogador <= 10){ idInimigo = aleatorio.nextInt( 5); }
        if(nivelJogador > 10 && nivelJogador <= 15){ idInimigo = aleatorio.nextInt( 6); }
        if(nivelJogador > 15 && nivelJogador <= 18){ idInimigo = aleatorio.nextInt( 7); }
        if(nivelJogador > 18 && nivelJogador <= 25){ idInimigo = aleatorio.nextInt( 8); }
        if(nivelJogador > 25 && nivelJogador <= 30){ idInimigo = aleatorio.nextInt(10); } //todos
        else                                       { idInimigo = aleatorio.nextInt(11); } //todos e boss
        switch (idInimigo){

            //inimigos
            case  1:{this.vidaLimite = 10; this.dano =   2;} //slime
            case  2:{this.vidaLimite =  5; this.dano =  10;} //esqueleto
            case  3:{this.vidaLimite = 10; this.dano =  10;} //zumbi
            case  4:{this.vidaLimite = 15; this.dano =  10;} //guerreiro
            case  5:{this.vidaLimite = 20; this.dano =  15;} //lobizomen
            case  6:{this.vidaLimite = 15; this.dano =  25;} //mago
            case  7:{this.vidaLimite = 30; this.dano =  30;} //militar
            case  8:{this.vidaLimite = 50; this.dano = 100;} //exercito
            case  9:{this.vidaLimite = 100;this.dano = 50;} //fantasma

            //boss
            case 10:{this.vidaLimite = vidaJogador; this.dano = 120;} //boss

            //nenhum
            default:{vidaLimite =  0; dano =   0;} //boss
        }
        setVida();
    }

    //dano do inimigo
    public double getDano(){ if( vida > 0 ){ return dano; } else{ return 0; } }

    //inimigo recebe o dano

    public void setVida(double damage) { this.vida = vida - damage; }

    //define a vida do inimigo pelo id
    private void setVida(){ vida=vidaLimite; }

}
