package rest;

import model.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicasandra on 11/10/2016.
 */
public class LinkParser {
    static CommentWebServiceClient client = new UsingRestTemplate();

    public LinkParser() {
    }

    public static Comment setId(Comment c) {
        String link = c.get_links().getSelf().getHref();
        String[] values = link.split("/");
        c.setId(Long.parseLong(values[values.length - 1]));
        return c;
    }

    public static List<Comment> setIdList(List<Comment> cList) {
        for (Comment c : cList) {
            setId(c);
        }
        return cList;
    }
}