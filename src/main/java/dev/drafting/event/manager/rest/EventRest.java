package dev.drafting.event.manager.rest;

import dev.drafting.event.manager.model.MessageModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface EventRest {
    String PREFIX = "/message";

    @PostMapping(PREFIX + "/send")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void send(@RequestBody String message);

    @GetMapping(PREFIX + "/all")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    List<MessageModel> findListAll();
}
