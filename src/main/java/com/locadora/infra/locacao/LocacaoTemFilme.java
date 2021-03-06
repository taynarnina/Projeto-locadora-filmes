package com.locadora.infra.locacao;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.locadora.infra.filme.Filme;

@Entity
@Table(name = "locacao_tem_filme")
public class LocacaoTemFilme {
	
	@EmbeddedId
	private LocacaoTemFilmeId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("locacaoId")
    private Locacao locacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("filmeId")
    private Filme filme;
	
	@Column(name = "QUANTIDADE_LOCADA")
	private Integer qtLocada;

	@Column(name = "VALOR_TOTAL_DIARIA")
	private Double vlrTotal;

	
	
	public LocacaoTemFilme(Integer id, Locacao locacao, Filme filme, Integer qtLocada, Double vlrTotal) {
		
		this.id = new LocacaoTemFilmeId(locacao.getId(), filme.getId());
		this.locacao = locacao;
		this.filme = filme;
		this.qtLocada = qtLocada;
		this.vlrTotal = vlrTotal;
	}

	public LocacaoTemFilme(){
		
	}
	
	

	public LocacaoTemFilmeId getId() {
		return id;
	}

	public void setId(LocacaoTemFilmeId id) {
		this.id = id;
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Integer getQtLocada() {
		return qtLocada;
	}

	public void setQtLocada(Integer qtLocada) {
		this.qtLocada = qtLocada;
	}

	public Double getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(Double vlrTotal) {
		this.vlrTotal = vlrTotal;
	}
	
	
}
