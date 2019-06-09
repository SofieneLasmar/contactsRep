package org.sid.Dao;

import org.sid.entite.Cantactt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CantactRepository extends JpaRepository<Cantactt, Long> {
	
	@Query("select c from Cantactt c where c.nom like:x")
	public Page<Cantactt> chercher(@Param("x") String mc , Pageable page);
	
	
//  @Query("select nom  from Cantactt c where c.nom like:x" )
//	public List<String> findByNom (@Param("x") string nom);

}
