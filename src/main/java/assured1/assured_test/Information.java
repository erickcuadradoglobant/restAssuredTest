package assured1.assured_test;

import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Information {
	
	public void getnodo(String uri, int id) {		
		if (id==20) {
			Datos nodo20 = new Datos(2, 20, "doloribus ad provident suscipit at", "qui consequuntur ducimus possimus quisquam amet similique\nsuscipit porro ipsam amet\neos veritatis officiis exercitationem vel fugit aut necessitatibus totam\nomnis rerum consequatur expedita quidem cumque explicabo");
			RestAssured.given()
			.pathParam("id", id)
			.get(uri+"posts/"+"{id}").then()
			.body("title", equalTo(nodo20.getTitle()))
			.body("userId",equalTo(nodo20.getUserId()) )
			.body("body" ,equalTo(nodo20.getBody()));
		
			//return nodo20;
		}
		else if (id==50) {
			Datos nodo50 = new Datos(5,
					50,
					"repellendus qui recusandae incidunt voluptates tenetur qui omnis exercitationem", 
					"error suscipit maxime adipisci consequuntur recusandae\nvoluptas eligendi et est et voluptates\nquia distinctio ab amet quaerat molestiae et vitae\nadipisci impedit sequi nesciunt quis consectetur");
			RestAssured.given()
			.pathParam("id", id)
			.get(uri+"posts/"+"{id}").then()
			.body("title", equalTo(nodo50.getTitle()))
			.body("userId",equalTo(nodo50.getUserId()) )
			.body("body" ,equalTo(nodo50.getBody()));
			//return nodo50;
		}else if (id==100) {
			Datos nodo100 = new Datos(10, 100, "at nam consequatur ea labore ea harum", "cupiditate quo est a modi nesciunt soluta\nipsa voluptas error itaque dicta in\nautem qui minus magnam et distinctio eum\naccusamus ratione error aut");
			RestAssured.given()
			.pathParam("id", id)
			.get(uri+"posts/"+"{id}").then()
			.body("title", equalTo(nodo100.getTitle()))
			.body("userId",equalTo(nodo100.getUserId()) )
			.body("body" ,equalTo(nodo100.getBody()));
			//return nodo100;
		}
		//return null;
	}
	public String getInfComment(String uri, int id) {
		String infoComment = null;
		System.out.println(uri+"comments?postId="+id);
		infoComment = RestAssured.given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).when().param("postId", id).get(uri+"comments?postId"+id).then().contentType(ContentType.JSON).extract().response().asString();
		//RestAssured.given().contentType(ContentType.JSON).when().param("id", id).get(uri+"comments?postId="+id).then().log().body();
		return infoComment;
	}
	
	public String getInfoUser(String uri, int id) {
		String infoUser = null;
		System.out.println(uri+"posts?userId="+id);
		infoUser = RestAssured.given().contentType(ContentType.JSON).when().param("userId", id).get(uri+"posts?userId"+id).then().extract().response().asString();
		//RestAssured.given().contentType(ContentType.JSON).when().param("id", id).get(uri+"posts?userId="+id).then().log().body();
		return infoUser;
	}
}
