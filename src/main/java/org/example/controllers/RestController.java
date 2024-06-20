package org.example.controllers;

import org.example.domain.JsonResponse;
import org.example.domain.Message;
import org.example.services.MessageService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.example.StaticString.*;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final MessageService messageService;

    public RestController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping(URL_API_MESSAGE)
    public JsonResponse addMessage(
            @Valid @ModelAttribute Message message,
            BindingResult bindingResult
    ) {

        JsonResponse res = new JsonResponse();
        if(!bindingResult.hasErrors()){
            messageService.save(message);
            res.setStatus("SUCCESS");
            res.setResult(MESSAGE_POST_MESSAGE_SUCCESS);
        }else{
            res.setStatus("FAIL");
            res.setResult(bindingResult.getAllErrors());
        }

        return res;

    }

    @GetMapping(URL_API_KILL_SESSION)
    public void killSession(
    ) {
        SecurityContextHolder.clearContext();
    }


}
