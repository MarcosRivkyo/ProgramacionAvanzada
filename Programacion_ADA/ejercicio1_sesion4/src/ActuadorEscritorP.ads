with System;
with Ada.Real_Time;
use Ada.Real_Time;
with Ada.Real_Time.Timing_Events;
use Ada.Real_Time;
with Text_IO;

package ActuadorEscritorP is
   salidaJitterControl:Ada.Real_Time.Timing_Events.Timing_Event;

   salidaPeriodo:Ada.Real_Time.Time_Span:=Ada.Real_Time.Milliseconds(260);

   type ActuadorDato is new Integer;
   protected type ActuadorEscritor is
      pragma Interrupt_Priority(System.Interrupt_Priority'Last);
      procedure iniciar;
      procedure escribir(dato:ActuadorDato);
      procedure Timer(event: in out Ada.Real_Time.Timing_Events.Timing_Event);
   private
      nextTime:Ada.Real_Time.Time;
      escribiendo:ActuadorDato;
   end ActuadorEscritor;
end ActuadorEscritorP;

