package com.Brayan_Vargas.taller1.service;

import com.Brayan_Vargas.taller1.model.HatCapacitydetail;
import com.Brayan_Vargas.taller1.model.HatParameter;

import java.util.List;

public interface HatCapacityService {

    public HatCapacitydetail saveHatParameter(HatCapacitydetail capacity);
    public HatCapacitydetail editHatParameter(HatCapacitydetail capacity);
    public HatCapacitydetail getHatParameter(long id);
    public List<HatCapacitydetail> findAll();
    public void delete(HatCapacitydetail capacity);

    public boolean isSaved(HatCapacitydetail capacity);

}
