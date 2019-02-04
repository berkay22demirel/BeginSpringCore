package declarativetransaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@Column(name = "addressid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressId;
	@Column(name = "province")
	private String province;
	@Column(name = "district")
	private String district;

	public Address(int addressId, String province, String district) {
		super();
		this.addressId = addressId;
		this.province = province;
		this.district = district;
	}

	public Address(String province, String district) {
		super();
		this.province = province;
		this.district = district;
	}

	public Address() {
		super();
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", province=" + province
				+ ", district=" + district + "]";
	}

}
