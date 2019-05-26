import java.util.*;

public class Hobbies {
    
    private final HashMap<String, String[]> hobbies = new HashMap<String, String[]>();
    
    public void add(String hobbyist, String... hobbies) {
        this.hobbies.put(hobbyist, hobbies);
    }
    
    public List<String> findHobbyists(String hobby) {
    	List<String> resultList = new ArrayList<>();
        try {
        	Set<String> keySet = hobbies.keySet();
        	
        	for(String key : keySet) {
        		String[] hobbiesList = hobbies.get(key);
        		for(String values : hobbiesList) {
        			if(values.contains(hobby)) {
        				resultList.add(key);
        			}
        		}
        	}
        } catch (Exception e) {
			// TODO: handle exception
        	throw new UnsupportedOperationException("Waiting to be implemented.");
		}
		return resultList;
    	
    }
    
    public static void main(String[] args) {
        Hobbies hobbies = new Hobbies();
        hobbies.add("John", "Piano", "Puzzles", "Yoga");
        hobbies.add("Adam", "Drama", "Fashion", "Pets");
        hobbies.add("Mary", "Magic", "Pets", "Reading");
        
        System.out.println(Arrays.toString(hobbies.findHobbyists("Yoga").toArray()));
    }
}