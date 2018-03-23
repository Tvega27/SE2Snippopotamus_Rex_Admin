package controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Objects;

public class NetworkInterface {
	private InetAddress serverAddress;
	private int portNumber;
	private Socket comSocket;

	public NetworkInterface(InetAddress address, int port) {
		Objects.requireNonNull(address);
		if (port < 0 || port > 65535) {
			throw new IllegalArgumentException("Invalid port number");
		}

		this.serverAddress = address;
		this.portNumber = port;
		try {
			this.comSocket = new Socket(address, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isReachable() throws UnknownHostException, IOException {
		if (serverAddress.isReachable(5000))
			return true;
		else
			return false;
	}

}
