package com.mitocode.dao;

import java.util.List;

import com.mitocode.model.Persona;

public interface IPersonaDAO {
	
	public void agregar(Persona persona) throws Exception;

	public void eliminar(int id) throws Exception;

	public void actualizar(Persona persona) throws Exception;

	public List<Persona> listarTodos() throws Exception;

	Persona listarPorId(int id) throws Exception;
}
