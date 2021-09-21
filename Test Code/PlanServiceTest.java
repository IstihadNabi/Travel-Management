package com.istihad.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import com.istihad.entity.Plan;
import com.istihad.repository.PlanRepository;

@RunWith(JUnit4.class)
public class PlanServiceTest {

    @Mock
    private PlanRepository planRepository;

    private Plan plan;
    private Plan plan2;
    private PlanService planService;
    private List<Plan> plans;

    @Before
    public void setup() throws Exception {

        plans = new ArrayList<Plan>();
        planService = new PlanService();
        planRepository = mock(PlanRepository.class);
        planService.setRepository(planRepository);
        plan = new Plan();
        plan.setUserId(1);

        plan2 = new Plan();
        plan2.setUserId(2);
        plan2.setPlace(null);

        when(planRepository.findPlansByUserId(plan.getUserId())).thenReturn(new ArrayList<Plan>());
        when(planRepository.findPlansByUserId(plan2.getUserId())).thenReturn(new ArrayList<Plan>());
        when(planRepository.save(plan)).thenReturn(plan);
        when(planRepository.save(plan2)).thenReturn(null);

    }

    @Test
    public void testGetPlansById() {
        when(planRepository.findPlansByUserId(plan.getUserId())).thenReturn(plans);
        assertEquals(plans, planService.getPlansById(plan.getUserId()));
    }

    @Test
    public void testAddPlan() {
        when(planRepository.save(plan)).thenReturn(plan);
        assertEquals(plan, planService.addPlan(plan));
    }

    @Test
    public void testDeletePlan() {
        when(planRepository.save(plan)).thenReturn(plan);
        assertEquals(true, planService.deletePlan(1));
    }

    @Test
    public void testInvalidGetPlansById() {
        when(planRepository.findPlansByUserId(plan.getUserId())).thenReturn(plans);
        when(planRepository.findPlansByUserId(plan2.getUserId())).thenReturn(plans);
        assertEquals(planService.getPlansById(plan.getUserId()), planService.getPlansById(plan.getUserId()));
    }

    @Test
    public void testInvalidAddPlan() {
        assertEquals(null, planService.addPlan(plan2));
    }

}
