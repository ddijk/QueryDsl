/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.querydsl;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dickdijk
 */
@Named(value = "riderController")
@Dependent
@Stateless
public class RiderController {

    String name;

    List<Rider> riders;

    @PersistenceContext
    EntityManager em;

    /**
     * Creates a new instance of RiderController
     */
    public RiderController() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void createRider() {
        Rider rider = new Rider();
        rider.setName(name);
        em.persist(rider);
    }

    public List<Rider> getRiders() {

        return em.createQuery("Select r from Rider r", Rider.class).getResultList();

    }

    public void setRiders(List<Rider> riders) {
        this.riders = riders;
    }

}
