package com.tangoe.mapperdeploy;

import org.eclipse.aether.graph.DependencyNode;
import org.eclipse.aether.resolution.DependencyResolutionException;

public class AetherAPIs 

{

	void readArtifactAndDependencies(String remoteRepo, String localDownloadRepo) throws DependencyResolutionException
	{
		Aether aether = new Aether( remoteRepo, localDownloadRepo);
    	
		AetherResult result = aether.resolve( "aspectj", "aspectjlib", "1.5.3" );
    	DependencyNode dependencyNode = result.getRoot();
    	
    	StringBuilder dump = new StringBuilder();
    	    	
    	aether.displayTree(dependencyNode, dump);
    	    	
	}
	
}
