package Repositories;

import models.Gate;

import java.util.Map;

public class GateRepository {
    private Map<Long, Gate> gates;

    public Gate getGate(long gateId){
        return gates.get(gateId);

    }
    public Gate setGate(Gate gate){
        gates.put(gate.getId(), gate);
        return gate;
    }

}
