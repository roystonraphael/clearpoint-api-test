@APITest
Feature: Todos list
  As a customer
  I want to manage my todos list
  So that I can organise my day according to plan

  Background: Verify API is accessible
    Given I have access to the Todo list API

  Scenario: Create a Todo Task
    When I create a todo task with title "foo" and body "bar"
    Then the new task is present in my list

  Scenario: Verify the entire task list
    When I fetch all the tasks within my Todo list
    Then I can see all the tasks present within my todo list