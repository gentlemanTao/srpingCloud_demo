package eureka.controller;

import com.sun.istack.internal.logging.Logger;
import eureka.clientInterface.ComputeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputeController  {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    ComputeClient computeClient;
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        logger.info("开始访问FeignClient");
        return computeClient.add(10, 20);
    }


}
