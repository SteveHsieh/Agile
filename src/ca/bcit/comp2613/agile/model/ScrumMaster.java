package ca.bcit.comp2613.agile.model;

public class ScrumMaster {
	private String id;
	private String firstName;
	private String lastName;
	private String sprintTaking;
	public enum Gender {
	    Male,Female
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the sprintTaking
	 */
	public String getSprintTaking() {
		return sprintTaking;
	}
	/**
	 * @param sprintTaking the sprintTaking to set
	 */
	public void setSprintTaking(String sprintTaking) {
		this.sprintTaking = sprintTaking;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ScrumMaster [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", sprintTaking=" + sprintTaking
				+ "]";
	}
	
	
}
