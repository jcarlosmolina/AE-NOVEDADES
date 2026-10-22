package com.keralty.aenovedades.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.inject.Inject;

import com.keralty.aenovedades.global.UserFunctions;
import com.keralty.aenovedades.sqlutils.SQLSelect;
import com.keralty.aenovedades.sqlutils.TypedQueryBuilder;
import com.keralty.aenovedades.utils.Agent;

public class AbstractRepository {

    protected Agent agent;

    protected UserFunctions userFunctionsSrv;

    @PersistenceContext
    protected EntityManager em;

    @Inject
    public AbstractRepository(Agent agent, UserFunctions userFunctionsSrv) {
        this.agent = agent;
        this.userFunctionsSrv = userFunctionsSrv;
    }

    public void setEntityManager(EntityManager em) {
    	this.em = em;
    }

    public int solveCountQuery(SQLSelect select) {
        return new TypedQueryBuilder<>(em, Long.class).build4Count(select).getSingleResult().intValue();
    }
    
    public void refreshEntity(Object entity) {
        try { 
            em.refresh(entity);
        } catch (Exception e) {
            // TODO: Decide if you want to log unexpected behavior
        }
    }
}
