package com.ardevcenter.lnbexplorer.data.jdo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.Query;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import java.util.logging.Logger;

public final class PMF {
	private static final Logger log = Logger.getLogger(PMF.class.getName());
	/*
	 * private static final PersistenceManagerFactory pmfInstance =
	 * JDOHelper.getPersistenceManagerFactory("transactions-optional");
	 */
	private static final PersistenceManagerFactory pmfInstance = JDOHelper.getPersistenceManagerFactory("transactions-optional");

	private PMF() {
	}

	public static PersistenceManagerFactory get() {
		return pmfInstance;
	}

	/*
	 * public static <T> void persistEntity(List<T> entities) {
	 * PersistenceManager pm = PMF.get().getPersistenceManager();
	 * 
	 * 
	 * try{ for (T entitity : entities) { pm.makePersistent(entitity); } }catch
	 * (Exception e){ log.severe(e.getMessage()); }finally { pm.close(); } }
	 */

	public static <T> void persistEntity(List<T> entities) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistentAll(entities);
		} catch (Exception e) {
			log.severe("CUSTOM APP ERROR: " + e.getMessage());
		} finally {
			pm.close();
		}
	}

	/*
	 * Retrieve a single instance of an entity
	 */

	public static <T, V> T getEntity(Class<T> classToUse, V key) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		T entity = null;
		try {
			entity = pm.getObjectById(classToUse, key);
		} catch (Exception e) {
			log.severe("CUSTOM APP ERROR: " + e.getMessage());
		} finally {
			pm.close();
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> getEntities(Class<T> classToUse, String filter, String ordering, String params, Object[] paramValues) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(classToUse);

		if (filter != null) {
			q.setFilter(filter);
		}

		if (ordering != null) {
			q.setOrdering(ordering);
		}

		q.declareParameters(params);
		List<T> results = new ArrayList<>();
		try {
			results = (List<T>) q.executeWithArray(paramValues);

		} finally {
			q.closeAll();
		}
		return results;

	}

	public static <T> Integer deleteAllEntities(List<T> entities) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		pm.deletePersistentAll(entities);
		return entities.size();
	}

	// Query query = pm.newQuery(Person.class);
	// query.declareParameters("int age1, int age2");
	// query.setFilter("this.age >= age1 && this.age <= age2");
	// Collection result =
	// (Collection)query.execute(new Integer(20), new Integer(60));
}
