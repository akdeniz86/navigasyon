package com.navi.project.dto;

import java.util.List;

public class RouteRequestDTO {
	
	   private List<List<Double>> coordinates;

	    private List<String> extra_info;

	    private String language;

	    private RouteOptionsDTO options;

	    private String preference;

	    private String units; 
	    
	    
	    

		public RouteRequestDTO(List<List<Double>> coordinates, List<String> extra_info, String language,
				RouteOptionsDTO options, String preference, String units) {
			super();
			this.coordinates = coordinates;
			this.extra_info = extra_info;
			this.language = language;
			this.options = options;
			this.preference = preference;
			this.units = units;
		}

		public List<List<Double>> getCoordinates() {
			return coordinates;
		}

		public void setCoordinates(List<List<Double>> coordinates) {
			this.coordinates = coordinates;
		}

		public List<String> getExtra_info() {
			return extra_info;
		}

		public void setExtra_info(List<String> extra_info) {
			this.extra_info = extra_info;
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		public RouteOptionsDTO getOptions() {
			return options;
		}

		public void setOptions(RouteOptionsDTO options) {
			this.options = options;
		}

		public String getPreference() {
			return preference;
		}

		public void setPreference(String preference) {
			this.preference = preference;
		}

		public String getUnits() {
			return units;
		}

		public void setUnits(String units) {
			this.units = units;
		}

}
