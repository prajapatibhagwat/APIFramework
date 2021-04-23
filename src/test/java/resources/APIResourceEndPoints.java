package resources;

/**
 * Enum is a special class in java which has collection of constants or methods
 * 
 * @author M1043004
 *
 */
public enum APIResourceEndPoints {

	AddPlaceAPI("/maps/api/place/add/json"), 
	getPlaceAPI("/maps/api/place/get/json"), 
	deletePlaceAPI("/maps/api/place/delete/json");

	private String resource;

	private APIResourceEndPoints(String resource) {
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}
	
	/**
	 * 
	 * How to use as generics 
	 * constructor will be called with value of resource which you pass
	 * APIResources resources = APIResources.valueOf(APIName)
	 * resource.getResource()
	 */
}
