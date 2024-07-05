package Comportamientos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


import jade.core.behaviours.OneShotBehaviour;

import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;




public class OneShotBehaviourDGT extends OneShotBehaviour{

	private static final long serialVersionUID = 1L;

    @Override
    public void action(){

        System.out.println("Lógica principal del agente DGT.");



        ACLMessage mensaje = this.myAgent.blockingReceive(MessageTemplate.and(
    			MessageTemplate.MatchPerformative(ACLMessage.REQUEST), MessageTemplate.MatchOntology("ontologia")));
 
		try{
			if(mensaje!= null){
				
					String mensajeFormateado =((String) mensaje.getContentObject()) ;
					registrarAccidente(mensajeFormateado);
					
			}
			else{
		        System.out.print(".");

			}
			
		}catch (UnreadableException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	  
    }
    
    private static void registrarAccidente(String datos){
    	
    	String nombreArchivo = "historialAccidentes";
    	
    	System.out.printf("Se ha registrado el accidente.");
    	
        try{
            BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo, true));
            escritor.write(datos);
            escritor.close();
        }catch (IOException e){
            System.err.println("Error al guardar datos en el archivo: " + e.getMessage());
        }
    }
}