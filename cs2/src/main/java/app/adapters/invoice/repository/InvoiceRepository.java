package app.adapters.invoice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.adapters.invoice.entity.InvoiceEntity;
import app.domain.models.Person;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
	List<InvoiceEntity> findByPerson(Person person);
	List<InvoiceEntity> findByOwnerId(Person person);

}
