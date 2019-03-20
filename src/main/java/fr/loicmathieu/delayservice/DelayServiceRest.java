package fr.loicmathieu.delayservice;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
@Path("/delay")
public class DelayServiceRest {
	@Inject @ConfigProperty(name="default.delay", defaultValue="250") private int defaultDelay;
	@Inject @ConfigProperty(name="default.get.response", defaultValue="OK") private String getResponse;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String delay(@QueryParam("delay") Long delay) throws InterruptedException {
    	if(delay == null) {
    		TimeUnit.MILLISECONDS.sleep(defaultDelay);
    	}
    	else {
    		TimeUnit.MILLISECONDS.sleep(delay);
    	}
    	
        return getResponse;
    }
}