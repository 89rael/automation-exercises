package com.automation.tests.services;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.models.Product;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.assertion.AssertionSupport;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestAssuredTest {

	
		private Product product = new Product(666, "the number of the beast", 1);
		 
		@BeforeMethod
		public void setUp() {
			
			RestAssured.baseURI="http://127.0.0.1";
			RestAssured.port=3000;
			RestAssured.basePath="api/product";
			
		}
		
		@Test
		public void getAll() {
			
			Response response = RestAssured.given().log().all().get();
			response.prettyPrint();
			assertEquals(response.statusCode(), 200);
			JsonPath json = response.jsonPath();
			assertFalse(json.getList("products").isEmpty(), "La lista de productos está vacía");
			assertEquals(json.getInt("products[0].id"), 1);
			assertEquals(json.getString("products[0].nombre"), "monitor");
			assertEquals(json.getInt("products[0].cantidad"), 12);
		}
	
		@Test
		public void getByIdUsingPathParam() {
			
			Response response = RestAssured.given().log().all()
					.pathParam("productId", "1").get("/{productId}");
			response.prettyPrint();
			assertEquals(response.statusCode(), 200);
			JsonPath json = response.jsonPath();
			assertNotNull(json.get(), "El recurso no es nulo");
			assertEquals(json.getInt("id"), 1);
			assertEquals(json.getString("nombre"), "monitor");
			assertEquals(json.getInt("cantidad"), 12);
			
			
		}
		
		@Test(dependsOnMethods="addProduct")
		public void getByIdUsingQueryParam() {
			
			Response response = RestAssured.given().log().all()
					.queryParam("productId", product.getId()).get();
			response.prettyPrint();
			assertEquals(response.statusCode(), 200);
			JsonPath json = response.jsonPath();
			assertNotNull(json.get(), "El recurso no es nulo");
			assertEquals(json.getInt("id"), product.getId());
			assertEquals(json.getString("nombre"), product.getNombre());
			assertEquals(json.getInt("cantidad"), product.getCantidad());
			
		}
		
		@Test
		public void addProduct() {
			
			Response response = RestAssured.given().log().all()
					.contentType(ContentType.JSON).body(product).post();
			response.prettyPrint();
			assertEquals(response.statusCode(), 201);
			JsonPath json = response.jsonPath();

			assertEquals(json.getString("message"), "El producto se ha recibido");
		}
		
		@Test(dependsOnMethods = "getByIdUsingQueryParam")
		public void deleteProduct(){
			Response response = RestAssured.given().log().all()
					.pathParam("id", product.getId())
					.delete("/{id}");
			response.prettyPrint();
			assertEquals(response.statusCode(), 200);
			JsonPath json = response.jsonPath();
			assertEquals(json.getString("message"), "El producto ha sido eliminado exitosamente.");
		}

}
