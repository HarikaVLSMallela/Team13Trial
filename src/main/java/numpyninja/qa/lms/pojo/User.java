package numpyninja.qa.lms.pojo;

public class User {
	
	private String userId;
	private String userFirstName;
	private String userMiddleName;
	private String userLastName;

	private String userLocation;
	private String userPhone;
	
	private String userLinkedIn;
	private String userRole;
	private String userRoleStatus;
	private String userVisaStatus;
	private String userEmail;
	private String userUnderGrad;
	private String userPostGrad;
	private String userTimeZone;
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	private String userComments;
	
	public User() {}
	
	public User(String userId,String userFirstName, String userMiddleName, String userLastName, String userLocation, String userPhone,
			String userLinkedIn, String userRole, String userRoleStatus, String userVisaStatus, String userEmail,
			String userUnderGrad, String userPostGrad, String userTimeZone, String userComments) {
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userMiddleName = userMiddleName;
		this.userLastName = userLastName;
		this.userLocation = userLocation;
		this.userPhone = userPhone;
		this.userLinkedIn = userLinkedIn;
		this.userRole = userRole;
		this.userRoleStatus = userRoleStatus;
		this.userVisaStatus = userVisaStatus;
		this.userEmail = userEmail;
		this.userUnderGrad = userUnderGrad;
		this.userPostGrad = userPostGrad;
		this.userTimeZone = userTimeZone;
		this.userComments = userComments;
	}
	
	public User(String userFirstName, String userMiddleName, String userLastName, String userLocation, String userPhone,
			String userLinkedIn, String userRole, String userRoleStatus, String userVisaStatus, String userEmail,
			String userUnderGrad, String userPostGrad, String userTimeZone, String userComments) {
		
		this.userFirstName = userFirstName;
		this.userMiddleName = userMiddleName;
		this.userLastName = userLastName;
		this.userLocation = userLocation;
		this.userPhone = userPhone;
		this.userLinkedIn = userLinkedIn;
		this.userRole = userRole;
		this.userRoleStatus = userRoleStatus;
		this.userVisaStatus = userVisaStatus;
		this.userEmail = userEmail;
		this.userUnderGrad = userUnderGrad;
		this.userPostGrad = userPostGrad;
		this.userTimeZone = userTimeZone;
		this.userComments = userComments;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserMiddleName() {
		return userMiddleName;
	}
	public void setUserMiddleName(String userMiddleName) {
		this.userMiddleName = userMiddleName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserLocation() {
		return userLocation;
	}
	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserLinkedIn() {
		return userLinkedIn;
	}
	public void setUserLinkedIn(String userLinkedIn) {
		this.userLinkedIn = userLinkedIn;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserRoleStatus() {
		return userRoleStatus;
	}
	public void setUserRoleStatus(String userRoleStatus) {
		this.userRoleStatus = userRoleStatus;
	}
	public String getUserVisaStatus() {
		return userVisaStatus;
	}
	public void setUserVisaStatus(String userVisaStatus) {
		this.userVisaStatus = userVisaStatus;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserUnderGrad() {
		return userUnderGrad;
	}
	public void setUserUnderGrad(String userUnderGrad) {
		this.userUnderGrad = userUnderGrad;
	}
	public String getUserPostGrad() {
		return userPostGrad;
	}
	public void setUserPostGrad(String userPostGrad) {
		this.userPostGrad = userPostGrad;
	}
	public String getUserTimeZone() {
		return userTimeZone;
	}
	public void setUserTimeZone(String userTimeZone) {
		this.userTimeZone = userTimeZone;
	}
	public String getUserComments() {
		return userComments;
	}
	public void setUserComments(String userComments) {
		this.userComments = userComments;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userFirstName=" + userFirstName + ", userMiddleName=" + userMiddleName
				+ ", userLastName=" + userLastName + ", userLocation=" + userLocation + ", userPhone=" + userPhone
				+ ", userLinkedIn=" + userLinkedIn + ", userRole=" + userRole + ", userRoleStatus=" + userRoleStatus
				+ ", userVisaStatus=" + userVisaStatus + ", userEmail=" + userEmail + ", userUnderGrad=" + userUnderGrad
				+ ", userPostGrad=" + userPostGrad + ", userTimeZone=" + userTimeZone + ", userComments=" + userComments
				+ "]";
	}





	
}
