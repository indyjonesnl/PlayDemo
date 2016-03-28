package controllers;

import models.Product;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import views.html.*;

import java.util.ArrayList;
import java.util.List;
import com.avaje.ebean.Model;

import javax.inject.Inject;

import static play.libs.Json.toJson;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    @Inject
    private FormFactory formFactory;

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Index"));
    }

    public Result addProduct() {
        Form<Product> userForm = formFactory.form(Product.class);
        Product product = userForm.bindFromRequest().get();
        product.save();
        //return ok("Product: " + product.name); // DEBUG
        return redirect(routes.HomeController.index());
    }

    public Result getProducts() {
        Model.Finder<Integer, Product> finder = new Model.Finder<>(Product.class);
        List<Product> products = finder.all();
        return ok(toJson(products));
    }
}
