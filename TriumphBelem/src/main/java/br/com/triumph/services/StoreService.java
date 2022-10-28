package br.com.triumph.services;

import br.com.triumph.daos.MotorcyclesDAO;
import br.com.triumph.models.Motorcycle;

public class StoreService {
    private MotorcyclesDAO motorcyclesDAO = new MotorcyclesDAO();

    public Motorcycle registerNewPromo(Integer id, Motorcycle infoNewPromo) {

        if (infoNewPromo.getDiscount() == null) {
            throw new RuntimeException("Unable to update data. The value cannot be 'Null'. Please, try another resource");
        }
        if (infoNewPromo.getName() != null) {
            throw new RuntimeException("Unable to update data. The value cannot be 'Null'. Please, try another resource");
        }

        if (infoNewPromo.getModel() != null) {
            throw new RuntimeException("Unable to update data. The value cannot be 'Null'. Please, try another resource");
        }
        if (infoNewPromo.getId() != null) {
            throw new RuntimeException("Unable to update data. The value cannot be 'Null'. Please, try another resource");
        }

        Motorcycle moto = motorcyclesDAO.getOneMotorcycle(id);
        moto.setDiscount(infoNewPromo.getDiscount());
        Motorcycle motorcycleUpdated = motorcyclesDAO.updateMotorcycle(moto);



        return motorcycleUpdated;
    }
}
