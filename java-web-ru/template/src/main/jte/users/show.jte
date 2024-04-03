@import exercise.dto.users.UserPage
@param UserPage user

<html lang="en">
<head>
    <title></title>
</head>
<body>
    <div>
        <p>${user.getUser().getFirstName()} ${user.getUser().getLastName()}</p>
        <p>${user.getUser().getEmail()}</p>
    </div>
</body>
</html>