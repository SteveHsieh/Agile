package ca.bcit.comp2613;

import java.util.ArrayList;

import ca.bcit.comp2613.a00887641.util.Helper;
import ca.bcit.comp2613.agile.model.ScrumMember;

public class TestDriver {
	public static void main(String[] args) {
		ArrayList <ScrumMember> members = new ArrayList <ScrumMember>();
		try{
			members = new Helper().createMembers();
		
		}
		catch(RuntimeException e){
			
		}
		
	}
}
