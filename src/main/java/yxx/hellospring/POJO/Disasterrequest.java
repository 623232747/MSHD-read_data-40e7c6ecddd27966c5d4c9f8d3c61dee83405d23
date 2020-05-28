/*
Author：王梓彧
DateTime：2020/5/11 4:35
Iteration：第二次迭代
 */
package yxx.hellospring.POJO;

public class Disasterrequest implements POJOInterface {
    @Override
    public String toString() {
        return "Disasterrequest{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", disastertype='" + disastertype + '\'' +
                ", status='" + status + '\'' +
                ", oUrl='" + oUrl + '\'' +
                ", requestUnit='" + requestUnit + '\'' +
                '}';
    }

    private String id;

    private String date;

    private String disastertype;

    private String status;

    private String oUrl;

    private String requestUnit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getDisastertype() {
        return disastertype;
    }

    public void setDisastertype(String disastertype) {
        this.disastertype = disastertype == null ? null : disastertype.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getoUrl() {
        return oUrl;
    }

    public void setoUrl(String oUrl) {
        this.oUrl = oUrl == null ? null : oUrl.trim();
    }

    public String getRequestUnit() {
        return requestUnit;
    }

    public void setRequestUnit(String requestUnit) {
        this.requestUnit = requestUnit == null ? null : requestUnit.trim();
    }
}