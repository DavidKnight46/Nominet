package com.nominet.excerise.model;

public class Receiver extends Tower {
	
	private boolean isInCoverage = false;
	
    public Receiver(int id, Point location) {
        super(id, location);
    }
    
    /**
     * 
     * @return
     */
    public boolean getIsInCoverage(){ return this.isInCoverage; }
    
    /**
     * 
     * @param inCoverage
     */
    public void setIsInCoverage(boolean inCoverage) { 
    	this.isInCoverage = inCoverage; 
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "id=" + id +
                ", location=" + location +
                '}';
    }
}
