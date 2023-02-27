package com.shiny.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaInitialConfiguration {
    // 创建一个名为 shiny 的Topic并设置分区数为8，分区副本数为2
//    @Bean
//    public NewTopic initialTopic() {
//        return new NewTopic("shiny",8, (short) 2 );
//    }
}
