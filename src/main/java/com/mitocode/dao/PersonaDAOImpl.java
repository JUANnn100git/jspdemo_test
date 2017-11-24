package com.mitocode.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mitocode.model.Persona;

public class PersonaDAOImpl implements IPersonaDAO{
	
	private Connection cx;
	
	public PersonaDAOImpl() {
		cx = Conexion.conectar();
	}
	
	@Override
	public void agregar(Persona persona) throws Exception {
		try {
			String sql = "INSERT INTO persona (nombres, apellidos, foto) VALUES(?, ?, ?)";
			PreparedStatement preparedStatement = cx.prepareStatement(sql);
			preparedStatement.setString(1, persona.getNombres());
			preparedStatement.setString(2, persona.getApellidos());
			preparedStatement.setBytes(3, persona.getFoto());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void eliminar(int id) throws Exception {
		try {
			String sql = "DELETE FROM persona WHERE id = ?";
			PreparedStatement preparedStatement = cx.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actualizar(Persona persona) throws Exception {
		try {
			String sql = "UPDATE persona SET nombres = ?,  apellidos= ?, foto= ? WHERE id = ?";
			PreparedStatement preparedStatement = cx.prepareStatement(sql);
			preparedStatement.setString(1, persona.getNombres());
			preparedStatement.setString(2, persona.getApellidos());
			preparedStatement.setBytes(3, persona.getFoto());
			preparedStatement.setInt(4, persona.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Persona> listarTodos() throws Exception {
		List<Persona> personas = new ArrayList<>();
		try {
			Statement statement = cx.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM persona");
			while(resultSet.next()) {
				Persona persona = new Persona();
				persona.setId(resultSet.getInt("id"));
				persona.setNombres(resultSet.getString("nombres"));
				persona.setApellidos(resultSet.getString("apellidos"));
				persona.setFoto(resultSet.getBytes("foto"));
				personas.add(persona);
			}
			resultSet.close();
			statement.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return personas;
	}

	@Override
	public Persona listarPorId(int id) throws Exception {
		Persona persona = new Persona();
		try {
			String sql = "SELECT * FROM persona WHERE id = ?";
			PreparedStatement preparedStatement = cx.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				persona.setId(resultSet.getInt("id"));
				persona.setNombres(resultSet.getString("nombres"));
				persona.setApellidos(resultSet.getString("apellidos"));
				persona.setFoto(resultSet.getBytes("foto"));
			}
			resultSet.close();
			preparedStatement.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return persona;
	}

}
