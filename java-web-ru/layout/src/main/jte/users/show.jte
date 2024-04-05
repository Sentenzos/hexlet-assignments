@import exercise.dto.users.UserPage
@param UserPage user

@template.layout.page(
content = @`
        <div>
            <div>${user.getUser().getFirstName()} ${user.getUser().getLastName()}</div>
            <div>${user.getUser().getEmail()}</div>
        </div>
`
)