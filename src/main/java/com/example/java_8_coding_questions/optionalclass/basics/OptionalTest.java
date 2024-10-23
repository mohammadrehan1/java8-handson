package com.example.java_8_coding_questions.optionalclass.basics;

import com.example.java_8_coding_questions.model.BlogPost;
import com.example.java_8_coding_questions.model.BlogPostType;
import com.example.java_8_coding_questions.model.DummyResponse;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {

        //if blogpost has value then set in response
        ifObjectHasValueWhenUsingOptional();

        System.out.println();

        BlogPost blogPost = null;

        // Optional.of() method will give you NPE if we pass null object to it
        //Optional<BlogPost> optionalBlogPost = Optional.of(blogPost);// O/P: NPE

        //Optional.ofNullable() method create an Optional object that may hold a null value
        // and it won't throw any NPE while passing null object to ofNullable() method as parameter.
        Optional<BlogPost> optionalBlogPost = Optional.ofNullable(blogPost);
        
        /*if(optionalBlogPost.isPresent()){
            BlogPost blogPost1 = optionalBlogPost.get();
        }
        else {
            throw new RuntimeException("Value is null");
        }*/

        //optionalBlogPost.ifPresent(blogPostt -> System.out.println("blogpost is present"));
        //optionalBlogPost.ifPresentOrElse(blogPostt -> System.out.println("blogpost is present"), () -> System.out.println("Sorry blogpost is not present"));
        optionalBlogPost.ifPresentOrElse(blogPostt -> System.out.println("blogpost is present"), () -> {
            throw new RuntimeException("Sorry blogpost is not present");
        });


    }

    private static void ifObjectHasValueWhenUsingOptional() {
        BlogPost post = new BlogPost("Java developer","Rehan", BlogPostType.NEWS,15);

        Optional<BlogPost> blogPostOptional = Optional.ofNullable(post);
        DummyResponse response = new DummyResponse();
        blogPostOptional.ifPresent(blogPost1 -> response.setTitle(blogPost1.getTitle()));

        blogPostOptional.map(BlogPost::getAuthor).ifPresent(response::setAuthor);
        System.out.println("new response from blogpost: "+response.getAuthor()+" "+response.getTitle());

        //set whole response object example
       DummyResponse dummyResponse = new DummyResponse();
        blogPostOptional.ifPresent(blogPost -> setDummyResponse(dummyResponse,blogPost));
        System.out.println("new response set from setDummyResponse method : "+dummyResponse.getAuthor()+" "+dummyResponse.getTitle());


    }

    public static void setDummyResponse(DummyResponse response, BlogPost post){

        response.setTitle(post.getTitle());
        response.setAuthor(post.getAuthor());
    }
}
