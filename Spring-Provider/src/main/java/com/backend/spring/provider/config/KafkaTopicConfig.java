package com.backend.spring.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {


    public NewTopic createTopic() {
        Map<String, String> configs = new HashMap<>();
        configs.put(TopicConfig.CLEANUP_POLICY_COMPACT, TopicConfig.CLEANUP_POLICY_COMPACT);
        configs.put(TopicConfig.MIN_IN_SYNC_REPLICAS_CONFIG, "1");
        configs.put(TopicConfig.RETENTION_MS_CONFIG, "604800000"); // 7 days in milliseconds
        configs.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); // 1 GB in bytes
        configs.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "10485760"); // 10 MB in bytes
        configs.put(TopicConfig.RETENTION_BYTES_CONFIG, "-1"); // Unlimited retention size

        return TopicBuilder.name("quickstart-events")
                .partitions(3)
                .replicas(1)
                .configs(configs)
                .build();
    }

}
