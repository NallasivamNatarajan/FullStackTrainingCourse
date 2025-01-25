package training;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckFunctions {
	
	
	public static void main(String[] args) {
		System.out.println(jumps(13,13));
		System.out.println(playlist(Arrays.asList(20,60,40,300)));
		
	}
	
	static int jumps(int flagHeight, int bigJump) {
		int nofjumps=0;
		nofjumps=(flagHeight/bigJump)+(flagHeight%bigJump);
		return nofjumps;
		}
	
	public static long playlist(List<Integer> songs) {
		Map<Integer,Integer> map= new HashMap<>();
		 long count=0;
		 for(int t : songs)
		 {
		 count =count +map.getOrDefault((60-t %60)%60,0);
		 map.put(t%60,map.getOrDefault(t%60,0)+1);
		 }
		 return count;
	}


}
