package travelPortal;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class TravelAgency {
	private String name;
	private Set<String> activities = new HashSet<>();

	TravelAgency(String name) {
		this.name = name;
	}
	
	void addActivity(String activity) {
		activities.add(activity);
	}
	
	List<String> getActivities() {
		return activities.stream().sorted().collect(Collectors.toList());
	}
	
	String getName() {
		return name;
	}
	
	boolean offerActivity(String activity) {
		return activities.contains(activity);
	}
}
