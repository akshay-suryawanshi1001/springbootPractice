package com.akshay.SpringbootPractice.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "features")
public class FeatureEndpoint {
	
	private static final Map<String, Feature> featureMap = new ConcurrentHashMap<String, Feature>();
	
	public FeatureEndpoint() {
		featureMap.put("Department", new Feature(true));
		featureMap.put("User", new Feature(false));
		featureMap.put("Authentication", new Feature(false));
		
	}
	
	@ReadOperation
	public Map<String, Feature> features(){
		return featureMap;
	}
	
	@ReadOperation
	public Feature feature(@Selector String featureName) {
		return featureMap.get(featureName);
	}
	
	private static class Feature{
		private boolean isEnabled;
		
		public Feature() {}
		public Feature(boolean isEnabled) {
			this.isEnabled = isEnabled;
		}
		public boolean isEnabled() {
			return isEnabled;
		}

		public void setEnabled(boolean isEnabled) {
			this.isEnabled = isEnabled;
		}
		
	}
	
	
}
