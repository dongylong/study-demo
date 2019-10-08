package com.study.es;

import groovy.json.JsonBuilder;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019/10/1 22:52
 * @changeRecord
 */
public class ESService {
    Client client = null;

    String index = "secilog";
    String type = "log";
    String id = "1";

    public void deleteIndex() {
        DeleteIndexRequest request = new DeleteIndexRequest(index);
        client.admin().indices().delete(request);
    }
    public void deleteDoc() {
        DeleteResponse deleteResponse = client.prepareDelete(index, type, id).get();
        DocWriteResponse.Result result = deleteResponse.getResult();
    }
    public void query() {
        GetResponse response = client.prepareGet(index, type, id).get();
        String source = response.getSource().toString();
        long version = response.getVersion();
        String indexName = response.getIndex();
        String type = response.getType();
        String id = response.getId();
    }

    void create() throws IOException {
        String indexName = "";
        String type = "3";
        XContentBuilder mapping = jsonBuilder()
                .startObject()
                .startObject("setting")
                //设置分片数
                .field("number_of_shards", 1)
                //设置副本数
                .field("number_of_replicas", 0)
                .endObject()
                .endObject()
                .startObject()
                .startObject(type)
                .startObject("propertys")
                .startObject("type")
                .field("type,:string")
                .field("store", "yes")
                .endObject()
                .startObject("eventCount")
                .field("type", "long")
                .field("store", "yes")
                .endObject()
                .startObject("eventDate")
                .field("type", "date")
                .field("format", "dateOptionalTime")
                .field("store", "yes")
                .endObject()
                .startObject("message")
                .field("type", "string")
                .field("index", "not_analyzed")
                .field("store", "yes")
                .endObject()
                .endObject()
                .endObject()
                .endObject();
        CreateIndexRequestBuilder cirb = client.admin().indices()
                .prepareCreate(indexName)
                .setSource(mapping);
        CreateIndexResponse response = cirb.execute().actionGet();
        if (response.isAcknowledged()) {
            System.out.println("index created");
        } else {
            System.out.println("index creation failed.");
        }
    }

    void createDoc() throws IOException {
        String indexName = "";
        String type = "";
        IndexResponse response = client.prepareIndex(indexName, type, "1")
                .setSource(
                        jsonBuilder().startObject()
                                .field("type", "syslog")
                                .field("eventCount", 1)
                                .field("eventDate", new Date())
                                .field("message", "secilog insert doc test")
                ).get();
        System.out.println("index:" + response.getIndex()
                + "insert docId:" + response.getId()
                + "result: " + response.getResult());
    }

    void updateDoc() throws IOException, ExecutionException, InterruptedException {
        String indexName = "";
        String type = "";
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index(indexName);
        updateRequest.type(type);
        updateRequest.id("1");
        updateRequest.doc(jsonBuilder().startObject()
                .field("type", "file")
                .endObject());
        client.update(updateRequest).get();
    }

    void updateDoc1() throws IOException, ExecutionException, InterruptedException {
        String indexName = "";
        String type = "";
        IndexRequest indexRequest = new IndexRequest(indexName, type, "3")
                .source(jsonBuilder().startObject()
                        .field("type", "syslog")
                        .endObject());
        UpdateRequest updateRequest = new UpdateRequest(indexName, type, "3")
                .doc(jsonBuilder().startObject().field("type", "file")
                        .endObject()).upsert(indexRequest);
        client.update(updateRequest).get();
    }

}
