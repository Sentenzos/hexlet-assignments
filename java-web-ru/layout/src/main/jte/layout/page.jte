@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hexlet Javalin Example</title>
</head>
<body>
<header>
    <a href="/">Главная</a>
    <a href="/users">Все пользователи</a>
</header>
<p>
    <a href="/users">Users</a>
    <a href="/courses">Courses</a>
</p>
${content}
<footer>Футер</footer>
</body>
</html>