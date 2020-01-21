package com.exercise.springBootSoap.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exercise.springBootSoap.entity.LocationEntity;
import com.exercise.springBootSoap.entity.LocationMemoryEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class LocationDAOImpl implements LocationDAO {

	public static List<LocationMemoryEntity> locationEntities;

	private EntityManager entityManager;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public LocationDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public String findClosestLocationNameByPoint(String point) { //
		// 'POINT(5 5)'
		Query query = entityManager
				.createQuery("FROM LocationEntity l WHERE location= ST_GeomFromText('"
						+ point + "', 0) ");

		LocationMemoryEntity locationEntity = (LocationMemoryEntity) query
				.getSingleResult();
		return locationEntity.getName();
	}

	@Override
	public List<LocationMemoryEntity> findAll() {
		try {
			Query query = entityManager
					.createQuery("from LocationMemoryEntity");
			locationEntities = query.getResultList();
		} catch (NoResultException e) {
			logger.error("No result found in findAll() method ");
		}
		return locationEntities;
	}

	@Override
	public void updateCounterOfClosestRequests(int id) {
		try {

			LocationEntity locationEntity = (LocationEntity) entityManager
					.find(LocationEntity.class, id);
			locationEntity.setClosestRequests(locationEntity
					.getClosestRequests() + 1);
		} catch (NoResultException e) {
			logger.error("No result found in updateCounterOfClosestRequests(int id) method");
		}

	}

	@Override
	public List<LocationMemoryEntity> findAllWithHigherCounter(int counter) {
		try {
			Query query = entityManager
					.createQuery("from LocationMemoryEntity where closestRequests > '"
							+ counter + "'");
			locationEntities = query.getResultList();
		} catch (NoResultException e) {
			logger.error("No result found in findAllWithHigherCounter(int counter) method");
		}

		return locationEntities;
	}

}