package com.tangoe.mapperdeploy;
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.restlet.Client;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.Server;
import org.restlet.resource.ClientResource;
import org.restlet.data.MediaType;


import org.restlet.data.Protocol;

public class App 
{
	
	private String remoteRepo = "http://blrnexus:8081/nexus/content/repositories/central";
	private String localDownloadRepo = "C:\\Tangoe\\Projects\\MapperDownload";
	private String groupId = "aspectj";
	private String artifactId = "aspectjlib";
	private String version = "1.5.3";
			
		
	public String getLocalDownloadRepo() 
	{
		return localDownloadRepo;
	}


	public String getGroupId() {
		return groupId;
	}


	public static void main(String[] args) 
	{
		
		try 
		{
			
			App app = new App();
			app.readRepoMetadata();
			app.downloadArtifactAndDependencies();
			
												
		} 
		catch (Throwable t) 
		{
			System.out.println(t);
		}
	}


	public void downloadArtifactAndDependencies() throws Exception
	{
		AetherAPIs aetherAPIs = new AetherAPIs();
		aetherAPIs.downloadArtifactAndDependencies(remoteRepo, localDownloadRepo, groupId, artifactId, version);
	}

	
	public void readRepoMetadata() throws Exception 
	{
		
			/*URL url = new URL(remoteRepo);
			HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
			httpURLConnection.setRequestMethod("GET");
			System.out.println(httpURLConnection.getResponseCode());
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			String output = bufferedReader.readLine();
			while(output != null)
			{
				System.out.println(output);
				output=bufferedReader.readLine();
			}
			httpURLConnection.disconnect();*/
		
		new ClientResource(remoteRepo).get().write(System.out);
	}
}
