package com.example.vertx;

import com.englishtown.vertx.hk2.HK2JerseyBinder;
import com.englishtown.vertx.hk2.HK2VertxBinder;
import com.englishtown.vertx.jersey.JerseyServer;
import com.example.jersey.myJersey;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;


public class demo {

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();


        vertx.runOnContext(aVoid -> {

            // Set up the jersey configuration
            // The minimum config required is a package to inspect for JAX-RS endpoints
            vertx.getOrCreateContext().config()
                    .put("jersey", new JsonObject()
                            .put("port", 8081)
                            .put("packages", new JsonArray()
                                    .add(myJersey.class.getPackage().getName())));

            // Use a service locator (HK2 or Guice are supported by default) to create the jersey server
            ServiceLocator locator = ServiceLocatorUtilities.bind(new HK2JerseyBinder(), new HK2VertxBinder(vertx));
            JerseyServer server = locator.getService(JerseyServer.class);

            // Start the server which simply returns "Hello World!" to each GET request.
            server.start();

        });

    }

}