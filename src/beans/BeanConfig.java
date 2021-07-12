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
		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "214214444441", "03042146444", 10000, 1, true));
		CuentaList.add(new Cuenta("Cuenta corriente", LocalDate.now(), "214214444442", "06004214445", 10000, 1, true));
		CuentaList.add(new Cuenta("Caja de ahorro en dolares", LocalDate.now(), "21412545446", "41241545455", 5000, 2, true));
		
		return new Usuario("Gabriel", "gaby-2011@hotmail.com.ar", "123", 
				new Persona("Gabriel Robledo", "41459054", "M", LocalDate.now(), "Liquidambar 1122", "Pacheco", 1, 1, false, true), true, CuentaList);
	}

	// Cliente 2
	@Bean
	public Usuario UsuarioEzequiel()
	{
		List<Cuenta> CuentaList = new ArrayList<Cuenta>();
		CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "215431515355", "235602630023", 10000, 1, true));
		CuentaList.add(new Cuenta("Caja de ahorro en dolares", LocalDate.now(), "1254125555", "346346634", 1200, 2, true));
		
		return new Usuario("Ezequiel", "Eze@hotmail.com.ar", "123", 
						new Persona("Ezequiel Bobadilla", "34534523", "M", LocalDate.now(), "Av. Paloma 2133", "El Talar", 1, 1, false, true), true, CuentaList);
	}

	// Cliente 3
	@Bean
	public Usuario UsuarioAilen()
	{
		List<Cuenta> CuentaList = new ArrayList<Cuenta>();
		CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "6346234111", "2355155551", 10000, 1, true));
		CuentaList.add(new Cuenta("Cuenta corriente", LocalDate.now(), "623623542221", "64366777374", 0, 1, true));
		
		return new Usuario("Ailen", "Ailen@hotmail.com.ar", "123", 
				new Persona("Ailen Ramirez", "44214441", "F", LocalDate.now(), "Hipolito 2344", "Jose C. Paz", 1, 1, false, true), true, CuentaList);
	}

	// Cliente 4
	@Bean
	public Usuario UsuarioLuciano()
	{
		List<Cuenta> CuentaList = new ArrayList<Cuenta>();
		
		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "1255662463", "235235236236", 10000, 1, true));
		CuentaList.add(new Cuenta("Cuenta corriente", LocalDate.now(), "21541254215", "535215314533", 0, 1, true));
		CuentaList.add(new Cuenta("Caja de ahorro en dolares", LocalDate.now(), "2121214155", "2154124442", 0, 2, true));
		
		return new Usuario("Luciano", "Luciano@hotmail.com.ar", "123", 
				new Persona("Luciano Rodriguez", "34215555", "M", LocalDate.now(), "Av. Alere 2154", "Los Troncos", 1, 1, true, true), true, CuentaList);

	}

	// Cliente 5
	@Bean
	public Usuario UsuarioMatias()
	{
		List<Cuenta> CuentaList = new ArrayList<Cuenta>();
		
		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "21513523525", "6436324235235", 10000, 1, true));
		CuentaList.add(new Cuenta("Caja de ahorro en dolares", LocalDate.now(), "34634663434", "6436346346666", 0, 2, true));
		
		return new Usuario("Matias", "Max@hotmail.com.ar", "123", 
				new Persona("Matias Gonzales", "42545321", "M", LocalDate.now(), "Martinez 1322", "Tigre", 1, 1, true, true), true, CuentaList);
		
	}

	// Cliente 6
	@Bean
	public Usuario UsuarioFranco()
	{
		List<Cuenta> CuentaList = new ArrayList<Cuenta>();

		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "534644463421", "2356212314", 285200, 1, true));
		
		return new Usuario("Franco", "Fran@hotmail.com.ar", "123",
				new Persona("Franco Alvarez", "35566213", "M", LocalDate.now(), "Larte 1122", "Tigre", 1, 1, true, true), true, CuentaList);
	}

	// Cliente 7
	@Bean
	public Usuario UsuarioDiego()
	{
		List<Cuenta> CuentaList = new ArrayList<Cuenta>();

		CuentaList.add(new Cuenta("Caja de ahorro en dolares", LocalDate.now(), "25323421412", "2362362366", 800, 2, true));
		
		return new Usuario("Diego", "Diego@hotmail.com.ar", "123", 
				new Persona("Diego Britez", "35235554", "M", LocalDate.now(), "Acceso 1245", "Tigre", 1, 1, true, true), true, CuentaList);
		
	}

	// Cliente 8
	@Bean
	public Usuario UsuarioAlfonso()
	{
		List<Cuenta> CuentaList = new ArrayList<Cuenta>();
		
		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "2151257547", "2362367231", 10000, 1, true));
		CuentaList.add(new Cuenta("Caja de ahorro en dolares", LocalDate.now(), "1256347734", "23623425623", 4000, 2, true));
		
		return new Usuario("Alfonso", "Alfonso@hotmail.com.ar", "123", 
				new Persona("Alfonso Galarza", "33456236", "M", LocalDate.now(), "Lenue 2142", "Benavidez", 1, 1, false, true), true, CuentaList);

	}

	// Cliente 9
	@Bean
	public Usuario UsuarioFederico()
	{
		List<Cuenta> CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta("Caja de ahorros en pesos", LocalDate.now(), "2152152155", "215125515", 10000, 1, true));
		CuentaList.add(new Cuenta("Caja de ahorro en dolares", LocalDate.now(), "2154123421556", "634634636", 0, 2, true));
		
		return new Usuario("Federico", "Fede@hotmail.com.ar", "123", 
				new Persona("Federico Acosta", "425453121", "M", LocalDate.now(), "Linier 4211", "San Fernando", 1, 1, false, true), true, CuentaList);
		
	}

	// Cliente 10
	@Bean
	public Usuario UsuarioAna()
	{
		List<Cuenta> CuentaList = new ArrayList<Cuenta>();
		CuentaList.add(new Cuenta("Caja de ahorro en dolares", LocalDate.now(), "214215236662", "512551555", 18700, 2, true));
		
		return new Usuario("Ana", "Ana@hotmail.com.ar", "123", 
				new Persona("Ana Martinez", "33451555", "F", LocalDate.now(), "Cerrito 1241", "Recoleta", 1, 1, false, true), true, CuentaList);
	}
	
	@Bean
	public Movimiento Movimiento1() 
	{
	    return new Movimiento(LocalDate.now(), 0, 1, 1, null);
    }

	@Bean
	public Movimiento Movimiento2() 
	{
	    return new Movimiento(LocalDate.now(), 0, 1, 2, null);
	}
	@Bean
	public Movimiento Movimiento3() 
	{
	    return new Movimiento(LocalDate.now(), 0, 1, 3, null);
	}
	
	@Bean
	public Movimiento Movimiento4() 
	{
	    return new Movimiento(LocalDate.now(), 0, 1, 4, null);
    }

	@Bean
	public Movimiento Movimiento5() 
	{
	    return new Movimiento(LocalDate.now(), 0, 1, 5, null);
    }
	
	@Bean
	public Movimiento Movimiento6() 
	{
	    return new Movimiento(LocalDate.now(), 0, 1, 6, null);
    }

	@Bean
	public Movimiento Movimiento7() 
	{
	    return new Movimiento(LocalDate.now(), 0, 1, 7, null);
    }
	
	@Bean
	public Movimiento Movimiento8() 
	{
	    return new Movimiento(LocalDate.now(), 0, 1, 8, null);
    }
	
	@Bean
	public Movimiento Movimiento9() 
	{
	    return new Movimiento(LocalDate.now(), 0, 1, 9, null);
    }
	
	@Bean
	public Movimiento Movimiento10() 
	{
	    return new Movimiento(LocalDate.now(), 0, 1, 10, null);
    }
	
	@Bean
	public Movimiento Movimiento11() 
	{
	    return new Movimiento(LocalDate.now(), 2500, 2, 1, 2);
    }
	
	@Bean
	public Movimiento Movimiento12() 
	{
	    return new Movimiento(LocalDate.now(), 2500, 3, 2, 1);
    }
	
	@Bean
	public Movimiento Movimiento13() 
	{
	    return new Movimiento(LocalDate.now(), 1200, 2, 5, 6);
	}
	
	@Bean
	public Movimiento Movimiento14() 
	{
	    return new Movimiento(LocalDate.now(), 1200, 3, 6, 5);
    }

	@Bean
	public Movimiento Movimiento15() 
	{
	    return new Movimiento(LocalDate.now(), 8000, 2, 3, 7);
    }

	@Bean
	public Movimiento Movimiento16() 
	{
	    return new Movimiento(LocalDate.now(), 8000, 3, 7, 3);
    }
}
