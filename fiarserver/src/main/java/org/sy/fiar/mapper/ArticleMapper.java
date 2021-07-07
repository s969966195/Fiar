package org.sy.fiar.mapper;

import org.apache.ibatis.annotations.Param;
import org.sy.fiar.bean.Article;

import java.util.List;

/**
 * 文章Dao
 *
 * @author SY
 * @since 2021/7/7 19:57
 */
public interface ArticleMapper {

    List<Article> getArticleByState(@Param("state") Integer state, @Param("start") Integer start, @Param("count") Integer count,
        @Param("uid") Long uid, @Param("keywords") String keywords);

    int getArticleCountByState(@Param("state") Integer state, @Param("uid") Long uid, @Param("keywords") String keywords);

    int deleteArticleById(@Param("aids") Long[] aids);

    int updateArticleState(@Param("aids") Long[] aids, @Param("state") Integer state);

    int addNewArticle(Article article);

    int updateArticle(Article article);

    Article getArticleById(Long aid);

    void pvIncrement(Long aid);

    int updateArticleStateById(@Param("articleId") Integer articleId, @Param("state") Integer state);

    List<String> getCategories(Long uid);

    List<Integer> getDataStatistics(Long uid);

    void pvStatisticsPerDay();

}
