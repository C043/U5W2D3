package fragnito.U5W2D3.services;

import fragnito.U5W2D3.entities.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostsService {
    private final List<BlogPost> blogPostList = new ArrayList<>();

    public List<BlogPost> findBlogPosts(){
        return this.blogPostList;
    }

    public BlogPost getBlogPostById(int postId){
        return this.blogPostList.stream().filter(post -> post.getId() == postId).findFirst().orElseThrow();
    }

    public BlogPost saveBlogPost(BlogPost body){
        Random rand = new Random();
        body.setId(rand.nextInt(1, 1000));
        body.setCover("https://picsum.photos/200/300");
        body.setTempoDiLettura(rand.nextInt(3, 10));
        this.blogPostList.add(body);
        return body;
    }

    public BlogPost updateBlogPost(int postId, BlogPost updatedBlogPost){
        BlogPost found = this.getBlogPostById(postId);
        found.setCover(updatedBlogPost.getCover());
        found.setTitolo(updatedBlogPost.getTitolo());
        found.setContenuto(updatedBlogPost.getContenuto());
        found.setTempoDiLettura(updatedBlogPost.getTempoDiLettura());
        found.setCategoria(updatedBlogPost.getCategoria());
        return found;
    }

    public void deleteBlogPost(int postId){
        BlogPost found = this.getBlogPostById(postId);
        this.blogPostList.remove(found);
    }
}
