package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hibernate.HibernateConnector;
import models.Cliente;
import models.Cuenta;
import models.Movimiento;
import models.Pais;
import models.Provincia;
import models.Tipo_Cuenta;
import models.Tipo_Movimiento;
import models.Usuario;

public class main {

	public static void main(String[] args) {

		HibernateConnector hibernateConnector = new HibernateConnector();

		hibernateConnector.AddEntity(new Tipo_Cuenta("Caja de ahorro en pesos"));
		hibernateConnector.AddEntity(new Tipo_Cuenta("Caja de ahorro en dólares"));
		
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
		hibernateConnector.AddEntity(new Pais("España"));
		hibernateConnector.AddEntity(new Pais("Costa rica"));
		hibernateConnector.AddEntity(new Pais("Peru"));
		
		// Cliente 1
		List<Cuenta> CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "214214444441", "03042146444", 10000, 1));
		CuentaList.add(new Cuenta("Cuenta corriente", LocalDate.now(), "214214444442", "06004214445", 10000, 1));
		CuentaList.add(new Cuenta("Caja de ahorro en dolares", LocalDate.now(), "21412545446", "41241545455", 5000, 2));
		
		hibernateConnector.AddEntity(
			new Cliente("Gabriel Robledo", "41459054", "M", LocalDate.now(), "Liquidambar 1122", "Pacheco", 1, 1,
				new Usuario("Gabriel", CuentaList)));
		
		// Cliente 2
		CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "215431515355", "235602630023", 10000, 1));
		CuentaList.add(new Cuenta("Caja de ahorro en dolares", LocalDate.now(), "1254125555", "346346634", 1200, 2));
		
		hibernateConnector.AddEntity(
			new Cliente("Ezequiel Bobadilla", "34534523", "M", LocalDate.now(), "Av. Paloma 2133", "El Talar", 1, 1,
				new Usuario("Ezequiel", CuentaList)));
		
		// Cliente 3
		CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "6346234111", "2355155551", 10000, 1));
		CuentaList.add(new Cuenta("Cuenta corriente", LocalDate.now(), "623623542221", "64366777374", 0, 1));
		
		hibernateConnector.AddEntity(
			new Cliente("Ailen Ramirez", "44214441", "F", LocalDate.now(), "Hipolito 2344", "Jose C. Paz", 1, 1,
				new Usuario("Ailen", CuentaList)));
		// Cliente 4
		CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "1255662463", "235235236236", 10000, 1));
		CuentaList.add(new Cuenta("Cuenta corriente", LocalDate.now(), "21541254215", "535215314533", 0, 1));
		CuentaList.add(new Cuenta("Caja de ahorro en dolares", LocalDate.now(), "2121214155", "2154124442", 0, 2));
		
		hibernateConnector.AddEntity(
			new Cliente("Luciano Rodriguez", "34215555", "M", LocalDate.now(), "Av. Alere 2154", "Los Troncos", 1, 1,
				new Usuario("Luciano", CuentaList)));

		// Cliente 5
		CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "21513523525", "6436324235235", 10000, 1));
		CuentaList.add(new Cuenta("Caja de ahorro en dolares", LocalDate.now(), "34634663434", "6436346346666", 0, 2));
		
		hibernateConnector.AddEntity(
			new Cliente("Matias Gonzales", "42545321", "M", LocalDate.now(), "Martinez 1322", "Tigre", 1, 1,
				new Usuario("MaxMatiasGonzales", CuentaList)));
		
		// Cliente 6
		CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "534644463421", "2356212314", 285200, 1));
		
		hibernateConnector.AddEntity(
			new Cliente("Franco Alvarez", "35566213", "M", LocalDate.now(), "Larte 1122", "Tigre", 1, 1,
				new Usuario("Franco", CuentaList)));

		// Cliente 7
		CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta("Caja de ahorro en dolares", LocalDate.now(), "25323421412", "2362362366", 800, 2));
		
		hibernateConnector.AddEntity(
			new Cliente("Diego Britez", "35235554", "M", LocalDate.now(), "Acceso 1245", "Tigre", 1, 1,
				new Usuario("Diego", CuentaList)));
		
		// Cliente 8
		CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "2151257547", "2362367231", 10000, 1));
		CuentaList.add(new Cuenta("Caja de ahorro en dolares", LocalDate.now(), "1256347734", "23623425623", 4000, 2));
		
		hibernateConnector.AddEntity(
			new Cliente("Alfonso Galarza", "33456236", "M", LocalDate.now(), "Lenue 2142", "Benavidez", 1, 1,
				new Usuario("Alfonso", CuentaList)));

		// Cliente 9
		CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "2152152155", "215125515", 10000, 1));
		CuentaList.add(new Cuenta("Caja de ahorro en dolares", LocalDate.now(), "2154123421556", "634634636", 0, 2));
		
		hibernateConnector.AddEntity(
			new Cliente("Federico Acosta", "425453121", "M", LocalDate.now(), "Linier 4211", "San Fernando", 1, 1,
				new Usuario("Federico", CuentaList)));
		

		// Cliente 10
		CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta("Caja de ahorro en dolares", LocalDate.now(), "214215236662", "512551555", 18700, 2));
		
		hibernateConnector.AddEntity(
			new Cliente("Ana Martinez", "33451555", "F", LocalDate.now(), "Cerrito 1241", "Recoleta", 1, 1,
				new Usuario("Ana", CuentaList)));
		
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 0, 1, 1, null));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 0, 1, 2, null));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 0, 1, 3, null));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 0, 1, 4, null));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 0, 1, 5, null));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 0, 1, 6, null));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 0, 1, 7, null));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 0, 1, 8, null));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 0, 1, 9, null));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 0, 1, 10, null));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 2500, 2, 1, 2));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 2500, 3, 2, 1));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 1200, 2, 5, 6));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 1200, 3, 6, 5));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 8000, 2, 3, 7));
		hibernateConnector.AddEntity(new Movimiento(LocalDate.now(), 8000, 3, 7, 3));
		
		hibernateConnector.SaveChange();

	}
}
