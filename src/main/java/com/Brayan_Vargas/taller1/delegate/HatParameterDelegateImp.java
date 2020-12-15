package com.Brayan_Vargas.taller1.delegate;

import com.Brayan_Vargas.taller1.model.HatParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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
        return null;
    }

    @Override
    public Iterable<HatParameter> GET_HatParameter() {
        return null;
    }

    @Override
    public HatParameter POST_HatParameter(HatParameter hatParameter) {
        return null;
    }

    @Override
    public void PUT_HatParameter(HatParameter hatParameter) {

    }

    @Override
    public void DELETE_HatParameter(HatParameter hatParameter) {

    }
}
