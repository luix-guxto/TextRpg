//definir o retorno do dano da arma
//\\opcional, apos aprender banco de dados, usar para criar um save game

public class Armas{
    Ferramentas ferramentas = new Ferramentas();
    Menu menu = new Menu();
    public int idArma=1;
    /* arma by id
    * 1 = soco <nada>
    * 2 = espada <nada>
    * 3 = pistola <bala>
    * 4 = metralhadora <5 bala>
    * 5 = arco <fleca>
    * 6 = besta <3 flecha>
    * 7 = granada <granada>
    * 8 = lança granadas <all granadas [dano = numero de granadas * dano da granada]>
    * 9 = bola de fogo <50 mana>
    * 10 = kameha <all mana [dano = mana gasta * dano base kameha]>
    */

    //munições
    private int bala = 10; //2 armas usam <3,4>
    private int flecha = 10; //2 armas usam <5,6>
    private int granada = 5; //2 armas usam <7,8>
    private int mana = 500; //2 armas usam <9,10>
    private int nvEspada = 1; //usado para melhorar a espada

    //limite munições
    private int limiteBala = 10;
    private int limiteFlecha = 10;
    private int limiteGranada = 5;
    private int limiteMana = 500;

    //retorna o valor na mochila
    public int getBala(){ return bala; }
    public int getFlecha(){ return flecha; }
    public int getGranada(){ return granada; }
    public int getMana(){ return mana; }
    public int getNvEspada(){ return nvEspada; }

    //retorna a capacidade maxima da moxila
    public int getLimiteBala() { return limiteBala; }
    public int getLimiteFlecha() { return limiteFlecha; }
    public int getLimiteGranada() { return limiteGranada; }
    public int getLimiteMana() { return limiteMana; }

    //levelUp da mochila
    public void upLimiteMana() { limiteMana=(int)Math.floor(limiteMana + (limiteMana * 0.5)); }
    public void upLimiteBala() { limiteBala=(int)Math.floor(limiteBala + (limiteBala * 0.9)); }
    public void upLimiteFlecha() { limiteFlecha=(int)Math.floor(limiteFlecha + (limiteFlecha * 0.7)); }
    public void upLimiteGranada() { limiteGranada=(int)Math.floor(limiteGranada + (limiteGranada * 0.6)); }
    public void setNvEspada() { nvEspada++; }
    public void upTudo() { upLimiteMana(); upLimiteBala(); upLimiteFlecha(); upLimiteGranada(); }
    public void reiniciar(){ limiteBala = 10; limiteFlecha = 10; limiteGranada = 5; limiteMana = 500; nvEspada = 1;}
public boolean temMunicao(){
        if(idArma == 1){ return true;}
        else{
            if(idArma == 2){ return true;}
            else{
                if (idArma == 3){
                    if(bala>0){ return true; } else { return false; }
                }else{
                    if (idArma == 4){
                        if(bala>=5){ return true;} else { return false; }
                    }else {
                        if(idArma == 5){
                            if (flecha>0){ return true; } else {return false;}
                        }else {
                            if (idArma == 6){
                                if(flecha>=3){ return true; }else {return false;}
                            }else{
                                if (idArma == 7){
                                    if(granada>0){ return true; }else {return false;}
                                }else{
                                    if (idArma == 8){
                                        if (granada>0){ return true; }else {return false;}
                                    }else{
                                        if (idArma == 9) {
                                            if (mana>=50){ return true; }else {return false;}
                                        }else{
                                            if (idArma == 10) {
                                                if (mana > 0) { return true; } else { return false; }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
}
    //recarrega munição
    public void setBala(int municao) {
        this.bala = bala + municao;
        if(bala > limiteBala){ bala = limiteBala; }
        ferramentas.linhas(50);
        System.out.println("Você recebeu "+municao+" balas");
        System.out.println("bala: "+bala+"/"+limiteBala);
        ferramentas.para();
    }
    public void setGranada(int municao) {
        this.granada =granada + municao;
        if(granada > limiteGranada) { granada = limiteGranada; }
        ferramentas.linhas(50);
        System.out.println("Você recebeu "+municao+" granadas");
        System.out.println("granadas: "+granada+"/"+limiteGranada);
        ferramentas.para();
    }
    public void setFlecha(int municao) {
        this.flecha = flecha + municao;
        if(flecha > limiteFlecha) { flecha = limiteFlecha; }
        ferramentas.linhas(50);
        System.out.println("Você recebeu "+municao+" flechas");
        System.out.println("flechas: "+flecha+"/"+limiteFlecha);
        ferramentas.para();
    }
    public void setMana(int municao) {
        this.mana = mana + municao;
        if (mana > limiteMana) { mana = limiteMana; }
        ferramentas.linhas(50);
        System.out.println("Você recebeu "+municao+" de mana");
        System.out.println("mana: "+mana+"/"+limiteMana);
        ferramentas.para();
    }

    //nome da arma
    public String getNomeArma(){
        if(idArma == 2){return "ESPADA";}
        if(idArma == 3){return "PISTOLA";}
        if(idArma == 4){return "METRALHADORA";}
        if(idArma == 5){return "ARCO";}
        if(idArma == 6){return "BESTA";}
        if(idArma == 7){return "GRANADA";}
        if(idArma == 8){return "LANÇA GRANADAS";}
        if(idArma == 9){return "BOLA DE FOGO";}
        if(idArma ==10){return "KAMEHA";}
        else{
            return "Soco";
        }
    }

    //menu arma
    public void escolheArma() { this.idArma = menu.arma(nvEspada); }


    //usa a Arma
     public double danoArma(){
        double dano = 1;
        if (idArma == 1){
            dano = 0;
        }
        if (idArma == 2){
            dano=nvEspada*3;
        }
        if (idArma ==3){
            dano=5;
            bala--;
        }
        if (idArma == 4){
            dano=5*5;
            bala-=5;
        }
        if (idArma == 5){
            dano=4;
            flecha--;
        }
        if (idArma == 6){
            dano=4*3;
            flecha-=3;
        }
        if (idArma == 7){
            dano=10;
            granada--;
        }
        if (idArma == 8){
            dano=10*granada;
            granada-=granada;
        }
        if (idArma == 9){
            dano=7;
            mana-=50;
        }
        if (idArma == 10){
            dano=2*mana;
            mana-=mana;
        }
        return dano;
     }
}
