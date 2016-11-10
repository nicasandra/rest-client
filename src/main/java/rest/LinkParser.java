package rest;

import model.Comment;

/**
 * Created by nicasandra on 11/10/2016.
 */
public class LinkParser {
    static CommentWebServiceClient client = new UsingRestTemplate();

    public LinkParser() {
    }

    public static Comment findId(Comment c) {
        String link = c.get_links().getSelf().getHref();
        String[] values = link.split("/");
        c.setId(Long.parseLong(values[values.length - 1]));
        return c;
    }
}
