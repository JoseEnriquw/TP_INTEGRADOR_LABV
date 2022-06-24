package frgp.utn.edu.ar.dao;

import java.io.Serializable;
import java.util.ArrayList;

public interface IGenericDao<Entity, PK extends Serializable> {
    void insert(Entity t);
    void update(Entity t);
    Entity get(PK id);
    ArrayList<Entity> getAll();
    void delete(Entity t);
}
