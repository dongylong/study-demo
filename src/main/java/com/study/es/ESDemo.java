package com.study.es;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpHost;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.alias.Alias;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019/12/6 15:49
 * @changeRecord
 */
public class ESDemo {
    public static void main(String[] args) {
        // 1. 初始化
        RestHighLevelClient client = getClient();
        try {
            IndexResponse indexResponse = insertUser(client);
            String id = indexResponse.getId();
            DocWriteResponse.Result result = indexResponse.getResult();
            search(client);
            System.out.println(id + ".." + result);
            List<User> res = search(client, User.class);
            System.out.println(JSON.toJSON(res));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static IndexResponse insert(RestHighLevelClient client) throws IOException {
        // 2. 创建索引
        IndexRequest indexRequest = new IndexRequest("posts");
        indexRequest.id("3");
        Map hashMap = new HashMap();
        hashMap.put("user", "dyl");
        hashMap.put("date", LocalDateTime.now());
        hashMap.put("msg", "learning es3");
        indexRequest.source(hashMap, XContentType.JSON);

        // 3. 条件设置
        indexRequest.routing("routing");
        indexRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
        indexRequest.setRefreshPolicy("wait_for");

        // 4. 监听
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        ActionListener<IndexResponse> listener = new ActionListener<IndexResponse>() {
            @Override
            public void onResponse(IndexResponse indexResponse) {
                System.out.println("indexResponse succeed!");
            }

            @Override
            public void onFailure(Exception e) {
                System.out.println("indexResponse failed!");
            }
        };

        return indexResponse;
    }

    public static IndexResponse insertUser(RestHighLevelClient client) throws IOException {
        // 2. 创建索引
        IndexRequest indexRequest = new IndexRequest("user-index");
        indexRequest.id();
        User user = new User();
        user.setName("dyl");
        user.setMsg("learning es3");
        user.setAge(65);
        user.setId("1");
        user.setTime(LocalDateTime.now());
        indexRequest.source(JSON.toJSONString(user), XContentType.JSON);
        // 3. 条件设置
        indexRequest.routing("user-routing");
        indexRequest.id(user.getId());
        indexRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
        indexRequest.setRefreshPolicy("wait_for");

        // 4. 监听
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        ActionListener<IndexResponse> listener = new ActionListener<IndexResponse>() {
            @Override
            public void onResponse(IndexResponse indexResponse) {
                System.out.println("indexResponse succeed!");
            }

            @Override
            public void onFailure(Exception e) {
                System.out.println("indexResponse failed!");
            }
        };

        return indexResponse;
    }

    public static List<Object> search(RestHighLevelClient client) throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        boolQueryBuilder.must(QueryBuilders.matchQuery("user", "dyl"));
        searchSourceBuilder.query(boolQueryBuilder);
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] hits = response.getHits().getHits();
        List<Object> res = new ArrayList(hits.length);
        for (SearchHit hit : hits) {
            res.add(hit.getSourceAsString());
        }
        return res;
    }

    public static <T> List<T> search(RestHighLevelClient client, Class<T> c) {
        SearchRequest request = new SearchRequest();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        boolQueryBuilder.must(QueryBuilders.matchQuery("name", "dyl"));
//        boolQueryBuilder.must(QueryBuilders.matchQuery("_id", "70Wy2m4B_QHcBEOo623P"));
        searchSourceBuilder.query(boolQueryBuilder);
        request.source(searchSourceBuilder);
        try {
            String jsonStr = JSONObject.toJSONString(searchSourceBuilder);
            System.out.println("request: "+ jsonStr);
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            SearchHit[] hits = response.getHits().getHits();
            List<T> res = new ArrayList<>(hits.length);
            for (SearchHit hit : hits) {
                res.add(JSON.parseObject(hit.getSourceAsString(), c));
            }
            return res;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void demo() throws IOException {
        RestHighLevelClient client = getClient();
        CreateIndexRequest request = new CreateIndexRequest("test1");
        // 2.索引setting配置
        request.settings(Settings.builder().put("index.number_of_shards", 5)
                .put("index.number_of_replicas", 2) // 副本数
                .put("analysis.analyzer.default.tokenizer", "standard")
        );
        // 3.设置索引的mapping
        request.mapping("_doc",
                "  {\n" +
                        "    \"_doc\": {\n" +
                        "      \"properties\": {\n" +
                        "        \"message\": {\n" +
                        "          \"type\": \"text\"\n" +
                        "        }\n" +
                        "      }\n" +
                        "    }\n" +
                        "  }",
                XContentType.JSON);

        // 设置索引别名
        request.alias(new Alias("lab1"));
        CreateIndexResponse response = client.indices().create(request, null);

        // 处理响应
        boolean acknowledged = response.isAcknowledged();
        boolean shardsAcknowledged = response.isShardsAcknowledged();

        System.out.println("请求结果---------------");
        System.out.println("acknowledged:" + acknowledged);
        System.out.println("shardsAcknowledged:" + shardsAcknowledged);


    }

    public static RestHighLevelClient getClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")));
        return client;
    }
}
