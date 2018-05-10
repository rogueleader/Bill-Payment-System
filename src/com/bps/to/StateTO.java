package com.bps.to;
 
public class StateTO {
 
      private String countryId;
      private String state;
 
      public StateTO() {
            // TODO Auto-generated constructor stub
      }
 
      public StateTO(String countryId, String state) {
            super();
            this.countryId = countryId;
            this.state = state;
      }
 
      public String getCountryId() {
            return countryId;
      }
 
      public void setCountryId(String countryId) {
            this.countryId = countryId;
      }
 
      public String getState() {
            return state;
      }
 
      public void setState(String state) {
            this.state = state;
      }
 
}
