package com.ite.fabrica_jdbc.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ite.fabrica_jdbc.modelo.beans.Usuario;

public class GestionUsuariosImplMysql8 implements IntGestionUsuario{
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	public GestionUsuariosImplMysql8() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fabrica_ropa?serverTimezone=UTC", "fabrica", "fabrica");
			System.out.println("conexion establecida");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("conexion NO establecida");
		}
	}

	@Override
	public List<Usuario> findAll() {
		sql = "select * from USUARIOS";
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setDireccion(rs.getString("direccion"));
				usuario.setEmail(rs.getString("email"));
				usuario.setEnabled(rs.getInt("enabled"));
				usuario.setFechaRegistro(rs.getDate("fecha_registro"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setPassword(rs.getString("password"));
				usuario.setUsername(rs.getString("username"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	@Override
	public Usuario findById(String username) {
		sql = "select * from USUARIOS where username = ?";
		Usuario usuario = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setUsername(rs.getString("username"));
				usuario.setPassword(rs.getString("password"));
				usuario.setDireccion(rs.getString("direccion"));
				usuario.setEnabled(rs.getInt("enabled"));
				usuario.setEmail(rs.getString("email"));
				usuario.setFechaRegistro(rs.getDate("fecha_registro"));
				usuario.setNombre(rs.getString("nombre"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}

	@Override
	public Usuario findByIdAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertOne(Usuario usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int borrarUno(String username) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
