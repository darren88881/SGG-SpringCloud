package springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @Author darren
 * @Date 2023/2/20 11:27
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudProviderConsulPayment8006 {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderConsulPayment8006.class, args);
    }
}
