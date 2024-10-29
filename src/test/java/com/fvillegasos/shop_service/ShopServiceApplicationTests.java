package com.fvillegasos.shop_service;

import com.fvillegasos.shopservice.model.ProductPriceInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ShopServiceApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void when_getProductPriceEndpoint_thenReturn_200_Test1() {
		var response = restTemplate.exchange(getHostAndEndpoint(),
				HttpMethod.GET,
				getHttpEntity(),
				ProductPriceInfo.class,
				35455, 1, "2020-06-14T10:00:00Z");

		Assertions.assertAll(
				() -> Assertions.assertNotNull(response),
				() -> Assertions.assertEquals(HttpStatus.OK, response.getStatusCode()),
				() -> Assertions.assertNotNull(response.getBody()),
				() -> Assertions.assertEquals(35.50, response.getBody().getPrice())
		);
	}

	@Test
	void when_getProductPriceEndpoint_thenReturn_200_Test2() {
		var response = restTemplate.exchange(getHostAndEndpoint(),
				HttpMethod.GET,
				getHttpEntity(),
				ProductPriceInfo.class,
				35455, 1, "2020-06-14T16:00:00Z");

		Assertions.assertAll(
				() -> Assertions.assertNotNull(response),
				() -> Assertions.assertEquals(HttpStatus.OK, response.getStatusCode()),
				() -> Assertions.assertNotNull(response.getBody()),
				() -> Assertions.assertEquals(25.45, response.getBody().getPrice())
		);
	}

	@Test
	void when_getProductPriceEndpoint_thenReturn_200_Test3() {
		var response = restTemplate.exchange(getHostAndEndpoint(),
				HttpMethod.GET,
				getHttpEntity(),
				ProductPriceInfo.class,
				35455, 1, "2020-06-14T21:00:00Z");

		Assertions.assertAll(
				() -> Assertions.assertNotNull(response),
				() -> Assertions.assertEquals(HttpStatus.OK, response.getStatusCode()),
				() -> Assertions.assertNotNull(response.getBody()),
				() -> Assertions.assertEquals(35.50, response.getBody().getPrice())
		);
	}

	@Test
	void when_getProductPriceEndpoint_thenReturn_200_Test4() {
		var response = restTemplate.exchange(getHostAndEndpoint(),
				HttpMethod.GET,
				getHttpEntity(),
				ProductPriceInfo.class,
				35455, 1, "2020-06-15T10:00:00Z");

		Assertions.assertAll(
				() -> Assertions.assertNotNull(response),
				() -> Assertions.assertEquals(HttpStatus.OK, response.getStatusCode()),
				() -> Assertions.assertNotNull(response.getBody()),
				() -> Assertions.assertEquals(30.50, response.getBody().getPrice())
		);
	}

	@Test
	void when_getProductPriceEndpoint_thenReturn_200_Test5() {
		var response = restTemplate.exchange(getHostAndEndpoint(),
				HttpMethod.GET,
				getHttpEntity(),
				ProductPriceInfo.class,
				35455, 1, "2020-06-16T21:00:00Z");

		Assertions.assertAll(
				() -> Assertions.assertNotNull(response),
				() -> Assertions.assertEquals(HttpStatus.OK, response.getStatusCode()),
				() -> Assertions.assertNotNull(response.getBody()),
				() -> Assertions.assertEquals(38.95, response.getBody().getPrice())
		);
	}

	private String getHostAndEndpoint() {
		return "http://localhost:" + port + "/product/price?productId={productId}&brandId={brandId}&applicationDate={applicationDate}";
	}

	private HttpEntity<?> getHttpEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}

}
