package de.marhan.patch.controller.common;

import org.springframework.http.MediaType;

import java.util.Map;



public class RestMediaType extends MediaType {

	public static final RestMediaType APPLICATION_MERGE_PATCH_JSON;

	public static final String APPLICATION_MERGE_PATCH_JSON_VALUE = "application/merge-patch+json";

	static {
		APPLICATION_MERGE_PATCH_JSON = new RestMediaType(valueOf(APPLICATION_MERGE_PATCH_JSON_VALUE));
	}


	public RestMediaType(MediaType type) {
		super(type, (Map<String, String>)null);

	}
}