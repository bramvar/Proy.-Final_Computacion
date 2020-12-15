package com.Brayan_Vargas.taller1.delegate;

import com.Brayan_Vargas.taller1.model.HatParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class HatParameterDelegateImp implements HatParameterDelegate{

    private RestTemplate restTemplate;
    final String SERVER="http://localhost:8080/backapi/";

    @Autowired
    public HatParameterDelegateImp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public HatParameter GET_HatParameter(long id) {
        HatParameter hatParameter=restTemplate.getForObject(SERVER+"hatParameter/"+id,HatParameter.class);
        return hatParameter;
    }

    @Override
    public Iterable<HatParameter> GET_HatParameters() {
        HatParameter[] list = restTemplate.getForObject(SERVER+"hatParameter",HatParameter[].class);
        List<HatParameter> hatList= Arrays.asList(list);
        return hatList;
    }

    @Override
    public HatParameter POST_HatParameter(HatParameter hatParameter) {
        return restTemplate.postForEntity(SERVER+"hatParameter",hatParameter,HatParameter.class).getBody();
    }

    @Override
    public void PUT_HatParameter(HatParameter hatParameter) {
        restTemplate.put(SERVER+"hatParameter",hatParameter,HatParameter.class);
    }

    @Override
    public void DELETE_HatParameter(HatParameter hatParameter) {

    }
}
