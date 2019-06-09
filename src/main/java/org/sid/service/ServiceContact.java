package org.sid.service;

import java.util.List;

import org.sid.entite.Cantactt;

public interface ServiceContact {
	
	
	public List<Cantactt> findByPrenomWith(String l);
}