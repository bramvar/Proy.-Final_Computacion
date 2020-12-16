package com.Brayan_Vargas.taller1.dao;

import com.Brayan_Vargas.taller1.model.HatCapacitydetail;
import com.Brayan_Vargas.taller1.model.HatParameter;

import java.util.List;

public interface HatCapacityDAO {
    public void save(HatCapacitydetail capacitydetail);
    public void edit(HatCapacitydetail capacitydetail);
    public void delete(HatCapacitydetail capacitydetail);
    public boolean isSaved(HatCapacitydetail capacitydetail);

    public HatCapacitydetail findById(long id);
    public List<HatCapacitydetail> findAll();
}
