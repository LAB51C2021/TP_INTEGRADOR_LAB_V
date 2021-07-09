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
			switch(tipo.getNombre()) {
				case "Caja de ahorro en pesos":
					return "CA $";
				case "Caja de ahorro en dólares":
					return "CA U$S";
				case "Cuenta corriente en pesos":
					return "CC $";
				case "Cuenta corriente en dólares":
					return "CC U$S";
			}
		}

		return "Otro";
	}
}
