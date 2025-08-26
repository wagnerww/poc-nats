package com.poc.nats.publish;

import java.util.logging.Logger;

import io.nats.client.Connection;
import io.nats.client.JetStream;
import io.nats.client.JetStreamManagement;
import io.nats.client.Nats;
import io.nats.client.api.PublishAck;
import io.nats.client.api.StorageType;
import io.nats.client.api.StreamConfiguration;
import io.nats.client.api.StreamInfo;
import io.nats.client.support.JsonUtils;


public class App 
{
    public static final Logger logger = Logger.getLogger(App.class.getName());
    public static void main( String[] args )
    {
        try (Connection nc = Nats.connect("nats://localhost:4222")) {
            JetStreamManagement jsm = nc.jetStreamManagement();

            // Build the configuration
            StreamConfiguration streamConfig = StreamConfiguration.builder()
                    .name("hello")
                    .subjects("world")
                    .storageType(StorageType.Memory)
                    .build();

            System.out.println("Creating Stream");

             // Create the stream
            StreamInfo streamInfo = jsm.addStream(streamConfig);
            JsonUtils.printFormatted(streamInfo);

            logger.info("Publishing a message to the 'world' subject");

            JetStream js = nc.jetStream();
            PublishAck ack = js.publish("world", "one".getBytes());
            JsonUtils.printFormatted(ack);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
