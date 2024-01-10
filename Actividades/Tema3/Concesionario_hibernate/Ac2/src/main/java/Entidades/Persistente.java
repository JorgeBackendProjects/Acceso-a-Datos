package Entidades;

import javax.persistence.*;

/**
 *
 * @author Usuario
 */
public class Persistente {
    
    public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		/*
		//HACER CONSULTAS DE UN SOLO DATO
		
		String sql = "SELECT u FROM Usuarios u where id = '1'";
		  Query q = entityManager.createQuery(sql);
		  Usuarios u = (Usuarios) q.getSingleResult();
		  
		 System.out.println(u.getNombre());
		*/
		
		
		//CONSULTA DE MAS DE UN DATO
		/*
		ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
		String sql = "SELECT u FROM Usuarios u";
		Query q = entityManager.createQuery(sql);
		 
		lista = (ArrayList<Usuarios>) q.getResultList();
		 
		System.out.println(lista.get(0).toString());
		*/
		
		 /*
		Usuarios usuario = new Usuarios();
		
		usuario.setCorreo("jorgemugar12@hotmail.com");
		usuario.setNombre("Jorge");
		usuario.setPassword("111111");
		*/
		 
		//entityManager.merge(usuario); 
		//ACTUALIZAR DATOS: HAY QUE USAR EL setID(*) tambien; 
	
		//entityManager.persist(usuario); 
		//ENTRADA NUEVA.
	
		//Usuarios u = entityManager.find(Usuarios.class, PK);
		//RECUPERAR UNA INSTANCIA
		
		/*Usuarios u = entityManager.getReference(Usuarios.class, PK);
		  entityManager.remove(u); */ //BORRAR UNA INSTANCIA
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();
	
		}
}