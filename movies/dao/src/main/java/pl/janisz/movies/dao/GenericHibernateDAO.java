package pl.janisz.movies.dao;

import java.util.List;

import java.lang.reflect.ParameterizedType;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.janisz.movies.dao.dataModel.PersistentObject;

public class GenericHibernateDAO<E extends PersistentObject> {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	private Class<E> entityClass;
	
	public Class<E> getEntityClass() {
		return entityClass;
	}
	
	@SuppressWarnings("unchecked")
	protected GenericHibernateDAO() {
		this.entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	public List<E> getAll() {	
		return sessionFactory.getCurrentSession().createCriteria(getEntityClass()).list();
	}
	
	public void saveOrUpdate(E entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

}

