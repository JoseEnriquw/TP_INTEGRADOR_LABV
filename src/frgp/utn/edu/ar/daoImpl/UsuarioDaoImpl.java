package frgp.utn.edu.ar.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import frgp.utn.edu.ar.dao.IUsuarioDao;
import frgp.utn.edu.ar.entidades.EUsuario;

public class UsuarioDaoImpl extends GenericDaoImpl<EUsuario,Integer> implements IUsuarioDao {

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public EUsuario getByName(String nombreUser) {
		return (EUsuario) this.hibernateTemplate.find("from EUsuario where nombreU=?", nombreUser).get(0);
	}

}
