package SystemDesign9.SocialNetwork92;

import java.util.ArrayList;

public class Person {
	private ArrayList<Integer> friends = new ArrayList<Integer>();
	private int personId;
	private String info;
	public ArrayList<Integer> getFriends() {
		return friends;
	}
	public void setFriends(ArrayList<Integer> friends) {
		this.friends = friends;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
