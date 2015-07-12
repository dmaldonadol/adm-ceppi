package cl.ml.ceppi.core.model.equipo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import cl.ml.ceppi.core.model.skill.Skill;

/**
 * 
 * @author Maldonado León
 * 
 */
@Entity
@SequenceGenerator(name = "SEC_SKILL_JUGADOR", sequenceName = "SEC_SKILL_JUGADOR")
@Table(name = "SKILL_JUGADOR")
public class SkillJugador implements Serializable {

	private static final long serialVersionUID = 4137884810393070496L;
	@Id
	@GeneratedValue(generator = "SEC_SKILL_JUGADOR")
	@Column(name = "ID_SKILL_JUGADOR", nullable = false)
	private int oid;
	@Column
	private String data;
	@OneToMany
	private Skill skill;

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}
