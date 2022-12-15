import java.net.*;
import java.io.*;
import java.util.*;
/**
 * Write a description of class act1_pract2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */ 
public class act1_pract2 extends Thread
{
    Socket id;
public act1_pract2(Socket i){
    id=i;
}

public void run(){
    try{
    PrintWriter salida = new PrintWriter(id.getOutputStream(),true);
    Scanner recibe = new Scanner(id.getInputStream());
    boolean variable = true;
    while(variable == true){
    String s = recibe.nextLine();
    if(s.equalsIgnoreCase("FIN")){
    variable = false;
    }else{
    salida.printf(s + "\r\n");
    }
    }
    }catch(Exception e){
    System.out.println("Error en run(): " + e);
    }
}

    public static void main(String args[]) throws IOException {
    ServerSocket ss= new ServerSocket(8888);
    while(true){
    Socket s = ss.accept();
    act1_pract2 t = new act1_pract2(s);
    t.start();
    }
} 
} 
