package org.gradle;

import ratpack.server.RatpackServer;
import ratpack.server.ServerConfig;
import java.net.URI;

public class Main1 {
	
	 public static void main(String... args) throws Exception {
	   RatpackServer.start(server -> server
	     .serverConfig(ServerConfig.embedded().publicAddress(new URI("http://company.org")))
	     .registryOf(registry -> registry.add("World!"))
	     .handlers(chain -> chain
	       .get(ctx -> ctx.render("Hello " + ctx.get(String.class)))
	       .get(":name", ctx -> ctx.render("Hello " + ctx.getPathTokens().get("name") + "!"))     
	     )
	   );
	 }
	}