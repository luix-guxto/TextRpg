public class Mochila extends Armas{

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

                //melhora niveis
                    public void setNvMochila() {
                        if(pano>=panoUp) {
                            upTudo();
                            nvMochila++;
                            pano-=panoUp;
                            panoUp=(int)Math.floor(pano + (pano * 0.5));
                        }else{
                            System.out.println("Pano insuficiente :(\n"+pano+"/"+panoUp);
                        }
                    }
                    public void upEspada() {
                    if(minerio>=minerioUp){
                        setNvEspada();
                        minerio-=minerioUp;
                        minerioUp=(int)Math.floor(minerio + (minerio * 0.5));
                    }else{
                        System.out.println("Minerio insuficiente:(\n"+minerio+"/"+minerioUp);
                    }
                }

                //cria itens
                    public void criaPocao(){
                        if(ervas>=5){
                            pocao++;
                            ervas-=5;
                            System.out.println("Poção criada, você possui "+pocao+" poções");
                        }else{
                            System.out.println("Você não tem ervas o suficiente :(\n"+ervas+"/5 ervas nescessarias");
                        }
                    }
                    public int getNvMochila() { return nvMochila; }

                //pega itens
                    public void setPano(int tecido) { this.pano=pano+tecido; }
                    public void setMinerio(int mineral) { this.minerio = minerio + mineral; }
                    public void setErvas(int planta) { this.ervas = ervas + planta; }
                    public void setPocao(int frasco) { this.pocao = pocao + frasco; }
}
