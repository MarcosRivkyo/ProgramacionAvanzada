package Agentes;

import Comportamientos.OneShotBehaviourDispositivo_1;
import jade.core.Agent;


public class Dispositivo_1 extends Agent{
	
	private static final long serialVersionUID = 1L;
    
    @Override
    protected void setup(){
        addBehaviour(new OneShotBehaviourDispositivo_1());
    } 
}
