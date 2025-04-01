package app.adapters.veterinarianhistory;

import java.util.List;

import app.domain.models.Order;
import app.domain.models.Pet;
import app.domain.models.VeterinarianHistory;
import app.ports.VeterinarianHistoryPort;

public class VeterinarianHistoryAdapter implements VeterinarianHistoryPort {

	@Override
	public void createVeterinarian(VeterinarianHistory veterinarianHistory) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveHistory(Pet pet, VeterinarianHistory history) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<VeterinarianHistory> getHistoryByPet(Pet pet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addOrderAnnulmentRecord(Order order) {
		// TODO Auto-generated method stub
		
	}

}
