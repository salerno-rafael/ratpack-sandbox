package org.gradle;
import ratpack.exec.Promise;
import ratpack.server.RatpackServer;
public class Main2 {

	/*
	 * Performing async operations
	 */
	 public static void main(String... args) throws Exception {
		   RatpackServer.start(server -> server 
		     .handlers(chain -> chain
		       .get(ctx ->  
		       Promise.async((f) ->
		       new Thread(() -> f.success("hello world")).start()
		    		   	    ).then(ctx::render))
		     )
		   );
		 }
	}
