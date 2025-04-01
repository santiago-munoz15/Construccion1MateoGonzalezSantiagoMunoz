package app.ports;

import java.util.List;

import app.domain.models.Order;
import app.domain.models.Pet;
import app.domain.models.VeterinarianHistory;

public interface VeterinarianHistoryPort {
	public void createVeterinarian(VeterinarianHistory veterinarianHistory) throws Exception;
	public void saveHistory(Pet pet, VeterinarianHistory history) throws Exception;
	List<VeterinarianHistory> getHistoryByPet(Pet pet);
	 void addOrderAnnulmentRecord(Order order);
}
