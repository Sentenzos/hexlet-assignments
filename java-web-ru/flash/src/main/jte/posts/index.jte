@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
page = page,
content = @`
    @if(page.getFlash() != null)
        <div>${page.getFlash()}</div>
    @endif
    <div>
        @if(page.getPosts() != null)
            @for (var post: page.getPosts())
                <div>
                    <h3>${post.getName()}</h3>
                    <p>${post.getBody()}</p>
                </div>
                <br>
             @endfor
        @endif
    </div>
`
)