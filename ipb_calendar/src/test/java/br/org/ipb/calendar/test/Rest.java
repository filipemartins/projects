package br.org.ipb.calendar.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

public class Rest {
	public static void main(String[] args) throws ClientProtocolException,
			IOException, JSONException {
		
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost("http://localhost:8080/ipb_calendar/rest/user/save");
		
		JSONObject json = new JSONObject();
		json.put("firstName", "Miriam");
		json.put("lastName", "Costa");
		StringEntity se = new StringEntity(json.toString());
		se.setContentType("application/json");
		
		System.out.println(json.toString());

		post.setEntity(se);		
		
		HttpResponse response = client.execute(post);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		
		String line = "";
		
		while ((line = rd.readLine()) != null) {
			System.out.println(line);
		}
	}
}