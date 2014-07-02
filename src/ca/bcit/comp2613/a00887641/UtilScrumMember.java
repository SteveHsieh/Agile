package ca.bcit.comp2613.a00887641;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import java.util.Random;
import java.util.UUID;

import ca.bcit.comp2613.agile.model.ScrumMaster;
import ca.bcit.comp2613.agile.model.ScrumMember;



public class UtilScrumMember
{
	public static ArrayList<ScrumMember> create10Members() {
	ArrayList<ScrumMember> members = new ArrayList<>();

	for (int i = 0; i < 10; i++) {
		String firstName = UUID.randomUUID().toString();
		String lastName = UUID.randomUUID().toString();
		String id =Integer.toString(i);
		ScrumMember member = new ScrumMember (id, firstName, lastName);
		members.add(member);
	}
	return members;
	}
	
	public static void AssignMemberToMaster(List<ScrumMaster> teachers,
			List<ScrumMember> students) {
		int studentArraySize = students.size();
		for (ScrumMaster teacher: teachers) {
			Random rand = new Random();
			
			for (int i = 0; i < 10; i++) {
				int randStudentIndex = rand.nextInt(studentArraySize);
				ScrumMember randomStudent = students.get(randStudentIndex);
				if (ScrumMaster.getMember() == null) {
					ScrumMaster.setMember(new ArrayList<ScrumMember>());					
				}
				UtilScrumMaster.addToClass(teacher, randomStudent, students);
			}
		}
	}

	public static void save(List<ScrumMember> members, ScrumMember member) {
		boolean foundUpdate = false;
		for (ScrumMember memberLoop :members) {
			if (memberLoop.getId().equals(member.getId())) {
				memberLoop.setFirstName(member.getFirstName());
				memberLoop.setLastName(member.getLastName());
				foundUpdate = true;
				break;
			}
		}
}
	public static void delete(List<ScrumMember> members, ScrumMember member) {
		Iterator<ScrumMember> iter = members.iterator();
		while (iter.hasNext()) {
			ScrumMember memberLoop = iter.next();
			if (memberLoop.getId().equals(member.getId())) {
				iter.remove();
				break;
			}
		}
	}

	public static void read(List<ScrumMember> members) {
		
		for (ScrumMember member : members)
		{
			System.out.println(member);
			
		}
		
	}
	
	public static ScrumMember findById(String string, List<ScrumMember> members) {
		for (ScrumMember studentLoop :members) {
			if (studentLoop.getId().equals(string)) {
				return studentLoop;
			}
			
		}
		return null;
	}
}
