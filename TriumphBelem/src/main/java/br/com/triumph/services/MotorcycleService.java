package br.com.triumph.services;

import br.com.triumph.daos.EnginesDAO;
import br.com.triumph.daos.MotorcyclesDAO;
import br.com.triumph.daos.ReservesDAO;
import br.com.triumph.models.Engine;
import br.com.triumph.models.Motorcycle;
import dtos.MotorcycleDto;

import java.util.List;

public class MotorcycleService {

    private MotorcyclesDAO motorcyclesDAO = new MotorcyclesDAO();
    private EnginesDAO enginesDAO = new EnginesDAO();
    private ReservesDAO reservesDao = new ReservesDAO();

    public Motorcycle updateMotorcycle(Integer id, Motorcycle motorcycle) {

        if (validateMotorcycle(motorcycle) == false) {
            throw new RuntimeException("Unable to update data");
        }

        Motorcycle moto1 = motorcyclesDAO.getOneMotorcycle(id);
        moto1.setName(motorcycle.getName());
        Motorcycle updatedMoto = motorcyclesDAO.updateMotorcycle(moto1);

        return updatedMoto;
    }

    public Motorcycle createMotorcycle(MotorcycleDto motorcycleDto) {

        if (motorcycleDto.getName() == null) {
            throw new RuntimeException("Unable to update data. The value cannot be 'Null'. PLease, enter a valid value");

        }

        Motorcycle moto = new Motorcycle();

        moto.setName(motorcycleDto.getName());
        moto.setModel(motorcycleDto.getModel());
        moto.setDiscount(motorcycleDto.getDiscount());
        moto.setId(motorcycleDto.getId());
        moto.setEngine(enginesDAO.getOneEngine(2));
        moto.setListReserve(reservesDao.getAllReserves());
        moto.setPrice(motorcycleDto.getPrice());
        moto.setTotal(motorcycleDto.getTotal());
        Motorcycle motoReturn = motorcyclesDAO.createMotorcycle(moto);

        return motoReturn;
    }

    public List<Motorcycle> getAllMotorcycles() {

        List<Motorcycle> list = motorcyclesDAO.getAllMotorcycles();

        return list;
    }

    public Motorcycle getOneMotorcycle (Integer id) {
        return motorcyclesDAO.getOneMotorcycle(id);
    }

    public List<Motorcycle> getMotorcycleByName(String name) {

        return motorcyclesDAO.getOneMotorcycleByName(name);
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













