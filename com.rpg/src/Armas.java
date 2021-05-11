import java.util.InputMismatchException;
import java.util.Scanner;

public class Armas extends Jogador{
    Limpeza limpa = new Limpeza();
    public int idArma=0;
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

    //limite munições
    private int limiteBala = 10;
    private int limiteFlecha = 10;
    private int limiteGranada = 5;
    private int limiteMana = 500;



    public void setIdArma() {
        int erro=0;
        for(boolean escolhe = true; escolhe;){

            limpa.linhas(50);
        if(erro==1){ System.out.println("Ops!\nEssa Arma não existe, tente outra!"); }
        if(erro==2){ System.out.println("Tente colocar um numero inteiro sem espaço"); }
        erro=0;
            limpa.linhas(1);
        System.out.println("Vamos usar qual arma?");

            limpa.linhas(1);

        System.out.println("1.soco              2.espada                3.pistola");
        System.out.println("4.metralhadora      5.arco                  6.besta");
        System.out.println("7.granada           8.lança granadas        9.bola de fogo");
        System.out.println("                    10.KAMEHAMEHA!!!");

        try{

            idArma = new Scanner(System.in).nextInt(); escolhe=false;

        }catch (InputMismatchException e){

            erro=2;
            idArma=1;
            escolhe=true;

         }
            if(idArma>10||idArma<1){
                erro=1;
                escolhe=true;

            }
        }
    }

    public void usaArma(){
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
                    System.out.println(getNome()+"você não tem balas o suficiente :(");
                }
            }
            case 4:{
                if(bala>=5){
                System.out.println(getNome()+"usa a metralhadora e bagaça a cara\n( TRA TA TA TA TRA");
                getDano(5 * 1);
                bala-=5;
                } else{
                    System.out.println(getNome()+"você não tem balas o suficiente :(");
                }
            }
            case 5:{
                if(flecha>0) {
                    System.out.println(getNome() + "usa o arco e da uma de Robin Hood\n( FEW )");
                    getDano(1);
                    flecha -= 1;
                }else{
                    System.out.println(getNome()+"você não tem flechas o suficiente :(");
                }
            }
            case 6:{
                if(flecha>=3) {
                    System.out.println(getNome() + "usa a besta, oloco 3 flechas\n( FEW, FEW, FEW )");
                    getDano(3 * 1);
                    flecha -= 3;
                }else {
                    System.out.println(getNome()+"você não tem flechas o suficiente :(");
                }
            }
            case 7:{
                if(granada>0) {
                    System.out.println(getNome() + "usa a gradana!\nFIRE IN THE HOLE\n\n( BOOOOOM! ) ");
                    getDano(1);
                    granada -= 1;
                }
            }
            case 8:{
                System.out.println(getNome()+"usa o lança granadas\nApelou kkk\n\n( BOOOM BOOM BOOOOM )");
                getDano(granada * 1);
                granada-=granada;
            }
            case 9:{
                System.out.println(getNome()+"usa a bola de fogo\n ( FLUEW )");
                getDano(1);
                mana-=50;
            }
            case 10:{
                System.out.println(getNome()+"usa o KAMEHAHA\n( KAAA - MEEE - HAAA - MEEE - HAAAAAAAAAAAAAAA");
                getDano(mana * 1);
                mana-=mana;
            }

        }

    }
}
