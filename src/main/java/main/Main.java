package main;

import model.Comment;
import rest.CommentWebServiceClient;
import rest.LinkParser;
import rest.UsingEasyREST;
import rest.UsingRestTemplate;

import java.util.Date;

/**
 * Created by fstancu on 11/9/2016.
 */

public class Main {

    public static void main(String[] args) {

//        model.Comment commentToBeSaved = new model.Comment("Florin", "stancu.florin23@gmail.com", "test from java", new Date());
//
//        rest.CommentWebServiceClient service = new rest.UsingRestTemplate();
//
//        model.Comment commentSaved = service.save(commentToBeSaved);
//        commentSaved.setName("Andrei");
//        service.update(commentSaved);
//
//        System.out.println(commentSaved);
//
//        model.Comment commentWithId4 = service.findById(1l);
//
//        System.out.println(commentWithId4);
//
//        service.delete(7L);
//
//        System.out.println("list--------------");
//
//        List<model.Comment> commentList = new ArrayList<model.Comment>();
//        commentList = service.findAll();
//        for (model.Comment c : commentList) {
//            System.out.println(c);
//        }


        /////////////////////////

        CommentWebServiceClient client1 = new UsingRestTemplate();
        CommentWebServiceClient client2 = new UsingEasyREST();
        //  Comment c = client.findById(2L);

        Comment c1 = new Comment("Handrei", "sdfsd@gmail.com", "comm", new Date());
        // c1.setId(3L);
        // System.out.println(client.update(c1));
        System.out.println(client1.save(c1));
        System.out.println(client1.findById(1L));

        // System.out.println(LinkParser.findId(3L));

//        List<Comment> commentList = new ArrayList<Comment>();
//        commentList = client.findAll();
//        for (model.Comment c : commentList) {
//            System.out.println(c);
//        }

        //    client.delete(6L);
        //    client.delete(7L);
        //  client.delete(10L);
        //   LinkParser l = new LinkParser();
        //   System.out.println(l.findById(2L).toString());

        //    System.out.println(client.findById(2L).get_links().getSelf().getHref());
    }

}
