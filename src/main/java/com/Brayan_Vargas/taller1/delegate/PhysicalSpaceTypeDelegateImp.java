package com.Brayan_Vargas.taller1.delegate;

import com.Brayan_Vargas.taller1.model.Physicalspace;
import com.Brayan_Vargas.taller1.model.Physicalspacetype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class PhysicalSpaceTypeDelegateImp implements PhysicalSpaceTypeDelegate{

    private RestTemplate restTemplate;
    final String SERVER="http://localhost:8080/backapi/";

    @Autowired
    public PhysicalSpaceTypeDelegateImp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Physicalspacetype GET_Type(long id) {
        Physicalspacetype type= restTemplate.getForObject(SERVER+"institution/"+id,Physicalspacetype.class);
        return type;
    }

    @Override
    public Iterable<Physicalspacetype> GET_Types() {
        Physicalspacetype[] types= restTemplate.getForObject(SERVER+"institution",Physicalspacetype[].class);
        List<Physicalspacetype> instList= Arrays.asList(types);
        return instList;
    }

    @Override
    public Physicalspacetype POST_Type(Physicalspacetype type) {
        return restTemplate.postForEntity(SERVER+"institution", type, Physicalspacetype.class).getBody();
    }

    @Override
    public void PUT_Type(Physicalspacetype type) {
        restTemplate.put(SERVER+"institution", type,Physicalspacetype.class);
    }

    @Override
    public void DELETE_Type(Physicalspacetype type) {
        restTemplate.delete(SERVER+"institution/", type,Physicalspacetype.class);
    }
}