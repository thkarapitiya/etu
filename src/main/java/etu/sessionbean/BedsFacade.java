/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu.sessionbean;

import etu.entity.Beds;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Stateless
public class BedsFacade extends AbstractFacade<Beds> {

    @PersistenceContext(unitName = "etuPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BedsFacade() {
        super(Beds.class);
    }
    
}
