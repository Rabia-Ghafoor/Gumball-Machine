package edu.iu.habahram.GumballMachine.model;

public class SoldOutState implements IState {

    IGumballMachine gumballMachine;
    public SoldOutState(IGumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public TransitionResult insertQuarter() {
        return new TransitionResult("No gumball available", false);
    }
    public TransitionResult ejectQuarter() {
        return new TransitionResult("No quarter inserted", false);
    }
    public TransitionResult turnCrank() {
        return new TransitionResult("No gumball available", false);
    }
    public TransitionResult dispense() {
        return new TransitionResult("No gumball available", false);
    }

    public String getTheName() {
        return GumballMachineState.OUT_OF_GUMBALLS.name();
    }



}
