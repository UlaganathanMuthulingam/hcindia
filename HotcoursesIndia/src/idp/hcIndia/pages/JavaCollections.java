package idp.hcIndia.pages;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



public class JavaCollections {
	static int duplictecount = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Character,Integer> duplicateChecker=new HashMap<Character,Integer>();
		String duplicate ="ulaganathan";
		char[] toArray= duplicate.toCharArray();
		System.out.println(toArray.length);
		for (char c : toArray) {
			if(duplicateChecker.containsKey(c))
			{
				duplicateChecker.put(c,duplicateChecker.get(c)+1 );
				
			}
			else
			{
				duplicateChecker.put(c,1);
			}
		}
		Set<Character> keys=duplicateChecker.keySet();
		for (Character character : keys) {
			if(duplicateChecker.get(character)>1)
			{
				System.out.println(character +" - repeated"+duplicateChecker.get(character)+"times");
			}
		}
		}
		
			

}
