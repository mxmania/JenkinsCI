package com.tangoe.mapperdeploy;

import org.eclipse.aether.graph.DependencyNode;
import org.eclipse.aether.resolution.DependencyResolutionException;

public class AetherAPIs 

{

	void downloadArtifactAndDependencies(String remoteRepo, String localDownloadRepo, String groupId, String artifactId, String version) throws DependencyResolutionException
	{
		Aether aether = new Aether( remoteRepo, localDownloadRepo);
    	
		AetherResult result = aether.resolve( groupId, artifactId, version );
    	DependencyNode dependencyNode = result.getRoot();
    	
    	StringBuilder dump = new StringBuilder();
    	    	
    	aether.displayTree(dependencyNode, dump);
    	    	
	}
	
}
