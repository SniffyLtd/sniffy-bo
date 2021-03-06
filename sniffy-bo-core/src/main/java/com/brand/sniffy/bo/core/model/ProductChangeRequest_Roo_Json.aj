// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.brand.sniffy.bo.core.model;

import com.brand.sniffy.bo.core.model.ProductChangeRequest;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect ProductChangeRequest_Roo_Json {
    
    public String ProductChangeRequest.toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }
    
    public String ProductChangeRequest.toJson(String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(this);
    }
    
    public static ProductChangeRequest ProductChangeRequest.fromJsonToProductChangeRequest(String json) {
        return new JSONDeserializer<ProductChangeRequest>().use(null, ProductChangeRequest.class).deserialize(json);
    }
    
    public static String ProductChangeRequest.toJsonArray(Collection<ProductChangeRequest> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }
    
    public static String ProductChangeRequest.toJsonArray(Collection<ProductChangeRequest> collection, String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<ProductChangeRequest> ProductChangeRequest.fromJsonArrayToProductChangeRequests(String json) {
        return new JSONDeserializer<List<ProductChangeRequest>>().use(null, ArrayList.class).use("values", ProductChangeRequest.class).deserialize(json);
    }
    
}
