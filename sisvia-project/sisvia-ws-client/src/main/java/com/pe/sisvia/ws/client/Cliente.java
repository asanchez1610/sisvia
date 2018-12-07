package com.pe.sisvia.ws.client;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.pe.sisvia.util.Constantes;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
@SuppressWarnings({"unchecked","rawtypes"})
@Component
public class Cliente {
	
	public Map<String, Object> calcularMontoTotal() throws IOException{
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
		  .url(Constantes.urlBase+"/external/api/calcularMontoViatico.json")
		  .get()
		  .addHeader("Cache-Control", "no-cache")
		  .build();
		Response response = client.newCall(request).execute();
		Gson gson = new Gson();
		Map map = gson.fromJson(response.body().string(), Map.class);
		return map;
	}
	
	public Map<String, Object> consultarTC() throws IOException{
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
		  .url(Constantes.urlBase+"/external/api/generarTC.json")
		  .get()
		  .addHeader("Cache-Control", "no-cache")
		  .build();
		Response response = client.newCall(request).execute();
		Gson gson = new Gson();
		Map map = gson.fromJson(response.body().string(), Map.class);
		return map;
	}
	
	public Map<String, Object> consultarMovimientos() throws IOException{
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
		  .url(Constantes.urlBase+"/external/api/ConsultarMovimientos_output.json")
		  .get()
		  .addHeader("Cache-Control", "no-cache")
		  .build();
		Response response = client.newCall(request).execute();
		Gson gson = new Gson();
		Map map = gson.fromJson(response.body().string(), Map.class);
		return map;
	}
	
}
