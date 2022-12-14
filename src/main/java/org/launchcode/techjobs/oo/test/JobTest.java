package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", job.getName());
        assertTrue(job.getName() instanceof String);

        assertEquals("ACME", job.getEmployer().getValue());
        assertTrue(job.getEmployer() instanceof Employer);

        assertEquals("Desert", job.getLocation().getValue());
        assertTrue(job.getLocation() instanceof Location);

        assertEquals("Quality control", job.getPositionType().getValue());
        assertTrue(job.getPositionType() instanceof PositionType);

        assertEquals("Persistence", job.getCoreCompetency().getValue());
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String result = job.toString();
        assertEquals('\n',result.charAt(0));
        assertEquals('\n',result.charAt(result.length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected = "";
        expected += "\nID: " + job.getId();
        expected += "\nName: " + job.getName();
        expected += "\nEmployer: " + job.getEmployer();
        expected += "\nLocation: " + job.getLocation();
        expected += "\nPosition Type: " + job.getPositionType();
        expected += "\nCore Competency: " + job.getCoreCompetency();
        expected += "\n";

        assertEquals(expected, job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
//        Job job = new Job();
        Job job = new Job("Product tester", new Employer(""), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String blankField = "Data not available";
        String expected = "";
        expected += "\nID: " + job.getId();
        expected += "\nName: " + job.getName();
        expected += "\nEmployer: " + blankField;
        expected += "\nLocation: " + blankField;
        expected += "\nPosition Type: " + job.getPositionType();
        expected += "\nCore Competency: " + job.getCoreCompetency();
        expected += "\n";

        assertEquals(expected, job.toString());

    }

}
