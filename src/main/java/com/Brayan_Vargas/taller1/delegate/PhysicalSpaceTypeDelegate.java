package com.Brayan_Vargas.taller1.delegate;

import com.Brayan_Vargas.taller1.model.Physicalspace;
import com.Brayan_Vargas.taller1.model.Physicalspacetype;

public interface PhysicalSpaceTypeDelegate {
    public Physicalspacetype GET_Type(long id);
    public Iterable<Physicalspacetype> GET_Types();
    public Physicalspacetype POST_Type(Physicalspacetype type);
    public void PUT_Type(Physicalspacetype type);
    public void DELETE_Type(Physicalspacetype type);
}
