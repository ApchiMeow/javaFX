package com.apchimeow.javafx;
import java.net.*;
import java.io.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
public class Client {
	public static void trimiteDate(DataOutputStream out,String sir) throws IOException
	{
		out.writeUTF(sir);
		out.flush();
	}
	public static String primesteDate(DataInputStream in) throws IOException
	{
		String sir=in.readUTF();
		return sir;
	}
	public static void main(String args[]) throws UnknownHostException, ScriptException
	{
            
		DataInputStream in=null;
		DataOutputStream out=null;
		Socket s =null;
		try
		{
			s=new Socket("10.58.184.2",2003);
			in=new DataInputStream(new BufferedInputStream(s.getInputStream()));
			out=new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
			
		}
		catch(Exception e){System.exit(1);}
		String expr="5-10";
		
		String rezultat="";
		try
		{
			trimiteDate(out,expr);
			
			rezultat=primesteDate(in);
		}
		catch(Exception e){}
		System.out.print(rezultat);
            
		
	}

}