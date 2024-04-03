package edu.iu.habahram.GumballMachine.service;

import edu.iu.habahram.GumballMachine.model.GumballMachine;
import edu.iu.habahram.GumballMachine.model.GumballMachineRecord;
import edu.iu.habahram.GumballMachine.model.IGumballMachine;
import edu.iu.habahram.GumballMachine.model.TransitionResult;
import edu.iu.habahram.GumballMachine.repository.IGumballRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

@Service
public class GumballService implements IGumballService{

    IGumballRepository gumballRepository;

    public GumballService(IGumballRepository gumballRepository) {
        this.gumballRepository = gumballRepository;
    }



    private TransitionResult similarCode(String id, Function<IGumballMachine, TransitionResult> action) throws IOException {
        GumballMachineRecord record = gumballRepository.findById(id);
        IGumballMachine machine = new GumballMachine(record.getId(), record.getState(), record.getCount());
        TransitionResult result = action.apply(machine);
        if (result.succeeded()) {
            record.setState(result.stateAfter());
            record.setCount(result.countAfter());
            save(record);
        }
        return result;
    }

    @Override
    public TransitionResult insertQuarter(String id) throws IOException {

        return similarCode(id, IGumballMachine::insertQuarter);
    }
//        GumballMachineRecord record = gumballRepository.findById(id);
//        IGumballMachine machine = new GumballMachine(record.getId(), record.getState(), record.getCount());
//        TransitionResult result = machine.insertQuarter();
//        if(result.succeeded()) {
//            record.setState(result.stateAfter());
//            record.setCount(result.countAfter());
//            save(record);
//        }
//        return result;
//    }

    @Override
    public TransitionResult ejectQuarter(String id) throws IOException {

        return similarCode(id, IGumballMachine::ejectQuarter);

    }

//    GumballMachineRecord record = gumballRepository.findById(id);
//    IGumballMachine machine = new GumballMachine(record.getId(), record.getState(), record.getCount());
//    TransitionResult result = machine.ejectQuarter();
//    if (result.succeeded()) {
//        record.setState(result.stateAfter());
//        record.setCount(result.countAfter());
//        save(record);
//    }
//    return result;
//
//
//    }

    @Override
    public TransitionResult turnCrank(String id) throws IOException {
        return similarCode(id, IGumballMachine::turnCrank);
    }

//        GumballMachineRecord record = gumballRepository.findById(id);
//        IGumballMachine machine = new GumballMachine(record.getId(), record.getState(), record.getCount());
//        TransitionResult result = machine.turnCrank();
//        if (result.succeeded()) {
//            record.setState(result.stateAfter());
//            record.setCount(result.countAfter());
//            save(record);
//        }
//        return result;
//
//
//    }

    @Override
    public TransitionResult dispense() throws IOException {
        return null;
    }


    @Override
    public List<GumballMachineRecord> findAll() throws IOException {
        return gumballRepository.findAll();
    }

    @Override
    public GumballMachineRecord findById(String id) throws IOException {
        return gumballRepository.findById(id);
    }

    @Override
    public String save(GumballMachineRecord gumballMachineRecord) throws IOException {
        return gumballRepository.save(gumballMachineRecord);
    }
}
