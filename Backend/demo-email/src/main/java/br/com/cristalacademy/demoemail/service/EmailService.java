package br.com.cristalacademy.demoemail.service;

import br.com.cristalacademy.demoemail.model.EmailEntity;
import br.com.cristalacademy.demoemail.model.enums.StatusEmail;
import br.com.cristalacademy.demoemail.model.repository.EmailRepository;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {

    private EmailRepository emailRepository;
    private JavaMailSender mailSender;

    public EmailEntity sendEmail(EmailEntity emailEntity) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailEntity.getEmailFrom());
            message.setTo(emailEntity.getEmailTo());
            message.setSubject(emailEntity.getSubject());
            message.setText(emailEntity.getText());

            mailSender.send(message);
            emailEntity.setStatusEmail(StatusEmail.SENT);

        }catch (Exception e) {
            emailEntity.setStatusEmail(StatusEmail.ERROR);
        }finally {
            emailRepository.save(emailEntity);
        }

        return emailEntity;

    }
}
