package app.adapters.veterinarianhistory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.adapters.veterinarian.entity.VeterinarianHistoryEntity;

public interface VeterinarianHistoryRepository extends JpaRepository<VeterinarianHistoryEntity, Long> {

}
