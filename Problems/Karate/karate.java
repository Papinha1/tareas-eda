import java.util.*;
public class karate{
    public static class luchador{
        int vida;
        int resistencia;
        int durabilidad;
        int ataque;
        int patada;
        int numero;
        luchador(int vida, int resistencia, int durabilidad, int ataque, int patada, int numero){
            this.vida = vida;
            this.resistencia = resistencia;
            this.durabilidad = durabilidad;
            this.ataque = ataque;
            this.patada = patada;
            this.numero = numero;
        }
        int getVida(){return vida;}
        void setVida(int vida){this.vida = vida;}
        
        int getResistencia(){return resistencia;}
        void setResistencia(int resistencia){this.resistencia = resistencia;}

        int getDurabilidad(){return durabilidad;}
        void setDurabilidad(int durabilidad){this.durabilidad = durabilidad;}

        int getAtaque(){return ataque;}
        void setAtaque(int ataque){this.ataque = ataque;}

        int getPatada(){return patada;}
        void setPatada(int patada){this.patada = patada;}

        int getNumero(){return numero;}
        void setNumero(int numero){this.numero = numero;}

        boolean TieneDurabilidad(){
            if (durabilidad > 0){
                durabilidad--;
                return true;
            } return false;
        }
        boolean AtaqueEnemigo(int dano){
            vida -= TieneDurabilidad() ? dano - resistencia : dano;
            return (vida > 0)? true : false; // puede seguir peleando?
        }
    }
    public static void ans(List<luchador> combate){
        luchador campeon = combate.remove(0); 
        while (!combate.isEmpty()){
            luchador rival = combate.remove(0);            
            while (rival.getVida() > 0 && campeon.getVida() > 0){
                if (campeon.getPatada() == rival.getVida()){
                    rival.setVida(0);
                    break;
                }
                if (rival.AtaqueEnemigo(campeon.getAtaque())){
                    luchador aux = rival;
                    rival = campeon;
                    campeon = aux;
                }
            }
        }
        System.out.println((campeon.getNumero() == 1 ? "gane yo :D" : campeon.getNumero())); 
    }
   public static void main(String[] args){
       Scanner scan = new Scanner(System.in);
       int vida,resistencia,durabilidad,ataque,patada;
       int n = scan.nextInt();
       List<luchador> combate = new ArrayList<>();
              for (int i = 0 ; i < n ; i++){
           vida = scan.nextInt();
           resistencia = scan.nextInt();
           durabilidad = scan.nextInt();
           ataque = scan.nextInt();
           patada = scan.nextInt();
           combate.add(new luchador(vida, resistencia, durabilidad, ataque, patada,i+1));
       }  
       ans(combate);
        scan.close();
   } 
}