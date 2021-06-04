package travelPortal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Proposal {
	private String code;
	private TravelAgency agency;
	private String destination;
	private int month;
	private int dayFirst, dayLast;
	private int minNP, maxNP;
	private int travelPrice;
	private List<Activity> activities = new ArrayList<>();

	Proposal(String code, TravelAgency agency, String destination, String period, int minNP, int maxNP, int travelPrice) {
		this.code = code;
		this.agency = agency;
		this.destination = destination;
		this.minNP = minNP;
		this.maxNP = maxNP;
		this.travelPrice = travelPrice;

		String[] elements = period.split(":");
		String[] days = elements[1].split("-");
		this.month = Integer.parseInt(elements[0]);
		this.dayFirst = Integer.parseInt(days[0]);
		this.dayLast = Integer.parseInt(days[1]);
	}

	int getMonth() {
		return month;
	}

	int getNumberOfDays() {
		return dayLast - dayFirst;
	}

	void setAgency(TravelAgency agency) {
		this.agency = agency;
	}

	String getCode() {
		return code;
	}

	String getDestination() {
		return destination;
	}

	void setDestination(String destination) {
		this.destination = destination;
	}

	String getPeriod() {
		return String.format("%d:%d-%d", month, dayFirst, dayLast);
	}

	int getMinNP() {
		return minNP;
	}

	void setMinNP(int minNP) {
		this.minNP = minNP;
	}

	int getMaxNP() {
		return maxNP;
	}

	void setMaxNP(int maxNP) {
		this.maxNP = maxNP;
	}

	int getTravelPrice() {
		return travelPrice;
	}

	void setTravelPrice(int travelPrice) {
		this.travelPrice = travelPrice;
	}

	TravelAgency getAgency() {
		return agency;
	}

	int addActivity(String activityType, String description, int price) throws TPException {
		if (!agency.offerActivity(activityType))
			throw new TPException("Activity '" + activityType + "' is not offered by " + code);
		Activity activity = new Activity(activityType, description, price);
		activities.add(activity);
		return getActivitiesPrice();
	}
	
	int getActivitiesPrice() {
		return activities.stream().collect(Collectors.summingInt(Activity::getPrice));
	}
	
	int getTotalPrice() {
		return getTravelPrice() + getActivitiesPrice();
	}

}
