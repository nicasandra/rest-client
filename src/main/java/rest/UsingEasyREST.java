package rest;

import model.Comment;
import model.Root;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicasandra on 11/10/2016.
 */
public class UsingEasyREST implements CommentWebServiceClient {

    ResteasyClient client = null;

    public UsingEasyREST() {
        client = new ResteasyClientBuilder().build();
    }

    public Comment save(Comment comment) {
        ResteasyWebTarget webTarget = client.target("http://localhost:8080/rest/comment/");
        Response resp = webTarget.request().post(Entity.entity(comment, "application/json"));
        if (resp.getStatus() == 201) {
            resp.close();
            return comment;
        }
        return null;

    }

    public Comment update(Comment comment) {
        ResteasyWebTarget webTarget = client.target("http://localhost:8080/rest/comment/" + comment.getId());
        Response resp = webTarget.request().put(Entity.entity(comment, "application/json"));

        if (resp.getStatus() == 204) {
            resp.close();
            return comment;
        }

        return null;
    }

    public Comment findById(Long commentId) {
        ResteasyWebTarget webTarget = client.target("http://localhost:8080/rest/comment/" + commentId);
        Response resp = webTarget.request().get();

        Comment value = resp.readEntity(Comment.class);
        resp.close();

        return value;
    }

    public List<Comment> findAll() {
        ResteasyWebTarget getDummy = client.target("http://localhost:8080/rest/comment/");
        Response resp = getDummy.request().get();

        List<Comment> values = resp.readEntity(Root.class).get_embedded().getComment();
        resp.close();

        return values;
    }

    public void delete(Long commentId) {
        ResteasyWebTarget getDummy = client.target("http://localhost:8080/rest/comment/" + commentId);
        Response resp = getDummy.request().delete();

        resp.close();
    }
}
