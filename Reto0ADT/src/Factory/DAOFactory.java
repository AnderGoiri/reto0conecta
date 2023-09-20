package Factory;


import Factory.DAOFactory;
import DAO.DAO;
import DAOImplementation.DAOdb;
import DAOImplementation.DAOfile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2dam
 */
public class DAOFactory {
    
    /**
     * Retrieves an instance of the Model interface based on the specified type.
     *
     * @param type An integer value representing the type of model to create.
     *             - 0 for FileModelImplementation.
     *             - 1 for DBModelImplementation.
     * @return An instance of the Model interface corresponding to the specified type,
     *         or null if an invalid type is provided.
     */
    public static DAO getModel(int type) {
        switch (type) {
            case 0:
                return new DAOdb();
            case 1:
                return new DAOfile();
            default:
                return null;
        }
    }
}
