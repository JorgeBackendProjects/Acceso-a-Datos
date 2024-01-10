import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Persistente {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin(); 
		
		
		//HACER CONSULTA DE UN SOLO DATO:
		
		/*
		 String sql = "select p from Profesor p where id = 1";
		 Query query = entityManager.createQuery(sql);
		 Profesor profesor = (Profesor) query.getSingleResult();
		  
		 System.out.println(profesor.toString());
		*/
		
		
		//CONSULTA DE MAS DE UN DATO:
		
		/*
		 List lista = new ArrayList<Profesor>();
		 String sql = "select p from Profesor p";
		 Query query = (Query) entityManager.createQuery(sql);
		 
		 lista = ((javax.persistence.Query) query).getResultList();
		 
		 for(int i = 0; i<lista.size(); i++) {
			 System.out.println(lista.get(i).toString());
		 }
		*/
		
		
		//INTRODUCIR UN OBJETO PROFESOR A UNA FILA:
		
		/*
		Profesor profesor = new Profesor();
		
		//profesor.setId(1); //HAY QUE INDICAR EL ID PARA ACTUALIZAR LA FILA.
		profesor.setNombre("Jorge");
		profesor.setApellidos("Muñoz Garcia");
		profesor.setCorreo("jorgemugar12@hotmail.com");
		profesor.setEdad(20);
		
		entityManager.persist(profesor);
		*/
		
		
		//ACTUALIZAR UNA FILA:
		//entityManager.merge(profesor); 
		

		//RECUPERAR UNA FILA: 
		
		/*
		Profesor p = entityManager.find(Profesor.class, 1);
		System.out.println(p.toString());
		*/
		 
		
		//BORRAR UNA INSTANCIA:
		
		/*
		Profesor p = entityManager.getReference(Profesor.class, 3);
		entityManager.remove(p); 
		*/
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();
	
		}

}
