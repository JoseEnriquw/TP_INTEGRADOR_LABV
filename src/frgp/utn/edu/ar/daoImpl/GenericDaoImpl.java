package frgp.utn.edu.ar.daoImpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import frgp.utn.edu.ar.dao.IGenericDao;

public class GenericDaoImpl<Entity, K extends Serializable> implements IGenericDao<Entity, K> {
	
	protected HibernateTemplate hibernateTemplate;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public Class<Entity> domainClass = getDomainClass();

	protected Class getDomainClass() {
		if (domainClass == null) {
			ParameterizedType thisType = (ParameterizedType) getClass()
					.getGenericSuperclass();
			domainClass = (Class) thisType.getActualTypeArguments()[0];
		}
		return domainClass;
	}

	 @Override 
	 @Transactional(propagation=Propagation.REQUIRED)
	 public void insert(Entity t){
	   this.hibernateTemplate.save(t);
	 }
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Entity get(K pk) {
		return (Entity) this.hibernateTemplate.load(domainClass, pk);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Entity> getAll() {
		try {
			return (ArrayList<Entity>)this.hibernateTemplate.loadAll(domainClass);
		}
		catch(Exception ex) {
			return null;
		}
    
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void update(Entity t)  {
	this.hibernateTemplate.update(t);
	}
	 
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	 public void delete(Entity t) {
      this.hibernateTemplate.delete(t);
	 }


	}

