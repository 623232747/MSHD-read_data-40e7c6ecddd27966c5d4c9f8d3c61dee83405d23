/*
Author：王梓彧
DateTime：2020/5/11 4:35
Iteration：第二次迭代
 */
package yxx.hellospring.POJO;

public class Civilstructure implements POJOInterface {
    @Override
    public String toString() {
        return "Civilstructure{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", basicallyIntactSquare='" + basicallyIntactSquare + '\'' +
                ", damagedSquare='" + damagedSquare + '\'' +
                ", destroyedSquare='" + destroyedSquare + '\'' +
                ", note='" + note + '\'' +
                ", reportingUnit='" + reportingUnit + '\'' +
                '}';
    }

    private String id;

    private String date;

    private String location;

    private String basicallyIntactSquare;

    private String damagedSquare;

    private String destroyedSquare;

    private String note;

    private String reportingUnit;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getBasicallyIntactSquare() {
        return basicallyIntactSquare;
    }

    public void setBasicallyIntactSquare(String basicallyIntactSquare) {
        this.basicallyIntactSquare = basicallyIntactSquare == null ? null : basicallyIntactSquare.trim();
    }

    public String getDamagedSquare() {
        return damagedSquare;
    }

    public void setDamagedSquare(String damagedSquare) {
        this.damagedSquare = damagedSquare == null ? null : damagedSquare.trim();
    }

    public String getDestroyedSquare() {
        return destroyedSquare;
    }

    public void setDestroyedSquare(String destroyedSquare) {
        this.destroyedSquare = destroyedSquare == null ? null : destroyedSquare.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getReportingUnit() {
        return reportingUnit;
    }

    public void setReportingUnit(String reportingUnit) {
        this.reportingUnit = reportingUnit == null ? null : reportingUnit.trim();
    }
}