package Services;

import Repositories.GateRepository;
import models.Gate;

public class GateService {
    private GateRepository gateRepository;
    public Gate getGate(Long gateId){
        return gateRepository.getGate(gateId);

    }
}
