package br.com.cristalacademy.demoemail.controller;

import br.com.cristalacademy.demoemail.controller.dto.EmailDTO;
import br.com.cristalacademy.demoemail.model.EmailEntity;
import br.com.cristalacademy.demoemail.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@AllArgsConstructor
public class EmailController {

    private EmailService emailService;


    @PostMapping("/sending-email")
    public ResponseEntity<Object> sendEmail(
            @Valid @RequestBody EmailDTO emailDTO
    ) throws URISyntaxException {
        EmailEntity emailEntity = new EmailEntity();
        BeanUtils.copyProperties(emailDTO,emailEntity);
        emailService.sendEmail(emailEntity);
        return ResponseEntity.created(new URI("/")).body(emailEntity);
    }

}
