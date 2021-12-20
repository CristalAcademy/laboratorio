package br.com.cristalacademy.demoemail.model;

import br.com.cristalacademy.demoemail.utils.anotation.BaseData;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;


@Entity
@Table(name = "Email")
public class EmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
}
