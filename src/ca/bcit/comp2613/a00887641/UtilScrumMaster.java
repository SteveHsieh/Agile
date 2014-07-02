package ca.bcit.comp2613.a00887641;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import ca.bcit.comp2613.agile.model.ScrumMaster;
import ca.bcit.comp2613.agile.model.ScrumMember;




public class UtilScrumMaster {
	public static ArrayList<ScrumMaster> create1000RandomStudents() {
		ArrayList<ScrumMaster> masters = new ArrayList<>();

		for (int i = 0; i < 30; i++) {
			String firstName = UUID.randomUUID().toString();
			String lastName = UUID.randomUUID().toString();
			String id =Integer.toString(i);
			ScrumMaster master = new ScrumMaster (id, firstName, lastName);
			masters.add(master);
		}
		return masters;
		}

		public static void save(List<ScrumMaster> masters, ScrumMaster member) {
			boolean foundUpdate = false;
			for (ScrumMaster masterLoop :masters) {
				if (masterLoop.getId().equals(member.getId())) {
					masterLoop.setFirstName(member.getFirstName());
					masterLoop.setLastName(member.getLastName());
					foundUpdate = true;
					break;
				}
			}
	}
		public static void delete(List<ScrumMaster> masters, ScrumMaster master) {
			Iterator<ScrumMaster> iter = masters.iterator();
			while (iter.hasNext()) {
				ScrumMaster masterLoop = iter.next();
				if (masterLoop.getId().equals(master.getId())) {
					iter.remove();
					break;
				}
			}
		}

		public static void read(List<ScrumMaster> masters) {
			
			for (ScrumMaster master : masters)
			{
				System.out.println(master);
				
			}
			
		}
		
		public static ScrumMaster findById(String id, List<ScrumMaster> masters) {
			for (ScrumMaster masterLoop : masters) {
				if (masterLoop.getId().equals(id)) {
					return masterLoop;
				}
				
			}
			return null;
		}
		

		public static void addToClass(ScrumMaster master, ScrumMember member, List<ScrumMember> members) {
			if (ScrumMaster.getMember() == null) {
				ScrumMaster.setMember(new ArrayList<ScrumMember>());
			}
			for (ScrumMember memberLoop : ScrumMaster.getMember()) {
				if (memberLoop.getId().equals(member.getId())) {
					return; // already in class
				}
			}
			
			member = UtilScrumMember.findById(member.getId(), members);
			ScrumMaster.getMember().add(member);
		}
}
