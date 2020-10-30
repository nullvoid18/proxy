package com.nullvoid.proxy;

import android.app.*;
import android.os.*;
import okhttp3.*;
import java.io.*;
import android.widget.*;

public class MainActivity extends Activity 
{
	private OkHttpClient client;
	private Request request;
	private Response response;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// HTTP Client
		client = new OkHttpClient();
		
		// URL
		String url = "http://dvd.netflix.com";
		
		// Request
		request= new Request.Builder()
		.url(url)
		.build();
		
		// Response
		try
		{
			response = client.newCall(request).execute();
			String result = response.body().toString();
			showToast(result);
		}
		catch (IOException e)
		{
			showToast(e.toString());
		}

	}
	
	private void showToast(String message){
		Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
	}
	
}
