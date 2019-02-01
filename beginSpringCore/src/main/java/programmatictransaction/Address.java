package programmatictransaction;

public class Address {

	private int addressId;
	private String province;
	private String district;

	public Address(int addressId, String province, String district) {
		super();
		this.addressId = addressId;
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
