package main;

import model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Tomi on 10/26/2018.
 */
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/articles")
    public List<Article> getAllArticles(){
        return articleService.getAllArtilces();
    }

    @RequestMapping("/articles/{id}")
    public Article getArticle(@PathVariable String id){
        return articleService.getArticle(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/articles")
    public void addArticle(@RequestBody Article article){
        articleService.addArticle(article);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/articles/{id}")
    public void updateArticle(@RequestBody Article article, @PathVariable String id){
        articleService.updateArticle(article, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/articles/{id}")
    public void deleteArticle(@PathVariable String id){
        articleService.deleteArticle(id);
    }
}