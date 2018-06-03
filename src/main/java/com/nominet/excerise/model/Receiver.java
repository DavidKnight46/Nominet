package com.nominet.excerise.model;

public class Receiver extends Tower {
	
	private boolean isConnectedToAReceiver = false;
	private boolean isInCoverage;
	
    public Receiver(int id, Point location, boolean inCoverage) {
        super(id, location);
        this.isInCoverage = inCoverage;
    }
    
    /**
     * 
     * @return
     */
    public boolean getIsInCoverage() { return this.isInCoverage; }
    
    /**
     * 
     * @return
     */
    public boolean getIsConnectedToRec(){ return this.isConnectedToAReceiver; }
    
    /**
     * 
     * @param inCoverage
     */
    public void setIsInCoverage(boolean inCoverage) { 
    	this.isConnectedToAReceiver = inCoverage; 
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "id=" + id +
                ", location=" + location +
                '}';
    }
}
