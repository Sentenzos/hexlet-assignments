package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;

public class SessionsController {

    // BEGIN
    public static void index(Context ctx) {
        var page = new MainPage(ctx.sessionAttribute("name"));
        ctx.render("posts/index.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new LoginPage(null, null);
        ctx.render("posts/build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        try {
            var name = ctx.formParamAsClass("name", String.class)
                    .check(value -> UsersRepository.findByName(value) != null, "Ошибка")
                    .get();
            ctx.formParamAsClass("password", String.class)
                    .check(value -> UsersRepository.findByName(name).getPassword().equals(encrypt(value)), "Ошибка")
                    .get();

            ctx.sessionAttribute("name", name);

            ctx.status(302);
            ctx.redirect("/");
        } catch (ValidationException e) {
            var name = ctx.formParam("name");
            var page = new LoginPage(name, "Ошибка");
            ctx.render("posts/build.jte", model("page", page)).status(422);
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("name", null);

        ctx.status(302);
        ctx.redirect("/");
    }
    // END
}
