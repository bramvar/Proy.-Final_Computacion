package com.Brayan_Vargas.taller1.delegate;

import com.Brayan_Vargas.taller1.model.HatParameter;
import com.Brayan_Vargas.taller1.model.Institution;

public interface HatParameterDelegate {

    public HatParameter GET_HatParameter(long id);
    public Iterable<HatParameter> GET_HatParameters();
    public HatParameter POST_HatParameter(HatParameter hatParameter);
    public void PUT_HatParameter(HatParameter hatParameter);
    public void DELETE_HatParameter(HatParameter hatParameter);
}
