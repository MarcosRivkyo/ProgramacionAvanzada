package Agentes;

import Comportamientos.OneShotBehaviourDGT;
import jade.content.lang.sl.SLCodec;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class DGT extends Agent{


	private static final long serialVersionUID = 1L;

	protected void setup(){
		
		
		  
		
			DFAgentDescription dfd = new DFAgentDescription();
			dfd.setName(getAID());
			ServiceDescription sd = new ServiceDescription();
			sd.setName("DGT");
			sd.setType("registrar");
			sd.addOntologies("ontologia");
			sd.addLanguages(new SLCodec().getName());
			dfd.addServices(sd);
		
		try
		{
			DFService.register(this, dfd);
		}
		catch(FIPAException e)
		{
			System.err.println("Agente " + getLocalName() + ": "+e.getMessage());
		}
		
        addBehaviour(new OneShotBehaviourDGT());
    }

    
}
