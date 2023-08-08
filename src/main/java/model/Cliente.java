package model;

public class Cliente {
	private int id;
	private String nomeCliente;
	private String enderecoCliente;
	private String modalidadeCliente;
	private String situacaoCliente;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	
	
	
	public String getEnderecoCliente() {
		return enderecoCliente;
	}
	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}
	
	
	
	public String getModalidadeCliente() {
		return modalidadeCliente;
	}
	public void setModalidadeCliente(String modalidadeCliente) {
		this.modalidadeCliente = modalidadeCliente;
	}
	
	
	
	
	
	public String getSituacaoCliente() {
		return situacaoCliente;
	}
	public void setSituacaoCliente(String situacaoCliente) {
		this.situacaoCliente = situacaoCliente;
	}
	
	
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nomeCliente=" + nomeCliente + ", enderecoCliente=" + enderecoCliente
				+ ", modalidadeCliente=" + modalidadeCliente + "]";
	}
	
}
