package org.sid.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.sid.Dao.CantactRepository;
import org.sid.entite.Cantactt;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service 
public class ServiceImpl implements ServiceContact {
     
    @Autowired
	CantactRepository contactRepository ;
	
	@Override
	public List<Cantactt> findByPrenomWith(String l) {
		
		List<Cantactt> contacts = contactRepository.findAll();
		List<Cantactt> cc = new ArrayList<Cantactt>();
		
		  Stream<Cantactt> s = contacts.stream();
		      s.forEach(c->{
		    	 if( c.getPrenom().startsWith("ha"))
		    	   cc.add(c);
		    	 cc.forEach(m->{
		    		 System.out.println("le prenom "+c.getPrenom());
		    		
		    	 });
		    	
		      });
		 
		      return cc ;
		
	}
	
	
	

}
