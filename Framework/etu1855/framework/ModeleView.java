package etu1855.framework;

import java.util.HashMap;

public class ModeleView {
    String url;
    HashMap<String,Object> data;

    public ModeleView(){
        this.data = new HashMap<String,Object>();
    }
        
    public ModeleView(String url){
        this.url = url;
        this.data = new HashMap<String,Object>();
    }

    public ModeleView(String url,HashMap<String,Object> data){
        this.url = url;
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }
    
    public void addItem(String key, Object value){
        HashMap<String,Object> mydata = this.getData();
        mydata.put(key, value);
        this.setData(mydata);
    }
}
