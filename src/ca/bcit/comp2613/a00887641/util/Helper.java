package ca.bcit.comp2613.a00887641.util;

import java.util.ArrayList;
import java.util.Random;

//import ca.bcit.comp2613.agile.model.ScrumMaster;
import ca.bcit.comp2613.agile.model.ScrumMember;

public class Helper {
	private int randomNumber;

	public ArrayList<ScrumMember> createMembers() {

		Random rn = new Random();
		randomNumber = rn.nextInt(Integer.MAX_VALUE) % 100;
		ArrayList<ScrumMember> members = new ArrayList<ScrumMember>();
		for (int i = 0; i < randomNumber; i++) {
			ScrumMember newbie = new ScrumMember();
			members.add(newbie);

		}

		return members;
	}

	public ScrumMember findScrumMemberByFirstName(String firstName) {
		ArrayList<ScrumMember> members = createMembers();
		ScrumMember SMember = null;
		for (ScrumMember member : members) {
			if (member.getFirstName() == firstName) {
				SMember = member;
				return SMember;

			}

		}

		return SMember;

	}

	/**
	 * @return the randomNumber
	 */
	public int getRandomNumber() {
		return randomNumber;
	}

}
