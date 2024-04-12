package exercise.controller;

import io.javalin.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) {
        var firstName = ctx.formParam("firstName");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email").trim().toLowerCase();
        var password = Security.encrypt(ctx.formParam("password"));
        var token = Security.generateToken();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(firstName);
        System.out.println(lastName);
        var user = new User(
                StringUtils.capitalize(firstName),
                StringUtils.capitalize(lastName),
                email, password, token);

        UserRepository.save(user);

        ctx.status(302);
        ctx.redirect(NamedRoutes.userPath(user.getId()));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var userOptional = UserRepository.find(id);

        if (userOptional.isPresent()) {
            var page = new UserPage(userOptional.get());
            ctx.render("users/show.jte", model("page", page));
        } else {
            ctx.status(300);
            ctx.redirect(NamedRoutes.buildUserPath());
        }
        if (UserRepository.getEntities().size() >= 2) UserRepository.clear();
    }
    // END
}
