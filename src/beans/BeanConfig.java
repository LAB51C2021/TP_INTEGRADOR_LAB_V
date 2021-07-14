package beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import models.Cuenta;
import models.Movimiento;
import models.Persona;
import models.Usuario;

@Configuration
public class BeanConfig 
{
	// Cliente 1
	@Bean
	public Usuario UsuarioGabriel()
	{
		List<Cuenta> CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "81770809078589", "2/519", 10000, 1, true));
		CuentaList.add(new Cuenta("Cuenta corriente", LocalDate.now(), "31994610885158", "8/963", 10000, 1, true));
		CuentaList.add(new Cuenta("Caja de ahorro en dolares", LocalDate.now(), "36836216757074", "7/238", 10000, 2, true));
		
		return new Usuario("Gabriel", "gaby-2011@hotmail.com.ar", "123", 
				new Persona("Gabriel Robledo", "41459054", "M", LocalDate.now(), "Liquidambar 1122", "Pacheco", 1, 1, true, true), true, CuentaList);
	}

	// Cliente 2
	@Bean
	public Usuario UsuarioEzequiel()
	{
		List<Cuenta> CuentaList = new ArrayList<Cuenta>();
		CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "79037976260297", "7/757", 10000, 1, true));
		CuentaList.add(new Cuenta("Caja de ahorro en dolares", LocalDate.now(), "20918457256630", "8/179", 10000, 2, true));
		
		return new Usuario("Ezequiel", "Eze@hotmail.com.ar", "123", 
						new Persona("Ezequiel Bobadilla", "34534523", "M", LocalDate.now(), "Av. Paloma 2133", "El Talar", 1, 1, true, true), true, CuentaList);
	}

	// Cliente 3
	@Bean
	public Usuario UsuarioAilen()
	{
		List<Cuenta> CuentaList = new ArrayList<Cuenta>();
		CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "77469673855230", "4/621", 10000, 1, true));
		CuentaList.add(new Cuenta("Cuenta corriente", LocalDate.now(), "85786506510339", "8/353", 0, 1, true));
		
		return new Usuario("Ailen", "Ailen@hotmail.com.ar", "123", 
				new Persona("Ailen Ramirez", "44214441", "F", LocalDate.now(), "Hipolito 2344", "Jose C. Paz", 1, 1, true, true), true, CuentaList);
	}

	// Cliente 4
	@Bean
	public Usuario UsuarioLuciano()
	{
		List<Cuenta> CuentaList = new ArrayList<Cuenta>();
		
		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "53830351931974", "7/266", 10000, 1, true));
		CuentaList.add(new Cuenta("Cuenta corriente", LocalDate.now(), "87173054846934", "47838", 0, 1, true));
		CuentaList.add(new Cuenta("Caja de ahorro en dolares", LocalDate.now(), "16003759554587", "3/421", 0, 2, true));
		
		return new Usuario("Luciano", "Luciano@hotmail.com.ar", "123", 
				new Persona("Luciano Rodriguez", "34215555", "M", LocalDate.now(), "Av. Alere 2154", "Los Troncos", 1, 1, true, true), true, CuentaList);

	}

	// Cliente 5
	@Bean
	public Usuario UsuarioMatias()
	{
		List<Cuenta> CuentaList = new ArrayList<Cuenta>();
		
		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "63152363034896", "3/398", 10000, 1, true));
		CuentaList.add(new Cuenta("Caja de ahorro en dolares", LocalDate.now(), "16242186394520", "5/530", 0, 2, true));
		
		return new Usuario("Matias", "Max@hotmail.com.ar", "123", 
				new Persona("Matias Gonzales", "42545321", "M", LocalDate.now(), "Martinez 1322", "Tigre", 1, 1, true, true), true, CuentaList);
		
	}

	// Cliente 6
	@Bean
	public Usuario UsuarioFranco()
	{
		List<Cuenta> CuentaList = new ArrayList<Cuenta>();

		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "31170900682918", "7/250", 10000, 1, true));
		
		return new Usuario("Franco", "Fran@hotmail.com.ar", "123",
				new Persona("Franco Alvarez", "35566213", "M", LocalDate.now(), "Larte 1122", "Tigre", 1, 1, true, true), true, CuentaList);
	}

	// Cliente 7
	@Bean
	public Usuario UsuarioDiego()
	{
		List<Cuenta> CuentaList = new ArrayList<Cuenta>();

		CuentaList.add(new Cuenta("Caja de ahorro en dolares", LocalDate.now(), "56499389498494", "9/512", 800, 2, true));
		
		return new Usuario("Diego", "Diego@hotmail.com.ar", "123", 
				new Persona("Diego Britez", "35235554", "M", LocalDate.now(), "Acceso 1245", "Tigre", 1, 1, true, true), true, CuentaList);
		
	}

	// Cliente 8
	@Bean
	public Usuario UsuarioAlfonso()
	{
		List<Cuenta> CuentaList = new ArrayList<Cuenta>();
		
		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "70750961764715", "3/263", 10000, 1, true));
		CuentaList.add(new Cuenta("Caja de ahorro en dolares", LocalDate.now(), "35272715925239", "1/601", 10000, 2, true));
		
		return new Usuario("Alfonso", "Alfonso@hotmail.com.ar", "123", 
				new Persona("Alfonso Galarza", "33456236", "M", LocalDate.now(), "Lenue 2142", "Benavidez", 1, 1, true, true), true, CuentaList);

	}

	// Cliente 9
	@Bean
	public Usuario UsuarioFederico()
	{
		List<Cuenta> CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "35626533408649", "9/165", 10000, 1, true));
		CuentaList.add(new Cuenta("Caja de ahorro en dolares", LocalDate.now(), "26396044516004", "2/062", 0, 2, true));
		
		return new Usuario("Federico", "Fede@hotmail.com.ar", "123", 
				new Persona("Federico Acosta", "425453121", "M", LocalDate.now(), "Linier 4211", "San Fernando", 1, 1, true, true), true, CuentaList);
		
	}

	// Cliente 10
	@Bean
	public Usuario UsuarioAna()
	{
		List<Cuenta> CuentaList = new ArrayList<Cuenta>();
		
		return new Usuario("Ana", "Ana@hotmail.com.ar", "123", 
				new Persona("Ana Martinez", "33451555", "F", LocalDate.now(), "Cerrito 1241", "Recoleta", 1, 1, false, true), true, CuentaList);
	}

	// Supervisor
	@Bean
	public Usuario UsuarioSupervisor()
	{
		List<Cuenta> CuentaList = new ArrayList<Cuenta>();
		
		return new Usuario("Supervisor", "supervisor@hotmail.com.ar", "123", 
				new Persona("Supervisor", "00000000", "M", LocalDate.now(), ".", ".", 1, 1, false, true), true, CuentaList);
	}
	
	@Bean
	public Movimiento Movimiento1() 
	{
	    return new Movimiento(LocalDate.now(), 10000, 1, 1, null);
    }

	@Bean
	public Movimiento Movimiento2() 
	{
	    return new Movimiento(LocalDate.now(), 10000, 1, 2, null);
	}
	@Bean
	public Movimiento Movimiento3() 
	{
	    return new Movimiento(LocalDate.now(), 10000, 1, 3, null);
	}
	
	@Bean
	public Movimiento Movimiento4() 
	{
	    return new Movimiento(LocalDate.now(), 10000, 1, 4, null);
    }

	@Bean
	public Movimiento Movimiento5() 
	{
	    return new Movimiento(LocalDate.now(), 10000, 1, 5, null);
    }
	
	@Bean
	public Movimiento Movimiento6() 
	{
	    return new Movimiento(LocalDate.now(), 10000, 1, 6, null);
    }

	@Bean
	public Movimiento Movimiento7() 
	{
	    return new Movimiento(LocalDate.now(), 10000, 1, 7, null);
    }
	
	@Bean
	public Movimiento Movimiento8() 
	{
	    return new Movimiento(LocalDate.now(), 10000, 1, 8, null);
    }
	
	@Bean
	public Movimiento Movimiento9() 
	{
	    return new Movimiento(LocalDate.now(), 10000, 1, 9, null);
    }
}
