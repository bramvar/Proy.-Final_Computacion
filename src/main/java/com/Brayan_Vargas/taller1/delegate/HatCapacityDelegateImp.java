package com.Brayan_Vargas.taller1.delegate;

import com.Brayan_Vargas.taller1.model.HatCapacitydetail;
import com.Brayan_Vargas.taller1.model.HatParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class HatCapacityDelegateImp implements HatCapacityDelegate{

    private RestTemplate restTemplate;
    final String SERVER="http://localhost:8080/backapi/";

    @Autowired
    public HatCapacityDelegateImp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public HatCapacitydetail GET_HatCapacitydetail(long id) {
        HatCapacitydetail hatCapacity=restTemplate.getForObject(SERVER+"hatCapacitydetail/"+id,HatCapacitydetail.class);
        return hatCapacity;
    }

    @Override
    public Iterable<HatCapacitydetail> GET_HatCapacitydetails() {
        HatCapacitydetail[] list = restTemplate.getForObject(SERVER+"hatCapacitydetail",HatCapacitydetail[].class);
        List<HatCapacitydetail> hatList= Arrays.asList(list);
        return hatList;
    }

    @Override
    public HatCapacitydetail POST_HatCapacitydetail(HatCapacitydetail capacitydetail) {
        return restTemplate.postForEntity(SERVER+"hatCapacitydetail",capacitydetail,HatCapacitydetail.class).getBody();
    }

    @Override
    public void PUT_HatCapacitydetail(HatCapacitydetail capacitydetail) {
        restTemplate.put(SERVER+"hatCapacitydetail",capacitydetail,HatCapacitydetail.class);
    }

    @Override
    public void DELETE_HatCapacitydetail(HatCapacitydetail capacitydetail) {

    }
}
