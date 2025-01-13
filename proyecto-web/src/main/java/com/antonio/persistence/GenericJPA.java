package com.antonio.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;

public class GenericJPA<T> {

    private Class<T> entidadGenerica;

    public GenericJPA(){};

    public GenericJPA(Class<T> entidadGenerica) {
        this.entidadGenerica = entidadGenerica;
    }

    //métodos propios
    public void createGenerico(T nuevaEntidad){
        EntityManager em = ConfigJPA.getEntityManager();

        try {
            // guardar algo en la DB, usamos begin y commit cuando se va a producir algún cambio en la base de datos
            em.getTransaction().begin(); // Iniciar una transaccion
            em.persist(nuevaEntidad);//método de la interfaz EntityManager para guardar en base de datos
            em.getTransaction().commit();//guarda persistencia si todo ha salido bien

        } finally {
            //si todo ha salido bien, se cierra la conexión.
            em.close();
        }
    }

    public Optional<T> findOneGenerico(Integer id){
        EntityManager em = ConfigJPA.getEntityManager();
        try{
            return Optional.ofNullable(em.find(this.entidadGenerica, id));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }

        return Optional.ofNullable(null);
    }

    public List<T> findAllGenerico(){
        EntityManager em = ConfigJPA.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        //mapea la clase
        CriteriaQuery<T> cq = cb.createQuery(this.entidadGenerica);
        //mapea la tabla (esta en entity de la clase)
        Root<T> root = cq.from(this.entidadGenerica);
        CriteriaQuery<T> all = cq.select(root);
        TypedQuery<T> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    public void updateGenerico(T actualizarElemento){
        EntityManager em = ConfigJPA.getEntityManager();

        try{
            em.getTransaction().begin();
            em.merge(actualizarElemento);
            em.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }

    }

    public void deleteGenerico(Integer id){
        EntityManager em = ConfigJPA.getEntityManager();

        try{
            em.getTransaction().begin();
            Optional<T> elementoEncontrado = Optional.ofNullable(em.find(this.entidadGenerica, id));

            if (elementoEncontrado.isPresent()){
                em.remove(elementoEncontrado.get());
                em.getTransaction().commit();
            }else{
                System.out.println("El id " + id + " de la tabla" + this.entidadGenerica.getSimpleName());
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
    }

}
