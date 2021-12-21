package br.com.cristalacademy.demoemail.model;

import br.com.cristalacademy.demoemail.model.enums.StatusEmail;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "Email")
@Data
public class EmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail = LocalDateTime.now();
    private StatusEmail statusEmail = StatusEmail.INIT;
}
