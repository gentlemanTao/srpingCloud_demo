package eureka.hystrix;

import com.sun.istack.internal.logging.Logger;
import eureka.clientInterface.ComputeClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
@Component
public class ComputeClientHystrix implements ComputeClient {

    private final Logger logger = Logger.getLogger(getClass());
    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        logger.info("回调");
        return -9999;
    }

}
