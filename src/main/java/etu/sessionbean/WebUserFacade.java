/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu.sessionbean;

import etu.entity.WebUser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aruna Csw
 */
@Stateless
public class WebUserFacade extends AbstractFacade<WebUser> {

    @PersistenceContext(unitName = "etuPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WebUserFacade() {
        super(WebUser.class);
    }
    
}
