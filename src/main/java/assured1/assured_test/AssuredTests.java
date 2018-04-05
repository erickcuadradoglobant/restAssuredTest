package assured1.assured_test;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class AssuredTests {
	public static String uri ="https://jsonplaceholder.typicode.com/";

	public AssuredTests() {
		// TODO Auto-generated constructor stub
	}
	//public String uri = ;

	//final RequestSpecification postmethods = RestAssured.given().accept();

	// for(int i= 1; i<=100; i++) {
	//String responsepost = given().when("posts"+Integer.toString(i)).then().
	// contentType(JSON).then();
	//	String resposepost = given().
	// final Response response = RestAssured.post()accept(ContentType.JSON).get("https://jsonplaceholder.typicode.com"+"/posts/"+Integer.toString(i);
	// Assert.assertThat(response.getStatusCode(), Matchers.equalTo(200));

	//}
	//@Test
	public void responses200() {
		String uri ="https://jsonplaceholder.typicode.com/";
		Response posts = RestAssured.given().accept(ContentType.JSON).get(uri+"posts/");	    	  
		Response comments = RestAssured.given().accept(ContentType.JSON).get(uri+"comments/");
		Response albums = RestAssured.given().accept(ContentType.JSON).get(uri+"albums/");
		Response photos = RestAssured.given().accept(ContentType.JSON).get(uri+"photos/");
		Response todos = RestAssured.given().accept(ContentType.JSON).get(uri+"todos/");
		Response users = RestAssured.given().accept(ContentType.JSON).get(uri+"users/");

		System.out.println("Respuesta posts: "+ posts.getStatusCode());
		System.out.println("Respuesta: cooments "+ comments.getStatusCode());
		System.out.println("Respuesta: albums "+ albums.getStatusCode());
		System.out.println("Respuesta: photos "+ photos.getStatusCode());
		System.out.println("Respuesta: todos "+ todos.getStatusCode());
		System.out.println("Respuesta: users "+ users.getStatusCode());

		Assert.assertEquals(posts.getStatusCode(), 200); 
		Assert.assertEquals(comments.getStatusCode(), 200); 
		Assert.assertEquals(albums.getStatusCode(), 200); 
		Assert.assertEquals(photos.getStatusCode(), 200); 
		Assert.assertEquals(todos.getStatusCode(), 200); 
		Assert.assertEquals(users.getStatusCode(), 200); 

	}

	@Test
	public void schemas() {
		
		String uri ="https://jsonplaceholder.typicode.com/";
		//String resource = "C:\\Users\\erick.cuadrado\\eclipse-workspace\\exercise\\rest\\resources\\posts-schema.json";
		//Response posts = RestAssured.given().accept(ContentType.JSON).get(uri+"posts/");	
		 
		JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder().setValidationConfiguration(ValidationConfiguration.newBuilder().setDefaultVersion(SchemaVersion.DRAFTV4).freeze()).freeze();
		//Response posts = RestAssured.given().accept(ContentType.JSON).get(uri+"posts/");	    	  
		//posts.then().body(JsonSchemaValidator.matchesJsonSchema(file)).;
		System.out.println("INICIA Posts");
		RestAssured.get(uri+"posts/").then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("posts-schema.json").using(jsonSchemaFactory));
		System.out.println("INICIA comments");
		RestAssured.get(uri+"comments/").then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("comments-schema.json").using(jsonSchemaFactory));
		System.out.println("INICIA albums");
		RestAssured.get(uri+"albums/").then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("albums-schema.json").using(jsonSchemaFactory));
		System.out.println("INICIA photos");
		RestAssured.get(uri+"photos/").then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("photos-schema.json").using(jsonSchemaFactory));
		System.out.println("INICIA todos");
		RestAssured.get(uri+"todos/").then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("todos-schema.json").using(jsonSchemaFactory));
		System.out.println("INICIA users");
		RestAssured.get(uri+"users/").then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("users-schema.json").using(jsonSchemaFactory));
		System.out.println("INICIA Posts");
		
	}
	@Test
	public void specificdata() {
		int id20 =20;
		int id50 =50;
		int id100 =100;
		Information posts = new Information();
		posts.getnodo(uri, id20);
		posts.getnodo(uri, id50);
		posts.getnodo(uri, id100);
	}
	@Test
	public void comment() {
		int id = 1;
		String commentjson;
		Information commentinfo = new Information();
		commentjson = commentinfo.getInfComment(uri, id);
		System.out.println(commentjson);
	}	
	@Test
	public void user() {
		int id = 1;
		String userjson;
		Information commentinfo = new Information();
		userjson = commentinfo.getInfoUser(uri, id);
		System.out.println(userjson);
	}
	
	



}

