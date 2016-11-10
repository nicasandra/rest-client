package rest;

import model.Comment;
import model.Root;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import rest.CommentWebServiceClient;

import java.util.List;

/**
 * Created by fstancu on 11/9/2016.
 */

public class UsingRestTemplate implements CommentWebServiceClient {

    RestTemplate restTemplate = null;

    public UsingRestTemplate() {
        restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
        restTemplate.getMessageConverters().add(jsonHttpMessageConverter);
    }

    /**
     * http://localhost:8080/api/comment
     * <p>
     * Content-Type: application/json
     * <p>
     * {
     * "name": "Florin2",
     * "email": "stancu.florin23@gmail.com",
     * "comment": "test",
     * "date": "2016-01-02"
     * }
     *
     * @param comment
     * @return
     */
    public Comment save(Comment comment) {
        Comment c = restTemplate.postForObject("http://localhost:8080/rest/comment", comment, Comment.class);
        return LinkParser.findId(c);
    }

    public Comment update(Comment comment) {
        restTemplate.put("http://localhost:8080/rest/comment/" + comment.getId(), comment, Comment.class);
        return comment;
    }

    /**
     * http://localhost:8080/api/comment/4
     *
     * @param commentId
     * @return
     */

    public Comment findById(Long commentId) {
        RestTemplate restTemplate = new RestTemplate();
        Comment c = restTemplate.getForObject("http://localhost:8080/rest/comment/" + commentId, Comment.class);
        return LinkParser.findId(c);
    }

    public List<Comment> findAll() {
        Root embedded = restTemplate.getForObject("http://localhost:8080/rest/comment/", Root.class);
        return embedded.get_embedded().getComment();
    }

    public void delete(Long commentId) {
        restTemplate.delete("http://localhost:8080/rest/comment/" + commentId, Comment.class);
    }

}
