/*
Author：王梓彧
DateTime：2020/5/11 4:35
Iteration：第二次迭代
 */
package yxx.hellospring.POJO;

public class Deathstatistics implements POJOInterface {
    @Override
    public String toString() {
        return "Deathstatistics{" +
                "id='" + id + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", number=" + number +
                ", reportingUnit='" + reportingUnit + '\'' +
                '}';
    }
    private String id;

    private String location;

    private String date;

    private Integer number;

    private String reportingUnit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getReportingUnit() {
        return reportingUnit;
    }

    public void setReportingUnit(String reportingUnit) {
        this.reportingUnit = reportingUnit == null ? null : reportingUnit.trim();
    }
}