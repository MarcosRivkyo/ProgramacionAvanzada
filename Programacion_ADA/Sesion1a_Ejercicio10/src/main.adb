with Ada.Text_IO;

procedure Main is
   type abecedario is (A,B,C,D,E,F,G,H,I,J,K,L,M,N,Ñ,O,P,Q,R,S,T,U,V,W,X,Y,Z);
   abc:abecedario;
begin
   abc:=abecedario'First;
   loop
      Ada.Text_IO.Put_Line(abecedario'Image(abc));
      exit when abc=abecedario'Last;
      abc:=abecedario'Succ(abc);
   end loop;
end Main;


