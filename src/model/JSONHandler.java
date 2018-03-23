package model;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public  class JSONHandler {
	public JSONHandler() {

	}

	public static CodeSnippet codeSnippetFromJSON(String json) {
		Gson gson = new Gson();

		return gson.fromJson(json, CodeSnippet.class);
	}

	public static String jsonStringFromSnippet(CodeSnippet snippet) {
		Gson gson = new Gson();

		return gson.toJson(snippet);
	}

	public static String jsonStringFromSnippetList(List<CodeSnippet> snippets) {
		Gson gson = new Gson();
		
		return gson.toJson(snippets);

	}
	
	public static List<CodeSnippet> codeListFromJSONString(String json) {
		Gson gson = new Gson();

		Type codeListType = new TypeToken<ArrayList<CodeSnippet>>(){}.getType();

		return gson.fromJson(json, codeListType);  
	}
}
