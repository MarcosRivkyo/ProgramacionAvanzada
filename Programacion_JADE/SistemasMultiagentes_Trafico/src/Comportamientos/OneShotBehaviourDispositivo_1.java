package Comportamientos;
import java.util.Random;

import jade.core.behaviours.OneShotBehaviour;

public class OneShotBehaviourDispositivo_1 extends OneShotBehaviour{

	private static final long serialVersionUID = 1L;

    @Override
    public void action(){
        System.out.println("VENTANA DEL COCHE1.");
        dibujarCoche();

        int tiempoAleatorio = new Random().nextInt(10000); 
         
        
        myAgent.addBehaviour(new WakerBehaviourDispositivo_1(myAgent, tiempoAleatorio));
    }
     
    private void dibujarCoche(){
        System.out.printf("      _______\n");
        System.out.printf("  ___//__|___\\____\n");
        System.out.printf(" |a  _  [ - 1 - ] _|\n");
        System.out.printf(" '-(o)--------(o)-'\n");
    }
    
}