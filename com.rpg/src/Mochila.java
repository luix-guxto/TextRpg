public class Mochila extends Armas{

    private int nvMochila = 1;
    private int pano=0;
    private int minerio=0;
    private int pocao=0;
    private int ervas=0;

    private int panoUp = 5;
    private int minerioUp = 5;

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
}
