package eureka.controller;

import com.sun.istack.internal.logging.Logger;
import eureka.clientInterface.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//RestController为默认的@Controller和@responsebody集结合
@RestController
public class ComputeController  {

    private final Logger logger = Logger.getLogger(getClass());

    /**
     * 微服务地址
     */
    private final String SERVICE_URL="http://eureka-client/add?a=10&b=20";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ComputeService computeService;

    /**
     * 普通访问示例
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        logger.info("url:http://eureka-client/add?a=10&b=20");
        return restTemplate.getForEntity(SERVICE_URL, String.class).getBody();

    }
    /**
     * 回调示例
     * @return
     */
    @RequestMapping(value = "/addSum", method = RequestMethod.GET)
    public String addSum() {
        logger.info("调用回调");
        return computeService.addService(SERVICE_URL);

    }

}
