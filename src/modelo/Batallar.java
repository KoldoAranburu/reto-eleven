package modelo;

import java.util.ArrayList;
import java.util.Random;

import controlador.GestorCaballeros;
import controlador.GestorEscuderos;
import vista.Visor;

public class Batallar {
	
	public static Caballero luchar(Caballero caballero,
			Caballero caballero2, ArrayList<Arma> armas) {
		Random random = new Random();
//		Cálculo de la Fuerza de lucha (FL): 
//
//			(fuerza habilidad + ataque del arma +defensa del escudo) 
//
//			FL1*random(1 , experiencia)  - FL2 * random(1, experiencia) > 10 por ejemplo  ->gana el Caballero 1
//
//			FL1*random(1 , experiencia)  - FL2 * random(1, experiencia) < 10 por ejemplo  ->gana el Caballero 2
//
//			Si no es empate.
		
		Escudero escuderoPJ1 = GestorEscuderos.getEscuderoByIDCaballero(caballero.getId_caballero());
		Escudero escuderoPJ2 = GestorEscuderos.getEscuderoByIDCaballero(caballero2.getId_caballero());
		
		int estocadaPJ1 = caballero.calcularFuerzaLucha()*random.nextInt(1, caballero.getExperiencia()) + escuderoPJ1.getExperiencia();
		int estocadaPJ2 = caballero2.calcularFuerzaLucha()*random.nextInt(1, caballero2.getExperiencia()) + escuderoPJ2.getExperiencia();
		
		if (estocadaPJ1-estocadaPJ2>10) {
			caballero.setExperiencia(caballero.getExperiencia()+15);
			escuderoPJ1.setExperiencia(escuderoPJ1.getExperiencia()+15);
			
			GestorCaballeros.subirExperienciaCaballero(caballero);
			GestorEscuderos.subirExperienciaEscudero(escuderoPJ1);
			return caballero;
		}else if(estocadaPJ1-estocadaPJ2<10) {
			caballero2.setExperiencia(caballero2.getExperiencia()+15);
			escuderoPJ2.setExperiencia(escuderoPJ1.getExperiencia()+15);
			
			GestorCaballeros.subirExperienciaCaballero(caballero);
			GestorEscuderos.subirExperienciaEscudero(escuderoPJ2);
			return caballero2;
		}else{
			return null;
		}
	}
	
	public static Caballero getPrimerLuchador(int id_caballero) {
		Caballero caballero = GestorCaballeros.getCaballero(id_caballero,new Caballero());
		return caballero;	
	}
	
	public static Caballero getSecundoluchador(ArrayList<Caballero> caballeros, Random random) {
		Caballero caballero2 = caballeros.get(random.nextInt(0, caballeros.size()));		
		return caballero2;
	}

}
