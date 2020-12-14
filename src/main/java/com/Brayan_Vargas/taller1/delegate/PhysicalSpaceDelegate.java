package com.Brayan_Vargas.taller1.delegate;

import com.Brayan_Vargas.taller1.model.Institution;
import com.Brayan_Vargas.taller1.model.Physicalspace;

public interface PhysicalSpaceDelegate {
    public Physicalspace GET_Space(long id);
    public Iterable<Physicalspace> GET_Spaces();
    public Physicalspace POST_Space(Physicalspace space);
    public void PUT_Space(Physicalspace space);
    public void DELETE_Space(Physicalspace space);

}
