package travelPortal;

class Activity {
	private String activityType;
	private String description;
	int price;

	Activity(String activityType, String description, int price) {
		this.activityType = activityType;
		this.description = description;
		this.price = price;
	}

	String getActivityType() {
		return activityType;
	}

	void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	String getDescription() {
		return description;
	}

	void setDescription(String description) {
		this.description = description;
	}

	int getPrice() {
		return price;
	}

	void setPrice(int price) {
		this.price = price;
	}	
}
