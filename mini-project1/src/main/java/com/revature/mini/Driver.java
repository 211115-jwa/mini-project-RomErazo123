package com.revature.mini;

import java.util.ArrayList;
import java.util.List;

import io.javalin.Javalin;

public class Driver {

	// Fields

	static List <Employee> coll = new ArrayList <Employee>();
	public static void main(String[] args) {	// Main method
		
		
		Javalin app = Javalin.create();			// Creating javalin object
		app.start();							// Starting the javalin
		
		app.post("/Collection", ctx -> {
			Employee yee = new Employee();
			
			//yee.arrayList.add(ctx.formParam("first"));
			
			yee.first =(ctx.formParam("first"));
			yee.last =(ctx.formParam("last"));
			yee.description = (ctx.formParam("description"));
			yee.money = Double.parseDouble(ctx.formParam("money"));
			yee.position = (ctx.formParam("position"));
			coll.add(yee);
			
			String response = "";
			
			for (Employee each : coll) {
				System.out.println(coll.toString());
					response += each.first + " " + 
							each.last + " " + " " +
							each.description + " " +
							each.money + " " + 
							each.position + "<br>";
			}
			
			ctx.html(response);
		});
	}
}
