with Text_IO;
with Calendar;
use Calendar;

procedure Main is

   task type TareaRecepcion is
      entry Mensaje(Entrada: in Integer; Cadena: out String);
   end TareaRecepcion;

   task type TareaEnvio;

   TR: TareaRecepcion;
   TE: TareaEnvio;

   task body TareaEnvio is
      Cadena: String := "Mensaje";
      Intervalo: constant Duration := 10.0; -- Intervalo de 10 segundos
      TiempoFinal: constant Time := Clock + 120.0; -- Duración total de 2 minutos
   begin
      while Clock < TiempoFinal loop
         TR.Mensaje(1, Cadena);
               Text_IO.Put_Line("Envio mensaje: " & Calendar.Day_Duration'Image(Calendar.Seconds(Clock)));

         delay Intervalo;
      end loop;
   end TareaEnvio;

   task body TareaRecepcion is
      Timeout: constant Duration := 15.0; -- Tiempo máximo de espera de 15 segundos
      UltimoMensaje: Time := Clock;
   begin
      loop
         select
            accept Mensaje(Entrada: in Integer; Cadena: out String) do
               UltimoMensaje := Clock;
               Text_IO.Put_Line("Recibo mensaje: " & Calendar.Day_Duration'Image(Calendar.Seconds(Clock)));

            end Mensaje;
         or
            delay Timeout;
            if Clock - UltimoMensaje >= Timeout then
               exit;
            end if;
         end select;
      end loop;
      Text_IO.Put_Line("Han pasado 15 segundos sin recibir nada => TareaRecepcion finaliza.");
   end TareaRecepcion;

begin
   null;
end Main;
