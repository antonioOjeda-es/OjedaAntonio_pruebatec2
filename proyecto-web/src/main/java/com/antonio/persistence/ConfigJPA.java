package com.antonio.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConfigJPA {

    /*
    instanciar EntityManagerFactory para acceder a los datos de conexión y para instanciarlo en EmpleadoJPA:
    sirve para comunicarse con la base de datos u tiliza persistence.xml para conseguir los datos y características de
    la conexión
     */
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DatosConexion");

    //Se utilizará cuando necesitemos utilizar una conexión de la base de datos en la clase EmpleadoJPA
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //Sirve para cerrar la conexión despues de cualquier transacción
    public static void close(){
        emf.close();
    }

}
