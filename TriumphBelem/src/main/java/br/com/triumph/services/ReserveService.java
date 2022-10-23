package br.com.triumph.services;

import br.com.triumph.daos.ReservesDAO;
import br.com.triumph.models.Reserve;

import java.util.List;

public class ReserveService {

    private ReservesDAO reservesDAO = new ReservesDAO();

    public Reserve updateReserve(Integer id, Reserve validateReserve) {

        if (validateReserve(validateReserve) == false) {
            throw new RuntimeException("Unable to update data. Change the value. Please, try another resource");
        }


        Reserve reserve = reservesDAO.updateReserve(validateReserve);
        reserve.setId(validateReserve.getId());
        Reserve reserveUpdated = reservesDAO.updateReserve(reserve);

        return reserveUpdated;
    }

    public Reserve createReserve(Reserve newReserve) {

        if (newReserve.getId() == null) {
            throw new RuntimeException("Unable to update data. The value cannot be 'Null'. Please, try another resource");
        }
        if (newReserve.getDate() == null) {
            throw new RuntimeException("Unable to update data. The value cannot be 'Null'. Please, try another resource");
        }
        if (newReserve.getPrice() == null) {
            throw new RuntimeException("Unable to update data. The value cannot be 'Null'. Please, try another resource");
        }

        Reserve reserve = reservesDAO.createReserve(newReserve);

        return reserve;
    }

    public List<Reserve> getAllReserves() {

        List<Reserve> list = reservesDAO.getAllReserves();

        return list;
    }

    public Reserve getOneReserve(Integer id){

        return reservesDAO.getOneReserve(id);
    }

    public List<Reserve> getOneReserveByName(String name){
        return getOneReserveByName(name);
    }

    public void deleteReserve(Integer id) {

        reservesDAO.deleteReserve(id);
    }

    private Boolean validateReserve(Reserve reserve) {

        boolean validate = true;

        if (reserve.getId() != null) {
            validate = false;
        }

        if (reserve.getDate() == null) {
            validate = false;
        }

        if (reserve.getPrice() == null) {
            validate = false;
        }

        return validate;
    }




}
