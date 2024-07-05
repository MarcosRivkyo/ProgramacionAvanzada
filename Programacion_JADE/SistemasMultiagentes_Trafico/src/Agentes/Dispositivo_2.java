package Agentes;

import Comportamientos.OneShotBehaviourDispositivo_2;
import jade.core.Agent;


public class Dispositivo_2 extends Agent{

private static final long serialVersionUID = 1L;
    
    @Override
    protected void setup(){
        addBehaviour(new OneShotBehaviourDispositivo_2());
    }

 
}
