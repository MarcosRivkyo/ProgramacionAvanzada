package Comportamientos;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import Agentes.Utils;
import jade.content.lang.sl.SLCodec;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPAAgentManagement.Envelope;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
 
 

public class OneShotBehaviourDetector extends OneShotBehaviour{
	boolean flag = true;
	private static final long serialVersionUID = 1L;
	String coche1 = "Coche_1 ";
	String coche2 = "Coche_2";
	String tipoAccidente= "" ;
	
    String[] MATRICULAS = {"1830DKD", "1263JWR", "5735ETJ", "5392TBS", "2479ZAK", "1930VJE", "7543BKR", "09748VSM", "2301GCA", "1039DSA"};
    String[] MODELOS = {"Toyota Corolla", "Honda Civic", "Lexus NX 300H", "Aston Martin Vulkan", "Nissan Qashqai", "Toyota Auris", "Mazda Miata", "Toyota Supra", "Acura NSX", "Audi A7", "Nissan GTR"};
    String[] DESCRIPCIONES = {"Choque frontal", "Choque lateral", "Choque trasero"};
    private static List<Integer> indicesSeleccionados = new ArrayList<>();


    @Override
    public void action(){
    	
    	if(flag == true){
    		ACLMessage msg = this.myAgent.blockingReceive(MessageTemplate.and(
                    MessageTemplate.MatchPerformative(ACLMessage.REQUEST), MessageTemplate.MatchOntology("ontologia")));
            

    		try{
            	
            	System.out.println("El agente: "+msg.getSender().getName()+" ha causado el accidente "+(String)msg.getContentObject());
                String mensajeRecibido = (String)msg.getContentObject();
                
                
                	if (mensajeRecibido != null){
                        if (mensajeRecibido.equals("Coche1")){
                        	flag = false;
                        	ACLMessage aclMessage = new ACLMessage(ACLMessage.REQUEST);
                            aclMessage.addReceiver(msg.getSender());
                            aclMessage.setOntology("ontologia");
                            aclMessage.setLanguage(new SLCodec().getName());
                            aclMessage.setEnvelope(new Envelope());
                            aclMessage.getEnvelope().setPayloadEncoding("ISO8859_1");
                            aclMessage.setLanguage("ISO8859_1");
                            aclMessage.setContentObject("EL COCHE 1 ES CULPABLE.");

                            this.myAgent.send(aclMessage);
                            
                            
 
                            String culpable = coche1;
                            String detalles = detallesCoche();
                            LocalTime horaActual = LocalTime.now();
                            String horaFormateada = horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                            String mensajeFormateado = String.format(":::::::Accidente registrado a las: %s ::::::: PROVOCADO POR %s ===> %s%n"
                            		+ "===================================================================================================================================================================%n", horaFormateada, culpable, detalles);


                            Utils.enviarMensaje(myAgent, "registrar", mensajeFormateado);

                        	if(tipoAccidente.equals("Choque frontal")){
                        		dibujarAccidenteFrontal_1();
                        	}else if(tipoAccidente.equals("Choque lateral")){
                        		dibujarAccidenteLateral_1();
                        	}else if(tipoAccidente.equals("Choque trasero")){
                        		dibujarAccidenteTrasero_1();
                        	}
                         	

                        }else  if (mensajeRecibido.equals("Coche2")){
                        	flag = false;
                        	ACLMessage aclMessage = new ACLMessage(ACLMessage.REQUEST);
                            aclMessage.addReceiver(msg.getSender());
                            aclMessage.setOntology("ontologia");
                            aclMessage.setLanguage(new SLCodec().getName());
                            aclMessage.setEnvelope(new Envelope());
                            aclMessage.getEnvelope().setPayloadEncoding("ISO8859_1");
                            aclMessage.setLanguage("ISO8859_1");
                            aclMessage.setContentObject("EL COCHE 2 ES CULPABLE.");
                            this.myAgent.send(aclMessage);
                            
                            
                            String culpable = coche2;
                            String detalles = detallesCoche();
                            LocalTime horaActual = LocalTime.now();
                            String horaFormateada = horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                            String mensajeFormateado = String.format(":::::::Accidente registrado a las: %s ::::::: PROVOCADO POR %s ===> %s%n"
                            		+ "===================================================================================================================================================================%n", horaFormateada, culpable, detalles);


                            
                        	Utils.enviarMensaje(this.myAgent, "registrar", mensajeFormateado);
                        	

                        	if(tipoAccidente.equals("Choque frontal")){
                        		dibujarAccidenteFrontal_2();
                        	}else if(tipoAccidente.equals("Choque lateral")){
                        		dibujarAccidenteLateral_2();
                        	}else if(tipoAccidente.equals("Choque trasero")){
                        		dibujarAccidenteTrasero_2();
                        	}
                        	

                        }
                    }
                
                

            } catch (Exception e){
                e.printStackTrace();
            }
    	}
    	
    	
		try{
			ACLMessage msg2 = this.myAgent.blockingReceive(MessageTemplate.and(
	                MessageTemplate.MatchPerformative(ACLMessage.REQUEST), MessageTemplate.MatchOntology("ontologia")));
	    	  String m;
			m = (String)msg2.getContentObject();
			if (m != null){
	              if (m.equals("Coche1")){
	              	flag = false;
	              	ACLMessage aclMessage = new ACLMessage(ACLMessage.REQUEST);
	                  aclMessage.addReceiver(msg2.getSender());
	                  aclMessage.setOntology("ontologia");
	                  aclMessage.setLanguage(new SLCodec().getName());
	                  aclMessage.setEnvelope(new Envelope());
	                  aclMessage.getEnvelope().setPayloadEncoding("ISO8859_1");
	                  aclMessage.setLanguage("ISO8859_1");
	                  aclMessage.setContentObject("EL COCHE 1 NO ES CULPABLE.");
	                  this.myAgent.send(aclMessage);
	              }else  if (m.equals("Coche2")){
	              	flag = false;
	              	ACLMessage aclMessage = new ACLMessage(ACLMessage.REQUEST);
	                  aclMessage.addReceiver(msg2.getSender());
	                  aclMessage.setOntology("ontologia");
	                  aclMessage.setLanguage(new SLCodec().getName());
	                  aclMessage.setEnvelope(new Envelope());
	                  aclMessage.getEnvelope().setPayloadEncoding("ISO8859_1");
	                  aclMessage.setLanguage("ISO8859_1");
	                  aclMessage.setContentObject("EL COCHE 2 NO ES CULPABLE.");
	                  this.myAgent.send(aclMessage);
	              }
	          }
		} catch (UnreadableException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   
    }
    


	private void dibujarAccidenteTrasero_1(){
    	
            System.out.printf("     _______             _________\n");
            System.out.printf("____//__|___\\____      /__|___\\\\__\\____\n");
            System.out.printf("|  _ [ - 1 - ] _ a| >>  |  _  [ - 2 - ] _a|\n");	
            System.out.printf("'-(o)--------(o)-'      '-(o)--------(o)-'\n");
            System.out.printf("	=========================================================\n");
            System.out.printf("                                                 \n");
            System.out.printf("              COLISION TRASERA!                       \n");
            System.out.printf("          EL COCHE 1 ES EL CULPABLE           \n");
       

        }
	
    
    private void dibujarAccidenteTrasero_2(){
    	
        System.out.printf("    _________                     _______ \n");
        System.out.printf("   /__|___\\\\__\\____       ___//__|___\\____ \n");
        System.out.printf("   | _ [ - 2 - ]   _a |  >>  |  _  [ - 1 - ] _a|\n");	
        System.out.printf("   '-(o)--------(o)-'        '-(o)--------(o)-'\n");
        System.out.printf("	=============================================================\n");
        System.out.printf("                                                  \n");
        System.out.printf("               COLISION TRASERA!                     \n");
        System.out.printf("          EL COCHE 2 ES EL CULPABLE               \n");
   

    }
    
    
    private void dibujarAccidenteFrontal_1(){
    	
        System.out.printf("      _________                       ________\n");
        System.out.printf("     /__|___\\\\__\\____          ___ //__|___\\____\n");
        System.out.printf("     |  _  [ - 2 - ] _a|	 <<  |a  _  [ - 1 - ] _|\n");	
        System.out.printf("     '-(o)--------(o)-'          '-(o)--------(o)-'\n");
        System.out.printf("	=============================================================\n");
        System.out.printf("                                                   \n");
        System.out.printf("                COLISION FRONTAL!                      \n");
        System.out.printf("           EL COCHE 1 ES EL CULPABLE               \n");
   

    }
    
    
    private void dibujarAccidenteFrontal_2(){
    	
        System.out.printf("      _________                    _______ \n");
        System.out.printf("     /__|___\\\\__\\____       ___//__|___\\____\n");
        System.out.printf("     |  _  [ - 2 - ] _a|	 >>  |a  _  [ - 1 - ] _|\n");	
        System.out.printf("     '-(o)--------(o)-'       '-(o)--------(o)-'\n");
        System.out.printf("	=============================================================\n");
        System.out.printf("                                                     \n");
        System.out.printf("          	       COLISION FRONTAL!                        \n");
        System.out.printf("               EL COCHE 2 ES EL CULPABLE	           \n");
   

    }
    
	private void dibujarAccidenteLateral_1(){
    	

        System.out.printf("                  ______	 \n");
        System.out.printf("                //______\\\n");
        System.out.printf("                ||______||\n");
        System.out.printf("                ||      ||\n");
        System.out.printf("                ||  [1] ||\n");
        System.out.printf("                ||      ||\n");
        System.out.printf("                ||______||\n");
        System.out.printf("                \\\\o___o//\n");
        System.out.printf("                                 \n");
        System.out.printf("             _____________ \n");
        System.out.printf("             |           \\\\o\\\n");
        System.out.printf("             |     [2]   || |\n");
        System.out.printf("             |___________//o/\n");
        System.out.printf("                                 \n");
        System.out.printf("              COLISION LATERAL!            \n");
        System.out.printf("        EL COCHE 1 ES EL CULPABLE\n");
   


       
    }
	
	
	private void dibujarAccidenteLateral_2(){
    	
        System.out.printf("                  ______	\n");
        System.out.printf("                //______\\\n");
        System.out.printf("                ||______||\n");
        System.out.printf("                ||      ||\n");
        System.out.printf("                ||  [2] ||\n");
        System.out.printf("                ||      ||\n");
        System.out.printf("                ||______||\n");
        System.out.printf("                \\\\o___o//\n");
        System.out.printf("                                 \n");
        System.out.printf("             _____________\n");
        System.out.printf("             |           \\\\o\\\n");
        System.out.printf("             |     [1]   || |\n");
        System.out.printf("             |___________//o//\n");
        System.out.printf("                                 \n");
        System.out.printf("              COLISION LATERAL!            \n");
        System.out.printf("        EL COCHE 2 ES EL CULPABLE\n");
   

       
    }


    	
        private String detallesCoche(){
        	        		
        		String mensaje = "";
        		
    	        int indiceMatricula = obtenerIndiceNoRepetido(MATRICULAS.length);
    	        int indiceModelo = obtenerIndiceNoRepetido(MODELOS.length);
    	        int indiceDescripcion = obtenerIndiceNoRepetido(DESCRIPCIONES.length);
    	        
    	        tipoAccidente = DESCRIPCIONES[indiceDescripcion];
                mensaje = String.format("Matrícula: %s Modelo: %s Descripción: %s", MATRICULAS[indiceMatricula], MODELOS[indiceModelo], DESCRIPCIONES[indiceDescripcion]);

                return mensaje;
        	}

        

        private static int obtenerIndiceNoRepetido(int maximo){
            Random rand = new Random();
            int indice;
            do {
                indice = rand.nextInt(maximo);
            } while (indicesSeleccionados.contains(indice));
            indicesSeleccionados.add(indice);
            return indice;
        }
}