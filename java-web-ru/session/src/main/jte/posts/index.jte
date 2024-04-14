@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
content = @`
    <main>
        <h1>Привет, Хекслет!</h1>
        @if(page.getName() == null)
            <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
        @else
            <div>${page.getName().toString()}</div>
            <form action="${NamedRoutes.logoutPath()}" method="post">
                <input type="submit" class="btn btn-primary" value="Выйти" />
            </form>
        @endif
    </main>
`
)
