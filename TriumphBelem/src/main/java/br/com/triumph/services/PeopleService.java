package br.com.triumph.services;

import br.com.triumph.daos.PeopleDAO;
import br.com.triumph.models.People;

import java.util.List;


public class PeopleService {

    private PeopleDAO peopleDAO = new PeopleDAO();

    public People updatePeople(Integer id, People validatePeople) {

        if (validatePeople(validatePeople) == false) {
            throw new RuntimeException("Unable to update data");
        }

        People people = peopleDAO.getOnePeople(id);
        people.setName(validatePeople.getName());
        People peopleUpdated = peopleDAO.updatePeople(people);

        return peopleUpdated;
    }

    public People createPeople(People newPeople) {

        if (newPeople.getName() == null) {
            throw new RuntimeException("Unable to update data. The value cannot be 'Null'. Please, try another resource");
        }
        if (newPeople.getLastname() == null) {
            throw new RuntimeException("Unable to update data. The value cannot be 'Null'. Please, try another resource");
        }
        if (newPeople.getId() == null) {
            throw new RuntimeException("Unable to update data. The value cannot be 'Null'. Please, try another resource");
        }

        People people = peopleDAO.createPeople(newPeople);

        return people;
    }

    public List<People> getAllPeople() {

        List<People> list = peopleDAO.getAllPeople();

        return list;
    }

    public People getOnePeople(Integer id){

        return peopleDAO.getOnePeople(id);
    }

    public List<People> getOnePeopleByName(String name){
        return peopleDAO.getOnePeopleByName(name);
    }

    public void deletePeople(Integer id) {

        peopleDAO.deletePeople(id);
    }

    private Boolean validatePeople(People people) {

        boolean validate = true;

        if (people.getName() != null) {
            validate = false;
        }
        if (people.getLastname() == null) {
            validate = false;
        }
        if (people.getId() == null) {
            validate = false;
        }
        return validate;
    }
}




