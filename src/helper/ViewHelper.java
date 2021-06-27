package helper;

import models.Persona;
import models.Tipo_Cuenta;
import models.Usuario;

public abstract class ViewHelper 
{
	public static String SetViewNameByUser(Usuario user) 
	{
		if(user != null) 
		{
			if(user.getPersona().isEsCliente()) 
			{
				return "HomeCliente";				
			}
			else
			{
				return "HomeRepresentante";				
			}
		}
		else 
		{
			return "Login";			
		}
	}
	

	public static String GetLetraPorTipo(Tipo_Cuenta tipo) 
	{
		if (tipo != null)
		{
			if (tipo.getNombre() == "Caja de ahorro en pesos")
			{
				return "CA $";
			}
			else if (tipo.getNombre() == "Caja de ahorro en dólares")
			{
				return "CA U$S";
			}
			else if (tipo.getNombre() == "Cuenta corriente en pesos")
			{
				return "CC $";
			}
			else if (tipo.getNombre() == "Cuenta corriente en dólares")
			{
				return "CC U$S";
			}
		}

		return "Otro";
	}
}
