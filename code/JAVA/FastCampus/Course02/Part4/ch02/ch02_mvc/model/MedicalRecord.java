package kr.pet.mvc.model;

public class MedicalRecord {
    // 진료일, 진료내용, 전화번호
    private String visitDate;
    private String content;
    private String phoneNumber;

    public MedicalRecord() {
    }

    public MedicalRecord(String phoneNumber, String visitDate, String content) {
        this.visitDate = visitDate;
        this.content = content;
        this.phoneNumber = phoneNumber;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "visitDate='" + visitDate + '\'' +
                ", content='" + content + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
