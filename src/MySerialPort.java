import java.io.BufferedInputStream;
import java.util.Date;
import java.util.Enumeration;

import javax.comm.CommPortIdentifier;
import javax.comm.PortInUseException;
import javax.comm.SerialPort;


public class MySerialPort {

	public MySerialPort() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String portName = "COM3";
		int timeWait = 3;
		CommPortIdentifier portIdentifier = null;
		SerialPort  sPort = null;
		BufferedInputStream in = null;
		byte[] data = new byte[1024];
		int dataLen = 0;
		try {
			portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
			sPort = (SerialPort) portIdentifier.open("温度计", timeWait);

			in = new BufferedInputStream(sPort.getInputStream());
			String outString = "";
			while(true){
				dataLen = in.read(data);
				outString = new Date().toString() + "\t" + new String(data, 0, dataLen).trim();
				System.out.println(outString);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sPort.close();
		}

	}

}
