package com.revature.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.C_Users;

@Component("userClient")
public class UserClient {
	@Autowired
	private RestTemplate restTemplate;

	private String resourceUrl;

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}


	public List<C_Users> getUsers() {
		ResponseEntity<List<C_Users>> response = this.restTemplate.exchange(this.resourceUrl + "/people/users",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<C_Users>>() {
				});
		return response.getBody();
	}
}
