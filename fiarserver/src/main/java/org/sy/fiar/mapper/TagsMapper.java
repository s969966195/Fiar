package org.sy.fiar.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 标签Dao
 *
 * @author SY
 * @since 2021/7/7 23:14
 */
public interface TagsMapper {

    int deleteTagsByAid(Long aid);

    int saveTags(@Param("tags") String[] tags);

    List<Long> getTagsIdByTagName(@Param("tagNames") String[] tagNames);

    int saveTags2ArticleTags(@Param("tagIds") List<Long> tagIds, @Param("aid") Long aid);

}
