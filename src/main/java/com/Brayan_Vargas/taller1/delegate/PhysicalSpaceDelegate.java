package com.Brayan_Vargas.taller1.delegate;

import com.Brayan_Vargas.taller1.model.Physicalspace;

public interface PhysicalSpaceDelegate {
    public Physicalspace GET_Campus(long id);
    public void GET_Institutions();
    public Physicalspace POST_Campus(Physicalspace institutioncampus);
    public void PUT_Campus(Physicalspace institutioncampus);
    public void DELETE_Campus(Physicalspace institutioncampus);

}
