package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the NEXUSQUESTION database table.
 * 
 */
@Entity
@NamedQuery(name="com.example.taller1.model.Nexusquestion.findAll", query="SELECT n FROM Nexusquestion n")
public class Nexusquestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NEXUSQUESTION_NEXQUESID_GENERATOR", sequenceName="NEXUSQUESTION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NEXUSQUESTION_NEXQUESID_GENERATOR")
	@Column(name="NEXQUES_ID")
	private long nexquesId;

	@Column(name="NEXQUES_ISACTIVE")
	private String nexquesIsactive;

	@Column(name="NEXQUES_NAME")
	private String nexquesName;

	@Column(name="NEXQUES_WEIGHT")
	private BigDecimal nexquesWeight;

	//bi-directional many-to-one association to com.example.taller1.model.Epidemnexus
	@ManyToOne
	@JoinColumn(name="EPINEX_EPINEX_ID")
	private Epidemnexus epidemnexus;

	//bi-directional many-to-one association to com.example.taller1.model.Nexuspoll
	@ManyToOne
	@JoinColumn(name="NEXPOLL_NEXPOLL_ID")
	private Nexuspoll nexuspoll;

	//bi-directional many-to-one association to com.example.taller1.model.Nexusweightbyday
	@OneToMany(mappedBy="nexusquestion")
	private List<Nexusweightbyday> nexusweightbydays;

	//bi-directional many-to-one association to com.example.taller1.model.UstPersonNexus
	@OneToMany(mappedBy="nexusquestion")
	private List<UstPersonNexus> ustPersonNexuses;

	public Nexusquestion() {
	}

	public long getNexquesId() {
		return this.nexquesId;
	}

	public void setNexquesId(long nexquesId) {
		this.nexquesId = nexquesId;
	}

	public String getNexquesIsactive() {
		return this.nexquesIsactive;
	}

	public void setNexquesIsactive(String nexquesIsactive) {
		this.nexquesIsactive = nexquesIsactive;
	}

	public String getNexquesName() {
		return this.nexquesName;
	}

	public void setNexquesName(String nexquesName) {
		this.nexquesName = nexquesName;
	}

	public BigDecimal getNexquesWeight() {
		return this.nexquesWeight;
	}

	public void setNexquesWeight(BigDecimal nexquesWeight) {
		this.nexquesWeight = nexquesWeight;
	}

	public Epidemnexus getEpidemnexus() {
		return this.epidemnexus;
	}

	public void setEpidemnexus(Epidemnexus epidemnexus) {
		this.epidemnexus = epidemnexus;
	}

	public Nexuspoll getNexuspoll() {
		return this.nexuspoll;
	}

	public void setNexuspoll(Nexuspoll nexuspoll) {
		this.nexuspoll = nexuspoll;
	}

	public List<Nexusweightbyday> getNexusweightbydays() {
		return this.nexusweightbydays;
	}

	public void setNexusweightbydays(List<Nexusweightbyday> nexusweightbydays) {
		this.nexusweightbydays = nexusweightbydays;
	}

	public Nexusweightbyday addNexusweightbyday(Nexusweightbyday nexusweightbyday) {
		getNexusweightbydays().add(nexusweightbyday);
		nexusweightbyday.setNexusquestion(this);

		return nexusweightbyday;
	}

	public Nexusweightbyday removeNexusweightbyday(Nexusweightbyday nexusweightbyday) {
		getNexusweightbydays().remove(nexusweightbyday);
		nexusweightbyday.setNexusquestion(null);

		return nexusweightbyday;
	}

	public List<UstPersonNexus> getUstPersonNexuses() {
		return this.ustPersonNexuses;
	}

	public void setUstPersonNexuses(List<UstPersonNexus> ustPersonNexuses) {
		this.ustPersonNexuses = ustPersonNexuses;
	}

	public UstPersonNexus addUstPersonNexus(UstPersonNexus ustPersonNexus) {
		getUstPersonNexuses().add(ustPersonNexus);
		ustPersonNexus.setNexusquestion(this);

		return ustPersonNexus;
	}

	public UstPersonNexus removeUstPersonNexus(UstPersonNexus ustPersonNexus) {
		getUstPersonNexuses().remove(ustPersonNexus);
		ustPersonNexus.setNexusquestion(null);

		return ustPersonNexus;
	}

}