package com.istihad.entity;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.istihad.TravelWebAppApplication;
import com.istihad.entity.Plan;
import com.istihad.service.PlanService;

@RunWith(JUnit4.class)
public class PlanTest {

    private Plan plan;

    @Before
    public void setUp() throws Exception {
        plan = new Plan();
        java.sql.Date date = java.sql.Date.valueOf("2010-01-31");
        plan.setUserId(1);
        plan.setPlaceId(1);
        plan.setPlace("test");
        plan.setAddress("test");
        plan.setHotel("test");
        plan.setDateTravel(date);
        plan.setDateAdded(date);
        plan.setClimate("test");
    }

    @Test
    public void testGetPlace() {
        assertEquals("test", plan.getPlace());
    }

    @Test
    public void testGetPlaceId() {
        assertEquals("1", plan.getPlaceId().toString());
    }

    @Test
    public void testGetAddress() {
        assertEquals("test", plan.getAddress());
    }

    @Test
    public void testGetClimate() {
        assertEquals("test", plan.getClimate());
    }

    @Test
    public void testGetHotel() {
        assertEquals("test", plan.getHotel());
    }

    @Test
    public void testGetDateTravel() {
        assertEquals("2010-01-31", plan.getDateTravel().toString());
    }

    @Test
    public void testGetDateAdded() {
        assertEquals("2010-01-31", plan.getDateAdded().toString());
    }

    @Test
    public void testInvalidClimate() throws Exception{
    	boolean exceptionCaught = false;
    	try{
    		plan.setClimate(null);
    		planService.addPlan(plan);
    	}catch(Exception e){
    		exceptionCaught = true;
    	}
    	assertTrue(exceptionCaught);
    }*/
}
