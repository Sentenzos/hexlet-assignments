package exercise.dto.posts;

import java.util.List;
import exercise.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


// BEGIN
@Getter
@Setter
@AllArgsConstructor
public class PostsPage {
    List<Post> posts;
    Integer currentPage;
}
// END


