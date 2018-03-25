package model;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Objects;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import javafx.beans.property.StringProperty;

public class Mediator {
	private InetAddress serverAddress;
	private int portNumber;
	private Socket comSocket;
	private DataInputStream in;
	private PrintStream out;
	private String serverPubKey;

	public Mediator() {

	}

	public Mediator(InetAddress address, int port) {
		Objects.requireNonNull(address);
		if (port < 0 || port > 65535) {
			throw new IllegalArgumentException("Invalid port number");
		}

		this.serverAddress = address;
		this.portNumber = port;
	}

	public boolean isReachable() throws UnknownHostException, IOException {
		return false;
	}

	public boolean requestServerDumpToJSONString() {
		return false;
	}

	public boolean requestServerAdd(CodeSnippet toAdd) {
		return false;
	}

	public boolean requestServerRemove(CodeSnippet toRemove) {
		return false;
	}

	public boolean requestServerModify(CodeSnippet origonal, CodeSnippet changed) {
		return false;
	}

	public boolean requestPKey() {
		return false;
	}

	public boolean logInToServer(String username, String password) {
		return false;
	}

	private boolean openSocket() {
		return false;
	}

	private boolean closeSocket() {
		return false;
	}

	public InetAddress getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(InetAddress serverAddress) {
		this.serverAddress = serverAddress;
	}

	public int getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}

	public String getServerPubKey() {
		return serverPubKey;
	}

	public void setServerPubKey(String serverPubKey) {
		this.serverPubKey = serverPubKey;
	}

	public String jsonStringFromSnippet(CodeSnippet snippet) {
		GsonBuilder gson = new GsonBuilder();
		gson.registerTypeAdapter(CodeSnippet.class, new JSONSnippetSerializer());
		return gson.create().toJson(snippet);
	}

	public class JSONSnippetSerializer implements JsonSerializer<CodeSnippet> {

		@Override
		public JsonElement serialize(CodeSnippet snippet, Type arg1, JsonSerializationContext arg2) {

			JsonObject obj = new JsonObject();
			JsonArray array = new JsonArray();

			obj.addProperty("name", snippet.getName());
			obj.addProperty("description", snippet.getDescription());
			obj.addProperty("code", snippet.getCode().getCodeText());
			for (StringProperty curr : snippet.getTags()) {
				array.add(curr.get());
			}
			obj.add("tags", array);
			obj.addProperty("flagged", snippet.isFlagged());
			return obj;
		}

	}
}
