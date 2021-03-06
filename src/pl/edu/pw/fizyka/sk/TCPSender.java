package pl.edu.pw.fizyka.sk;

import java.io.*;
import java.net.*;

class TCPSender implements Runnable{

	private InetAddress tcpAddress;
	private File file;
	private InputStream in;
	private AppData appData;
	private Config config;
	
	TCPSender(InetAddress sendTo, int fileID){
		tcpAddress = sendTo;
		file = new File(appData.ownFiles.get(0));
		appData = AppData.getInstance();
		config = Config.getInstance();
	}

	public void run() {
        try {
			Socket socket = new Socket(tcpAddress, 44444);
	        byte[] bytes = new byte[16 * 1024];
			try 
			{
				in = new FileInputStream(file);
				try 
				{
					OutputStream out = socket.getOutputStream();
					int count;
			        try 
			        {
			        	System.out.println("--------File is being sent--------");
						while ((count = in.read(bytes)) > 0)
						{
						    out.write(bytes, 0, count);
						}
						System.out.println("--------File sent!--------");
					}
			        catch (IOException e)
			        {
						e.printStackTrace();
					}
			        out.close();
				} 
				catch (IOException e) 
				{
				e.printStackTrace();
				}
				in.close();
			} 
			catch (FileNotFoundException e) 
			{
			e.printStackTrace();
			}
			socket.close();
        } catch (IOException e)
        {
			e.printStackTrace();
		}
	}
	

	//TODO
	//User Interface:
	//	- LIST OF DETECTED CLIENTS WITH FOLDERS AND FILES
	//	- LIST OF OWN SHARED FOLDERS
	//	- OPTION OF SHARING/DOWNLOADING, PROMPT/ASK FOR LOCATION WHEN DOWNLOAD
	//Programming functionalities:
	//DECLARE OWN SHARED CATALOGS LIST
	//	ON LINUX
	//	? ON WINDOWS
	//RUMBA PROTOCOL QUERY IN LAN
	//	CLIENT ANSWERS WHEN SUPPORTING RUMBA
	//SENDING AND RECEIVING REQUESTS
	//	SHARED FILES AND CATALOGS LIST REQUEST
	//	FILE DOWNLOAD REQUEST
}
