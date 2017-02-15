package com.tangoe.mapperdeploy;

import java.io.File;

import org.codehaus.plexus.util.FileUtils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	App app = new App();
		String localRepo = app.getLocalDownloadRepo();
		String groupId = app.getGroupId();
		
    	try
    	{
    		
    	   	app.downloadArtifactAndDependencies();
    	   	
    	   	File file = new File(localRepo+ "\\"+ groupId);
    	   	if(file.exists())
    	   	{
    	   		assertTrue( true );
    	   		//FileUtils.deleteDirectory(file);
    	   	}
    	   	else
    	   	{
    	   		assertTrue( false );
    	   	}
    	}
    	catch(Exception e)
    	{
    		assertTrue(false);
    	}
    	finally
    	{
    		
    	}
    }
}
