package kr.pet.mvc.controller;

import kr.pet.mvc.model.MedicalRecord;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordController {

    // 진료기록을 관리하는 컨트롤러
    private List<MedicalRecord> records = new ArrayList<>();
    // 진료기록을 등록하는 메서드
    public void addMedicalRecord(MedicalRecord record){
        records.add(record);
    }
    // 진료기록을 조회하는 메서드
    // 전화번호에 해당하는 모든 진료기록을 검색하여 새로운 List<MedicalRecord> 를 만들어주는 메서드
    // 진료기록을 삭제하는 메서드
    public void removeMedicalRecord(String phoneNumber){
        for(int i=0;i<records.size();i++){
            if(records.get(i).getPhoneNumber().equals(phoneNumber)){
                records.remove(i);
                break;
            }
        }
    }

    public List<MedicalRecord> findMedicalRecord(String phoneNumber){
        List<MedicalRecord> result = new ArrayList<>();
        for(MedicalRecord record : records){
            if(record.getPhoneNumber().equals(phoneNumber)){
                result.add(record);
            }
        }// end for
        return result;
    }

}
