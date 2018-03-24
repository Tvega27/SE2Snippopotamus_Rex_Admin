package controller;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Objects;

import model.CodeSnippet;
import model.JSONHandler;

public class NetworkInterface {
	private InetAddress serverAddress;
	private int portNumber;
	private Socket comSocket;
	private DataInputStream in;
	private PrintStream out;
	private String serverPubKey;

	public NetworkInterface(InetAddress address, int port) {
		Objects.requireNonNull(address);
		if (port < 0 || port > 65535) {
			throw new IllegalArgumentException("Invalid port number");
		}

		this.serverAddress = address;
		this.portNumber = port;
	}

	public boolean isReachable() throws UnknownHostException, IOException {
		if (serverAddress.isReachable(5000))
			return true;
		else
			return false;
	}

	public String requestServerDumpToJSONString() {
		try {
			this.comSocket = new Socket("localhost", portNumber);
			this.out = new PrintStream(comSocket.getOutputStream());
			this.in = new DataInputStream(new BufferedInputStream(comSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: hostname");
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to: hostname");
		}
		out.print("DUMP");
		String toReturn = null;
		try {
			toReturn = in.readUTF();
			comSocket.close();
		} catch (IOException e) {
		}
		return toReturn;

	}

	public boolean requestServerAdd(CodeSnippet toAdd) {
		try {
			this.comSocket = new Socket("localhost", portNumber);
			this.out = new PrintStream(comSocket.getOutputStream());
			this.in = new DataInputStream(new BufferedInputStream(comSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: hostname");
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to: hostname");
		}
		String verification = null;
		out.print("ADD" + " " + JSONHandler.jsonStringFromSnippet(toAdd));
		try {
			verification = in.readUTF();
			comSocket.close();
		} catch (IOException e) {
		}
		if (verification == "?") {
			return true;
		} else {
			return false;
		}

	}

	public boolean requestServerRemove(CodeSnippet toRemove) {
		try {
			this.comSocket = new Socket("localhost", portNumber);
			this.out = new PrintStream(comSocket.getOutputStream());
			this.in = new DataInputStream(new BufferedInputStream(comSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: hostname");
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to: hostname");
		}
		String verification = null;
		out.print("REMOVE" + " " + JSONHandler.jsonStringFromSnippet(toRemove));
		try {
			verification = in.readUTF();
			comSocket.close();
		} catch (IOException e) {
		}
		if (verification == "?") {
			return true;
		} else {
			return false;
		}

	}

	public boolean requestServerModify(CodeSnippet origonal, CodeSnippet changed) {

		try {
			this.comSocket = new Socket("localhost", portNumber);
			this.out = new PrintStream(comSocket.getOutputStream());
			this.in = new DataInputStream(new BufferedInputStream(comSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: hostname");
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to: hostname");
		}
		String verification = null;
		out.print("MODIFY" + " " + JSONHandler.jsonStringFromSnippet(origonal)
				+ JSONHandler.jsonStringFromSnippet(changed));
		try {
			verification = in.readUTF();
			comSocket.close();
		} catch (IOException e) {
		}
		if (verification == "?") {
			return true;
		} else {
			return false;
		}

	}

	public boolean requestPKey() {

		try {
			this.comSocket = new Socket("localhost", portNumber);
			this.out = new PrintStream(comSocket.getOutputStream());
			this.in = new DataInputStream(new BufferedInputStream(comSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: hostname");
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to: hostname");
		}
		out.print("REQUEST_PKEY");
		try {
			this.serverPubKey = in.readUTF();
			comSocket.close();
		} catch (IOException e) {
		}
		if (this.serverPubKey != null) {
			return true;
		} else {
			return false;
		}

	}

	public boolean logInToServer(String username, String password) {
			return false;
	}

}
