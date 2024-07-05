package body ActuadorEscritorP is
   protected body ActuadorEscritor is
      procedure iniciar is
      begin
         null;

         nextTime:=Clock+salidaPeriodo;
      end iniciar;

      procedure escribir(dato:ActuadorDato) is
      begin
         null;
         escribiendo:=dato;
         nextTime:=Clock+salidaPeriodo;
         Ada.Real_Time.Timing_Events.Set_Handler(salidaJitterControl, nextTime, Timer'Access);
         Text_IO.Put_Line("Escribir");
      end escribir;

      procedure Timer(event: in out Ada.Real_Time.Timing_Events.Timing_Event) is
      begin
         nextTime:=nextTime+salidaPeriodo;
         Ada.Real_Time.Timing_Events.Set_Handler(salidaJitterControl, nextTime, Timer'Access);
      end Timer;
   end ActuadorEscritor;
end ActuadorEscritorP;

