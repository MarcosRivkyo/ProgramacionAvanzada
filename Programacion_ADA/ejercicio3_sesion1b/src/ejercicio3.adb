with Text_IO;

procedure Ejercicio3 is

   cadena:String(1..50);
   elementos:Integer;

   type correspondencia is
      record
         Letra:Character;
         Valor:Integer;
      end record;

   type almacen is array(1..14) of correspondencia;

   traductor:almacen;
   procedure llenar_traductor is
   begin
   traductor(1).Letra:='I';
   traductor(1).Valor:=1;

   traductor(2).Letra:='i';
   traductor(2).Valor:=1;

   traductor(3).Letra:='V';
   traductor(3).Valor:=5;

   traductor(4).Letra:='v';
   traductor(4).Valor:=5;

   traductor(5).Letra:='X';
   traductor(5).Valor:=10;

   traductor(6).Letra:='x';
   traductor(6).Valor:=10;

   traductor(7).Letra:='L';
   traductor(7).Valor:=50;

   traductor(8).Letra:='l';
   traductor(8).Valor:=50;

   traductor(9).Letra:='C';
   traductor(9).Valor:=100;

   traductor(10).Letra:='c';
   traductor(10).Valor:=100;

   traductor(11).Letra:='D';
   traductor(11).Valor:=500;

   traductor(12).Letra:='d';
   traductor(12).Valor:=500;

   traductor(13).Letra:='M';
   traductor(13).Valor:=1000;

   traductor(14).Letra:='m';
   traductor(14).Valor:=1000;

   end llenar_traductor;

   function comprobar_numero return Integer is
      flag:boolean:=False;
   begin
      for i in 1..elementos loop
         for j in 1..14 loop
            if cadena(i) = traductor(j).Letra then
               flag:=True;
            end if;
         end loop;
         if flag = False then
            Text_IO.Put_Line("Alguno de los caracteres introducidos no es un numero romano ");
            return -1;
         else
            flag:=False;
         end if;
      end loop;
      return 1;
   end comprobar_numero;

   function traducir_simple(L:Character) return Integer is
   traduccion:Integer;
   bandera:boolean:=False;
   begin
      for i in 1..14 loop
         if L = traductor(i).Letra then
          --  Text_IO.Put_Line("La letra a traducir es: "&traductor(i).Letra);
          --  Text_IO.Put_Line("que vale: "&Integer'Image(traductor(i).Valor));
            traduccion:=traductor(i).Valor;
            bandera:=True;
            exit when bandera;
         end if;
      end loop;
      return traduccion;
   end traducir_simple;

   resultado:Integer:=0;
   procedure traducir is
      numero:Integer;
   begin
         for i in 1..elementos loop
            numero:=traducir_simple(cadena(i));
            if i = 1 then
                resultado:= resultado + numero;
	--	Text_IO.Put_Line("El valor del resultado ahora es: "&Integer'Image(resultado));
            else
            if numero > traducir_simple(cadena(i-1)) then
               resultado:= resultado - traducir_simple(cadena(i-1));
            --   Text_IO.Put_Line("El valor del resultado ahora es: "&Integer'Image(resultado));
               resultado:= resultado + (numero - traducir_simple(cadena(i-1)));
            --   Text_IO.Put_Line("El valor del resultado ahora es: "&Integer'Image(resultado));
            else
               resultado:=resultado+numero;
            --   Text_IO.Put_Line("El valor del resultado ahora es: "&Integer'Image(resultado));
            end if;
	end if;
     	end loop;
   end traducir;
begin
   Text_IO.Put_Line("Introduzca el numero romano que desea traducir");
   Text_IO.Get_Line(cadena, elementos);

   llenar_traductor;
   if comprobar_numero = 1 then

   traducir;
   Text_IO.Put_Line("El numero introducido en numeros romanos vale: "&Integer'Image(resultado));
   else
      null;
   end if;

end Ejercicio3;
