package com.example.demo.db;

import com.example.demo.entity.Entity;

import java.util.*;
import java.util.stream.Collectors;

abstract public class SimpleDataRepository<T extends Entity, ID extends Long>  implements DataRepository<T, ID>{

    private List<T> dataList = new ArrayList<T>();

    private static long index=0;

    private Comparator<T> sort = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return Long.compare(o1.getId(), o2.getId());
        }
    };
    // Create
    @Override
    public T save(T data) { // save 메서드는 create 와 update 기능을 둘 다 동작한다.
        if(Objects.isNull(data)){
            //return null;
            throw  new RuntimeException("Data is null");
        }
        // 기존에 동일한 id 가 존재하는 지 db 에서 확인
        var prevData = dataList.stream()
                .filter(it ->{
                    return it.getId().equals(data.getId());
                })
                .findFirst();

        if(prevData.isPresent()){
            // 기존에 존재하는 id 일 경우
            // Optional<UserEntity> 였기 때문에 dataList.remove(prevData) 라면 id 가 있는지 반드시 점검하지는 않는다
            // 동일한 id 로 업데이트 내용이 append 되는 현상 dataList.remove(prevData);
            dataList.remove(prevData.get()); // 기존 데이터는 날리고
            dataList.add(data);  //  it.getId().equals(data.getId()); 로 인해 동일한 id 를 가진 데이터가 추가된다.
        }else{
            // 없는 데이터였을 경우
            index++;

            // unique id
            // Generic Type 일 때 상속을 이용하여 타입을 제한할 수 있다
            data.setId(index);
            dataList.add(data);

        }
        return data;
    }

    // Reade
    @Override
    public Optional<T> findById(ID id){ // id가 존재할 수 도 있고 아닐 수도 있기 때문에 Optional 하다
        return  dataList.stream()
                .filter(it -> {
                    return (it.getId().equals(id));
                    })
                .findFirst();
    }

    @Override
    public List<T> findAll() {
        return dataList.stream()
                .sorted(sort)
                .collect(Collectors.toList());
    }



    // Delete
    @Override
    public void delete(ID id) {
        var deleteEntity = dataList.stream()
                .filter(it -> {
                    return ( it.getId().equals(id));
                })
                .findFirst();
        if(deleteEntity.isPresent()){
            dataList.remove(deleteEntity.get());
        }
    }
}
