package comparadores;

import java.util.Comparator;

import logica.candidato.Candidato;

public class CompararPorCitas implements Comparator<Candidato>{

	@Override
	public int compare(Candidato o1, Candidato o2) {	
		return o2.getCitas().size() - o1.getCitas().size();
	}

}
