//definir o retorno do dano da arma
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
    public void upLimiteBala() { limiteBala=(int)Math.floor(limiteMana + (limiteBala * 0.9)); }
    public void upLimiteFlecha() { limiteFlecha=(int)Math.floor(limiteFlecha + (limiteFlecha * 0.7)); }
    public void upLimiteGranada() { limiteGranada=(int)Math.floor(limiteGranada + (limiteGranada * 0.6)); }
    public void setNvEspada() { nvEspada++; }
    public void upTudo() { upLimiteMana(); upLimiteBala(); upLimiteFlecha(); upLimiteGranada(); }

    //recarrega munição
    public void setBala(int municao) {
        this.bala = bala + municao;
        if(bala > limiteBala){ bala = limiteBala; }
    }
    public void setGranada(int granadas) {
        this.granada =granada + granadas;
        if(granada > limiteGranada) { granada = limiteGranada; }
    }
    public void setFlecha(int flechas) {
        this.flecha = flecha + flechas;
        if(flecha > limiteFlecha) { flecha = limiteFlecha; }
    }
    public void setMana(int manas) {
        this.mana = mana + manas;
        if (mana > limiteMana) { mana = limiteMana; }
    }

    //menu arma
    public void escolheArma() { this.idArma = menu.arma(nvEspada); }


    //usa a Arma
     /* public void usaArma(){
        switch (idArma){
            case 1:{
                System.out.println(getNome()+"usa o soco na cara\n( POW )");
                getDano(1);
            }
            case 2:{
                System.out.println(getNome()+"usa a espada e corta o inimigo\n( VAP )");
                getDano(1);
            }
            case 3:{
                if(bala>0){
                System.out.println(getNome()+"usa a pistola e acerta o tiro\n( PAPAPA )");
                getDano(1);
                bala-=1;
                }
                else{
                    System.out.println(getNome()+"você não tem balas o suficiente :(\n"+bala+"/1 balas nescessarias");
                }
            }
            case 4:{
                if(bala>=5){
                System.out.println(getNome()+"usa a metralhadora e bagaça a cara\n( TRA TA TA TA TRA");
                getDano(5 * 1);
                bala-=5;
                } else{
                    System.out.println(getNome()+"você não tem balas o suficiente :(\n"+bala+"/5 balas nescessarias");
                }
            }
            case 5:{
                if(flecha>0) {
                    System.out.println(getNome() + "usa o arco e da uma de Robin Hood\n( FEW )");
                    getDano(1);
                    flecha -= 1;
                }else{
                    System.out.println(getNome()+"você não tem flechas o suficiente :(\n"+flecha+"/1 flechas nescessarias");
                }
            }
            case 6:{
                if(flecha>=3) {
                    System.out.println(getNome() + "usa a besta, oloco 3 flechas\n( FEW, FEW, FEW )");
                    getDano(3 * 1);
                    flecha -= 3;
                }else {
                    System.out.println(getNome()+"você não tem flechas o suficiente :(\n"+flecha+"/3 flechas nescessarias");
                }
            }
            case 7:{
                if(granada>0) {
                    System.out.println(getNome() + "usa a gradana!\nFIRE IN THE HOLE\n\n( BOOOOOM! ) ");
                    getDano(1);
                    granada -= 1;
                }else{
                    System.out.println(getNome()+"Você não tem granadas o suficiente :(\n"+granada+"/1 granadas nescessarias");
                }
            }
            case 8:{
                if(granada>=3) {
                    System.out.println(getNome() + "usa o lança granadas\nApelou kkk\n\n( BOOOM BOOM BOOOOM )");
                    getDano(granada * 1);
                    granada -= granada;
                }else{
                    System.out.println(getNome()+"Você não tem granadas o suficiente :(\n"+granada+"/3 no minimo para usar");
                }
            }
            case 9:{
                if(mana>=50) {
                    System.out.println(getNome() + "usa a bola de fogo\n ( FLUEW )");
                    getDano(1);
                    mana -= 50;
                }else{
                    System.out.println(getNome()+"Você não tem mana o suficiente :(\n"+mana+"/50 mana nescessaria");
                }
            }
            case 10:{
                if(mana>=100) {
                    System.out.println(getNome() + "usa o KAMEHAHA\n( KAAA - MEEE - HAAA - MEEE - HAAAAAAAAAAAAAAA )\nVocê gastou "+mana+" e ficou com nada");
                    getDano(mana * 1);
                    mana -= mana;
                }else{
                    System.out.println(getNome()+"Você não tem mana o suficiente :(\n"+mana+"/100 no minimo para usar");
                }
            }

        }

    } */
}
