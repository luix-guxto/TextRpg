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


            if (idInimigo == 2){ return "Esqueleto"; }
            if (idInimigo == 3){ return "Zumbi"; }
            if (idInimigo == 4){ return "Guerreiro"; }
            if (idInimigo == 5){ return "Lobizomem"; }
            if (idInimigo == 6){ return "Mago"; }
            if (idInimigo == 7){ return "Militar"; }
            if (idInimigo == 8){ return "Exercíto"; }
            if (idInimigo == 9){ return "Fantasma"; }
            if (idInimigo == 10){ return "Chefão"; }
        else{ return "Slime"; }
    }

    public int getIdInimigo() {
        return idInimigo;
    }

    public double getVida(){ return vida; }
    public String vida(){ return vida+"/"+vidaLimite; }

    //define qual inimigo o jogador vai enfrentar
    public void setIdInimigo(double nivelJogador, double vidaJogador) {
        //conforme o nivel do jogador sobe, aparece inimigos mais fortes
        if(nivelJogador >=0  && nivelJogador <=  2){ idInimigo = 1; } //nenhum ou slime
        else {
            if (nivelJogador > 2 && nivelJogador <= 5) {
                idInimigo = aleatorio.nextInt(2)+1;
            }else{
            if (nivelJogador > 5 && nivelJogador <= 8) {
                idInimigo = aleatorio.nextInt(3)+1;
            }else{
            if (nivelJogador > 8 && nivelJogador <= 10) {
                idInimigo = aleatorio.nextInt(4)+1;
            }else{
            if (nivelJogador > 10 && nivelJogador <= 15) {
                idInimigo = aleatorio.nextInt(5)+1;
            }else{
            if (nivelJogador > 15 && nivelJogador <= 18) {
                idInimigo = aleatorio.nextInt(6)+1;
            }else{
            if (nivelJogador > 18 && nivelJogador <= 25) {
                idInimigo = aleatorio.nextInt(7)+1;
            }else{
            if (nivelJogador > 25 && nivelJogador <= 30) {
                idInimigo = aleatorio.nextInt(8)+1;
            }else{
                if (nivelJogador > 30 && nivelJogador<=50){
                    idInimigo = aleatorio.nextInt(9)+1;
                }//todos
            else {
                idInimigo = aleatorio.nextInt(10)+1;
            }
        }}}}}}}}//todos e boss
        System.out.println();
        //inimigos
            if(idInimigo == 1){vida = 10; dano =   2;} //slime
            if(idInimigo == 2){vida =  5; dano =  10;} //esqueleto
            if(idInimigo == 3){vida = 10; dano =  10;} //zumbi
            if(idInimigo == 4){vida = 15; dano =  10;} //guerreiro
            if(idInimigo == 5){vida = 20; dano =  15;} //lobizomen
            if(idInimigo == 6){vida = 15; dano =  25;} //mago
            if(idInimigo == 7){vida = 30; dano =  30;} //militar
            if(idInimigo == 8){vida = 50; dano = 100;} //exercito
            if(idInimigo == 9){vida = 100;dano = 50;} //fantasma

            //boss
            if(idInimigo == 10){vidaLimite = vidaJogador; dano = 120;} //boss
vidaLimite = vida;

    }



    //da xp
    public double giveXp(){
        if(vida<=0) {
            return Math.floor((aleatorio.nextDouble() * (idInimigo + aleatorio.nextInt(100)) + idInimigo));

        }
        else {
            return 0;
        }
    }

    //dano do inimigo
    public double getDano(){ if( vida > 0 ){ return dano; } else{ return 0; } }

    //inimigo recebe o dano
    public void setVida(double damage) { vida -= damage; }



}
