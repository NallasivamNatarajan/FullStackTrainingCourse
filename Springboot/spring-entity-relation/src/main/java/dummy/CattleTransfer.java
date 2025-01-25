package dummy;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_cattle_transfer")
public class CattleTransfer {

	@Id
	@Column(name="transfer_id")
	private int transferId;
	
	@OneToMany(mappedBy="transfer",fetch=FetchType.EAGER)
	private Set<Cattle> cattles;
	
	@Column(name="cattle_From")
	private String cattleFrom;
	
	public CattleTransfer(int transferId, String cattleFrom, CattleHouse cattleHouse, String transferReason,
			Date operateDate) {
		super();
		this.transferId = transferId;
		this.cattleFrom = cattleFrom;
		this.cattleHouse = cattleHouse;
		this.transferReason = transferReason;
		this.operateDate = operateDate;
	}

	@OneToOne
	@JoinColumn(name="cattle_house_id")
	private CattleHouse cattleHouse;
	
	@Column(name="transfer_reason")
	private String transferReason;
	
	@OneToMany(mappedBy="transfer",fetch=FetchType.EAGER)
	private Set<Employees> employees;
	
	@Column(name="operate_date")
	@Temporal(TemporalType.DATE)
	private Date operateDate;

	public CattleTransfer() {
		super();
	}

	public Set<Cattle> getCattle() {
		return cattles;
	}

	public void setCattle(Set<Cattle> cattles) {
		this.cattles = cattles;
	}

	public CattleHouse getCattleHouse() {
		return cattleHouse;
	}

	public void setCattleHouse(CattleHouse cattleHouse) {
		this.cattleHouse = cattleHouse;
	}

	public int getTransferId() {
		return transferId;
	}

	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}

	public String getCattleFrom() {
		return cattleFrom;
	}

	public void setCattleFrom(String cattleFrom) {
		this.cattleFrom = cattleFrom;
	}

	public String getTransferReason() {
		return transferReason;
	}

	public void setTransferReason(String transferReason) {
		this.transferReason = transferReason;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	@Override
	public String toString() {
		return "CattleTransfer [transferId=" + transferId + ", cattles=" + cattles + ", cattleFrom=" + cattleFrom
				+ ", cattleHouse=" + cattleHouse + ", transferReason=" + transferReason + ", employees=" + employees
				+ ", operateDate=" + operateDate + "]";
	}

}
