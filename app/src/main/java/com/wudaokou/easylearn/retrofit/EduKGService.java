package com.wudaokou.easylearn.retrofit;

import com.wudaokou.easylearn.data.EntityInfo;
import com.wudaokou.easylearn.data.KnowledgeCard;
import com.wudaokou.easylearn.data.Question;
import com.wudaokou.easylearn.data.RelatedSubject;
import com.wudaokou.easylearn.data.SearchResult;
import com.wudaokou.easylearn.retrofit.entityLink.JsonEntityLink;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface EduKGService {

//    @Headers("Content-Type: application/x-www-form-urlencoded; charset=UTF-8")
    @GET("instanceList?id=e260ad16-7b00-40fc-b200-cf1da1dc7889")
    Call<JSONArray<SearchResult>> instanceList(@Query("course") String course,
                                    @Query("searchKey") String searchKey);

    @GET("infoByInstanceName?id=e260ad16-7b00-40fc-b200-cf1da1dc7889")
    Call<JSONObject<EntityInfo>> infoByInstanceName(@Query("course") String course,
                                                    @Query("name") String name);

    @GET("questionListByUriName?id=e260ad16-7b00-40fc-b200-cf1da1dc7889")
    Call<JSONArray<Question>> questionListByUriName(@Query("uriName") String uriName);

    @FormUrlEncoded
    @POST("linkInstance")
    Call<JSONObject<JsonEntityLink>> linkInstance(@Field("id") String id,
                                                  @Field("course") String course,
                                                  @Field("context") String text);

    @FormUrlEncoded
    @POST("relatedsubject")
    Call<JSONArray<RelatedSubject>> relatedSubject(@Field("id") String id,
                                                   @Field("course") String course,
                                                   @Field("subjectName") String subjectName);

    @FormUrlEncoded
    @POST("getKnowledgeCard")
    Call<JSONObject<KnowledgeCard>> getKnowledgeCard(@Field("id") String id,
                                                    @Field("course") String course,
                                                    @Field("uri") String uri);
}

