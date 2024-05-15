package exercise.controller.users;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@SpringBootApplication
@RestController
public class PostsController {
    private List<Post> posts = Data.getPosts();

    @GetMapping("/api/users/{id}/posts")
    public ResponseEntity<List<Post>> show(@PathVariable String id) {
        var res = posts.stream()
                .filter(p -> String.valueOf(p.getUserId()).equals(id)).toList();

        return ResponseEntity.ok().body(res);
    }

    @PostMapping("/api/users/{id}/posts")
    public ResponseEntity<Post> create(@PathVariable String id, @RequestBody Post data) {
        var post = new Post();
        post.setTitle(data.getTitle());
        post.setBody(data.getBody());
        post.setSlug(data.getSlug());
        post.setUserId(Integer.parseInt(id));
        posts.add(post);

        return ResponseEntity.status(201).body(post);
    }
}
// END
