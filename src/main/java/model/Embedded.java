package model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by nicasandra on 11/10/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Embedded {
    private List<Comment> comment;

    public Embedded() {
    }

    public Embedded(List<Comment> comment) {
        this.comment = comment;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "model.model.Embedded{" +
                "comment=" + comment +
                '}';
    }
}
