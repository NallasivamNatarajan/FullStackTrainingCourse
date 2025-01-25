package dummy;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_cattle_house")
public class CattleHouse {

	@Id
	@Column(name="cattle_house_id")
	private int cattleHouseId;
	
	@Column(name="cattle_house_details")
	private String cattleHouseDetails;
	
	@Column(name="capacity")
	private String capacity;
	
	@Column(name="operator")
	private String operator;
	
	@Column(name="antisepsis_date")
	@Temporal(TemporalType.DATE)
	private Date antisepsisDate;
	
	@Column(name="record")
	private String record;

	public CattleHouse() {
		super();
	}

	public CattleHouse(int cattleHouseId, String cattleHouseDetails, String capacity, String operator,
			Date antisepsisDate, String record) {
		super();
		this.cattleHouseId = cattleHouseId;
		this.cattleHouseDetails = cattleHouseDetails;
		this.capacity = capacity;
		this.operator = operator;
		this.antisepsisDate = antisepsisDate;
		this.record = record;
	}

	public int getCattleHouseId() {
		return cattleHouseId;
	}

	public void setCattleHouseId(int cattleHouseId) {
		this.cattleHouseId = cattleHouseId;
	}

	public String getCattleHouseDetails() {
		return cattleHouseDetails;
	}

	public void setCattleHouseDetails(String cattleHouseDetails) {
		this.cattleHouseDetails = cattleHouseDetails;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getAntisepsisDate() {
		return antisepsisDate;
	}

	public void setAntisepsisDate(Date antisepsisDate) {
		this.antisepsisDate = antisepsisDate;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	@Override
	public String toString() {
		return "CattleHouse [cattleHouseId=" + cattleHouseId + ", cattleHouseDetails=" + cattleHouseDetails
				+ ", capacity=" + capacity + ", operator=" + operator + ", antisepsisDate=" + antisepsisDate
				+ ", record=" + record + "]";
	}

	
}
