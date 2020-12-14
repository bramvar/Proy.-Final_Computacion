package com.Brayan_Vargas.taller1.delegate;

import com.Brayan_Vargas.taller1.model.Physicalspacetype;

public interface PhysicalSpaceTypeDelegate {
    public Physicalspacetype GET_Campus(long id);
    public void GET_Institutions();
    public Physicalspacetype POST_Campus(Physicalspacetype institutioncampus);
    public void PUT_Campus(Physicalspacetype institutioncampus);
    public void DELETE_Campus(Physicalspacetype institutioncampus);
}
