package main;

import model.Comment;
import rest.CommentWebServiceClient;
import rest.UsingEasyREST;
import rest.UsingRestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fstancu on 11/9/2016.
 */

public class Main {

    public static void main(String[] args) {

//        Comment commentToBeSaved = new Comment("Florin", "stancu.florin23@gmail.com", "test from java", new Date());
//
//        CommentWebServiceClient restTemplate = new UsingRestTemplate();
//
//        System.out.println(">>>Saved object:");
//        Comment commentSaved = restTemplate.save(commentToBeSaved);
//        System.out.println(commentSaved);
//
//        commentSaved.setName("Andrei");
//        System.out.println(">>>Updated object:");
//        System.out.println(restTemplate.update(commentSaved));
//
//        System.out.println(">>>Find by id:");
//        System.out.println(restTemplate.findById(2l));
//
//        //Delete object
////        restTemplate.delete(1L);
//
//        System.out.println(">>>List--------------");
//        List<model.Comment> commentList = restTemplate.findAll();
//        for (model.Comment c : commentList) {
//            System.out.println(c);
//        }


        /*
        EasyREST
         */

        CommentWebServiceClient easyREST = new UsingEasyREST();

        Comment c1 = new Comment("Vladut", "sdfsd@gmail.com", "comm", new Date());
        System.out.println("\n\n>>>Saved object:");
        System.out.println(easyREST.save(c1));

        c1.setName("Marcel");
        c1.setId(1L);
        System.out.println(">>>Updated object:");
        System.out.println(easyREST.update(c1));

        System.out.println(">>>Find by id:");
        System.out.println(easyREST.findById(1L));

        //Delete object
 //       easyREST.delete(2L);


        System.out.println(">>>List-----------");
        List<Comment> comments = easyREST.findAll();
        for (Comment c : comments) {
            System.out.println(c);
        }
    }

}
