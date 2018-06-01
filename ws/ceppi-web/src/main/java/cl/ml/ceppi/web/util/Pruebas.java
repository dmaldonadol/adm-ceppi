package cl.ml.ceppi.web.util;

import java.math.BigDecimal;

public class Pruebas 
{
	public static void main(String[] args) 
	{
		BigDecimal montoRegistrado = new BigDecimal("10000");
		BigDecimal montoReq = new BigDecimal("2000");
		BigDecimal suma = montoRegistrado.add(montoReq);
		
		System.out.println(suma.toString());
		
		if ( suma.toString().equals("15000"))
		{
			System.out.println("PAGADA");
		}
		else
		{
			System.out.println("PARCIAL");
		}
	}
}
