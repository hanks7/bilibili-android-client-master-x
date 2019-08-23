package com.hotbitmapgg.bilibili.network.api;

import com.hotbitmapgg.bilibili.entity.attention.AttentionDynamicInfo;
import com.hotbitmapgg.bilibili.entity.bangumi.BangumiDetailsCommentInfo;
import com.hotbitmapgg.bilibili.entity.bangumi.SpecialTopic;
import com.hotbitmapgg.bilibili.entity.bangumi.SpecialTopicIResult;
import com.hotbitmapgg.bilibili.entity.discover.ActivityCenterInfo;
import com.hotbitmapgg.bilibili.entity.discover.TopicCenterInfo;
import com.hotbitmapgg.bilibili.entity.video.VideoCommentInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcc on 16/8/8 21:08
 * 100332338@qq.com
 */
public interface BiliApiService {

    /**
     * 视频评论
     */
    @GET("feedback")
    Observable<VideoCommentInfo> getVideoComment(@Query("aid") int aid, @Query("page") int page, @Query("pagesize") int pageSize, @Query("ver") int ver);

    /**
     * 专题详情
     */
    @GET("sp")
    Observable<SpecialTopic> getSpInfo(@Query("spid") int spid, @Query("title") String title);

    /**
     * 专题视频
     */
    @GET("spview")
    Observable<SpecialTopicIResult> getSpItemList(@Query("spid") int spid, @Query("season_id") int season_id, @Query("bangumi") int bangumi);

    /**
     * 话题中心
     */
    @GET("topic/getlist?device=phone&mobi_app=iphone&page=1&pagesize=137")
    Observable<TopicCenterInfo> getTopicCenterList();

    /**
     * 话题中心
     */
    @GET("event/getlist?device=phone&mobi_app=iphone")
    Observable<ActivityCenterInfo> getActivityCenterList(@Query("page") int page, @Query("pagesize") int pageSize);


    /**
     * 首页关注
     */
    @GET("x/feed/pull?_device=android&_hwid=8a326709e1bcf955&_ulv=10000&access_key=d28935de4660236588ca04bd4c4dc281&appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&pn=1&ps=20&type=0&sign=e40f746ab0c288ca9446d3da9969594c")
    Observable<AttentionDynamicInfo> getAttentionDynamic();

    /**
     * 番剧详情评论
     */
    @GET("x/v2/reply?_device=iphone&_hwid=c84c067f8d99f9d3&_ulv=10000&access_key=19946e1ef3b5cad1a756c475a67185bb&appkey=27eb53fc9058f8c3&appver=3940&build=3940&nohot=0&oid=5189987&platform=ios&pn=1&ps=20&sign=c3b059e907f5c1d3416daa9fcc6396bf&sort=0&type=1")
    Observable<BangumiDetailsCommentInfo> getBangumiDetailsComments();
}
