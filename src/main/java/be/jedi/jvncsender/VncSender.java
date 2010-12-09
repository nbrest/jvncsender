package be.jedi.jvncsender;

import com.tightvnc.vncviewer.VncSenderConnection;

public class VncSender {

	//Defaults to 1 second
	int vncWaitTime=1;

	String vncHost;
	int vncPort;
	String vncPassword;

	public VncSender(String vncHost, int vncPort, String vncPassword) {
		super();
		this.vncHost = vncHost;
		this.vncPort = vncPort;
		this.vncPassword = vncPassword;
	}

	public void sendText(String vncText) {
		String[] vncTextArray=new String[1];
		vncTextArray[0]=vncText;
		this.sendText(vncTextArray);	
	}
	
	public void sendText(String vncText[]) {

		// Ignore Cert file
		// https://www.chemaxon.com/forum/ftopic65.html&highlight=jmsketch+signer

		VncSenderConnection jvnc=new VncSenderConnection(vncHost,vncPort,vncPassword);
		try {
			jvnc.open();		
			
			for (int i=0; i< vncText.length; i++) {
				
				jvnc.print(vncText[i]);
				
				sleep(vncWaitTime);
			}

			jvnc.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.toString());
		}

	}; 

	void sleep(int seconds) {
		//We need to wait
		try{
			Thread.currentThread().sleep(seconds*1000);//sleep for 1000 ms
		}
		catch(InterruptedException ie){
		}
	}


	public int getVncWaitTime() {
		return vncWaitTime;
	}

	public void setVncWaitTime(int vncWaitTime) {
		this.vncWaitTime = vncWaitTime;
	}

	public String getVncHost() {
		return vncHost;
	}


	public void setVncHost(String vncHost) {
		this.vncHost = vncHost;
	}

	public int getVncPort() {
		return vncPort;
	}

	public void setVncPort(int vncPort) {
		this.vncPort = vncPort;
	}

	public String getVncPassword() {
		return vncPassword;
	}

	public void setVncPassword(String vncPassword) {
		this.vncPassword = vncPassword;
	}

}
