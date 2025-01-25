package dummy;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_curative")
public class Curative {

	@Id
	@Column(name="curative_id")
	private int curativeId;
	
	@Column(name="curative_name")
	private String curativeName;
	
	@Column(name="manufacturing_date")
	@Temporal(TemporalType.DATE)
	private Date manufacturingDate;
	
	@Column(name="use_method")
	private String useMethod;
	
	@Column(name="producer")
	private String producer;
	
	public Curative() {
		super();
	}

	public Curative(int curativeId, String curativeName, Date manufacturingDate, String useMethod, String producer) {
		super();
		this.curativeId = curativeId;
		this.curativeName = curativeName;
		this.manufacturingDate = manufacturingDate;
		this.useMethod = useMethod;
		this.producer = producer;
	}

	public int getCurativeId() {
		return curativeId;
	}

	public void setCurativeId(int curativeId) {
		this.curativeId = curativeId;
	}

	public String getCurativeName() {
		return curativeName;
	}

	public void setCurativeName(String curativeName) {
		this.curativeName = curativeName;
	}

	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public String getUseMethod() {
		return useMethod;
	}

	public void setUseMethod(String useMethod) {
		this.useMethod = useMethod;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	@Override
	public String toString() {
		return "Curative [curativeId=" + curativeId + ", curativeName=" + curativeName + ", manufacturingDate="
				+ manufacturingDate + ", useMethod=" + useMethod + ", producer=" + producer + "]";
	}
	
}
