package com.wal.monkeys.processor;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.wal.monkeys.model.User;
import com.wal.monkeys.util.JsonUtil;
import com.wal.monkeys.util.Utils;

import org.apache.kafka.connect.json.JsonSerializer;



public class KafkaaProducer {
	
	public void publishMessage(User user) {
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			
			String userObjString = objectMapper.writeValueAsString(user);
			
			Producer<String, String> producer = new KafkaProducer<String, String>(getProducerProperties("localhost"));
			
			System.out.println("About to send the message to the topic...");
			
			producer.send(new ProducerRecord<String, String>(Utils.kTopic, userObjString));
			
			System.out.println("Message to the topic: "+userObjString);
			
			producer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
    private Properties getProducerProperties(String host) {
        Properties props = new Properties();
        // set Kafka machine and port
        props.put("bootstrap.servers", host + ":9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 1638400);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 935544320);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");;
        return props;
    }

	
	public String getJson(User user) {
		
		JsonUtil jsonUtil = new JsonUtil();
		String jsonString = jsonUtil.returnJson(user);
		
		return (jsonString);
		
	}

}
