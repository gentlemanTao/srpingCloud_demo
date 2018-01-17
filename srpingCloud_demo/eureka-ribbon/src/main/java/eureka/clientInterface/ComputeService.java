package eureka.clientInterface;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ComputeService {

    @Autowired
    RestTemplate restTemplate;

    //HystrixCommand注解为断路器，fallbackMethod为连接不上服务的的回调函数
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService(String url) {
        //restTemplate.getForEntity采用get请求
        return restTemplate.getForEntity(url, String.class).getBody();
    }

    /**
     * 回调函数
     * @return
     */
    public String addServiceFallback() {
        return "error";
    }

}
