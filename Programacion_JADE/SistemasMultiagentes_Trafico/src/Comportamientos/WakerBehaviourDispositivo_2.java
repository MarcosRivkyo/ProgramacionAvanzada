package Comportamientos;

import Agentes.Utils;
import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;

import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;


public class WakerBehaviourDispositivo_2 extends WakerBehaviour{

    public WakerBehaviourDispositivo_2(Agent a, long tiempoAleatorio){
		super(a, tiempoAleatorio);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
   

    @Override
	public void onWake(){
    	
    	Utils.enviarMensaje(this.myAgent, "intermediar", "Coche2");
        
    ACLMessage msg = this.myAgent.blockingReceive(MessageTemplate.and(
			MessageTemplate.MatchPerformative(ACLMessage.REQUEST), MessageTemplate.MatchOntology("ontologia")));
	String mensaje = null;
	try{
		mensaje = (String) msg.getContentObject();
	    System.out.println(mensaje);
	}catch (UnreadableException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	} 
  
} 
