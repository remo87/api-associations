package com.remo.associationsapi.resolvers.association.query;

import com.graphql.spring.boot.test.GraphQLTestTemplate;
import io.micrometer.core.instrument.util.IOUtils;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;


import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MockAssociationRepository.class)
public class ApplicationResolverTests {

	private static final String GRAPHQL_QUERY_REQUEST_PATH = "graphql/resolver/query/request/%s.graphql";
	private static final String GRAPHQL_QUERY_RESPONSE_PATH = "graphql/resolver/query/response/%s.json";

	@Autowired
	GraphQLTestTemplate graphQLTestTemplate;

	@Test
	void associations_are_returned() throws IOException, JSONException {
		var testName = "get_associations";
		var graphQLResponse = graphQLTestTemplate
				.postForResource(format(GRAPHQL_QUERY_REQUEST_PATH, testName));

		var expectedResponseBody = read(format(GRAPHQL_QUERY_RESPONSE_PATH, testName));

		assertThat(graphQLResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		JSONAssert.assertEquals(expectedResponseBody, graphQLResponse.getRawResponse().getBody(), true);
	}

	@Test
	void scores_are_returned() throws IOException, JSONException {
		var testName = "get_scores_by_id";
		var graphQLResponse = graphQLTestTemplate
				.postForResource(format(GRAPHQL_QUERY_REQUEST_PATH, testName));

		var expectedResponseBody = read(format(GRAPHQL_QUERY_RESPONSE_PATH, testName));

		assertThat(graphQLResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		JSONAssert.assertEquals(expectedResponseBody, graphQLResponse.getRawResponse().getBody(), true);
	}

	private String read(String location) throws IOException {
		return IOUtils.toString(
				new ClassPathResource(location).getInputStream(), StandardCharsets.UTF_8);
	}
}
