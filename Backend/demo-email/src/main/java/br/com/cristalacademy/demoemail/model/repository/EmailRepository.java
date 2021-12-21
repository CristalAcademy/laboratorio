package br.com.cristalacademy.demoemail.model.repository;

import br.com.cristalacademy.demoemail.model.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailEntity, Long> {
}
