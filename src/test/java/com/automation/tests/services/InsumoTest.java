package com.automation.tests.services;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.models.Insumo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class InsumoTest {
	
	private Insumo insumo = new  Insumo(10, "notebook", 10);
	
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
		assertEquals(json.getInt("products[1].id"), 2);
		assertEquals(json.getString("products[1].nombre"), "CPU");
		assertEquals(json.getInt("products[1].cantidad"), 3);
	}
	
	@Test
	public void getByIdUsingPathParam() {
		
		Response response = RestAssured.given().log().all()
				.pathParam("productId", "3").get("/{productId}");
		response.prettyPrint();
		assertEquals(response.statusCode(), 200);
		JsonPath json = response.jsonPath();
		assertNotNull(json.get(), "El recurso no es nulo");
		assertEquals(json.getInt("id"), 3);
		assertEquals(json.getString("nombre"), "teclado");
		assertEquals(json.getInt("cantidad"), 20);
	}
	
	@Test
	public void addProduct() {
		
		Response response = RestAssured.given().log().all()
				.contentType(ContentType.JSON).body(insumo).post();
		response.prettyPrint();
		assertEquals(response.statusCode(), 201);
		JsonPath json = response.jsonPath();

		assertEquals(json.getString("message"), "El producto se ha recibido");
	}
	
	@Test()
	public void getByIdUsingQueryParam() {
		
		Response response = RestAssured.given().log().all()
				.queryParam("productId", insumo.getId()).get();
		response.prettyPrint();
		assertEquals(response.statusCode(), 200);
		JsonPath json = response.jsonPath();
		assertNotNull(json.get(), "El recurso no es nulo");
		assertEquals(json.getInt("id"), insumo.getId());
		assertEquals(json.getString("nombre"), insumo.getNombre());
		assertEquals(json.getInt("cantidad"), insumo.getCantidad());
		
	}
	
	@Test()
	public void deleteProduct(){
		Response response = RestAssured.given().log().all()
				.pathParam("id", insumo.getId())
				.delete("/{id}");
		response.prettyPrint();
		assertEquals(response.statusCode(), 200);
		JsonPath json = response.jsonPath();
		assertEquals(json.getString("message"), "El producto ha sido eliminado exitosamente.");
	}
}
