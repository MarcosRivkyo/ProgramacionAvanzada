package Comportamientos;
import java.util.Random;

import jade.core.behaviours.OneShotBehaviour;

public class OneShotBehaviourDispositivo_2 extends OneShotBehaviour{

	private static final long serialVersionUID = 1L;

    @Override
    public void action(){
        System.out.println("VENTANA DEL COCHE2.");
        dibujarCoche();
        
        int tiempoAleatorio = new Random().nextInt(10000); 
        myAgent.addBehaviour(new WakerBehaviourDispositivo_2(myAgent, tiempoAleatorio));
    }
    
    
    private void dibujarCoche(){
        System.out.printf("   _________\n");
        System.out.printf(" /__|___\\__\\_______\n");
        System.out.printf(" |  _  [ - 2 - ] _a|\n");
        System.out.printf(" '-(o)--------(o)-'\n");
    }
}
  