package com.htg.adshow.controller.sys;

import com.htg.adshow.service.IMqttSender;
import com.htg.adshow.service.impl.MSGServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * MQTT消息发送
 *
 * @author BBF
 */
@Controller
@RequestMapping(value = "/")
public class MqttController {
    /**
     * 注入发送MQTT的Bean
     */
    @Resource
    private IMqttSender iMqttSender;

    /**
     * 发送MQTT消息
     *
     * @param message 消息内容
     * @return 返回
     */

    @Autowired
    private MSGServiceImpl msgService;
    @ResponseBody
    @GetMapping(value = "/mqtt", produces = "text/html")
    public ResponseEntity<String> sendMqtt(@RequestParam(value = "msg") String message) {
        iMqttSender.sendToMqtt(message);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(value = "/mqtt_with_topic")
    public ResponseEntity<String> sendMqttWithTopic(@RequestParam(value = "topic") String topic, @RequestParam(value = "msg") String message) {
        iMqttSender.sendToMqtt(topic, message);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }


}