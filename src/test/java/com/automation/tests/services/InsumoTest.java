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
	
	private Insumo insumo = new  Insumo(10, "Cinta", 10);
	
	@BeforeMethod
	public void setUp() {
		
		RestAssured.baseURI="http://127.0.0.1";
		RestAssured.port=3000;
		RestAssured.basePath="api/insumo";
		
	}
	
	@Test
	public void getAll() {
		
		Response response = RestAssured.given().log().all().get();
		response.prettyPrint();
		assertEquals(response.statusCode(), 200);
		JsonPath json = response.jsonPath();
		assertFalse(json.getList("insumos").isEmpty(), "La lista de insumos está vacía");
		assertEquals(json.getInt("insumos[1].id"), 2);
		assertEquals(json.getString("insumos[1].nombre"), "papel A4");
		assertEquals(json.getInt("insumos[1].cantidad"), 5);
	}
	
	@Test
	public void getByIdUsingPathParam() {
		
		Response response = RestAssured.given().log().all()
				.pathParam("insumoId", "3").get("/{insumoId}");
		response.prettyPrint();
		assertEquals(response.statusCode(), 200);
		JsonPath json = response.jsonPath();
		assertNotNull(json.get(), "Insumo no encontrado");
	}
	
	@Test
	public void addInsumo() {
		
		Response response = RestAssured.given().log().all()
				.contentType(ContentType.JSON).body(insumo).post();
		response.prettyPrint();
		assertEquals(response.statusCode(), 201);
		JsonPath json = response.jsonPath();

		assertEquals(json.getString("mensaje"), "El insumo se ha agregado");
	}
	
	@Test()
	public void getByIdUsingQueryParam() {
		
		Response response = RestAssured.given().log().all()
				.queryParam("id", insumo.getId()).get();
		response.prettyPrint();
		assertEquals(response.statusCode(), 200);
		JsonPath json = response.jsonPath();
		assertNotNull(json.get(), "El recurso no es nulo");
		assertEquals(json.getInt("id"), 10);
		assertEquals(json.getString("nombre"), insumo.getNombre());
		assertEquals(json.getInt("cantidad"), insumo.getCantidad());
		
	}
	
	@Test()
	public void deleteInsumo(){
		Response response = RestAssured.given().log().all()
				.pathParam("id", insumo.getId())
				.delete("/{id}");
		response.prettyPrint();
		assertEquals(response.statusCode(), 200);
		JsonPath json = response.jsonPath();
		assertEquals(json.getString("message"), "El insumo ha sido eliminado exitosamente.");
	}
}
