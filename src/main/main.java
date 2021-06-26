package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import hibernate.HibernateConnector;
import models.Customer;
import models.LogonUser;
import models.Representative;
import models.Cuenta;
import models.Movimiento;
import models.Pais;
import models.Provincia;
import models.Tipo_Cuenta;
import models.Tipo_Movimiento;
import models.UserType;

public class main {

	public static void main(String[] args) {

		HibernateConnector hibernateConnector = new HibernateConnector();
		
		hibernateConnector.AddEntity(new UserType("Representante"));
		hibernateConnector.AddEntity(new UserType("Cliente"));

		hibernateConnector.AddEntity(new Tipo_Cuenta("Caja de ahorro en pesos"));
		hibernateConnector.AddEntity(new Tipo_Cuenta("Caja de ahorro en dolares"));
		
		hibernateConnector.AddEntity(new Tipo_Movimiento("Alta"));
		hibernateConnector.AddEntity(new Tipo_Movimiento("Ingreso"));
		hibernateConnector.AddEntity(new Tipo_Movimiento("Egreso"));
		
		hibernateConnector.AddEntity(new Provincia("Buenos Aires"));
		hibernateConnector.AddEntity(new Provincia("Santa Fe"));
		hibernateConnector.AddEntity(new Provincia("Chubut"));
		hibernateConnector.AddEntity(new Provincia("Cordoba"));
		hibernateConnector.AddEntity(new Provincia("San Luis"));
		hibernateConnector.AddEntity(new Provincia("Mendoza"));
		hibernateConnector.AddEntity(new Provincia("Salta"));
		hibernateConnector.AddEntity(new Provincia("Jujuy"));
		hibernateConnector.AddEntity(new Provincia("Chaco"));
		
		hibernateConnector.AddEntity(new Pais("Argentina"));
		hibernateConnector.AddEntity(new Pais("Bolivia"));
		hibernateConnector.AddEntity(new Pais("Chile"));
		hibernateConnector.AddEntity(new Pais("Brasil"));
		hibernateConnector.AddEntity(new Pais("Mexico"));
		hibernateConnector.AddEntity(new Pais("Estados Unidos"));
		hibernateConnector.AddEntity(new Pais("Inglaterra"));
		hibernateConnector.AddEntity(new Pais("Espa�a"));
		hibernateConnector.AddEntity(new Pais("Costa rica"));
		hibernateConnector.AddEntity(new Pais("Peru"));
		
		// Usuarios representantes
		Representative rep = new Representative("Gabriel", "Robledo", "fake@mail.com", "41459054", "M", LocalDate.now(), "Liquidambar 1122", "Pacheco", 1, 1, 1);
		hibernateConnector.AddEntity(rep);
		hibernateConnector.AddEntity(new LogonUser(rep, "GRobledo", "Robledo01"));
		
		rep = new Representative("Ezequiel", "Bobadilla", "fake@mail.com", "34534523", "M", LocalDate.now(), "Av. Paloma 2133", "El Talar", 1, 1, 1);
		hibernateConnector.AddEntity(rep);
		hibernateConnector.AddEntity(new LogonUser(rep, "EBobadilla", "Bobadilla01"));
		
		rep = new Representative("Ailen", "Ramirez", "fake@mail.com", "44214441", "F", LocalDate.now(), "Hipolito 2344", "Jose C. Paz", 1, 1, 1);
		hibernateConnector.AddEntity(rep);
		hibernateConnector.AddEntity(new LogonUser(rep, "ARamirez", "Ramirez01"));
		
		// Cliente 1
		List<Cuenta> CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta(1, "34215555", 1));
		CuentaList.add(new Cuenta(1, "34215555", 2));
		CuentaList.add(new Cuenta(2, "34215555", 3));
		Customer cus = new Customer(1, "Luciano", "Rodriguez", "fake@mail.com", "34215555", "M", LocalDate.now(), "Av. Alere 2154", "Los Troncos", 1, 1, 2, CuentaList);
		hibernateConnector.AddEntity(cus);
		hibernateConnector.AddEntity(new LogonUser(cus, "LRodriguez", "Rodriguez01"));
		
		// Cliente 2
		CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta(1, "42545321", 1));
		CuentaList.add(new Cuenta(2, "42545321", 2));
		cus = new Customer(1, "Matias", "Gonzales", "fake@mail.com", "42545321", "M", LocalDate.now(), "Martinez 1322", "Tigre", 1, 1, 2, CuentaList);
		hibernateConnector.AddEntity(cus);
		hibernateConnector.AddEntity(new LogonUser(cus, "MGonzales", "Gonzales01"));
		
		// Cliente 3
		CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta(1, "35566213", 1));
		CuentaList.add(new Cuenta(1, "35566213", 2));
		cus = new Customer(2, "Franco", "Alvarez", "fake@mail.com", "35566213", "M", LocalDate.now(), "Larte 1122", "Tigre", 1, 1, 2, CuentaList);
		hibernateConnector.AddEntity(cus);
		hibernateConnector.AddEntity(new LogonUser(cus, "FAlvarez", "Alvarez01"));
		
		// Cliente 4
		CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta(1, "35235554", 1));
		CuentaList.add(new Cuenta(1, "35235554", 2));
		CuentaList.add(new Cuenta(2, "35235554", 3));
		cus = new Customer(2, "Diego", "Britez", "fake@mail.com", "35235554", "M", LocalDate.now(), "Acceso 1245", "Tigre", 1, 1, 2, CuentaList);
		hibernateConnector.AddEntity(cus);
		hibernateConnector.AddEntity(new LogonUser(cus, "DBritez", "Britez01"));
		
		// Cliente 5
		CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta(1, "33456236", 1));
		CuentaList.add(new Cuenta(2, "33456236", 2));
		cus = new Customer(3, "Alfonso", "Galarza", "fake@mail.com", "33456236", "M", LocalDate.now(), "Lenue 2142", "Benavidez", 1, 1, 2, CuentaList);
		hibernateConnector.AddEntity(cus);
		hibernateConnector.AddEntity(new LogonUser(cus, "AGalarza", "Galarza01"));
		
		// Cliente 6
		CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta(1, "425453121", 1));
		cus = new Customer(3, "Federico", "Acosta", "fake@mail.com", "425453121", "M", LocalDate.now(), "Linier 4211", "San Fernando", 1, 1, 2, CuentaList);
		hibernateConnector.AddEntity(cus);
		hibernateConnector.AddEntity(new LogonUser(cus, "FAcosta", "Acosta01"));
		
		// Cliente 7
		CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta(2, "33451555", 1));
		cus = new Customer(1, "Ana", "Martinez", "fake@mail.com", "33451555", "F", LocalDate.now(), "Cerrito 1241", "Recoleta", 1, 1, 2, CuentaList);
		hibernateConnector.AddEntity(cus);
		hibernateConnector.AddEntity(new LogonUser(cus, "AMartinez", "Martinez01"));
		
		hibernateConnector.AddEntity(new Movimiento(1));
		hibernateConnector.AddEntity(new Movimiento(2));
		hibernateConnector.AddEntity(new Movimiento(3));
		hibernateConnector.AddEntity(new Movimiento(4));
		hibernateConnector.AddEntity(new Movimiento(5));
		hibernateConnector.AddEntity(new Movimiento(6));
		hibernateConnector.AddEntity(new Movimiento(7));
		hibernateConnector.AddEntity(new Movimiento(8));
		hibernateConnector.AddEntity(new Movimiento(9));
		hibernateConnector.AddEntity(new Movimiento(10));
		hibernateConnector.AddEntity(new Movimiento(2500, 2, 1, 2));
		hibernateConnector.AddEntity(new Movimiento(2500, 3, 2, 1));
		hibernateConnector.AddEntity(new Movimiento(1200, 2, 5, 6));
		hibernateConnector.AddEntity(new Movimiento(1200, 3, 6, 5));
		hibernateConnector.AddEntity(new Movimiento(8000, 2, 3, 7));
		hibernateConnector.AddEntity(new Movimiento(8000, 3, 7, 3));
		
		hibernateConnector.SaveChange();

	}
}
