package exercise.dto.posts;

import java.util.List;
import java.util.Map;

import exercise.model.Post;
import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// BEGIN

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EditPostPage {
    private String name;
    private String body;
    private Long id;
    private Map<String, List<ValidationError<Object>>> errors;
}
// END