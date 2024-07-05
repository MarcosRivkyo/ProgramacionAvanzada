with Text_IO;

procedure Ejercicio4_Main is

   task type Servidor is
      entry sensor1(entrada: in Integer);
      entry sensor2(entrada: in Integer; salida: out Integer);
   end Servidor;

   task body Servidor is

   begin
      loop
      select

            accept sensor1(entrada:in Integer) do
               Text_IO.Put_Line("Se ha recibido un mensaje en el sensor 1");
               Text_IO.Put_Line("El parámetro recibido ha sido: "&Integer'Image(entrada));
            end sensor1;
      or
            accept sensor2(entrada:in Integer; salida:out Integer) do
               Text_IO.Put_Line("Se ha recibido un mensaje en el sensor 2");
               Text_IO.Put_Line("El parámetro de entrada recibido ha sido: "&Integer'Image(entrada));
               salida:=2*entrada;
               Text_IO.Put_Line("La salida correspondiente es: "&Integer'Image(salida));
         end sensor2;
     or
          terminate;
         end select;
        end loop;
        end  Servidor;

   t:Servidor;
   var:Integer;
   var2:Integer;
begin
   var:=65;
   t.sensor1(var);
   t.sensor2(var,var2);

end Ejercicio4_Main;
