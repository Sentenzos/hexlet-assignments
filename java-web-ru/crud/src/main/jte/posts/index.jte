@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
content = @`
    @for(var post : page.getPosts())
        <div>
            <a href="/posts/${post.getId()}">${post.getName()}</a>
        </div>
    @endfor
    <div>
        <a href="/posts?page=${page.getCurrentPage() - 1}">назад</a>
        ${page.getCurrentPage()}
        <a href="/posts?page=${page.getCurrentPage() + 1}">вперед</a>
    </div>
`
)