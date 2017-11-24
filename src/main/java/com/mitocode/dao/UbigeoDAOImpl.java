package com.mitocode.dao;

import java.util.ArrayList;
import java.util.List;

import com.mitocode.model.Ubigeo;

public class UbigeoDAOImpl implements IUbigeoDAO{

	@Override
	public List<Ubigeo> listarPaises() throws Exception {
		List<Ubigeo> lista = new ArrayList<>(); //Set hashSet
		lista.add(new Ubigeo(1, "Perú"));
		lista.add(new Ubigeo(2, "Colombia"));
		lista.add(new Ubigeo(3, "Ecuador"));
		lista.add(new Ubigeo(4, "México"));
		return lista;
	}

	@Override
	public List<Ubigeo> listarRegiones(int codPais) throws Exception {
		List<Ubigeo> lista = new ArrayList<>(); //Set hashSet
		
		switch(codPais) {
		case 1:
			lista.add(new Ubigeo(11, "Lima"));
			lista.add(new Ubigeo(12, "La Libertad"));
			lista.add(new Ubigeo(13, "Lambayeque"));
			break;
		case 2:
			lista.add(new Ubigeo(21, "Bogotá"));
			lista.add(new Ubigeo(22, "Cali"));
			lista.add(new Ubigeo(23, "Medellín"));
			break;
		default:
			break;
		
		}
		return lista;
	}

	@Override
	public List<Ubigeo> listarProvincias(int codPais, int codRegion) throws Exception {
		List<Ubigeo> lista = new ArrayList<>(); //Set hashSet
		
		switch(codPais) {
		case 1:
			switch(codRegion) {
			case 11:
				lista.add(new Ubigeo(111, "Lima Metropolitana"));
				lista.add(new Ubigeo(121, "Huaral"));
				lista.add(new Ubigeo(131, "Canta"));
				break;
			case 12:
				break;
			default:
				break;
			}
			break;
		case 2:
			break;
		default:
			break;	
		}
		return lista;
	}

}
