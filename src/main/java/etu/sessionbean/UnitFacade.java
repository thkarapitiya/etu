/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu.sessionbean;

import etu.entity.Unit;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aruna Csw
 */
@Stateless
public class UnitFacade extends AbstractFacade<Unit> {

    @PersistenceContext(unitName = "etuPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UnitFacade() {
        super(Unit.class);
    }
    
}
