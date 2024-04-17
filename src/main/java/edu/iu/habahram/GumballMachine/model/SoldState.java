package edu.iu.habahram.GumballMachine.model;

public class SoldState implements  IState{

    public TransitionResult insertQuarter() {
        return new TransitionResult("You can't insert a quarter, you already have one", false);
    }

    public TransitionResult ejectQuarter() {
        return new TransitionResult("Sorry, you already turned the crank", false);
    }

    public TransitionResult turnCrank() {
        return new TransitionResult("Turning twice doesn't get you another gumball!", false);
    }

    public TransitionResult dispense() {
        return new TransitionResult("A gumball comes rolling out the slot...", true);
    }

    public String getTheName() {

        return GumballMachineState.GUMBALL_SOLD.name();
    }
}
