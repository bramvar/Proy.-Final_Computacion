package com.Brayan_Vargas.taller1.delegate;

import com.Brayan_Vargas.taller1.model.HatCapacitydetail;
import com.Brayan_Vargas.taller1.model.HatParameter;

public interface HatCapacityDelegate {
    public HatCapacitydetail GET_HatCapacitydetail(long id);
    public Iterable<HatCapacitydetail> GET_HatCapacitydetail();
    public HatCapacitydetail POST_HatCapacitydetail(HatCapacitydetail capacitydetail);
    public void PUT_HatCapacitydetail(HatCapacitydetail capacitydetail);
    public void DELETE_HatCapacitydetail(HatCapacitydetail capacitydetail);
}
