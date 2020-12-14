package com.Brayan_Vargas.taller1.delegate;

import com.Brayan_Vargas.taller1.model.Physicalspacetype;

public interface PhysicalSpaceTypeDelegate {
    public Physicalspacetype GET_Type(long id);
    public void GET_Type();
    public Physicalspacetype POST_Type(Physicalspacetype institutioncampus);
    public void PUT_Type(Physicalspacetype institutioncampus);
    public void DELETE_Type(Physicalspacetype institutioncampus);
}
