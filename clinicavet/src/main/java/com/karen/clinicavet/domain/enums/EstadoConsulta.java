package com.karen.clinicavet.domain.enums;

public enum EstadoConsulta {

	AGENDADA(1,"Agendada"),
	CANCELADA(2, "Cancelada"),
	CONCLUIDA(3, "Concluída");
	
	private int cod;
	private String descricao;
	
	private EstadoConsulta(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}


	public String getDescricao() {
		return descricao;
	}

	public static EstadoConsulta toEnum(Integer id) {

		 if (id == null) {
		 return null;
		 }

		 for (EstadoConsulta x : EstadoConsulta.values()) {
		 if (id.equals(x.getCod())) {
		 return x;
		 }
		 }
		 throw new IllegalArgumentException("Id inválido " + id);
		 } 

	
	
}
