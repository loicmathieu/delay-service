package fr.loicmathieu.delayservice;

import java.util.concurrent.TimeUnit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/delay")
public class DelayServiceRest {
	private static final int DEFAULT_DELAY = 250;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String delay(@QueryParam("delay") Long delay) throws InterruptedException {
    	if(delay == null) {
    		TimeUnit.MILLISECONDS.sleep(DEFAULT_DELAY);
    	}
    	else {
    		TimeUnit.MILLISECONDS.sleep(delay);
    	}
    	
        return "OK";
    }
}