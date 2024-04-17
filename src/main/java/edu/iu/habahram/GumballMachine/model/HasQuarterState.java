package edu.iu.habahram.GumballMachine.model;

public class HasQuarterState implements IState {
    public TransitionResult insertQuarter() {
        return new TransitionResult("You can't insert another quarter", false);
    }

    public TransitionResult ejectQuarter() {
        return new TransitionResult("Quarter returned", true);
    }

    public TransitionResult turnCrank() {
        return new TransitionResult("You turned...", true);
    }

    public TransitionResult dispense() {
        return new TransitionResult("No gumball dispensed", false);
    }

    public String getTheName() {
        return GumballMachineState.HAS_QUARTER.name();
    }




}
