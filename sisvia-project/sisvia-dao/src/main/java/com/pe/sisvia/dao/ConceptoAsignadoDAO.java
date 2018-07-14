package com.pe.sisvia.dao;

import java.util.List;

import com.pe.sisvia.model.Conceptoasignado;

public interface ConceptoAsignadoDAO {

	public Conceptoasignado grabar(Conceptoasignado concepto);
	
	public List<Conceptoasignado> listarConceptosAsignadosPorViatico(Long idViatico);
}
