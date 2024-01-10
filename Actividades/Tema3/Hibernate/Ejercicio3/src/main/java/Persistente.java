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
		 String sql = "select a from Asignatura a where id = 1";
		 Query query = entityManager.createQuery(sql);
		 Asignatura asignatura = (Asignatura) query.getSingleResult();
		  
		 System.out.println(asignatura.toString());
		*/
		
		
		//CONSULTA DE MAS DE UN DATO:
		
		/*
		 List lista = new ArrayList<Asignatura>();
		 String sql = "select a from Asignatura a";
		 Query query = (Query) entityManager.createQuery(sql);
		 
		 lista = ((javax.persistence.Query) query).getResultList();
		 
		 for(int i = 0; i<lista.size(); i++) {
			 System.out.println(lista.get(i).toString());
		 }
		*/
		
		
		//INTRODUCIR UN OBJETO ASIGNATURA A UNA FILA:
		
		/*
		Asignatura asignatura = new Asignatura();
		
		//asignatura.setId(3); //HAY QUE INDICAR EL ID PARA ACTUALIZAR LA FILA.
		asignatura.setNombre("Educación");
		asignatura.setCurso("4ºESO");
		asignatura.setNumeroTemas(10);
		asignatura.setCreditos(200);
		
		entityManager.persist(asignatura);
		*/
		
		
		//ACTUALIZAR UNA FILA:
		//entityManager.merge(asignatura); 
		

		//RECUPERAR UNA FILA: 
		
		/*
		Asignatura a = entityManager.find(Asignatura.class, 1);
		System.out.println(a.toString());
		*/
		 
		
		//BORRAR UNA INSTANCIA:
		
		/*
		Asignatura a = entityManager.getReference(Asignatura.class, 3);
		entityManager.remove(a); 
		*/
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();
	
		}

}
