// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.brand.sniffy.bo.core.model;

import com.brand.sniffy.bo.core.model.Category;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect Category_Roo_Json {
    
    public static Category Category.fromJsonToCategory(String json) {
        return new JSONDeserializer<Category>().use(null, Category.class).deserialize(json);
    }
    
    public static String Category.toJsonArray(Collection<Category> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }
    
    public static String Category.toJsonArray(Collection<Category> collection, String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<Category> Category.fromJsonArrayToCategorys(String json) {
        return new JSONDeserializer<List<Category>>().use(null, ArrayList.class).use("values", Category.class).deserialize(json);
    }
    
}
