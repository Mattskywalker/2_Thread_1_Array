
package main;

import java.util.ArrayList;


public class ThreadInt extends Thread{

    private char[] data;
    int index = 0,indiceInicial,indiceFinal,contadorDigitos;
    public ThreadInt(char[] data){

        this.data = data;

    }

    public void listar(int inicial, int finalValue){

        for(int i = inicial;i <= finalValue;i++){

            System.out.println("Valores encontrados: THREADINTEIROS: " + data[i]);
        }

    }

    public void run(){

        for(char a:data){

            //System.out.println("indice: " + index);

            if(Character.isDigit(a)){
                this.contadorDigitos++;
              //  System.out.println("contador: " + contadorDigitos);
            }
            if(contadorDigitos >= 1){
                //System.out.println("entrei no if");
                try{

                    int i = index + 1;
                  //  System.out.println("Valor de  i: proxima posição lida: "+ i);
                    if(Character.isDigit(data[i])){
                    //    System.out.println("Calma, ainda tem numero pela frente: esse numero é : " + data[i]);
                        i = 0;
                    }
                    else{
                      //  System.out.println("O caractere encontrado, não era um numero " +
                        //        "significa que a cadeia acabou em : "+ a);
                        this.indiceInicial = index - (contadorDigitos - 1);
                        //System.out.println("Valor da posição do primeiro numero encontrado: " + this.indiceInicial);
                        this.indiceFinal = this.indiceInicial + (contadorDigitos - 1);
                        //System.out.println("Valor da posição do ultimo numero encontrado: " + this.indiceFinal);

                        if(contadorDigitos >= 2){
                            this.listar(indiceInicial,indiceFinal);
                            this.contadorDigitos = 0;
                        }else{
                            contadorDigitos=0;
                        }

                    }

                }catch(ArrayIndexOutOfBoundsException e){

                    //System.out.println("Deu erro, então o proximo numero, pode ser o fim do array: "+ a);
                    this.indiceInicial = index - (contadorDigitos - 1);
                    //System.out.println("Valor da posição do primeiro numero encontrado: " + this.indiceInicial);
                    this.indiceFinal = this.indiceInicial + (contadorDigitos - 1);
                    //System.out.println("Valor da posição do ultimo numero encontrado: " + this.indiceFinal);

                    if(contadorDigitos >= 2){
                        this.listar(indiceInicial,indiceFinal);
                        this.contadorDigitos = 0;
                    }else{
                        contadorDigitos=0;
                    }

                    break;

                }
            }

            index++;
        }

    }

}
