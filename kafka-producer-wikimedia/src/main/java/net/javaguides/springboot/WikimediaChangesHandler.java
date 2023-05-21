package net.javaguides.springboot;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

// in order to handle the events, we create a separate class WikimediaChangesHandler,
// it will be triggered whenever there is a new event in wikimedia
public class WikimediaChangesHandler implements EventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesHandler.class);
    private KafkaTemplate<String,String> kafkaTemplate;
    private String topic;

    public WikimediaChangesHandler(KafkaTemplate<String,String> kafkaTemplate, String topic) {
        this.kafkaTemplate=kafkaTemplate;
        this.topic=topic;
    }

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    // whenever there is a new event in wikimedia, the onMessage() method will be triggered & it will read that event
    // inside onMessage() method we have written the logic to send the message to the topic using KafkaTemplate provided send() method
    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        LOGGER.info(String.format("event data -> %s", messageEvent.getData()));

        kafkaTemplate.send(topic,messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
