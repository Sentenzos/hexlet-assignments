package exercise.dto.posts;

import java.util.List;
import exercise.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import exercise.dto.BasePage;
import lombok.Setter;

// BEGIN
@AllArgsConstructor
@Getter
public class PostsPage extends BasePage {
    List<Post> posts;
}
// END
