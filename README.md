This is a demonstration of some inconsistencies in JBehave's handling of story cancellation (because of a timeout).

Two issues are demonstrated

## 1

JBehave aborts the whole story so scenarios past the cancelled one are not even visible in the report despite doFailOnStoryTimeout(false) and doIgnoreFailureInStories(true).
If in the Test class constructor you set .useStoryTimeoutInSecs(1)), then it will kill the very first scenario and there is no signs of the second one to be present.
The target/jbehave/view/reports.html report will look like

Scenarios: Total=1, Successful=0, Pending=0, Failed=1

The target/jbehave/view/reports.html shows just

```
Scenario: slow and failing test
Given a default state
When I do something slow (FAILED)
java.lang.InterruptedException: sleep interrupted
STORY CANCELLED (DURATION 2 s)
```

No second scenario

## 2
JBehave may report cancelled scenarios as successful. Change .useStoryTimeoutInSecs to 2

The target/jbehave/view/reports.html report will look like

Scenarios: Total=2, Successful=1, Pending=1, Failed=1

Which seem to be just wrong given that target/jbehave/view/test.test.html shows:
```
Scenario: slow and failing test
Given a default state
When I do something slow
Then nothing should happen (FAILED)
java.lang.InterruptedException: sleep interrupted

Scenario: scenario description
STORY CANCELLED (DURATION 3 s)
```

So I see on failed scenario and one cancelled but which of them JBehave thinks is successful?
