package org.sid.web;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.sid.Dao.CantactRepository;
import org.sid.entite.Cantactt;
import org.sid.service.ServiceContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class RestCantactt {

@Autowired
private CantactRepository cantactRepository ;

private ServiceContact serviceContact ;

@RequestMapping(value="/cantactts" ,method=RequestMethod.GET)
public List<Cantactt> getCantactts(){
	
	return cantactRepository.findAll();
}

public List<Cantactt> getByName(String lettre ) {
	
	List<Cantactt> cs = cantactRepository.findAll();
	Stream<Cantactt> s = cs.stream();
	List<Cantactt> tt = s.filter(x->x.getNom().startsWith(lettre)).collect(Collectors.toList());
   return tt ;
}
@RequestMapping(value="/cantactts/{id}" ,method=RequestMethod.GET)
public Optional<Cantactt> getCantactById(@PathVariable Long id){
	
	return cantactRepository.findById(id);
}
@RequestMapping(value="/chercherR",method=RequestMethod.GET)
public Page<Cantactt> chercherr (@RequestParam(name="mc",defaultValue="") String mc ,
		@RequestParam(name="page",defaultValue="0") int page , 
		@RequestParam(name="size",defaultValue="5") int size){
	
	return cantactRepository.chercher("%"+mc+"%", new PageRequest(page, size));
}
@RequestMapping(value="/contactd/{id}" , method=RequestMethod.DELETE)
public boolean deleteCantact(@PathVariable Long id){
	cantactRepository.deleteById(id);
	return true ;
}
@RequestMapping(value="/saveConatctt", method=RequestMethod.POST)
 public Cantactt saveContact(@RequestBody Cantactt c ) {
	
	return cantactRepository.save(c);
	
 }
@RequestMapping(value="/updateContact/{id}", method=RequestMethod.PUT)
public Cantactt updateContact(@RequestBody Cantactt c ,@PathVariable Long id) {
	c.setId(id);
	return cantactRepository.save(c);
	
}

@GetMapping("/findByName/{ms}")
public List<Cantactt> findContactByPrenom(@PathVariable String prefix){
	  
	return serviceContact.findByPrenomWith(prefix);
	
	
}




}
