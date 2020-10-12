package com.cg.otms;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features",glue= {"stepDefinitions"},plugin = {"pretty"})
//,"html:test-output","json:json_output/cucumber_report","junit:junit_xml/cucumber.xml"
//,monochrome = true
//tags= {"@smoke"},
public class TestRunner {
	
}
