with Text_IO;
with Ada.Real_Time;
use Ada.Real_Time;
with Ada.Real_Time.Timing_Events;
use Ada.Real_Time;
with SensorLectorP;
use SensorLectorP;
with ActuadorEscritorP;
use ActuadorEscritorP;

procedure Ejercicio1 is
   task type AlgoritmoControl(entrada:access SensorLector; salida:access ActuadorEscritor);
   task type iniciar_objetos;
   task body AlgoritmoControl is
      datoEntrada:SensorDato;
      datoSalida:ActuadorDato;
   begin
      loop
         entrada.leer(datoEntrada);

         salida.escribir(datoSalida);

      end loop;
   end AlgoritmoControl;

   sl:aliased SensorLector;
   ae:aliased ActuadorEscritor;
   control:AlgoritmoControl(sl'Access, ae'Access);

   task body iniciar_objetos is
   begin
      sl.iniciar;
      ae.iniciar;
   end iniciar_objetos;

   i:iniciar_objetos;

begin
   --  Insert code here.
  null;
end Ejercicio1;
