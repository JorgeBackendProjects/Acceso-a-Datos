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
		 String sql = "select a from Alumno a where id = 1";
		 Query query = entityManager.createQuery(sql);
		 Alumno alumno = (Alumno) query.getSingleResult();
		  
		 System.out.println(alumno.toString());
		*/
		
		
		//CONSULTA DE MAS DE UN DATO:
		
		/*
		 List lista = new ArrayList<Alumno>();
		 String sql = "select a from Alumno a";
		 Query query = (Query) entityManager.createQuery(sql);
		 
		 lista = ((javax.persistence.Query) query).getResultList();
		 
		 for(int i = 0; i<lista.size(); i++) {
			 System.out.println(lista.get(i).toString());
		 }
		*/
		
		
		//INTRODUCIR UN OBJETO ALUMNO A UNA FILA:
		
		/*
		Alumno alumno = new Alumno();
		
		//alumno.setId(1); //INDICA EL ID PARA ACTUALIZAR LA FILA.
		alumno.setNombre("Jorge");
		alumno.setApellidos("Muñoz Garcia");
		alumno.setCorreo("jorgemugar12@hotmail.com");
		alumno.setEdad(20);
		
		entityManager.persist(alumno);
		*/
		
		
		//ACTUALIZAR UNA FILA:
		//entityManager.merge(alumno); 
		

		//RECUPERAR UNA FILA: 
		
		/*
		Alumno a = entityManager.find(Alumno.class, 1);
		System.out.println(a.toString());
		*/
		 
		
		//BORRAR UNA INSTANCIA:
		
		/*
		Alumno a = entityManager.getReference(Alumno.class, 3);
		entityManager.remove(a); 
		*/
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();
	
		}

}
