package br.com.triumph.services;

import br.com.triumph.daos.MotorcyclesDAO;
import br.com.triumph.models.Motorcycle;
import java.util.List;

public class MotorcycleService {

    private MotorcyclesDAO motorcyclesDAO = new MotorcyclesDAO();

    public Motorcycle updateMotorcycle(Integer id, Motorcycle motorcycle) {

        if (validateMotorcycle(motorcycle) == false) {
            throw new RuntimeException("Unable to update data");
        }

        Motorcycle moto1 = motorcyclesDAO.getOneMotorcycle(id);
        moto1.setName(motorcycle.getName());
        Motorcycle updatedMoto = motorcyclesDAO.updateMotorcycle(moto1);

        return updatedMoto;
    }

    public Motorcycle createMotorcycle(Motorcycle newMotorcycle) {
        if (newMotorcycle.getDiscount() == null) {
            throw new RuntimeException("Unable to update data, Please, go into the Store and try to update");
        }
        if (newMotorcycle.getName() == null) {
            throw new RuntimeException("Unable to update data. The value cannot be 'Null'. PLease, enter a valid value");
        }
        if (newMotorcycle.getModel() == null) {
            throw new RuntimeException("Unable to update data. The value cannot be 'Null'. PLease, enter a valid value");
        }

        Motorcycle moto = motorcyclesDAO.createMotorcycle(newMotorcycle);

        return moto;
    }

    public List<Motorcycle> getAllMotorcycles() {

        List<Motorcycle> list = motorcyclesDAO.getAllMotorcycles();

        return list;
    }

    public void deleteMotorcycle(Integer id) {

        motorcyclesDAO.deleteMotorcycle(id);
    }

    private Boolean validateMotorcycle(Motorcycle motorcycle) {

        boolean validate = true;


        if (motorcycle.getDiscount() != null) {
            validate = false;
        }

        if (motorcycle.getName() == null) {
            validate = false;
        }

        if (motorcycle.getModel() == null) {
            validate = false;
        }

        return validate;
    }
}













