package com.huskyui.canal;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class SpringbootKafkaCanalDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootKafkaCanalDemoApplication.class, args);
    }


    @Bean
    public NewTopic topic(){
        return TopicBuilder.name("canaltopic")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @KafkaListener(id = "myId",topics = "canaltopic")
    public void listen(String in){
        System.out.println(in);
    }

}
