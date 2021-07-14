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
			if (tipo.getNombre().equals("Caja de ahorro en pesos"))
			{
				return "CA " + tipo.getSigno_Moneda();
			}

			if (tipo.getNombre().equals("Caja de ahorro en dólares"))
			{
				return "CA " + tipo.getSigno_Moneda();
			}
		}

		return "Otro";
	}
}
