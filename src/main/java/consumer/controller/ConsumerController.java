package consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * Created by whyse
 * on 2018/1/11 18:06
 */
@Controller
public class ConsumerController {
    static Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    RestTemplate restTemplate;
    //=======================================================
    @RequestMapping("/ribbon-consumer")
    @ResponseBody
    public String consumer() {
        String tar = restTemplate.getForEntity("http://hello-service/hello",String.class).getBody();
        return tar;
    }
}
