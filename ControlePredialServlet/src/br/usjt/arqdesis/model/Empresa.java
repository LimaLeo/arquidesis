package br.usjt.arqdesis.model;

public class Empresa {
	String cnpj, razaoSocial, horarioDeFuncionamento;
	int idEmpresa, temperaturaMaximaAr;

	// Getters and Setters
	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getHorarioDeFuncionamento() {
		return horarioDeFuncionamento;
	}

	public void setHorarioDeFuncionamento(String horarioDeFuncionamento) {
		this.horarioDeFuncionamento = horarioDeFuncionamento;
	}

	public int getTemperaturaMaximaAr() {
		return temperaturaMaximaAr;
	}

	public void setTemperaturaMaximaAr(int temperaturaMaximaAr) {
		this.temperaturaMaximaAr = temperaturaMaximaAr;
	}
	
	@Override
	public String toString() {
		return "Empresa [id=" + idEmpresa + ", cnpj=" + cnpj + ", razao social=" + razaoSocial + ", horario de funcionamento="
				+ horarioDeFuncionamento + ", temperatura maxima do ar:" + temperaturaMaximaAr + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (idEmpresa != other.idEmpresa) {
			return false;
		}
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (razaoSocial == null) {
			if (other.razaoSocial != null)
				return false;
		} else if (!horarioDeFuncionamento.equals(other.horarioDeFuncionamento))
			return false;
		if (horarioDeFuncionamento == null) {
			if (other.horarioDeFuncionamento != null)
				return false;
		} else if (!horarioDeFuncionamento.equals(other.horarioDeFuncionamento))
			return false;
		if (temperaturaMaximaAr != other.temperaturaMaximaAr)
			return false;

		return true;
	}

}
