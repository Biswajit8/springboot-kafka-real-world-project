# springboot-kafka-real-world-project
This is a multi-module maven project. Inside this, we have created two sub-projects, 
one for Kafka Producer, another for Kafka Consumer.
The Producer reads realtime stream data from wikimedia & writes that data to Kafka Topic.
The Consumer consumes the realtime data from Kafka Topic & writes that data to database.
Here we use Apache Kafka as a broker to exchange messages between Producer & Consumer in
a Spring Boot project.

Wikimedia url: https://stream.wikimedia.org/v2/stream/recentchange
