package Client;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException
	{
		int port = 8899;
		String host = "127.0.0.1";		
		
		Socket client = new Socket(host,port);
		
		Writer writer = new OutputStreamWriter(client.getOutputStream());
		writer.write("Hello Server");
		writer.flush();
		
		Reader reader = new InputStreamReader(client.getInputStream());
		char[] cha = new char[256];
		
		int len;
		
		StringBuilder sb = new StringBuilder();
		
		while((len = reader.read(cha))!=-1)
		{
			sb.append(new String(cha,0,len));
		}
		System.out.println("from server" + sb);
		
		

		writer.close();
		reader.close();
		client.close();
		
		
	}

}
