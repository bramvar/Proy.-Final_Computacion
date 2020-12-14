package com.Brayan_Vargas.taller1.delegate;

import com.Brayan_Vargas.taller1.model.Physicalspace;

public interface PhysicalSpaceDelegate {
    public Physicalspace GET_Space(long id);
    public void GET_Space();
    public Physicalspace POST_Space(Physicalspace institutioncampus);
    public void PUT_Space(Physicalspace institutioncampus);
    public void DELETE_Space(Physicalspace institutioncampus);

}
