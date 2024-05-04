package com.example.demo.db;

import java.util.List;
import java.util.Optional;

public interface DataRepository<T, ID> extends Repository<T, ID> {
    //create, update
    T save(T data); // 기존에 데이터가 없다면 save , 있다면 update
    // read
    Optional<T> findById(ID id);  // 요구하는 위치를 인식하여 값을 반환할 수 있도록 하는 메서드
    List<T> findAll();
    //delete
    void delete(ID id);

}
