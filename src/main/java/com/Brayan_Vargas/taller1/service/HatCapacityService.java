package com.Brayan_Vargas.taller1.service;

import com.Brayan_Vargas.taller1.model.HatCapacitydetail;
import com.Brayan_Vargas.taller1.model.HatParameter;

import java.util.List;

public interface HatCapacityService {

    public HatCapacitydetail saveHatCapacitydetail(HatCapacitydetail capacity);
    public HatCapacitydetail editHatCapacitydetail(HatCapacitydetail capacity);
    public HatCapacitydetail getHatCapacitydetail(long id);
    public List<HatCapacitydetail> findAll();
    public void delete(HatCapacitydetail capacity);

    public boolean isSaved(HatCapacitydetail capacity);

}
