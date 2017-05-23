package com.greenfox.controller;

import com.greenfox.model.Receive;
import com.greenfox.model.Response;
import com.greenfox.repository.MessageRepository;
import com.greenfox.service.MessageValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

  @Autowired
  MessageValidator messageValidator;

  @Autowired
  MessageRepository messageRepository;

  @RequestMapping("/api/message/receive")
  @CrossOrigin("*")
  public Response receive(@RequestBody Receive receive) {
    messageRepository.save(receive.getMessage());
    return messageValidator.validate(receive);
  }
}
