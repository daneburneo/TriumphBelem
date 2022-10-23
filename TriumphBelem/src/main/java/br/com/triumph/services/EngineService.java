package br.com.triumph.services;

import br.com.triumph.daos.EnginesDAO;
import br.com.triumph.models.Engine;
import br.com.triumph.models.Motorcycle;

import java.util.List;

public class EngineService {

    private EnginesDAO enginesDAO = new EnginesDAO();

    public Engine updateEngine(Integer id, Engine validateEngine) {

        if (validateEngi(validateEngine) == false) {
            throw new RuntimeException("Unable to update data. Change the value. Please, try another resource");
        }

        Engine engine = enginesDAO.updateEngine(validateEngine);
        engine.setId(validateEngine.getId());
        Engine engineUpdated = enginesDAO.updateEngine(engine);

        return engineUpdated;
    }

    public Engine createEngine(Engine newEngine) {

        if (newEngine.getId() == null) {
            throw new RuntimeException("Unable to update data. The value cannot be 'Null'. Please, try another resource");
        }
        if (newEngine.getRefrigeration() == null) {
            throw new RuntimeException("Unable to update data. The value cannot be 'Null'. Please, try another resource");
        }

        Engine engine = enginesDAO.createEngine(newEngine);

        return engine;
    }

    public List<Engine> getAllEngines() {

        List<Engine> list = enginesDAO.getAllEngines();

        return list;
    }

    public Engine getOneEngine(Integer id){

        return enginesDAO.getOneEngine(id);
    }


    public List<Engine> getOneEngineByName(String name){
        return  enginesDAO.getOneEngineByName(name);
    }


    public void deleteEngine(Integer id) {

        enginesDAO.deleteEngine(id);
    }

    private Boolean validateEngi(Engine engine) {

        boolean validate = true;

        if (engine.getRefrigeration() != null) {
            validate = false;
        }

        if (engine.getType() == null) {
            validate = false;
        }

        if (engine.getId() == null) {
            validate = false;
        }

        return validate;
    }
}
