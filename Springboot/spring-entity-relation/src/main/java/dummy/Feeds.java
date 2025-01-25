package dummy;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_feeds")
public class Feeds {

	@Id
	@Column(name="feed_id")
	private int feedId;
	
	@Column(name="feed_name")
	private String feedName;
	
	@Column(name="manufacturing_date")
	@Temporal(TemporalType.DATE)
	private Date maufacturingDate;
	
	@Column(name="manufacturing_code")
	private String manufacturingCode;
	
	@Column(name="validation_period")
	private int validationPeriod;
	
	@Column(name="producer")
	private String producer;
	
	@Column(name="address")
	private String address;
	
	public Feeds() {
		super();
	}

	public Feeds(int feedId, String feedName, Date maufacturingDate, String manufacturingCode, int validationPeriod,
			String producer, String address) {
		super();
		this.feedId = feedId;
		this.feedName = feedName;
		this.maufacturingDate = maufacturingDate;
		this.manufacturingCode = manufacturingCode;
		this.validationPeriod = validationPeriod;
		this.producer = producer;
		this.address = address;
	}

	public int getFeedId() {
		return feedId;
	}

	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}

	public String getFeedName() {
		return feedName;
	}

	public void setFeedName(String feedName) {
		this.feedName = feedName;
	}

	public Date getMaufacturingDate() {
		return maufacturingDate;
	}

	public void setMaufacturingDate(Date maufacturingDate) {
		this.maufacturingDate = maufacturingDate;
	}

	public String getManufacturingCode() {
		return manufacturingCode;
	}

	public void setManufacturingCode(String manufacturingCode) {
		this.manufacturingCode = manufacturingCode;
	}

	public int getValidationPeriod() {
		return validationPeriod;
	}

	public void setValidationPeriod(int validationPeriod) {
		this.validationPeriod = validationPeriod;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Feeds [feedId=" + feedId + ", feedName=" + feedName + ", maufacturingDate=" + maufacturingDate
				+ ", manufacturingCode=" + manufacturingCode + ", validationPeriod=" + validationPeriod + ", producer="
				+ producer + ", address=" + address + "]";
	}
	
}
