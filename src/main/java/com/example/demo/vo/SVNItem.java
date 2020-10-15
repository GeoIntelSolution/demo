package com.example.demo.vo;

import java.util.Objects;

public class SVNItem {
    private int id;
    private String svnUrl;
    private String vn;
    private String password;
    private String filePath;
    private String alias;

    public SVNItem(int id, String svnUrl, String vn, String password, String filePath, String alias) {
        this.id = id;
        this.svnUrl = svnUrl;
        this.vn = vn;
        this.password = password;
        this.filePath = filePath;
        this.alias = alias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSvnUrl() {
        return svnUrl;
    }

    public void setSvnUrl(String svnUrl) {
        this.svnUrl = svnUrl;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SVNItem svnItem = (SVNItem) o;
        return id == svnItem.id &&
                Objects.equals(svnUrl, svnItem.svnUrl) &&
                Objects.equals(vn, svnItem.vn) &&
                Objects.equals(password, svnItem.password) &&
                Objects.equals(filePath, svnItem.filePath) &&
                Objects.equals(alias, svnItem.alias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, svnUrl, vn, password, filePath, alias);
    }
}
