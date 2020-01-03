import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class ConsumerExample {
	public static void main(String[] args) {
		String topicName = "search";
		Properties configPro = new Properties();
		configPro.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configPro.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.StringDeserializer");

		configPro.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.StringDeserializer");
		configPro.put(ConsumerConfig.GROUP_ID_CONFIG, "udemybuyukveri");
		configPro.put(ConsumerConfig.CLIENT_ID_CONFIG, "exam1");

		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(configPro);

		consumer.subscribe(Arrays.asList(topicName));
		try {
			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(100);
				for (ConsumerRecord<String, String> record : records) {
					System.out.println(record.value());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		consumer.close();

	}
}
