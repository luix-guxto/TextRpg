//finalizado

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Mochila extends Armas{

    private int erro = 0;
    Random aleatorio = new Random();

    //nivel da mochila
        private int nvMochila = 1;

    //itens da mochila
        private int pano=0;
        private int minerio=0;
        private int pocao=0;
        private int ervas=0;

    //quantidade para evoluir
        private int panoUp = 5;
        private int minerioUp = 5;

            //AÇÕES\\
    public double usaPocao(double vidaJogador, String nomeJogador){
        ferramentas.linhas(50);
        if(pocao>0){
            System.out.println(nomeJogador+"usou uma poção e recuperou "+vidaJogador);
            ferramentas.para();
            return vidaJogador;
        }
        else {
            System.out.println(nomeJogador+"você não possui pocoes :(");
            ferramentas.para();
            return 0;
        }
    }

                //melhora niveis
                    public void setNvMochila() {
                        if(pano>=panoUp) {
                            ferramentas.linhas(50);
                            System.out.println("Mochila subiu de nivel!");
                            upTudo();
                            nvMochila++;
                            pano-=panoUp;
                            panoUp=(int)Math.floor(panoUp + (panoUp * aleatorio.nextDouble()));
                            ferramentas.para();
                        }else{
                            ferramentas.linhas(50);
                            System.out.println("Pano insuficiente :(\n"+pano+"/"+panoUp);
                            ferramentas.para();
                        }
                    }
                    public void upEspada() {
                    if(minerio>=minerioUp){
                        ferramentas.linhas(50);
                        System.out.println("A Espada subiu de nivel!");
                        setNvEspada();
                        minerio-=minerioUp;
                        minerioUp=(int)Math.floor(minerioUp + (minerioUp * aleatorio.nextDouble()));
                        ferramentas.para();
                    }else{
                        ferramentas.linhas(50);
                        System.out.println("Minerio insuficiente:(\n"+minerio+"/"+minerioUp);
                        ferramentas.para();
                    }
                }
                public void reinicia(){
                        reiniciar();
                }

                //cria itens
                    public void criaPocao(){
        ferramentas.linhas(50);
                        if(ervas>=5){
                            pocao++;
                            ervas-=5;
                            System.out.println("Poção criada, você possui "+pocao+" poções");
                        }else{
                            System.out.println("Você não tem ervas o suficiente :(\n"+ervas+"/5 ervas nescessarias");

                        }
                        ferramentas.para();
                    }
                    public int getNvMochila() { return nvMochila; }

                //pega itens
                    public void setPano(int tecido) {
                        pano=pano+tecido;
                        ferramentas.linhas(50);
                        System.out.println("Você recebeu "+tecido+" panos!");
                        ferramentas.para();
                    }
                    public void setMinerio(int mineral) {
                        minerio = minerio + mineral;
                        ferramentas.linhas(50);
                        System.out.println("Você recebeu "+mineral+" minerios!");
                        ferramentas.para();
                    }
                    public void setErvas(int planta) {
                        ervas = ervas + planta;
                        ferramentas.linhas(50);
                        System.out.println("Você recebeu "+planta+" ervas!");
                        ferramentas.para();
                    }
                    public void setPocao(int frasco) {
                        pocao = pocao + frasco;
                        ferramentas.linhas(50);
                        System.out.println("Incrivel!!!\n   Você recebeu "+frasco+" poções!!!");
                        ferramentas.para();
                    }

                //menu
                public void menuMochila(String nome){
                        int opcao;
                        for(boolean menu = true; menu;) {

                            menu = false;
                            ferramentas.linhas(50);
                            if (erro == 1) {
                                System.out.println("Ops!\nNão existe essa opção, tente outra!");
                            }
                            erro = 0;
                            ferramentas.linhas(2);
                            System.out.println("        Inventario do " + nome);
                            ferramentas.linhas(1);
                            System.out.println("nivel da mochila " + getNvMochila());
                            System.out.println("nivel da espada " + getNvEspada());
                            ferramentas.linhas(2);
                            System.out.println("1. upgrade mochila " + pano + "/" + panoUp);
                            System.out.println("2. upgrade espada " + minerio + "/" + minerioUp);
                            System.out.println("3. munições\n4. criar poção "+ ervas +"/5");
                            System.out.println("5. sair");

                            try { opcao = new Scanner(System.in).nextInt(); }
                            catch (InputMismatchException e){ opcao=-1; }
                                if (opcao==1){
                                    setNvMochila();
                                    menu = true;
                                }
                                if (opcao==2){
                                    upEspada();
                                    menu = true;
                                }
                                if (opcao==3){
                                    getMunicoes(nome);
                                    menu = true;

                                }
                                if(opcao==4){
                                    criaPocao();
                                    menu = true;
                                }
                                if( opcao!=1 && opcao!=2 && opcao!=3 && opcao!=4 && opcao!=5){
                                    erro = 1;
                                    menu = true;
                                }



                        }
                }
                public void getMunicoes(String nome){
                        ferramentas.linhas(50);
                        System.out.println("        Munições");
                        ferramentas.linhas(2);
                        System.out.println(nome+"Você possui:");
                        ferramentas.linhas(1);
                        System.out.println("Mana: "+getMana()+"/"+getLimiteMana());
                        System.out.println("Balas: "+getBala()+"/"+getLimiteBala());
                        System.out.println("Granadas: "+getGranada()+"/"+getLimiteGranada());
                        System.out.println("Flechas: "+getFlecha()+"/"+getLimiteFlecha());
                        ferramentas.para();
                }
}
