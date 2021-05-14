//finalizado
//\\opcional, apos aprender banco de dados, aplicar para salvar o placar
package com.rpg;
public class Placar {
    Ferramentas ferramentas = new Ferramentas();

    //placar nominal
    private String[] placarNome = {
            "maria",
            "joao",
            "paulo",
            "camila",
            "pedro",
            "marcos",
            "fernanda",
            "carlos",
            "henrique",
            "jose"};

    //placar dos valores
    private double[] placarScore = {
            10,
            15,
            97,
            30,
            35,
            26,
            75,
            38,
            20,
            18 };


    private int posicaoMenor;
    private double menorScore;


            //pega a menor posi√ß√£o
            public void setPosicaoMenor(){
                menorScore = placarScore[0];
                posicaoMenor=0;
                for(int varrendo = 0; varrendo<10 ; varrendo++) {
                    if (placarScore[varrendo] < menorScore) {
                        menorScore = placarScore[varrendo];
                        posicaoMenor = varrendo;
                    }
                }
            }

            //escreve no placar
            public void setPlacarNome(String nomear){
                setPosicaoMenor();
                this.placarNome[posicaoMenor]=nomear;
            }
            public void setPlacarScore(double pontuacao){
                setPosicaoMenor();
                this.placarScore[posicaoMenor]=pontuacao;
            }
            public double getMenorScore(){
                return menorScore;
            }

            //imprime o placar
            public void imprimePlacar(){
                ferramentas.linhas(50);
                setPosicaoMenor();

                int top1, top2, top3, top4, top5, top6, top7, top8, top9, top10;

                int posicaoMaior=posicaoMenor;
                double maiorScore = placarScore[posicaoMenor];
                for(int varrendo = 0; varrendo<10; varrendo++){
                    if(placarScore[varrendo]> maiorScore){
                        maiorScore =placarScore[varrendo];
                        posicaoMaior=varrendo;
                    }
                }
                top1 = posicaoMaior;
                System.out.println("1∫  "+placarNome[top1]+" - "+placarScore[top1]);

                posicaoMaior=posicaoMenor;
                maiorScore =placarScore[posicaoMenor];
                for (int varrendo = 0 ; varrendo<10;varrendo++){
                    if (placarScore[varrendo]> maiorScore && varrendo!=top1){
                        maiorScore =placarScore[varrendo];
                        posicaoMaior=varrendo;
                    }
                }

               top2 = posicaoMaior;
                System.out.println("2∫  "+placarNome[top2]+" - "+placarScore[top2]);

                posicaoMaior=posicaoMenor;
                maiorScore =placarScore[posicaoMenor];
                for (int varrendo = 0 ; varrendo<10;varrendo++){
                    if (placarScore[varrendo]> maiorScore && varrendo!=top1 && varrendo!=top2){
                        maiorScore =placarScore[varrendo];
                        posicaoMaior=varrendo;
                    }
                }
                top3 = posicaoMaior;
                System.out.println("3∫  "+placarNome[top3]+" - "+placarScore[top3]);

                posicaoMaior=posicaoMenor;
                maiorScore =placarScore[posicaoMenor];
                for (int varrendo = 0 ; varrendo<10;varrendo++){
                    if (placarScore[varrendo]> maiorScore && varrendo!=top1 && varrendo!=top2 && varrendo!=top3){
                        maiorScore =placarScore[varrendo];
                        posicaoMaior=varrendo;
                    }
                }
                top4 = posicaoMaior;
                System.out.println("4∫  "+placarNome[top4]+" - "+placarScore[top4]);

                posicaoMaior=posicaoMenor;
                maiorScore =placarScore[posicaoMenor];
                for (int varrendo = 0 ; varrendo<10;varrendo++){
                    if (placarScore[varrendo]> maiorScore && varrendo!=top1 && varrendo!=top2 && varrendo!=top3 && varrendo!=top4){
                        maiorScore =placarScore[varrendo];
                        posicaoMaior=varrendo;
                    }
                }

                top5 = posicaoMaior;
                System.out.println("5∫  "+placarNome[top5]+" - "+placarScore[top5]);

                posicaoMaior=posicaoMenor;
                maiorScore =placarScore[posicaoMenor];
                for (int varrendo = 0 ; varrendo<10;varrendo++){
                    if (placarScore[varrendo]> maiorScore && varrendo!=top1
                            && varrendo!=top2 && varrendo!=top3 && varrendo!=top4 && varrendo!=top5){
                        maiorScore =placarScore[varrendo];
                        posicaoMaior=varrendo;
                    }
                }
               top6 = posicaoMaior;
                System.out.println("6∫  "+placarNome[top6]+" - "+placarScore[top6]);

                posicaoMaior=posicaoMenor;
                maiorScore =placarScore[posicaoMenor];
                for (int varrendo = 0 ; varrendo<10;varrendo++){
                    if (placarScore[varrendo]> maiorScore && varrendo!=top1
                            && varrendo!=top2 && varrendo!=top3 && varrendo!=top4 && varrendo!=top5 && varrendo!=top6){
                        maiorScore =placarScore[varrendo];
                        posicaoMaior=varrendo;
                    }
                }
               top7 = posicaoMaior;
                System.out.println("7∫  "+placarNome[top7]+" - "+placarScore[top7]);

                posicaoMaior=posicaoMenor;
                maiorScore =placarScore[posicaoMenor];
                for (int varrendo = 0 ; varrendo<10;varrendo++){
                    if (placarScore[varrendo]> maiorScore && varrendo!=top1
                            && varrendo!=top2 && varrendo!=top3 && varrendo!=top4
                            && varrendo!=top5 && varrendo!=top6 && varrendo!=top7){
                        maiorScore =placarScore[varrendo];
                        posicaoMaior=varrendo;
                    }
                }

                top8 = posicaoMaior;
                System.out.println("8∫  "+placarNome[top8]+" - "+placarScore[top8]);

                posicaoMaior=posicaoMenor;
                maiorScore =placarScore[posicaoMenor];
                for (int varrendo = 0 ; varrendo<10;varrendo++){
                    if (placarScore[varrendo]> maiorScore && varrendo!=top1
                            && varrendo!=top2 && varrendo!=top3 && varrendo!=top4
                            && varrendo!=top5 && varrendo!=top6 && varrendo!=top7 && varrendo!=top8){
                        maiorScore =placarScore[varrendo];
                        posicaoMaior=varrendo;
                    }
                }
                top9 = posicaoMaior;
                System.out.println("9∫  "+placarNome[top9]+" - "+placarScore[top9]);

                top10 = posicaoMenor;
                System.out.println("10∫ "+placarNome[top10]+" - "+placarScore[top10]);

                ferramentas.para();
            }

}
