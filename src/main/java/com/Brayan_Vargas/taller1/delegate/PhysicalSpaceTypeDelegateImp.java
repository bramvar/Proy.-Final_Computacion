package com.Brayan_Vargas.taller1.delegate;

import com.Brayan_Vargas.taller1.model.Physicalspace;
import com.Brayan_Vargas.taller1.model.Physicalspacetype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Component
public class PhysicalSpaceTypeDelegateImp implements PhysicalSpaceTypeDelegate{

    private RestTemplate restTemplate;
    final String SERVER="http://localhost:8080/backapi/";

    @Autowired
    public PhysicalSpaceTypeDelegateImp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Physicalspacetype GET_Type(long id) {
        Physicalspacetype type= restTemplate.getForObject(SERVER+"physicalspacetype/"+id,Physicalspacetype.class);
        return type;
    }

    @Override
    public Iterable<Physicalspacetype> GET_Types() {
        Physicalspacetype[] types= restTemplate.getForObject(SERVER+"physicalspacetype",Physicalspacetype[].class);
        List<Physicalspacetype> instList= Arrays.asList(types);
        return instList;
    }

    @Override
    public Physicalspacetype POST_Type(Physicalspacetype type) {
        return restTemplate.postForEntity(SERVER+"physicalspacetype", type, Physicalspacetype.class).getBody();
    }

    @Override
    public void PUT_Type(Physicalspacetype type) {
        restTemplate.put(SERVER+"physicalspacetype", type,Physicalspacetype.class);
    }

    @Override
    public void DELETE_Type(Physicalspacetype type) {
        restTemplate.delete(SERVER+"physicalspacetype/", type,Physicalspacetype.class);
    }
}
