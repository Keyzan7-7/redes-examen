import java.net.*;
import java.io.*;
import java.util.*;

/**
 * Write a description of class chat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class chat extends Thread
{
  Socket id;
public chat(Socket i){
    id=i;
   
    }

public void run(){
try{
Scanner entrada = new Scanner(id.getInputStream());
while(entrada.hasNext()){
System.out.println(entrada.nextLine());
}
}catch(Exception e){
    System.out.println("Error en run(): " + e);
}
}

public static void main(String args[]) throws IOException{
Socket s = new Socket("nombre del servidor", 7); // el 7 sería el puerto
chat t = new chat(s);
t.start();
String x = "";
PrintWriter salida = new PrintWriter(s.getOutputStream(),true);
Scanner teclado = new Scanner(System.in);
while(x.equalsIgnoreCase("FIN") != true){
x = teclado.nextLine();
salida.printf(x);
}
s.close();
}
}
