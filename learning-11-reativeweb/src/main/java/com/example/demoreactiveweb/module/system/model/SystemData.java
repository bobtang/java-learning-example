package com.example.demoreactiveweb.module.system.model;

/**
 * @author liupei
 * @date 2018/10/15 15:41
 */
public class SystemData {
    
    private long id;
    
    private String name;
    
    private int level;
    
    public SystemData() {
    }
    
    public SystemData(String name, int level) {
        this.name = name;
        this.level = level;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
}
